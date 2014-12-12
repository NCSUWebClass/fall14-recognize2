package com.istudy.db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Gregory Daniels
 *
 */
public interface RecogConnectionDriverI {
	public Connection getConnection() throws SQLException;
}
