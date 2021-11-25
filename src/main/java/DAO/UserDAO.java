package DAO;

import org.springframework.context.support.AbstractApplicationContext;

import Services.User.UserServices;

public class UserDAO {
	public static UserServices getUserDAO(AbstractApplicationContext context) {
		return (UserServices) context.getBean("user");
	}
}
