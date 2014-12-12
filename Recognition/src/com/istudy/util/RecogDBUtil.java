package com.istudy.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.istudy.db.RecogDBException;
import com.istudy.db.RecognitionDBFactory;

/**
 * @author Gregory Daniels
 *
 */
public class RecogDBUtil {
	
	public static boolean canObtainProductionInstance() {
		try {
			RecognitionDBFactory.getProductionInstance().getConnection().close();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public static void closeConnection(Connection conn, PreparedStatement ps) {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.err.println("Error closing connections");
			
		}
	}

	public static long getLastInsert(Connection conn) throws SQLException, RecogDBException {
			ResultSet rs = conn.createStatement().executeQuery("SELECT LAST_INSERT_ID()");
			rs.next();
			long result = rs.getLong(1);
			rs.close();
			return result;
	}
}
