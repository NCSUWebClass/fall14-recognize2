package com.istudy.exception;

import java.util.ArrayList;

/**
 * @author Gregory Daniels
 *
 */
public class RegisterFormValidationException extends Exception {

	private static final long serialVersionUID = 6702099083264864724L;
	
	private ArrayList<String> errors;
	
	public RegisterFormValidationException(ArrayList<String> registrationErrors) {
		errors = registrationErrors;
	}
	
	public  ArrayList<String> getErrorMessages(){
		return errors;
	}

}
