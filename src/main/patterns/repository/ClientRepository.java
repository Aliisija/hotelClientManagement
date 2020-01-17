package main.patterns.repository;

import main.patterns.domain.Client;

import java.util.HashMap;
import java.util.Map;

public class ClientRepository {

    private Map<Long, Client> clients = new HashMap<>();
    private Integer clientIdCount = 0;

    public void saveClient(final Client client) {
        clientIdCount++;
        clients.put(client.getId(), client);
    }

    public Map<Long, Client> getAllClients() {
        return clients;
    }

    public void deleteClient(final Long id) {
        clients.remove(id);
    }

    public Integer getAmountOfClients() {
        return clientIdCount;
    }
}
