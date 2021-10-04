package fr.cbu.OwnCrm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OwnCrmConnection {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.hsqldb.jdbcDriver");

		String url = "jdbc:hsqldb:mem:owncrm";
		String user = "sa";
		String password = "";

		Connection c = DriverManager.getConnection(url, user, password);
		return c;
	}

	public static void closeConnection(Connection c) throws SQLException {
		c.close();
	}

}
