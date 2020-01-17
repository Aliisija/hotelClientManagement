package main.patterns.handlers;

import main.patterns.constants.RequestTypes;
import main.patterns.dto.ClientDTO;
import main.patterns.facade.impl.ClientManagementFacade;
import main.patterns.factory.EntityFactory;
import main.patterns.mapper.ClientToDTOMapper;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DeleteRequestHandler implements ChainHandler {

    private Scanner input = new Scanner(System.in);
    private ClientManagementFacade facade;

    DeleteRequestHandler(final ClientManagementFacade facade) {
        this.facade = facade;
    }

    @Override
    public void handleRequest(final RequestTypes type) throws InterruptedException {
        if (type == RequestTypes.DELETE) {
            final Map<Long, ClientDTO> clients = facade.getAllClients();
            final Long id = getId();
            if (id == 0L) {
                System.out.println("Invalid input.");
            } else if (doesUserExist(clients, id)) {
                final ClientDTO deletedClient = clients.get(id);
                facade.deleteClient(id);
                System.out.println("Client " + deletedClient.getName() + " " + deletedClient.getSurname()
                        + " with ID " + deletedClient.getClientId() + " deleted.");
                System.out.println();
            } else {
                System.out.println("User not found.");
            }
        } else {
            System.out.println("Invalid request type. Try again.");
        }
    }

    private Long getId() throws InterruptedException {
            try {
                System.out.println("Type id of the client to delete: ");
                final long id = input.nextLong();
                TimeUnit.SECONDS.sleep(2);
                return id;
            } catch (InputMismatchException e) {
                return 0L;
            }
    }

    private boolean doesUserExist(final Map<Long, ClientDTO> clients, final Long id) {
        if (clients != null && clients.size() > 0) {
            return clients.containsKey(id);
        }
        return false;
    }
}
