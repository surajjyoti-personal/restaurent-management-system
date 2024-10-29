package managers;

import exceptions.EntityAlreadyExistsException;
import exceptions.EntityDoesNotExistsException;
import models.ItemType;
import models.MenuItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuManager {
    private static MenuManager instance;
    private final Map<String, MenuItem> menuItems;
    private MenuManager() {
        menuItems = new HashMap<>();
    }
    public static MenuManager getInstance() {
        if (instance == null) {
            instance = new MenuManager();
        }
        return instance;
    }

    public MenuItem addMenuItem(MenuItem menuItem) throws EntityAlreadyExistsException {
        if (menuItems.containsKey(menuItem.getName())) {
            throw new EntityAlreadyExistsException("menuItem= " + menuItem.getName());
        }
        menuItems.put(menuItem.getName(), menuItem);
        return menuItem;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems.values().stream().toList();
    }

    public List<MenuItem> getAllByType(ItemType type) {
        return menuItems.values().
                stream().
                filter(menuItem -> menuItem.getType().equals(type))
                .toList();
    }

    public MenuItem updatePrice(String itemName, double price) throws EntityDoesNotExistsException {
        if (!menuItems.containsKey(itemName)) {
            throw new EntityDoesNotExistsException("menuItem= " +itemName);
        }
        MenuItem menuItem = menuItems.get(itemName);
        menuItem.setPrice(price);
        menuItems.put(menuItem.getName(), menuItem);
        return menuItem;

    }

    public MenuItem removeMenuItem(String itemName) throws EntityDoesNotExistsException {
        if (!menuItems.containsKey(itemName)) {
            throw new EntityDoesNotExistsException("menuItem= " +itemName);
        }
        MenuItem menuItem = menuItems.get(itemName);
        menuItems.remove(itemName);
        return menuItem;
    }

}
