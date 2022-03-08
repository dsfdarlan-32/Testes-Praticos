package testePrático3.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	private Connection conn;
	private String user = "root";
	private String password = "root";
	private String database = "banco_teste_automacao";

	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/" + database, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConnection() throws SQLException {
		if (conn != null) {
			conn.close();
		}
		conn = null;
	}
}
