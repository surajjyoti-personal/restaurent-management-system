package models;

public class CustomerUser extends User {
    public CustomerUser(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "CustomerUser{" +
                "name=" + super.getName() +
                ", id=" + super.getId() +
                "}";
    }
}
