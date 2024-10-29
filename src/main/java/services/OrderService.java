package services;

import exceptions.EntityDoesNotExistsException;
import managers.OrderManager;
import models.MenuItem;
import models.Order;

import java.util.List;
import java.util.UUID;

public class OrderService {
    private final OrderManager orderManager;
    public OrderService(OrderManager orderManager) {
        this.orderManager = orderManager;
    }
    public Order createOrder(String userName, MenuItem menuItem, int quantity) {
        Order order = new Order(UUID.randomUUID().toString().substring(0, 8).toUpperCase(), menuItem, quantity);
        return orderManager.addOrder(userName, order);
    }

    public List<Order> getAllOrdersByUsername(String userName) {
        return orderManager.getOrdersByUserName(userName);
    }

    public Order updateOrderQuantityByUsernameAndOrderId(String userName, String orderId, int quantity) throws EntityDoesNotExistsException {
        return orderManager.updateOrderQuantity(userName, orderId, quantity);
    }
}
