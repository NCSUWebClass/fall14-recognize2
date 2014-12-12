package com.istudy.util;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.istudy.gameparts.Album;

/**
 * @author Gregory Daniels
 *
 */
public class RecognizeUtil {

	public static String getStringValue(Element e, String ID){
		String textVal = null;
		NodeList nl = e.getElementsByTagName(ID);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}
		if (textVal != null){
			return textVal;
		} else {
			throw new IllegalArgumentException("Element doesn't exist within XML Document.");
		}
	}
	
	public static int getIntValue(Element e, String ID){
		return Integer.valueOf(getStringValue(e,ID));
	}
	
	public static String generateLinkToSubAlbumImages(Album currentAlbum, String subAlbumTitle) throws Exception{
		if ( currentAlbum != null && subAlbumTitle != null){
			return "images/"+currentAlbum.getTitle()+"/"+subAlbumTitle+"/"+subAlbumTitle.split(" ")[0].toLowerCase();
		} else {
			throw new Exception();
		}
	}
}
