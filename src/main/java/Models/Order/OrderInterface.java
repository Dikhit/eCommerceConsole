package Models.Order;

public interface OrderInterface {
    int createOrder(Order order);
    Order getOrderById(String id);
    Order[] getOrderByUser(String id);
    Order[] getAllOrders();
    Order updateOrder(Order order);
}
