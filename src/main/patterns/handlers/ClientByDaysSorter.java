package main.patterns.handlers;

import main.patterns.constants.Status;
import main.patterns.dto.ClientDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * Behavioral pattern - Iterator pattern (?)
 */
public class ClientByDaysSorter extends ClientSorter {

    @Override
    boolean shouldSortByStatus() {
        return false;
    }

    @Override
    Map<Long, ClientDTO> sortByDays(Map<Long, ClientDTO> entityMap, int days) {
        Map<Long, ClientDTO> sortedByDays = new HashMap<>();
        entityMap.forEach((id, client) -> {
            if (client.getDaysStaying() == days) {
                sortedByDays.put(id, client);
            }
        });
        return sortedByDays;
    }

    @Override
    Map<Long, ClientDTO> sortByStatus(Map<Long, ClientDTO> entityMap, Status status) {
        return null;
    }
}
