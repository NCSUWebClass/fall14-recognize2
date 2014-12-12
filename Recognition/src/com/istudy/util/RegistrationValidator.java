package com.istudy.util;

import java.util.ArrayList;

import com.istudy.auth.RegisterForm;
import com.istudy.enums.FormatValidation;
import com.istudy.exception.RegisterFormValidationException;

/**
 * @author Gregory Daniels
 *
 */
public class RegistrationValidator {
	
	
	ArrayList<String> registrationErrors = new ArrayList<String>();
	
	public RegistrationValidator() {
	}
	
	public void validate(RegisterForm regForm) throws RegisterFormValidationException{
		if(!FormatValidation.USERNAME.getRegex().matcher(regForm.getName()).matches()){
			registrationErrors.add(FormatValidation.USERNAME.name() + " " + FormatValidation.USERNAME.getDescription());
		}
		if (!FormatValidation.PASSWORD.getRegex().matcher(regForm.getPassword()).matches()){
			registrationErrors.add(FormatValidation.PASSWORD.name() + " " +FormatValidation.PASSWORD.getDescription());
		}
		if(registrationErrors.size() > 0){
			throw new RegisterFormValidationException(registrationErrors);
		}
	}
}
