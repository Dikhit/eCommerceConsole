package DAO;

import org.springframework.context.support.AbstractApplicationContext;

import Services.Order.OrderService;

public class OrderDAO {
	public static OrderService getOrderDAO(AbstractApplicationContext context) {
		return (OrderService) context.getBean("order");
	}

}
