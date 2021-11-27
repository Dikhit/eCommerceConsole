package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.OrderDAO;
import DAO.ProductDAO;
import DAO.UserDAO;
import Models.Order.Order;
import Models.Product.Product;
import Models.User.User;
import Services.Order.OrderService;
import Services.Products.ProductService;
import Services.User.UserServices;
import Templates.OrderTemplates;
import Templates.ProductTemplate;
import Templates.UserTemplates;

public class App {
	private static AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	private static UserServices userServices = UserDAO.getUserDAO(context);
	private static ProductService productService = ProductDAO.getProductDAO(context);
	private static OrderService orderService = OrderDAO.getOrderDAO(context);
	
		public static void main(String[] args) {
	        Scanner userInput = new Scanner(System.in);
	        boolean isLoggedOut = false;
	        while(!isLoggedOut){
	            System.out.println("1. Registration \n2. LogIn \n3. Any other value for exit !!");
	            System.out.println("Enter your choice : ");
	            int choice = userInput.nextInt();
	            userInput.nextLine();

	            switch (choice){
	                case 1:
	                    System.out.println("Enter your name : ");
	                    String name = userInput.nextLine();

	                    System.out.println("Enter your email : ");
	                    String email = userInput.nextLine();

	                    System.out.println("Enter some amount for your wallet : ");
	                    int walletPrice = userInput.nextInt();
	                    userInput.nextLine();

	                    System.out.println("Enter your password : ");
	                    String password = userInput.nextLine();

	                    User customer = new User(name, email, walletPrice, password);
	                    User currentUser = userServices.register(customer);
	                    if ( currentUser != null){
	                        System.out.println("Your registration details ...");
	                        System.out.println(currentUser);
	                    }
	                    break;

	                case 2:
	                    System.out.println("Enter your email : ");
	                    email = userInput.nextLine().trim();

	                    System.out.println("Enter your password : ");
	                    password = userInput.nextLine().trim();

	                    currentUser = userServices.logIn(email,password);
	                    if (currentUser != null){
	                        System.out.println(currentUser);

	                        if (currentUser.getRole().equals("ADMIN")){
	                            System.out.println("1. Update my Profile !!");
	                            System.out.println("2. My Order List !!");
	                            System.out.println("3. New Order !!");

	                            System.out.println("4. Display My Products !!");
	                            System.out.println("5. Add New Product in my store !!");

	                            System.out.println("6. Product Update !!");

	                            System.out.println("7. Change Role of Any User !!");
	                            //System.out.println("8. Create new Role !!");
	                            System.out.println("9. Check all order history !!");

	                            choice = userInput.nextInt();
	                            userInput.nextLine();

	                            switch (choice){
	                                case 1:
	                                    UserTemplates.updateProfileTemplate(currentUser, context);
	                                    break;
	                                case 2:
	                                    System.out.println("Your all Orders are listed bellow !!");
	                                    List<Order> orderDetails = orderService.getOrderByUser(currentUser);
	                                    for (Order order : orderDetails ){
	                                        System.out.println(order);
	                                    }
	                                    break;

	                                case 3:
	                                    Order order = OrderTemplates.newOrderTemplate(currentUser, context);
	                                    if (orderService.createOrder(order) == 1){
	                                        System.out.println("Order placed Successfully !!");
	                                    }
	                                    else {
	                                        System.out.println("Something went wrong !!");
	                                    }
	                                    break;

	                                case 4:
	                                    System.out.println("My Products !!");
	                                    List<Product> products = productService.getProductByUser(currentUser);
	                                    for (Product product : products) {
	                                        System.out.println(product.getName());
	                                        System.out.println(product.getPrice());
	                                        System.out.println(product.getDescription());
	                                        System.out.println("\n");
	                                    }
	                                    break;
	                                case 5:
	                                    Product newProduct = ProductTemplate.addingNewProduct(currentUser);
	                                    if(productService.addProduct(newProduct) == 1){
	                                        System.out.println("Your product added successfully");
	                                    }
	                                    else{
	                                        System.out.println("not able to store your product !!");
	                                    }
	                                    break;
	                                case 6:
	                                    System.out.println("Product Update !!");
	                                    products = productService.getProductByUser(currentUser);
	                                    for (int i = 0; i < products.size(); i++) {
	                                        System.out.println(i);
	                                        System.out.println(products.get(i).getName());
	                                        System.out.println(products.get(i).getPrice());
	                                        System.out.println(products.get(i).getDescription());
	                                        System.out.println("\n");
	                                    }
	                                    choice = userInput.nextInt();
	                                    userInput.nextLine();
	                                    Product product = ProductTemplate.updateProduct(products.get(choice));
	                                    if( productService.updateProduct(product) == 1){
	                                        System.out.println("Updated Successfully !!");
	                                    }
	                                    else {
	                                        System.out.println("Something went wrong !!");
	                                    }
	                                    break;

	                                case 7:
	                                    System.out.println("List of All Users... ");
	                                    List<User> users = userServices.getAllUser();
	                                    for (int i = 0; i < users.size(); i++) {
	                                        User user = users.get(i);
	                                        System.out.println(i);
	                                        System.out.println(user.getName());
	                                        System.out.println(user.getEmail());
	                                        System.out.println(user.getWalletPrice());
	                                        System.out.println(user.getRole());
	                                    }
	                                    choice = userInput.nextInt();
	                                    userInput.nextLine();
	                                    System.out.println("Enter the new role : ");
	                                    String role = userInput.nextLine();
	                                    User user = users.get(choice);
	                                    if (role.equals("VENDOR") || role.equals("ADMIN")){
	                                        user.setRole(role);
	                                        if(userServices.updateUser(user) != null){
	                                            System.out.printf("Updated Successfully !!");
	                                        }
	                                        else{
	                                            System.out.printf("Not updated !!");
	                                        }

	                                    }
	                                    else{
	                                        System.out.println("Not a valid role !!");
	                                    }
	                                    break;

	                                case 8:
	                                    System.out.println("Create new role !!");
	                                    break;

	                                case 9:
	                                    System.out.println("All Orders ...");
	                                    orderDetails = orderService.getAllOrders();
	                                    for (Order o : orderDetails ){
	                                        System.out.println(o);
	                                    }
	                                    break;
	                            }
	                        }

	                        else if (currentUser.getRole().equals("VENDOR")){
	                            System.out.println("1. Update my Profile !!");
	                            System.out.println("2. My Order List !!");
	                            System.out.println("3. New Order !!");

	                            System.out.println("4. Display My Products !!");
	                            System.out.println("5. Add New Product in my store !!");
	                            //System.out.println("6. Product Update !!");

	                            choice = userInput.nextInt();
	                            userInput.nextLine();

	                            switch (choice){
	                                case 1:
	                                    UserTemplates.updateProfileTemplate(currentUser, context);
	                                    break;

	                                case 2:
	                                    System.out.println("Your all Orders are listed bellow !!");
	                                    List<Order> orderDetails = orderService.getAllOrdersFromUsers(currentUser);
	                                    for (Order order : orderDetails ){
	                                        System.out.println(order);
	                                    }
	                                    break;

	                                case 3:
	                                    Order order = OrderTemplates.newOrderTemplate(currentUser, context);
	                                    if (orderService.createOrder(order) == 1){
	                                        System.out.println("Order placed Successfully !!");
	                                    }
	                                    else {
	                                        System.out.println("Something went wrong !!");
	                                    }
	                                    break;

	                                case 4:
	                                    System.out.println("My Products !!");
	                                    List<Product> products = productService.getProductByUser(currentUser);
	                                    for (Product product : products) {
	                                        System.out.println(product.getName());
	                                        System.out.println(product.getPrice());
	                                        System.out.println(product.getDescription());
	                                        System.out.println("\n");
	                                    }
	                                    break;

	                                case 5:
	                                    System.out.println("Adding new Product .. ");
	                                    Product newProduct = ProductTemplate.addingNewProduct(currentUser);
	                                    System.out.println(newProduct);
	                                    if(productService.addProduct(newProduct) == 1){
	                                        System.out.println("Your product added successfully");
	                                    }
	                                    else{
	                                        System.out.println("not able to store your product !!");
	                                    }
	                                    break;
	                                case 6:
	                                    System.out.println("Update Product !!");
	                                    break;
	                                default:
	                                    break;
	                            }
	                        }

	                        else if(currentUser.getRole().equals("CUSTOMER")){
	                            System.out.println("1. Update my Profile !!");
	                            System.out.println("2. My Order List !!");
	                            System.out.println("3. New Order !!");
	                            choice = userInput.nextInt();
	                            userInput.nextLine();
	                            switch (choice){
	                                case 1:
	                                    UserTemplates.updateProfileTemplate(currentUser, context);
	                                    break;

	                                case 2:
	                                    System.out.println("Your all Orders are listed bellow !!");
	                                    List<Order> orderDetails = orderService.getAllOrders();
	                                    for (Order order : orderDetails ){
	                                        System.out.println(order);
	                                    }
	                                    break;
	                                case 3:
	                                    Order order = OrderTemplates.newOrderTemplate(currentUser, context);
	                                    if (orderService.createOrder(order) == 1){
	                                        System.out.println("Order placed Successfully !!");
	                                    }
	                                    else {
	                                        System.out.println("Something went wrong !!");
	                                    }
	                                    break;
	                            }
	                        }
	                    }
	                    break;
	                default:
	                    isLoggedOut = true;
	                    break;
	            }
	        }

	    }			

}	
