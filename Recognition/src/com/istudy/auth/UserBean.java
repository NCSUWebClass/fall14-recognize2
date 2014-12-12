package com.istudy.auth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Gregory Daniels
 *
 */
public class UserBean {
	
	private long uID = 0L;
	
	private String userName = "";
	
	private int currentScore = 0;
	
	private String password = "";
	
	private String role = "";

	private int highestScore = 0;

	private String lastDayPlayed = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
	
	public UserBean(){
		
	}
	
	public UserBean(long uID){
		this.uID = uID;
	}
	
	public void setUID(long uID){
		this.uID = uID;
	}
	
	public long getUID(){
		return uID;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole(){
		return role;
	}
	
	public void setRole(String role){
		this.role = role;
	}

	public int getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}
	
	public void updateHighestScore(){
		this.highestScore = Math.max(highestScore, currentScore);
	}

	public String getLastDayPlayed() {
		return lastDayPlayed;
	}

	public void setLastDayPlayed(String lastDayPlayed) {
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
}
