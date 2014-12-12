package com.istudy.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.istudy.auth.OptionBean;
import com.istudy.auth.RecogUserDatabase;
import com.istudy.auth.RecogUserOptionsDatabase;
import com.istudy.auth.RegisterForm;
import com.istudy.auth.UserBean;
import com.istudy.db.RecogDBException;
import com.istudy.db.RecognitionDBFactory;
import com.istudy.enums.Difficulty;
import com.istudy.exception.RegisterFormValidationException;
import com.istudy.exception.UserNameAlreadyExistsException;
import com.istudy.util.RegistrationValidator;

/**
 * @author Gregory Daniels
 *
 */
public class RegisterAction {
	
	private RecogUserDatabase userDatabase;
	
	private RecogUserOptionsDatabase optDatabase;
	
	private RegistrationValidator validator = new RegistrationValidator();
	
	private static final int INITIAL_HIGHSCORE = 0;
	
	private static final String INITIAL_ROLE = "player";

	private static final String INITIAL_LAST_DAY_PLAYED = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
					
	public RegisterAction(RecognitionDBFactory factory){
		userDatabase = factory.getRecogUserDatabase();
		optDatabase = factory.getRecogUserOptionsDatabase();
	}
	
	public void addNewUser(RegisterForm regForm) throws RegisterFormValidationException, RecogDBException, UserNameAlreadyExistsException {
		if(!userDatabase.checkUserExists(regForm.getName())){
			validator.validate(regForm);
			UserBean user = new UserBean();
			user.setUserName(regForm.getName());
			user.setPassword(regForm.getPassword());
			user.setHighestScore(INITIAL_HIGHSCORE);
			user.setRole(INITIAL_ROLE);
			user.setLastDayPlayed(INITIAL_LAST_DAY_PLAYED);
			initializeUserOptions(userDatabase.addUser(user));
		} else {
			throw new UserNameAlreadyExistsException();
		}
	}
	
	private void initializeUserOptions(long uID) throws RecogDBException{
		OptionBean defaultOptions = new OptionBean(uID);
		defaultOptions.setMusicSetting(false);
		defaultOptions.setSfxSetting(false);
		defaultOptions.setDiffSetting(Difficulty.MED);
		optDatabase.activateUserOptions(defaultOptions);
	}
	
	

}
