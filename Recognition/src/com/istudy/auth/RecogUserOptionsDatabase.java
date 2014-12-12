package com.istudy.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.istudy.db.OptionLoader;
import com.istudy.db.RecogDBException;
import com.istudy.db.RecognitionDBFactory;
import com.istudy.util.RecogDBUtil;

/**
 * @author Gregory Daniels
 *
 */
public class RecogUserOptionsDatabase {
	
	private RecognitionDBFactory recogFactory;
	
	private OptionLoader optionLoader = new OptionLoader();

	public RecogUserOptionsDatabase(RecognitionDBFactory recogFactory) {
		this.recogFactory = recogFactory;
	}

	public long activateUserOptions(OptionBean userOptionBean) throws RecogDBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = recogFactory.getConnection();
			ps = conn.prepareStatement("INSERT INTO options (uID, musicsetting, sfxsetting, diffsetting) VALUES (?,?,?,?)");
			ps.setLong(1, userOptionBean.getUID());
			ps.setBoolean(2, userOptionBean.getMusicSetting());
			ps.setBoolean(3, userOptionBean.getSfxSetting());
			ps.setString(4, userOptionBean.getDiffSetting().toString());
			ps.executeUpdate();
			ps.close();
			return RecogDBUtil.getLastInsert(conn);
		} catch (SQLException e) {
			throw new RecogDBException(e);
		} finally {
			RecogDBUtil.closeConnection(conn, ps);
		}
	}
	
	public void updateOptions(OptionBean userOptionBean) throws RecogDBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = recogFactory.getConnection();
			ps = conn.prepareStatement("UPDATE options SET musicsetting = ?, sfxsetting = ?, diffsetting = ? WHERE uID = ?");
			ps.setBoolean(1, userOptionBean.getMusicSetting());
			ps.setBoolean(2, userOptionBean.getSfxSetting());
			ps.setString(3, userOptionBean.getDiffSetting().toString());
			ps.setLong(4, userOptionBean.getUID());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RecogDBException(e);
		} finally {
			RecogDBUtil.closeConnection(conn, ps);
		}
	}

	public OptionBean getOptions(long uID) throws RecogDBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = recogFactory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM options WHERE uID = ?");
			ps.setLong(1, uID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				OptionBean result = optionLoader.loadSingle(rs);
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
	
	public void deactivateUserOptions(long uID) throws RecogDBException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = recogFactory.getConnection();
			ps = conn.prepareStatement("DELETE FROM options WHERE uID=?");
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
