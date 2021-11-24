package Models.Product;

import Models.User.User;

public interface ProductInterface {
    boolean addProduct(Product product);
    Product getProductById(String id);
    Product[] getProductByUser(User user);
    Product[] getAllProduct();
    Product updateProduct(Product product);
    boolean deleteProduct(Product product);
}
