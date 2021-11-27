package Templates;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;

import DAO.ProductDAO;
import DAO.UserDAO;
import Models.Order.Order;
import Models.Product.Product;
import Models.User.User;

public class OrderTemplates {
	private static Scanner userInput = new Scanner(System.in);
	
	public static Order newOrderTemplate(User currentUser, AbstractApplicationContext context) {

        System.out.println("New Order ...");
        List<Product> products = ProductDAO.getProductDAO(context).getAllProduct();
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + "-->");
            System.out.println(products.get(i).getName());
            System.out.println(products.get(i).getPrice());
            System.out.println(products.get(i).getDescription());
            System.out.println(products.get(i).getDate());
            System.out.println("\n");
        }
        
        int choice = userInput.nextInt();
        userInput.nextLine();
        
        int totalPrice = userInput.nextInt();
        userInput.nextLine();
        
        String customerID = currentUser.getId();
        
        Product product =  products.get(choice);
        String productID = product.getId();
        String vendorID = product.getVendorID();

        System.out.println("Enter the quantity : ");
        int quantity = userInput.nextInt();
        
        if(currentUser.getWalletPrice() >= product.getPrice() * quantity){
            Order order = new Order(customerID, vendorID, productID, quantity, totalPrice);
            currentUser.setWalletPrice(
                    currentUser.getWalletPrice() - product.getPrice() * quantity
            );
            UserDAO.getUserDAO(context).updateUser(currentUser);
            return order;
        }
        else{
            System.out.println("Not Enough Balance !! Recharge Your Wallet !!");
        }
        return null;
    }
}
