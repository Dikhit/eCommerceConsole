package Application;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Services.Order.OrderService;
import Services.Products.ProductService;
import Services.User.UserServices;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		UserServices userServices = (UserServices) context.getBean("user");
		ProductService productService = (ProductService) context.getBean("product");
		OrderService orderService = (OrderService) context.getBean("order");
		
		
	}
}	
