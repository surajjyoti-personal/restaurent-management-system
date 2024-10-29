package models;

public class Order {
    private final String  id;
    private MenuItem item;
    private int quantity;
    private OrderStatus status;
    public Order(String id, MenuItem item, int quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.status = OrderStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public MenuItem getItem() {
        return item;
    }

    public void setItem(MenuItem item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String toString() {
        return "Order{" +
                "id=" + id +
                ", item=" + item +
                ", quantity=" + quantity +
                ", status=" + status +
                "}";
    }
}
