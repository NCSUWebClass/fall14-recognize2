package com.istudy.auth;

import com.istudy.enums.Difficulty;

/**
 * @author Gregory Daniels
 *
 */
public class OptionBean {
	
	private long uID = 0;
	
	private boolean musicSetting = true;
	
	private boolean sfxSetting = true;
	
	private Difficulty diffSetting = Difficulty.MED;
	
	public OptionBean(long uID){
		this.uID = uID;
	}
	
	public long getUID(){
		return uID;
	}

	public boolean getMusicSetting() {
		return musicSetting;
	}

	public void setMusicSetting(boolean musicSetting) {
		this.musicSetting = musicSetting;
	}

	public boolean getSfxSetting() {
		return sfxSetting;
	}

	public void setSfxSetting(boolean sfxSetting) {
		this.sfxSetting = sfxSetting;
	}

	public Difficulty getDiffSetting() {
		return diffSetting;
	}

	public void setDiffSetting(Difficulty diffSetting) {
		this.diffSetting = diffSetting;
	}
}
