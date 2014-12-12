package com.istudy.exception;

/**
 * @author Gregory Daniels
 *
 */
public class UserNameAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "Username is already taken";
	
	public UserNameAlreadyExistsException(){
		super(MESSAGE);
	}
	
	public UserNameAlreadyExistsException(String message){
		super(message);
	}

}
