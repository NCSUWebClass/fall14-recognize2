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
public class SettingsAction {
			
	private RecogUserDatabase userDB;
	
	private RecogUserOptionsDatabase optDB;
	
	private UserBean currentUser;
	
	public SettingsAction(RecognitionDBFactory factory, UserBean currentUser) {
		userDB = factory.getRecogUserDatabase();
		optDB = factory.getRecogUserOptionsDatabase();
		this.currentUser = currentUser;
	}
	
	public void deactivateAccount() throws RecogDBException{
		userDB.deactivateUserAccount(currentUser.getUID());
		optDB.deactivateUserOptions(currentUser.getUID());
	}
	
	public void updateOptions(OptionBean updatedOptions) throws RecogDBException{
		optDB.updateOptions(updatedOptions);
	}

}
