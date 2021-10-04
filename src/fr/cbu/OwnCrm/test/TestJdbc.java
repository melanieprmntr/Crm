package fr.cbu.OwnCrm.test;

import java.sql.Connection;
import java.sql.SQLException;

import fr.cbu.OwnCrm.jdbc.OwnCrmConnection;

public class TestJdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection c = OwnCrmConnection.getConnection();
		System.out.println("Connection : " + c);
		OwnCrmConnection.closeConnection(c);
	}

}
