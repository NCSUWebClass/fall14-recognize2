package com.istudy.gameparts;

import com.istudy.enums.Difficulty;

/**
 * @author Gregory Daniels
 *
 */
public class UserSettingsBean {
	
	private Difficulty difficultySetting;
	
	private boolean musicSetting;
	
	private long uID;
	
	public void setUID(long uID){
		this.uID = uID;
	}
	
	public long getUID(){
		return uID;
	}

	public void setMusicSetting(boolean musicSetting){
		this.musicSetting = musicSetting; 
	}
	
	public boolean getMusicSetting(){
		return musicSetting;
	}
	
	public void setDifficulty(Difficulty d){
		this.difficultySetting = d;
	}
	
	public Difficulty getDifficulty(){
		return difficultySetting;
	}
	
	
}
