package Services.User;

import Models.User.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getInt("walletPrice"),
                rs.getString("password"),
                rs.getString("role"),
                rs.getString("createdAt")
        );
    }
}
