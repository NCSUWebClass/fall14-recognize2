package com.istudy.exception;

/**
 * @author Gregory Daniels
 *
 */
public class AlbumFinishedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "All images have been played for this album";
	
	public AlbumFinishedException(){
		super(MESSAGE);
	}
	
	public AlbumFinishedException(String message){
		super(message);
	}

}
