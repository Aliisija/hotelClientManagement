package main.patterns.handlers;

import main.patterns.constants.RequestTypes;
import main.patterns.constants.Status;
import main.patterns.dto.ClientDTO;
import main.patterns.facade.impl.ClientManagementFacade;
import main.patterns.factory.EntityFactory;
import main.patterns.mapper.ClientToDTOMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.util.Objects.requireNonNull;

public class AllClientsRequestHandler implements ChainHandler {

    private ClientManagementFacade facade;
    private EntityFactory factory;
    private ClientToDTOMapper mapperToDTO;
    private Scanner userInput = new Scanner(System.in);
    private ClientSorter sorter;

    AllClientsRequestHandler(final ClientManagementFacade facade, final EntityFactory factory, final ClientToDTOMapper mapperToDTO) {
        this.facade = facade;
        this.factory = factory;
        this.mapperToDTO = mapperToDTO;
    }

    @Override
    public void handleRequest(final RequestTypes type) throws InterruptedException {
        if (type == RequestTypes.VIEW_ALL) {
            boolean processRunning = true;
            do {
                System.out.println("Sort clients by criteria? 1. Yes 2. No");
                final int choice;
                    choice = userInput.nextInt();
                if (choice == 2) {
                    final Map<Long, ClientDTO> clients = facade.getAllClients();
                    showClientList(clients);
                    processRunning = false;
                } else if (choice == 1) {
                    System.out.println("Which criteria? 1.Days staying 2.Status");
                    int searchChoice = userInput.nextInt();
                    if (searchChoice == 1) {
                        System.out.println("Type days to search by (from 1 to 10)");
                        int daysChoice = userInput.nextInt();
                        if(daysChoice >= 1 && daysChoice <= 10) {
                            showListByChosenDays(daysChoice);
                            processRunning = false;
                        } else {
                            System.out.println("Invalid input, please try again.");
                        }
                    } else if (searchChoice == 2) {
                        System.out.println("Sort by: 1.ECONOMY 2.REGULAR 3.VIP");
                        int statusChoice;

                        statusChoice = userInput.nextInt();

                        showListByStatus(statusChoice);
                        processRunning = false;
                    }
                } else {
                    System.out.println("Invalid input, please try again.");
                }
            } while (processRunning);

        } else {
            final ChainHandler nextHandler = new DeleteRequestHandler(facade);
            nextHandler.handleRequest(type);
        }
    }

    private void showListByChosenDays(final Integer daysChoice) {
        List<Integer> choices = new ArrayList<>() ;
        for (int i = 1; i <= 10; i++) {
            choices.add(i);
        }
        final Map<Long, ClientDTO> clientsToSort = facade.getAllClients();
        sorter = new ClientByDaysSorter();
        showClientList(requireNonNull(sorter.sortClients(clientsToSort, choices.get(daysChoice-1), null)));
    }

    private void showListByStatus(final Integer statusChoice) {
        final Map<Integer, Status> choices = new HashMap<>();
        choices.put(1, Status.ECONOMY);
        choices.put(2, Status.REGULAR);
        choices.put(3, Status.VIP);
        final Map<Long, ClientDTO> clientsToSort = facade.getAllClients();
        sorter = new ClientByStatusSorter();
        showClientList(requireNonNull(sorter.sortClients(clientsToSort, 0, choices.get(statusChoice))));
    }

    private void showClientList(final Map<Long, ClientDTO> clients) {
        if (clients.isEmpty()) {
            System.out.println("No clients were found.");
            return;
        }
        clients.forEach((id, client) -> System.out.println(client.getClientId() + ". " + client.getName() + " " + client.getSurname() + ", " + client.getStatus() + ", staying days: " + client.getDaysStaying()));
    }
}
