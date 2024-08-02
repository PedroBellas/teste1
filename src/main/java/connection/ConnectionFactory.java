package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ConnectionFactory {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/avaliacao";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	public static Connection getConnection() throws Exception {
		try {
			
			Class.forName(DRIVER);
			
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException ex) {
			throw new Exception(ex);
		}
	}
	
	public static void closeConnection(Connection con) throws Exception {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			throw new Exception(ex);
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt) throws Exception {
		try {
			closeConnection(con);
			
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException ex) {
			throw new Exception(ex);
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) throws Exception {
		try {
			closeConnection(con, stmt);
			
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException ex) {
			throw new Exception(ex);
		}
	}
}
