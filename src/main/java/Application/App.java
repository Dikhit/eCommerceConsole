package Application;

import java.util.UUID;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.OrderDAO;
import DAO.ProductDAO;
import DAO.UserDAO;
import Services.Order.OrderService;
import Services.Products.ProductService;
import Services.User.UserServices;

public class App {
	private static AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	public static void main(String[] args) {
		
	}
}	
