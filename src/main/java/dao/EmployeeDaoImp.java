package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import pojo.Employee;

public class EmployeeDaoImp {
	public static void create(Employee employee) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String sql = new String("INSERT INTO funcionario (cd_funcionario, nm_funcionario) SELECT (MAX(cd_funcionario) + 1), ? FROM funcionario");

		try {
			stmt = con.prepareStatement(sql);

			stmt.setString(1, employee.getName());
			
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public static List<Employee> findAll() throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = new String("SELECT cd_funcionario, nm_funcionario FROM funcionario ORDER BY nm_funcionario ASC");

		try {
			stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			return descompressEmployeeObjectFromResultSet(rs);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	}
	
	public static Employee findById(Integer id) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = new String("SELECT cd_funcionario, nm_funcionario FROM funcionario WHERE cd_funcionario = ?");

		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			return descompressEmployeeObjectFromResultSet(rs).get(0);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	}
	

	
	public static void update(Employee employee) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String sql = new String("UPDATE funcionario SET nm_funcionario = ? WHERE cd_funcionario = ?");
		try {
			stmt = con.prepareStatement(sql);

			stmt.setString(1, employee.getName());
			stmt.setInt(2, employee.getId());
			
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
		String sql = new String("DELETE FROM funcionario WHERE cd_funcionario = ?");

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
	
	
	private static List<Employee> descompressEmployeeObjectFromResultSet(ResultSet rs) throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();
		while(rs.next()) {
			Employee employee = new Employee(rs.getInt("cd_funcionario"), rs.getString("nm_funcionario"));
			
			employees.add(employee);
		}
		
		return employees;
	}
}
