package com.istudy.action;

import java.util.LinkedList;

import com.istudy.gameparts.Album;
import com.istudy.gameparts.AlbumDatabase;

/**
 * Action that is represented from the user selecting an album to play.
 * @author Gregory Daniels
 *
 */
public class AlbumSelectAction {
	
	private AlbumDatabase albumDatabase;
				
	public AlbumSelectAction(AlbumDatabase albumDatabase) {
		this.albumDatabase = albumDatabase;
	}
	
	public Album selectAblum(String albumTitle){
		return albumDatabase.getAlbum(albumTitle);
	}
	
	public LinkedList<Album> getAllAlbums(){
		return albumDatabase;
	}
}
