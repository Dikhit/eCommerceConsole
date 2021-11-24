package Application;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Services.User.UserServices;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		UserServices userServices = (UserServices) context.getBean("user");
		
		System.out.println(userServices.logIn("dikhitbhuyan@gmail.com", "kaku0001"));
		System.out.println(userServices.getAllUser());
		
	}
}	
