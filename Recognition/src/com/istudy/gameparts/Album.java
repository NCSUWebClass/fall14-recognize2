package com.istudy.gameparts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.istudy.exception.AlbumFinishedException;

/**
 * @author Gregory Daniels
 *
 */
public class Album {
	
	private Random randomSelect = new Random();
	
	private int ID;
	
	private String title;
	
	private LinkedList<String> subAlbumTitles;
	
	private ArrayList<Boolean> subHasBeenPlayed;
			
	public Album(String title, LinkedList<String> subAlbumTitles){
		this.title = title;
		this.subAlbumTitles = subAlbumTitles;
		subHasBeenPlayed = new ArrayList<Boolean>();
		for (int i = 0; i < subAlbumTitles.size(); i++) {
			subHasBeenPlayed.add(false);
		}
	}
	
	public String getTitle(){
		return title;
	}
	
	public int getID(){
		return ID;
	}
	
	public String getRandomSubAlbum() throws AlbumFinishedException{
		if(!allSubTitlesPlayed()){
			int num = randomSelect.nextInt(subAlbumTitles.size());
			if(!subHasBeenPlayed.get(num)){
				subHasBeenPlayed.set(num, true);
				return subAlbumTitles.get(num);
			} else {
				return getRandomSubAlbum();
			}
		} else {
			throw new AlbumFinishedException();
		}
	}
	
	public void resetSubAlbums(){
		subHasBeenPlayed = new ArrayList<Boolean>();
		for (int i = 0; i < subAlbumTitles.size(); i++) {
			subHasBeenPlayed.add(false);
		}
	}
	
	public boolean allSubTitlesPlayed(){
		if(subHasBeenPlayed.contains(false)){
			return false;
		} else {
			return true;
		}
	}
	
	public List<String> getSubAlbumTitles(){
		return subAlbumTitles;
	}
}
