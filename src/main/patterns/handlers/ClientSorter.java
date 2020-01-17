package main.patterns.handlers;

import main.patterns.constants.Status;
import main.patterns.dto.ClientDTO;

import java.util.Map;

/**
 * Behavioral pattern - Template Method
 * */
public abstract class ClientSorter {

    final public Map<Long, ClientDTO> sortClients(final Map<Long, ClientDTO> entityMap, final int days, final Status status) {
        if (shouldSortByDays()) {
            return sortByDays(entityMap, days);
        } else if (shouldSortByStatus()) {
            return sortByStatus(entityMap, status);
        }
        return null;
    }

    abstract Map<Long, ClientDTO> sortByDays(final Map<Long, ClientDTO> entityMap, final int days);

    abstract Map<Long, ClientDTO> sortByStatus(final Map<Long, ClientDTO> entityMap, final Status status);

    boolean shouldSortByDays() {
        return true;
    }

    boolean shouldSortByStatus() {
        return true;
    }
}
