package models;

public class MenuItem {
    private String name;
    private double price;
    private ItemCategory category;
    private ItemType type;
    public MenuItem(String name, double price, ItemCategory category, ItemType type) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name=" + name +
                ", price=" + price +
                ", itemType=" + type +
                ", category=" + category +
                '}';
    }
}
