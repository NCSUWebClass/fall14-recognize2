package com.istudy.action;

import java.util.List;

import com.istudy.auth.RecogUserDatabase;
import com.istudy.auth.UserBean;
import com.istudy.db.RecogDBException;
import com.istudy.db.RecognitionDBFactory;

/**
 * @author Gregory Daniels
 *
 */
public class LeaderboardAction {
			
	private RecogUserDatabase userDB;
	
	public LeaderboardAction(RecognitionDBFactory factory) {
		userDB = factory.getRecogUserDatabase();
	}
	
	public List<UserBean> getAllUsersLB() throws RecogDBException{
		return userDB.getAllUsers();
	}

}
