package com.istudy.action;

import com.istudy.auth.OptionBean;
import com.istudy.auth.RecogUserDatabase;
import com.istudy.auth.RecogUserOptionsDatabase;
import com.istudy.auth.UserBean;
import com.istudy.db.RecogDBException;
import com.istudy.db.RecognitionDBFactory;

/**
 * @author Gregory Daniels
 *
 */
public class LoginAction {	
	
	private RecogUserDatabase userDatabase;
	
	private RecogUserOptionsDatabase optDatabase;
	
	
	public LoginAction(RecognitionDBFactory factory){
		userDatabase = factory.getRecogUserDatabase();
		optDatabase = factory.getRecogUserOptionsDatabase();
	}
	
	public UserBean login(String username, String password) throws RecogDBException{
		return userDatabase.getUser(username, password);
	}
	
	public OptionBean getCurrentUserOptions(long uID) throws RecogDBException{
		return optDatabase.getOptions(uID);
	}
}
