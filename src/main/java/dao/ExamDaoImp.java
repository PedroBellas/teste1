package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import connection.ConnectionFactory;
import pojo.Exam;

public class ExamDaoImp implements ExamDao {

	@Override
	public void create(Exam user) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String sql = new String("INSERT INTO exame (cd_exame, nm_exame, ic_ativo, ds_detalhe_exame, ds_detalhe_exame1) SELECT (MAX(cd_exame) + 1) ?, ?, ?, ? FROM exame");

		try {
			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getActive().toString());
			stmt.setString(3, user.getDescriptionExame());
			stmt.setString(4, user.getDescriptionExame1());
			
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	}

	@Override
	public List<Exam> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exam> findExamsByParams(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Exam> findExamsByParams(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Exam> findExamsByParams(Integer id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exam> findActive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exam> findUnactive() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void update(Exam user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
