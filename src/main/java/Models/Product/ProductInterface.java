package Models.Product;

import java.util.List;

import Models.User.User;

public interface ProductInterface {
    int addProduct(Product product);
    Product getProductById(String id);
    List<Product> getProductByUser(User user);
    List<Product> getAllProduct();
    int updateProduct(Product product);
    int deleteProduct(Product product);
}
