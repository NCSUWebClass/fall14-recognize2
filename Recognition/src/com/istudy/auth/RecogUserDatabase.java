package com.istudy.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.istudy.db.RecogDBException;
import com.istudy.db.RecognitionDBFactory;
import com.istudy.db.UserLoader;
import com.istudy.util.RecogDBUtil;

/**
 * @author Gregory Daniels
 *
 */
public class RecogUserDatabase {
	
	private RecognitionDBFactory recogFactory;
	
	private UserLoader userLoader = new UserLoader();

	public RecogUserDatabase(RecognitionDBFactory recogFactory) {
		this.recogFactory = recogFactory;
	}

	public long addUser(UserBean userBean) throws RecogDBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = recogFactory.getConnection();
			ps = conn.prepareStatement("INSERT INTO users (username, password, role, highestscore, ldayplayed) VALUES (?,?,?,?,?)");
			ps.setString(1, userBean.getUserName());
			ps.setString(2, userBean.getPassword());
			ps.setString(3, userBean.getRole());
			ps.setInt(4, userBean.getHighestScore());
			ps.setDate(5, new java.sql.Date(userBean.getLatestDatePlayedObj().getTime()));			
			ps.executeUpdate();
			ps.close();
			return RecogDBUtil.getLastInsert(conn);
		} catch (SQLException e) {
			throw new RecogDBException(e);
		} finally {
			RecogDBUtil.closeConnection(conn, ps);
		}
	}
	
	public void updateUser(UserBean userBean) throws RecogDBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = recogFactory.getConnection();
			ps = conn.prepareStatement("UPDATE users SET username = ?, password = ?, role = ?, highestscore = ?, ldayplayed = ? WHERE uID = ?");
			ps.setString(1, userBean.getUserName());
			ps.setString(2, userBean.getPassword());
			ps.setString(3, userBean.getRole());
			ps.setInt(4, userBean.getHighestScore());
			ps.setDate(5, new java.sql.Date(userBean.getLatestDatePlayedObj().getTime()));	
			ps.setLong(6, userBean.getUID());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RecogDBException(e);
		} finally {
			RecogDBUtil.closeConnection(conn, ps);
		}
	}

	public UserBean getUser(String username, String password) throws RecogDBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = recogFactory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				UserBean result = userLoader.loadSingle(rs);
				rs.close();
				ps.close();
				return result;
			}
			else{
				rs.close();
				ps.close();
				return null;
			}
		} catch (SQLException e) {
			throw new RecogDBException(e);
		} finally {
			RecogDBUtil.closeConnection(conn, ps);
		}
	}

	public boolean checkUserExists(String name) throws RecogDBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = recogFactory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM users WHERE username=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			boolean check = rs.next();
			rs.close();
			ps.close();
			return check;
		} catch (SQLException e) {
			
			throw new RecogDBException(e);
		} finally {
			RecogDBUtil.closeConnection(conn, ps);
		}
	}
	
	public List<UserBean> getAllUsers() throws RecogDBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = recogFactory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM users ORDER BY highestscore DESC");
			ResultSet rs = ps.executeQuery();
			List<UserBean> loadlist = userLoader.loadList(rs);
			rs.close();
			ps.close();
			return loadlist;
		} catch (SQLException e) {
			throw new RecogDBException(e);
		} finally {
			RecogDBUtil.closeConnection(conn, ps);
		}
	}
	
	public void deactivateUserAccount(long uID) throws RecogDBException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = recogFactory.getConnection();
			ps = conn.prepareStatement("DELETE FROM users WHERE uID=?");
			ps.setLong(1, uID);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RecogDBException(e);
		} finally {
			RecogDBUtil.closeConnection(conn, ps);
		}
	}
}
