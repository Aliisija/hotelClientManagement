package main.patterns.controller;

import main.patterns.constants.Names;
import main.patterns.constants.RequestTypes;
import main.patterns.constants.Surnames;
import main.patterns.facade.impl.ClientManagementFacade;
import main.patterns.facade.impl.ClientManagementFacadeImpl;
import main.patterns.factory.EntityFactory;
import main.patterns.handlers.ChainHandler;
import main.patterns.handlers.CreateRequestHandler;
import main.patterns.mapper.ClientToDTOMapper;
import main.patterns.repository.ClientRepository;

import java.util.Scanner;

public class ClientManagementController {

    private final ClientRepository repository = new ClientRepository();
    private final Names names = new Names();
    private final Surnames surnames = new Surnames();
    private final EntityFactory factory = new EntityFactory(names, surnames);
    private final ClientToDTOMapper mapperToDTO = new ClientToDTOMapper();
    private boolean running = true;

    private Scanner userInput = new Scanner(System.in);
    private ClientManagementFacade managementFacade = new ClientManagementFacadeImpl(repository, factory, mapperToDTO);
    private ChainHandler handler = new CreateRequestHandler(managementFacade, factory, mapperToDTO);

    public void createMenu() throws InterruptedException {
        int input;
        do {
            System.out.println("-------------");
            System.out.println("Select an option:");
            System.out.println("1. Create a new client.");
            System.out.println("2. View hotel purchases being made now.");
            System.out.println("3. View all clients.");
            System.out.println("4. Delete a client.");
            System.out.println("5. Exit the application.");

            input = userInput.nextInt();
            RequestTypes type;

            switch (input) {
                case 1:
                    type = RequestTypes.CREATE;
                    handler.handleRequest(type);
                    break;
                case 2:
                    type = RequestTypes.VIEW_PURCHASES;
                    handler.handleRequest(type);
                    break;
                case 3:
                    type = RequestTypes.VIEW_ALL;
                    handler.handleRequest(type);
                    break;
                case 4:
                    type = RequestTypes.DELETE;
                    handler.handleRequest(type);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        }
        while (running);
        System.out.println("Exiting application.");
    }
}
