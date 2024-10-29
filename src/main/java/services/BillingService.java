package services;

import exceptions.EntityDoesNotExistsException;
import exceptions.InvalidPaymentModeException;
import managers.OrderManager;
import managers.TableManager;
import models.Order;
import models.PaymentMode;
import models.Table;
import models.TableStatus;
import strategy.PaymentStrategy;
import strategy.StrategyManager;

import java.util.List;

public class BillingService {
    private final OrderManager orderManager;
    private final TableManager tableManager;
    public BillingService(OrderManager orderManager, TableManager tableManager) {
        this.orderManager = orderManager;
        this.tableManager = tableManager;
    }

    public double payBill(String userName, PaymentMode paymentMode) throws InvalidPaymentModeException, EntityDoesNotExistsException {
        PaymentStrategy paymentStrategy = StrategyManager.getPaymentStrategy(paymentMode);
        List<Order> orders = orderManager.getOrdersByUserName(userName);
        double total = 0;
        for (Order order : orders) {
            total += order.getItem().getPrice() * order.getQuantity();
        }
        double totalAmount = paymentStrategy.processPayment(total);
        Table table = tableManager.getByCustomerName(userName);
        table.setCustomer(null);
        table.setStatus(TableStatus.VACANT);
        return totalAmount;
    }

}
