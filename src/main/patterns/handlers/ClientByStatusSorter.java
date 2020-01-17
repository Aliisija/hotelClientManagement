package main.patterns.handlers;

import main.patterns.constants.Status;
import main.patterns.dto.ClientDTO;

import java.util.*;

/**
 * Behavioral pattern - Iterator pattern (?)
 */
public class ClientByStatusSorter extends ClientSorter{

    @Override
    boolean shouldSortByDays() {
        return false;
    }

    @Override
    Map<Long, ClientDTO> sortByDays(Map<Long, ClientDTO> entityMap, int days) {
        return null;
    }

    @Override
    Map<Long, ClientDTO> sortByStatus(Map<Long, ClientDTO> entityMap, Status status) {

        Map<Long, ClientDTO> sortedByLevel = new HashMap<>();
        entityMap.forEach((id, client) -> {
            if (client.getStatus() == status) {
                sortedByLevel.put(id, client);
            }
        });
        return sortedByLevel;

    }
}
