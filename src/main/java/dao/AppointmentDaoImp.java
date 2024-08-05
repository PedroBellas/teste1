package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import pojo.Appointment;
import pojo.Employee;
import pojo.Exam;

public class AppointmentDaoImp {
	public static void create(Appointment appointment) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String sql = new String("INSERT INTO exame_realizado (cd_exame_realizado, cd_funcionario, cd_exame, dt_realizacao) SELECT MAX(cd_exame_realizado + 1), ?, ?, ? FROM exame_realizado");

		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, appointment.getEmployee().getId());
			stmt.setInt(2, appointment.getExam().getId());
			stmt.setDate(3, appointment.getDate());
			
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public static List<Appointment> findAll() throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = new String("SELECT cd_exame_realizado, f.cd_funcionario, f.nm_funcionario, e.cd_exame, e.nm_exame, e.ic_ativo, dt_realizacao FROM exame_realizado er INNER JOIN exame e ON er.cd_exame = e.cd_exame INNER JOIN funcionario f ON f.cd_funcionario = er.cd_funcionario");

		try {
			stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			return descompressAppointmentFromResultSet(rs);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	}
	
	private static List<Appointment> descompressAppointmentFromResultSet(ResultSet rs) throws SQLException {
		List<Appointment> appointments = new ArrayList<Appointment>();
		while(rs.next()) {
			Employee employee = new Employee(rs.getInt("cd_funcionario"), rs.getString("nm_funcionario"));
			
			Exam exam = new Exam(rs.getInt("cd_exame"), rs.getString("nm_exame"), rs.getBoolean("ic_ativo"), null, null);
			
			Appointment appointment = new Appointment(rs.getInt("cd_exame_realizado"), exam, employee, rs.getDate("dt_realizacao"));
			
			appointments.add(appointment);
		}
		
		return appointments;
	}
}
