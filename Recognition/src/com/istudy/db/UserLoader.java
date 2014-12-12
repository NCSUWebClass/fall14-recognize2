package com.istudy.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.istudy.auth.UserBean;

/**
 * @author Gregory Daniels
 *
 */
public class UserLoader {

	public UserBean loadSingle(ResultSet rs) throws SQLException {
		UserBean userBean = new UserBean(rs.getLong("uID"));
		userBean.setUserName(rs.getString("username"));
		userBean.setPassword(rs.getString("password"));
		userBean.setRole(rs.getString("role"));
		userBean.setHighestScore(rs.getInt("highestscore"));
		userBean.setLastDayPlayed(new SimpleDateFormat("MM/dd/yyyy").format(new Date(rs.getDate("ldayplayed").getTime())));
		return userBean;
	}
	
	public List<UserBean> loadList(ResultSet rs) throws SQLException {
		List<UserBean> list = new ArrayList<UserBean>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc.itrust.beans.loaders.BeanLoader#loadParameters(java.sql.PreparedStatement, java.lang.Object)
	 */
	public PreparedStatement loadParameters(PreparedStatement ps, UserBean uBean) throws SQLException {
		return null;
	}
}
