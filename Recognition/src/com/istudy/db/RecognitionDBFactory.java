package com.istudy.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.istudy.auth.RecogUserDatabase;
import com.istudy.auth.RecogUserOptionsDatabase;

/**
 * @author Gregory Daniels
 *
 */
public class RecognitionDBFactory {
	
	private static RecognitionDBFactory productionInstance = null;
	private RecogConnectionDriverI driver;
	
	public static RecognitionDBFactory getProductionInstance() throws SQLException {
			productionInstance = new RecognitionDBFactory();
		return productionInstance;
	}
	
	protected RecognitionDBFactory() throws SQLException {
		this.driver = new RecogConnectionDriver();
	}	
	
	public Connection getConnection() throws SQLException {
		return driver.getConnection();
	}
	
	public RecogUserDatabase getRecogUserDatabase(){
		return new RecogUserDatabase(this);
	}
	
	public RecogUserOptionsDatabase getRecogUserOptionsDatabase(){
		return new RecogUserOptionsDatabase(this);
	}
}
