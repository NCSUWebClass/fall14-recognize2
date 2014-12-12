package com.istudy.deprecated;

public class UserDoesntExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "User doesn't exist";
	
	public UserDoesntExistException(){
		super(MESSAGE);
	}
	
	public UserDoesntExistException(String message){
		super(message);
	}

}
