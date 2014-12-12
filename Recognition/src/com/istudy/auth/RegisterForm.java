package com.istudy.auth;

/**
 * @author Gregory Daniels
 *
 */
public class RegisterForm {
	
	private String name;
	
	private String password;
	
	public String getPassword(){
		return password;
	}

	public String getName(){
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
