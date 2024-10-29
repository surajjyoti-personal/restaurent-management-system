package models;

import java.util.concurrent.atomic.AtomicInteger;

public class Table {
    private final int id;
    private CustomerUser customer;
    private TableStatus status;
    public  Table(int id){
        this.id = id;
        this.customer = null;
        this.status = TableStatus.VACANT;
    }

    public int getId() {
        return id;
    }

    public CustomerUser getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerUser customer) {
        this.customer = customer;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "Table{" +
                "id=" + id +
                ", customer=" + customer +
                ", status=" + status +
                "}";
    }
}
