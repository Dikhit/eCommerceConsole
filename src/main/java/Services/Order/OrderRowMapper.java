package Services.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Models.Order.Order;

public class OrderRowMapper implements RowMapper<Order>{

	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Order(
				rs.getString("id"),
				rs.getString("customerID"),
				rs.getString("productID"),
				rs.getInt("quantity"),
				rs.getString("date")
			);
	}
}
