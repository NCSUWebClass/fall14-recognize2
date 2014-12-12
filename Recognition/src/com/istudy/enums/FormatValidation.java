package com.istudy.enums;

import java.util.regex.Pattern;

/**
 * @author Gregory Daniels
 *
 */
public enum FormatValidation {
	USERNAME("[a-zA-Z0-9?\\-'.\\s]{8,40}", " must be between to 8-40 alphanumeric characters and symbols ?-'."), 
	DATE("[\\d]{2}/[\\d]{2}/[\\d]{4}", 			"MM/DD/YYYY"),
	PHONE_NUMBER("[\\d]{3}-[\\d]{3}-[\\d]{4}", 	"xxx-xxx-xxxx"),
	ROLE("^(?:admin|hcp|uap|test)$", "must be one of {admin, hcp, uap, test}"),
	EMAIL("^(([A-Za-z0-9]+_+)|([A-Za-z0-9]+\\-+)|([A-Za-z0-9]+\\.+)|([A-Za-z0-9]+\\++))*[A-Za-z0-9]+@((\\w+\\-+)|(\\w+\\.))*\\w{1,63}\\.[a-zA-Z]{2,6}$",
					"Up to 30 alphanumeric characters and symbols . and _ @"), 
						ANSWER("[a-zA-Z0-9\\s]{1,30}", "Up to 30 alphanumeric characters"),
	CITY("[a-zA-Z\\s]{1,15}", "Up to 15 characters"),
	STATE("[A-Z]{2}", "Two capital letters"),
	PASSWORD("[a-zA-Z0-9]{8,20}", " must be between 8-20 alphanumeric characters only.");

	private Pattern regex;
	private String description;

	private FormatValidation(String regex, String errorMessage) {
		this.regex = Pattern.compile(regex);
		this.description = errorMessage;
	}

	public Pattern getRegex() {
		return regex;
	}

	public String getDescription() {
		return description;
	}
}
