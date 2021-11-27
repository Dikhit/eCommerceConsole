package Services.User;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

	public User register(User user) {
		String sql = "insert into users(id, name, email, walletPrice, password, role) values(?, ?, ?, ?, ?, ?)";
		Serializable result =  jdbcTemplate.update(
				sql,
				user.getId(), user.getName(), user.getEmail(), user.getWalletPrice(), user.getPassword(), user.getRole()
		);
		System.out.println(result);
		return getUserById(user.getId());
		
	}

	public User updateUser(User user) {
		String sql = "update users set name=?, email = ?, walletPrice=?, password= ?, role = ? where id = ?";
		jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getWalletPrice(), user.getPassword(), user.getRole(), user.getId());
		return getUserById(user.getId());
	}

	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public User getUserById(String id) {
		String sql = "select * from users where id = ?";
		User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
		return user;
	}

	public List<User> getAllUser() {
		String sql = "select * from users";
		List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
		return users;
	}
	
}
