package Models.Order;

import java.util.List;

import Models.User.User;

public interface OrderInterface {
    int createOrder(Order order);
    Order getOrderById(String id);
    List<Order> getOrderByUser(User user);
    List<Order> getAllOrders();
}
