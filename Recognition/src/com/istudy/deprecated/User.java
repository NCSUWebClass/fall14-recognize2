package com.istudy.deprecated;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.w3c.dom.Element;

import com.istudy.util.RecognizeUtil;

/**
 * Represents a User playing the game. 
 */
public class User {
	
	/** User name */
	private String name = "";
	
	/** Score for the user */
	private int currentScore = 0;
	
	/** Password for the user */
	private String password = "";

	private int highestScore = 0;

	private String lastDayPlayed = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
	
	/** Grabs user name and password from XML file */
	public User(Element userElement){
		this(RecognizeUtil.getStringValue(userElement, "name"), 
				RecognizeUtil.getStringValue(userElement, "password"),
				RecognizeUtil.getIntValue(userElement, "highscore"),
				RecognizeUtil.getStringValue(userElement, "ldayplay"));
	}
	
	/** Set user name and password when registering on website */
	public User(String name,String password,int highestScore, String lastDayPlayed){		
		if(name == null || name.length() <= 7 || name.equals("")) {
			throw new IllegalArgumentException("Username must be at least eight characters");
		}
		if (password == null || password.length() <= 7 || password.equals("")){
			throw new IllegalArgumentException("Password must be at least eight characters");
		}
		this.name = name;
		this.password = password;
		this.currentScore = 0;
		this.highestScore = highestScore;
		this.lastDayPlayed = lastDayPlayed;
	}
	
	public Date getLatestDatePlayedObj() {
		Date d = null; 
		try {
			d = new SimpleDateFormat("MM/dd/yyyy").parse(lastDayPlayed);
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
		
		return d;
	}

	public String getLatestDatePlayed() {
		return lastDayPlayed;
	}
	
	public void setLatestDatePlayed(String lastDayPlayed) {
		this.lastDayPlayed = lastDayPlayed;
	}

	/** Set the score for the user */
	public void setCurrentScore(int currentScore){
		this.currentScore = currentScore;
	}
	
	/** Returns the user's score */
	public int getCurrentScore(){
		return currentScore;
	}
	
	public void setHighestScore(int currentScore){
		this.highestScore = Math.max(currentScore, highestScore);
	}
	
	public int getHighestScore(){
		return highestScore;
	}
	
	/** Return the user's password */
	public String getPassword(){
		return password;
	}
	
	/** Return the name of the user */
	public String getName(){
		return name;
	}
	
	@Override
	public boolean equals(Object compare){
		boolean isEqual = false;
		if(compare == null){
			return isEqual;
		}
		if(compare instanceof User){
			User that = (User) compare;
			isEqual = (this.hashCode() == that.hashCode());
		}
		return isEqual;
	}
	
	@Override
	public int hashCode(){
		int code = 0;
		for(int i = 0; i < name.length(); i++){
			code += name.charAt(i) * 3;
		} 
		for(int i = 0; i < password.length(); i++){
			code += password.charAt(i) * 2;
		}
		return code;
	}

}
