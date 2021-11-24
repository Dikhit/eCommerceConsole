package Services.User;

import org.springframework.jdbc.core.JdbcTemplate;

import Models.User.User;
import Models.User.UserInterface;

public class UserServices implements UserInterface{
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public User logIn(String email, String password) {
		String sql = "select * from users where email = ? and password = ?";
		User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), email, password);
		return user;
	}

	public int register(User user) {
//		String sql = 
		return 0;
	}

	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User[] getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
