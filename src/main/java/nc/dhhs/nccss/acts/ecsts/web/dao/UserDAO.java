package nc.dhhs.nccss.acts.ecsts.web.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nc.dhhs.nccss.acts.ecsts.web.dao.model.UserInfo;

@Repository
public class UserDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public UserInfo getUserInfo(String username){
		String sql = "SELECT id, username name, password pass, authority role FROM "+
				"users WHERE username = ?";
		UserInfo userInfo = (UserInfo)jdbcTemplate.queryForObject(sql, new Object[]{username},
				new UserMapper());
		return userInfo;
	}
	
} 
