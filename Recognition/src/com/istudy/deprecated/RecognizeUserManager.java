package com.istudy.deprecated;

import java.io.File;

public class RecognizeUserManager {
	
	private static volatile RecognizeUserManager instance = new RecognizeUserManager();
	protected File userFile;	
	protected UserParser uParser;
	
	public static RecognizeUserManager getInstance() {
		instance = new RecognizeUserManager();
		return instance;
	}
	
    // private constructor
    private RecognizeUserManager() {	
    	userFile = new File(System.getProperty("user.home")+"/users.xml");
    	uParser = new UserParser(userFile);
    }
    
//    public static void main(String[] args){
//    	RecognizeUserManager r = RecognizeUserManager.getInstance();
//    	System.out.println(r.uParser.getUsers().get(0).getLatestDatePlayed());
//    }
}
