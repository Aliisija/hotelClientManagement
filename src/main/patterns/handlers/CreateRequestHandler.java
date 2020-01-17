package main.patterns.handlers;

import main.patterns.constants.RequestTypes;
import main.patterns.domain.Client;
import main.patterns.facade.impl.ClientManagementFacade;
import main.patterns.factory.EntityFactory;
import main.patterns.mapper.ClientToDTOMapper;

public class CreateRequestHandler implements ChainHandler {

    private ClientManagementFacade facade;
    private EntityFactory factory;
    private ClientToDTOMapper mapper;

    public CreateRequestHandler(final ClientManagementFacade facade, final EntityFactory factory, final ClientToDTOMapper mapper) {
        this.facade = facade;
        this.factory = factory;
        this.mapper = mapper;
    }

    @Override
    public void handleRequest(final RequestTypes type) throws InterruptedException {
        if (type == RequestTypes.CREATE) {
            final Client createdClient = (Client) facade.createClient();
            System.out.println();
            System.out.println("Client created:");
            System.out.println("- Name: " + createdClient.getName());
            System.out.println("- Surname: " + createdClient.getSurname());
            System.out.println("- Client ID: " + createdClient.getId());
            System.out.println("- Status: " + createdClient.getStatus());
            System.out.println("- Days staying: " + createdClient.getDaysStaying());
            System.out.println();
        } else {
            final ChainHandler nextRequestHandler = new ViewPurchasesHandler(facade, mapper, factory);
            nextRequestHandler.handleRequest(type);
        }
    }
}
