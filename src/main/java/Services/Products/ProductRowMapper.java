package Services.Products;

import Models.Product.Product;
import Models.User.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(
                rs.getString("id"),
                rs.getString("name"),
                rs.getInt("price"),
                rs.getString("description"),
                rs.getString("vendorID"),
                rs.getString("createdAt")
        );
    }
}

