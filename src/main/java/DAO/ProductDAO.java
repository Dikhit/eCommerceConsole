package DAO;

import org.springframework.context.support.AbstractApplicationContext;

import Services.Products.ProductService;

public class ProductDAO {
	public static ProductService getProductDAO(AbstractApplicationContext context) {
		return (ProductService) context.getBean("product");
	}
}
