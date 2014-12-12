package com.istudy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Gregory Daniels
 *
 */
public class RecogConnectionDriver implements RecogConnectionDriverI {
	
	private static final String host = "jdbc:mysql://localhost:3306/recognition";

	private static final String userName = "root";

	private static final String password = "";

	@Override
	public Connection getConnection() throws SQLException {
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		    throw new RuntimeException("Cannot find the driver in the classpath!", e);
		}
		return DriverManager.getConnection( host, userName, password );
	}

}