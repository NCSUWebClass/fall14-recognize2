package com.istudy.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import com.istudy.auth.UserBean;
import com.istudy.exception.AlbumFinishedException;
import com.istudy.gameparts.Album;
import com.istudy.gameparts.AlbumDatabase;

/**
 * @author Gregory Daniels
 *
 */
public class PlayAction2 {
	
	private UserBean currentUser;
	private ArrayList<String> sequence;
	private static Album selectedAlbum;
	private static final int ALT_SQ_SIZE = 6;
	private static PlayAction2 getGameInstance = null;
	
	public static PlayAction2 getGameInstance(UserBean loggedInUser, AlbumDatabase albumDatabase, String selectedAlbumTitle) throws SQLException {
		if(getGameInstance == null){
			getGameInstance = new PlayAction2(loggedInUser,albumDatabase,selectedAlbumTitle);
		} else if (!selectedAlbum.getTitle().equalsIgnoreCase(selectedAlbumTitle)){
			getGameInstance = new PlayAction2(loggedInUser,albumDatabase,selectedAlbumTitle);
		}
		return getGameInstance;
	}
	
	public void reset(){
		currentUser = null;
		sequence = null;
		selectedAlbum = null;
		getGameInstance = null;
	}
	
	public PlayAction2(UserBean loggedInUser, AlbumDatabase albumDatabase, String selectedAlbumTitle){
		currentUser = loggedInUser;
		selectedAlbum = albumDatabase.getAlbum(selectedAlbumTitle);
		sequence = new ArrayList<String>(ALT_SQ_SIZE);
		for(int i = 0; i < ALT_SQ_SIZE; i++){
			sequence.add(null);
		}
	}
	
	public ArrayList<String> randomChoiceSeq(){
		for(int i = 0; i < sequence.size(); i++){
			sequence.set(i, "_alt_"+String.valueOf((i+1)));
		}
		Collections.shuffle(sequence);
		for(int i = 0; i < sequence.size(); i++){
			if(sequence.get(i).contains("6")){
				sequence.set(i, "_correct");
			}
		}
		return sequence;
	}
	
	public UserBean getCurrentUser(){
		return currentUser;
	}
		
	public Album getSelectedAlbum(){
		return selectedAlbum;
	}
	
	public String getRandomSubTitle() throws AlbumFinishedException{
		return selectedAlbum.getRandomSubAlbum();
	}
	
//	public static void main(String[] args) throws RecogDBException, SQLException, AlbumFinishedException{
//		RecognitionDBFactory fact = RecognitionDBFactory.getProductionInstance();
//		AlbumsLoader al = new AlbumsLoader();
//		AlbumDatabase da = new AlbumDatabase(al);
//		PlayAction2 action = PlayAction2.getGameInstance(fact.getRecogUserDatabase().getUser("Papa2k15", "Password"), da, "Dogs");
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		action.reset();
//		action = PlayAction2.getGameInstance(fact.getRecogUserDatabase().getUser("PatelTheBest", "WeInThis"), da, "Aliens");
//		action.getSelectedAlbum().resetSubAlbums();
//		System.out.println("NEXT GAME");
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		action.reset();
//		action = PlayAction2.getGameInstance(fact.getRecogUserDatabase().getUser("Papa2k15", "Password"), da, "Superheros");
//		action.getSelectedAlbum().resetSubAlbums();
//		System.out.println("NEXT GAME");
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//		System.out.println(action.getSelectedAlbum().getRandomSubAlbum());
//	}
}
