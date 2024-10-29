package managers;

import exceptions.EntityAlreadyExistsException;
import exceptions.EntityDoesNotExistsException;
import models.CustomerUser;
import models.Table;
import models.TableStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableManager {
    private static TableManager instance;
    private final Map<Integer, Table> tables;
    private TableManager() {
        tables = new HashMap<>();
    }
    public static TableManager getInstance() {
        if (instance == null) {
            instance = new TableManager();
        }
        return instance;
    }

    public Table addTable(Table table) throws EntityAlreadyExistsException {
        if (tables.containsKey(table.getId())) {
            throw new EntityAlreadyExistsException("tableId=" + table.getId());
        }
        tables.put(table.getId(), table);
        return table;
    }

    public Table getById(int id) throws EntityDoesNotExistsException {
        if (!tables.containsKey(id)) {
            throw new EntityDoesNotExistsException("tableId=" + id);
        }
        return tables.get(id);
    }

    public Table getByCustomerName(String customerName) throws EntityDoesNotExistsException {
        for (Table table : tables.values()) {
            if (table.getCustomer().getName().equals(customerName)) {
                return table;
            }
        }
        throw new EntityDoesNotExistsException("customerName=" + customerName);
    }

    public List<Table> getAllTables() {
        return tables.values().stream().toList();
    }
    public Table updateCustomerAndStatus(int id, CustomerUser customerUser, TableStatus status)  throws EntityDoesNotExistsException {
        if (!tables.containsKey(id)) {
            throw new EntityDoesNotExistsException("tableId=" + id);
        }
        Table table = tables.get(id);
        table.setCustomer(customerUser);
        table.setStatus(status);
        tables.put(id, table);
        return table;
    }
}
