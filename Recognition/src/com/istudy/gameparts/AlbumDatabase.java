package com.istudy.gameparts;

import java.util.LinkedList;

/**
 * @author Gregory Daniels
 *
 */
public class AlbumDatabase extends LinkedList<Album>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	public AlbumDatabase(AlbumsLoader albumLoader){
		for(Album a : albumLoader.getAllAlbums()){
			this.add(a);
		}
	}
	
	public Album getAlbum(String albumTitle){
		for (Album a: this) {
			if(a.getTitle().equalsIgnoreCase(albumTitle)){
				return a;
			}
		}
		return null;
	}

	public boolean contains(String albumTitle){
		boolean contain = false;
		for(Album a: this){
			if(a.getTitle().equalsIgnoreCase(albumTitle)){
				contain = true;
				break;
			}
		}
		return contain;
	}
}
