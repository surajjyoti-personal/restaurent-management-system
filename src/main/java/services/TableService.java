package services;

import exceptions.EntityAlreadyExistsException;
import exceptions.EntityDoesNotExistsException;
import exceptions.TableAlreadyReservedException;
import managers.TableManager;
import models.CustomerUser;
import models.Table;
import models.TableStatus;

import java.util.List;

public class TableService {
    private final TableManager tableManager;
    public TableService(TableManager tableManager) {
        this.tableManager = tableManager;
    }

    public List<Table> getAllTables() {
        return tableManager.getAllTables();
    }

    public Table addTable(int id) throws EntityAlreadyExistsException {
        Table table = new Table(id);
        return tableManager.addTable(table);
    }

    public Table bookTableByCustomer(int id, CustomerUser customer) throws EntityDoesNotExistsException, TableAlreadyReservedException {
        Table table = tableManager.getById(id);
        if (table.getStatus() == TableStatus.RESERVED) {
            throw new TableAlreadyReservedException("tableId= " + id);
        }
        return tableManager.updateCustomerAndStatus(id, customer, TableStatus.RESERVED);
    }
    public Table allocateTable(CustomerUser customerUser) throws EntityDoesNotExistsException {
        List<Table> tables = tableManager.getAllTables();
        for (Table table : tables) {
            if (table.getStatus() == TableStatus.VACANT) {
                return tableManager.updateCustomerAndStatus(table.getId(), customerUser, TableStatus.RESERVED);
            }
        }
        return null;
    }
}
