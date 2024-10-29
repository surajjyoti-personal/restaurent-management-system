package services;

import exceptions.EntityAlreadyExistsException;
import exceptions.EntityDoesNotExistsException;
import managers.MenuManager;
import models.ItemCategory;
import models.ItemType;
import models.MenuItem;

import java.util.List;

public class MenuService {
    private final MenuManager menuManager;
    public MenuService(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    public MenuItem addItem(String name, double price, ItemType itemType, ItemCategory category) throws EntityAlreadyExistsException {
        MenuItem menuItem = new MenuItem(name, price, category, itemType);
        return menuManager.addMenuItem(menuItem);
    }

    public List<MenuItem> getAllMenuItems() {
        return menuManager.getMenuItems();
    }

    public List<MenuItem> getItemsByType(ItemType itemType) {
        return menuManager.getAllByType(itemType);
    }

    public MenuItem updatePrice(String itemName, double price) throws EntityDoesNotExistsException {
       return menuManager.updatePrice(itemName, price);
    }

    public MenuItem removeMenuItem(String itemName) throws EntityDoesNotExistsException {
        return menuManager.removeMenuItem(itemName);
    }
}
