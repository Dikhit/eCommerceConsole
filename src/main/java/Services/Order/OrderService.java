package Services.Order;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import Models.Order.Order;
import Models.Order.OrderInterface;
import Models.User.User;

public class OrderService implements OrderInterface{
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int createOrder(Order order) {
		String sql = "insert into orders (id, customer, vendor, product, quantity, totalPrice) values (?, ?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(
				sql,
				order.getId(),
				order.getCustomerID(),
				order.getVendorID(),
				order.getProductID(),
				order.getQuantity(),
				order.getTotalPrice()
			);
		return result;
	}

	public Order getOrderById(String id) {
		return null;
	}

	public List<Order> getOrderByUser(User user) {
		String sql = "select * from orders where customer = ?";
		List<Order> orders = jdbcTemplate.query(sql, new OrderRowMapper(), user.getId());
		return orders;
	}

	public List<Order> getAllOrders() {
		String sql = "select * from orders";
		List<Order> orders = jdbcTemplate.query(sql, new OrderRowMapper());
		return orders;
	}
	
	public List<Order> getAllUnAcceptedOrder(User user){
		String sql = "select * from orders where vendor = ? and isAccepted = false";
		List<Order> orders = jdbcTemplate.query(sql, new OrderRowMapper(), user.getId());
		System.out.println(orders.toString());
		return orders;
	}
	
	public List<Order> getAllAcceptedOrder(User user){
		String sql = "select * from orders where vendor = ? and isAccepted = true";
		List<Order> orders = jdbcTemplate.query(sql, new OrderRowMapper(), user.getId());
		return orders;
	}
	
	public List<Order> getAllOrdersFromUsers(User user){
		String sql = "select * from orders where vendor = ?";
		List<Order> orders = jdbcTemplate.query(sql, new OrderRowMapper(), user.getId());
		return orders;
	}
	
	public int handleAccepting(Order order) {
		String sql = "update orders set isAccepted = true where id = ?";
		int result = jdbcTemplate.update(sql, order.getId());
		return result;
	}
	

}
