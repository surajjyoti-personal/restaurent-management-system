package managers;

import exceptions.EntityDoesNotExistsException;
import models.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderManager {
    private static OrderManager instance;
    private final Map<String, List<Order>> orders;
    private OrderManager() {
        orders = new HashMap<>();
    }
    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }
    public Order addOrder(String userName, Order order) {
        List<Order> orderList = orders.getOrDefault(userName, new ArrayList<>());
        orderList.add(order);
        orders.put(userName, orderList);
        return order;
    }

    public List<Order> getOrdersByUserName(String userName) {
        return orders.getOrDefault(userName, new ArrayList<>());
    }

    public Order updateOrderQuantity(String userName, String orderId, int quantity) throws EntityDoesNotExistsException {
        if (!orders.containsKey(userName)) {
            throw new EntityDoesNotExistsException("userName=" + userName);
        }
        List<Order> orderList = orders.get(userName);
        for (Order order : orderList) {
            if (order.getId().equals(orderId)) {
                order.setQuantity(quantity);
                orders.put(userName, orderList);
                return order;
            }
        }
        throw new EntityDoesNotExistsException("orderId=" + orderId);
    }
}
