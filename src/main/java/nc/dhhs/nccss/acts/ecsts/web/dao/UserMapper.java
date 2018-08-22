package nc.dhhs.nccss.acts.ecsts.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nc.dhhs.nccss.acts.ecsts.web.dao.model.UserInfo;

public class UserMapper implements RowMapper<UserInfo> {

	public UserInfo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		UserInfo user = new UserInfo();
		user.setId(resultSet.getLong("id"));
		user.setUsername(resultSet.getString("name"));
		user.setPassword(resultSet.getString("pass"));
		user.setRole(resultSet.getString("role"));
		return user;
	}
}
