package Services.Order;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import Models.Order.Order;
import Models.Order.OrderInterface;
import Models.Product.Product;
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
		String sql = "insert into orders (id, customer, product, quantity) values (?, ?, ?, ?)";
		int result = jdbcTemplate.update(
				sql, 
				new OrderRowMapper(),
				order.getId(),
				order.getCustomerID(),
				order.getProductID(),
				order.getQuantity()
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
		String sql = "select * from orders where vendor = ?";
		List<Order> orders = jdbcTemplate.query(sql, new OrderRowMapper(), user.getId());
		for (Order order : orders) {
			if(order.isAccepted() == true) {
				orders.remove(order);
			}
		}
		return orders;
	}
	
	public List<Order> getAllAcceptedOrder(User user){
		String sql = "select * from orders where vendor = ?";
		List<Order> orders = jdbcTemplate.query(sql, new OrderRowMapper(), user.getId());
		for (Order order : orders) {
			if(order.isAccepted() == false) {
				orders.remove(order);
			}
		}
		return orders;
	}
	
	public List<Order> getAllOrdersFromUsers(User user){
		String sql = "select * from orders where vendor = ?";
		List<Order> orders = jdbcTemplate.query(sql, new OrderRowMapper(), user.getId());
		return orders;
	}
	
	public int handleAccepting(Order order) {
		String sql = "update oders set isAccepted = true where vendor = ? and product = ?";
		int result = jdbcTemplate.update(sql, new OrderRowMapper(), order.getVendorID(), order.getProductID());
		return result;
	}
	

}
