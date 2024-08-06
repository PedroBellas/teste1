package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import pojo.Exam;
import pojo.Pagination;

public class ExamDaoImp {

	public static void create(Exam user) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String sql = new String("INSERT INTO exame (cd_exame, nm_exame, ic_ativo, ds_detalhe_exame, ds_detalhe_exame1) SELECT IFNULL((MAX(cd_exame) + 1), 0), ?, ?, ?, ? FROM exame");

		try {
			stmt = con.prepareStatement(sql);

			stmt.setString(1, user.getName());
			stmt.setBoolean(2, user.getActive());
			stmt.setString(3, user.getDescriptionExam());
			stmt.setString(4, user.getDescriptionExam1());
			
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static List<Exam> find(Pagination pagination) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = new String("SELECT cd_exame, nm_exame, ic_ativo, ds_detalhe_exame, ds_detalhe_exame1 FROM exame LIMIT ?, ?");

		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, pagination.getMinRow());
			stmt.setInt(2, pagination.getSize());
			
			rs = stmt.executeQuery();
			
			return descompressExamObjectFromResultSet(rs);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	}
	
	public static List<Exam> findAllActives() throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = new String("SELECT cd_exame, nm_exame, ic_ativo, ds_detalhe_exame, ds_detalhe_exame1 FROM exame WHERE ic_ativo = 1 ORDER BY nm_exame ASC");

		try {
			stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			return descompressExamObjectFromResultSet(rs);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	}
	
	public static Integer getQtyRegistries(Exam exam) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			
			if (exam.getName() != null) {
				String sql = new String("SELECT COUNT(cd_exame) AS quantidade FROM exame WHERE UPPER(nm_exame) LIKE UPPER(?)");
				stmt = generateSearchStatementByParams(stmt, con, exam, null, sql);
			} else {
				String sql = new String("SELECT COUNT(cd_exame) AS quantidade FROM exame");
				stmt = con.prepareStatement(sql);
			}
			
			rs = stmt.executeQuery();
			
			rs.next();
			
			return rs.getInt("quantidade");
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	}

	public static List<Exam> findExamsByParams(Exam exam, Pagination pagination) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = new String("SELECT cd_exame, nm_exame, ic_ativo, ds_detalhe_exame, ds_detalhe_exame1 FROM exame WHERE UPPER(nm_exame) LIKE UPPER(?)");
		try {
			stmt = generateSearchStatementByParams(stmt, con, exam, pagination, sql);
			rs = stmt.executeQuery();
			
			return descompressExamObjectFromResultSet(rs);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	}
	
	public static Exam findById(Integer id) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = new String("SELECT cd_exame, nm_exame, ic_ativo, ds_detalhe_exame, ds_detalhe_exame1 FROM exame WHERE cd_exame = ?");

		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			return descompressExamObjectFromResultSet(rs).get(0);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	}
	

	
	public static void update(Exam exam) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String sql = new String("UPDATE exame SET nm_exame = ?, ic_ativo = ?, ds_detalhe_exame = ?, ds_detalhe_exame1 = ? WHERE cd_exame = ?");
		try {
			stmt = con.prepareStatement(sql);

			stmt.setString(1, exam.getName());
			stmt.setBoolean(2, exam.getActive());
			stmt.setString(3, exam.getDescriptionExam());
			stmt.setString(4, exam.getDescriptionExam1());
			stmt.setInt(5, exam.getId());
			
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void delete(Integer id) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String sql = new String("DELETE FROM exame WHERE cd_exame = ?");

		try {
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);
			
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	private static List<Exam> descompressExamObjectFromResultSet(ResultSet rs) throws SQLException {
		List<Exam> exams = new ArrayList<Exam>();
		while(rs.next()) {
			Exam exam = new Exam(
					rs.getInt("cd_exame"),
					rs.getString("nm_exame"),
					rs.getBoolean("ic_ativo"),
					rs.getString("ds_detalhe_exame"),
					rs.getString("ds_detalhe_exame1"));
			
			exams.add(exam);
		}
		
		return exams;
	}
	
	public static PreparedStatement generateSearchStatementByParams(PreparedStatement stmt, Connection con, Exam exam, Pagination pagination, String sql) throws SQLException {
		int qtyParams = 0;
		
		if (exam.getId() != null) {
			sql = sql.concat(" AND cd_exame = ? ");
		}
		
		if (exam.getActive() != null) {
			sql = sql.concat(" AND ic_ativo = ? ");
		}
		
		if (pagination != null) {
			sql = sql.concat(" LIMIT ?, ?");
		}
		
		stmt = con.prepareStatement(sql);
		
		qtyParams++;
		stmt.setString(qtyParams, exam.getName());
		

		if (exam.getId() != null) {
			qtyParams++;
			stmt.setInt(qtyParams, exam.getId());
		}
		
		if (exam.getActive() != null) {
			qtyParams++;
			stmt.setBoolean(qtyParams, exam.getActive());
		}
		
		if (pagination != null) {
			qtyParams++;
			stmt.setInt(qtyParams, pagination.getMinRow());
			qtyParams++;
			stmt.setInt(qtyParams, pagination.getSize());
		}
		
		return stmt;
	}
}
