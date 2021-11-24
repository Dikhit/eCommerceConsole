package Services.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Models.Order.Order;

public class OrderRowMapper implements RowMapper<Order>{

	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Order(
				rs.getString("id"),
				rs.getString("customer"),
				rs.getString("product"),
				rs.getInt("quantity"),
				rs.getInt("totalPrice"),
				rs.getBoolean("isAccepted"),
				rs.getString("vendor"),
				rs.getString("orderedAt")
			);
	}
}
