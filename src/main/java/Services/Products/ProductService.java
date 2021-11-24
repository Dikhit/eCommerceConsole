package Services.Products;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import Models.Product.Product;
import Models.Product.ProductInterface;
import Models.User.User;

public class ProductService implements ProductInterface{
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addProduct(Product product) {
		String sql = "insert into products (id, name, price, description, vendorID ) values(?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(
				sql, 
				new ProductRowMapper(),
				product.getId(),
				product.getName(),
				product.getPrice(),
				product.getDescription(),
				product.getVendorID()
			);
		return result;
	}

	public Product getProductById(String id) {
		String sql = "select * from products where id = ?";
		Product product = jdbcTemplate.queryForObject(sql, new ProductRowMapper(), id);
		return product;
	}

	public List<Product> getProductByUser(User user) {
		String sql = "select * from products where vendorID = ?";
		List<Product> products= jdbcTemplate.query(sql,  new ProductRowMapper());
		return products;
	}

	public List<Product> getAllProduct() {
		String sql = "select * from products";
		List<Product> products= jdbcTemplate.query(sql,  new ProductRowMapper());
		return products;
	}

	public int updateProduct(Product product) {
		String sql = "update products set  name = ?, price=?, description = ? where id = ? ";
		int result = jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getDescription());
		return result;
	}

	public int deleteProduct(Product product) {
		String sql = "delete from products where id = ?";
		int result = jdbcTemplate.update(sql, new ProductRowMapper());
		return result;
	}

}
