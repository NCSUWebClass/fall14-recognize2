package com.istudy.deprecated;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.istudy.exception.UserNameAlreadyExistsException;

public class UserParser {

//	/** The host for the User XML file. */
//	private static final String HOST = "localhost:8080";

	/** The path for the USer XML file. */
	@SuppressWarnings("unused")
	private static final String PATH = "//Recognition//WebContent//users.xml";

	private List<User> users;

	private File userFile;

	Document dom;

	public UserParser(File usersXMLFile) {
		userFile = usersXMLFile;
		parseUsers();
	}

	private void parseUsers() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		users = new LinkedList<User>();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.parse(userFile);
			Element docRootElement = dom.getDocumentElement();
			NodeList nl = docRootElement.getElementsByTagName("player");
			if (nl != null && nl.getLength() > 0) {
				for (int i = 0; i < nl.getLength(); i++) {
					Element wEle = (Element) nl.item(i);
					User w = new User(wEle);
					users.add(w);
				}
			}
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void addUser(User userToAdd) throws FileNotFoundException,
	UserNameAlreadyExistsException {
		if(!userNameExists(userToAdd)){ 
			PrintStream addUser = new PrintStream(userFile);
			addUser.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<users>"); 
			int i = 0; 
			while(i < users.size()){
					addUser.println("<player><name>" +users.get(i).getName()
							+"</name><password>" +users.get(i).getPassword()
							+"</password><highscore>" + users.get(i).getHighestScore() 
							+ "</highscore><ldayplay>" + users.get(i).getLatestDatePlayed()
							+ "</ldayplay></player>"); i++; 
			}
			addUser.println("<player><name>" +userToAdd.getName()
					+"</name><password>" + userToAdd.getPassword()
					+"</password><highscore>" + userToAdd.getHighestScore()
					+ "</highscore><ldayplay>" + userToAdd.getLatestDatePlayed()
					+ "</ldayplay></player>");
				addUser.print("</users>"); 
				addUser.close(); 
				parseUsers(); 
			} else {
				throw new UserNameAlreadyExistsException(); 
			}
	}

//	private void addUser(User user, String yes) {
//		/* Setup an FTP client for connecting with the user XML file. */
//		FTPClient ftpClient = new FTPClient();
//		try {
//			/* Tell the client to read files in binary mode. */
//			ftpClient.setFileType(FTP.BINARY_FILE_TYPE, FTP.BINARY_FILE_TYPE);
//			ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
//			/* Attempt to open a connection to the file host. */
//			int reply = 0;
//			ftpClient.connect(HOST);
//			/* Retrieve the status of the socket connection. */
//			reply = ftpClient.getReplyCode();
//			/* If the connection was refused, quit the program. */
//			if (!FTPReply.isPositiveCompletion(reply)) {
//				ftpClient.disconnect();
//				System.err.println("FTP server refused connection.");
//				System.exit(1);
//			}
//			/* Store the file. */
//			ftpClient.storeFile("users.xml", getUserInputStream(user));
//		} catch (SocketException ex) {
//			ex.printStackTrace();
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		} finally {
//			/* Attempt to close the connection to the host. */
//			if (ftpClient.isConnected()) {
//				try {
//					ftpClient.disconnect();
//				} catch (IOException ex) {
//					/* Do nothing. */
//				}
//			}
//		}
//	}
//
//	/**
//	 * Returns an input stream for the User XML data.
//	 */
//	private FileInputStream getUserInputStream(User user) {
//		File localFile = new File("users.xml");
//		try {
//			BufferedWriter writer = new BufferedWriter(
//					new FileWriter(localFile));
//			StringBuilder builder = new StringBuilder();
//			builder.append("<users>\n");
//			for (User u : users) {
//				builder.append("<player><name>");
//				builder.append(u.getName());
//				builder.append("</name><password>");
//				builder.append(u.getPassword());
//				builder.append("</password></player>\n");
//			}
//			builder.append("<player><name>");
//			builder.append(user.getName());
//			builder.append("</name><password>");
//			builder.append(user.getPassword());
//			builder.append("</password></player>\n");
//			builder.append("</users>");
//			writer.write(builder.toString());
//			writer.close();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		FileInputStream inputStream = null;
//		try {
//			inputStream = new FileInputStream(localFile.getAbsolutePath());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		return inputStream;
//	}

	private boolean userNameExists(User userToAdd) {
		boolean exists = false;
		for (int i = 0; i < users.size(); i++) {
			if (userToAdd.getName().equalsIgnoreCase(users.get(i).getName())) {
				exists = true;
				return exists;
			}
		}
		return exists;
	}

	public void removeUser(User userToRemove) throws FileNotFoundException,
	UserDoesntExistException {
		if (users.contains(userToRemove)) {
			PrintStream removeUser = new PrintStream(userFile);
			removeUser
			.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<users>");
			int i = 0;
			while (i < users.size()) {
				if (!userToRemove.equals(users.get(i))) {
					removeUser.println("<player><name>" +users.get(i).getName()
							+"</name><password>" +users.get(i).getPassword()
							+"</password><highscore>" + users.get(i).getHighestScore() 
							+ "</highscore><ldayplay>" + users.get(i).getLatestDatePlayed()
							+ "</ldayplay></player>"); i++;
				}
				i++;
			}
			removeUser.print("</users>");
			removeUser.close();
			parseUsers();
		} else {
			throw new UserDoesntExistException();
		}
	}

	public void printUserNames() {
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getName());
		}
	}

	public List<User> getUsers() {
		return users;
	}
}
