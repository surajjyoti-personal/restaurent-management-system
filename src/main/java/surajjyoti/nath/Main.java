package surajjyoti.nath;

import exceptions.EntityAlreadyExistsException;
import exceptions.EntityDoesNotExistsException;
import exceptions.InvalidPaymentModeException;
import exceptions.TableAlreadyReservedException;
import managers.MenuManager;
import managers.OrderManager;
import managers.TableManager;
import models.*;
import services.BillingService;
import services.MenuService;
import services.OrderService;
import services.TableService;

public class Main {
    public static void main(String[] args) throws EntityAlreadyExistsException, EntityDoesNotExistsException, TableAlreadyReservedException, InvalidPaymentModeException {
        MenuManager menuManager = MenuManager.getInstance();
        MenuService menuService = new MenuService(menuManager);

        TableManager tableManager = TableManager.getInstance();
        TableService tableService = new TableService(tableManager);

        OrderManager orderManager = OrderManager.getInstance();
        OrderService orderService = new OrderService(orderManager);

        BillingService billingService = new BillingService(orderManager, tableManager);


        MenuItem biriyani = menuService.addItem("Biriyani", 450, ItemType.NON_VEG, ItemCategory.MAIN_COURSE);
        MenuItem frenchFry = menuService.addItem("French Fry", 200, ItemType.VEG, ItemCategory.STARTER);
        MenuItem friedRice = menuService.addItem("Fried Rice", 400, ItemType.NON_VEG, ItemCategory.MAIN_COURSE);
        System.out.println(menuService.getAllMenuItems());

        System.out.println("------");
        MenuItem item = menuService.updatePrice("Biriyani", 500);
        System.out.println(menuService.getAllMenuItems());

        System.out.println("------");
        item = menuService.removeMenuItem("Biriyani");
        System.out.println(menuService.getAllMenuItems());

        System.out.println("------");
        System.out.println(menuService.getItemsByType(ItemType.NON_VEG));

        System.out.println("------");
        CustomerUser customer1 = new CustomerUser("Bob");
        CustomerUser customer2 = new CustomerUser("Alice");
        tableService.addTable(1);
        tableService.addTable(2);
        tableService.addTable(3);
        tableService.bookTableByCustomer(1, customer1);
//        tableService.bookTableByCustomer(1, customer1); throws exception
        tableService.allocateTable(customer2);
        System.out.println(tableService.getAllTables());

        System.out.println("------");
        Order order1 = orderService.createOrder("Bob", biriyani, 2);
        Order order2 = orderService.createOrder("Bob", frenchFry, 2);
        System.out.println(orderService.getAllOrdersByUsername("Bob"));
        orderService.updateOrderQuantityByUsernameAndOrderId("Bob", order1.getId(), 3);
        System.out.println(orderService.getAllOrdersByUsername("Bob"));

        System.out.println("------");
        double totalAmount = billingService.payBill("Bob", PaymentMode.CASH);

    }
}