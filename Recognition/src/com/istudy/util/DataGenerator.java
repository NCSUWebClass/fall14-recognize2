package com.istudy.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.istudy.db.RecognitionDBFactory;

/**
 * @author Gregory Daniels
 *
 */
public class DataGenerator {
	
	public static void main(String[] args) throws IOException, SQLException {
		DataGenerator gen = new DataGenerator();
		gen.clearAllTables();
		gen.generateUsers();	
		gen.generateOptions();
	}

	private String DIR = "sql/data";

	private RecognitionDBFactory factory;

	public DataGenerator() throws SQLException {
		this.factory = RecognitionDBFactory.getProductionInstance();
	}

	public DataGenerator(String projectHome, RecognitionDBFactory factory) {
		this.DIR = projectHome + "/sql/data";
		this.factory = factory;
	}
	
	public void clearAllTables() throws FileNotFoundException, SQLException, IOException{
		new RecogDBGeneratorUtil(factory).executeSQLFile(DIR + "/deleteFromAllTables.sql");
	}
	
	public void generateUsers() throws FileNotFoundException, SQLException, IOException{
		new RecogDBGeneratorUtil(factory).executeSQLFile(DIR + "/users.sql");
	}
	
	public void generateOptions() throws FileNotFoundException, SQLException, IOException{
		new RecogDBGeneratorUtil(factory).executeSQLFile(DIR + "/options.sql");
	}

}
