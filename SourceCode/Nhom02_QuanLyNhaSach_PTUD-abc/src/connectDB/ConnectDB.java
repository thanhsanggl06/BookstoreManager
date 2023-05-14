package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {
	public static Connection con = null;
	private static ConnectDB instance = new ConnectDB();	
	public static ConnectDB getInstance() {
		return instance;
	}
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyHieuSach";
		String user = "sa";
		String password = "10102002Hh";
		con = DriverManager.getConnection(url, user, password);
		return con;
	}

	public void disconnect() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}


}
