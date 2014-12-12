package com.istudy.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.istudy.auth.OptionBean;
import com.istudy.enums.Difficulty;

/**
 * @author Gregory Daniels
 *
 */
public class OptionLoader {

	public OptionBean loadSingle(ResultSet rs) throws SQLException {
		OptionBean optBean = new OptionBean(rs.getLong("uID"));
		optBean.setMusicSetting(rs.getBoolean("musicsetting"));
		optBean.setSfxSetting(rs.getBoolean("sfxsetting"));
		optBean.setDiffSetting(Difficulty.parse(rs.getString("diffsetting")));
		return optBean;
	}

}
