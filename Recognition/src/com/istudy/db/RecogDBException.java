package com.istudy.db;

import java.sql.SQLException;

/**
 * @author Gregory Daniels
 *
 */
public class RecogDBException extends Exception {

	private static final long serialVersionUID = -6012833491591900395L;
	private SQLException sqlException = null;
	private static final String message = "Error with database access";

	public RecogDBException(SQLException e) {
		super("A database exception has occurred. Please see the log in the console for stacktrace");
		this.sqlException = e;
	}

	public SQLException getSQLException() {
		return sqlException;
	}
	
	public String getMessage(String message){
		return message;
	}

	public String getMessage() {
		if (sqlException != null)
			return sqlException.getMessage();
		else
			return message;
	}
}
