package com.istudy.gameparts;

import java.io.File;
import java.util.LinkedList;

/**
 * @author Gregory Daniels
 *
 */
public class AlbumsLoader {
	
	private static volatile AlbumsLoader instance = new AlbumsLoader();
	private LinkedList<Album> albums;

	public static AlbumsLoader getInstance() {
		instance = new AlbumsLoader();
		return instance;
	}
	
	public AlbumsLoader(){
		File f = new File(System.getProperty("user.home")+"/DEVELOPMENT/CSC342FinalProject/Recognition/WebContent/images");
		albums = new LinkedList<Album>();
		int i = 0;
		while(i < f.listFiles().length){
			File fi = f.listFiles()[i];
			Album a = null;
			LinkedList<String> subAlbumTitles = new LinkedList<String>();
			if(fi.isDirectory()){
				int j = 0;
				while(j < fi.listFiles().length){
					File fj = fi.listFiles()[j];
					if(fj.isDirectory()){
						subAlbumTitles.add(fj.getName());
					}
					j++;
				}
			}
			a = new Album(fi.getName(),subAlbumTitles);
			albums.add(a);
			i++;
		}
	}
	
	public LinkedList<Album> getAllAlbums(){
		return albums;
	}
}
