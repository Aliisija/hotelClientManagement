package main.patterns.handlers;

import main.patterns.constants.RequestTypes;
import main.patterns.facade.impl.ClientManagementFacade;
import main.patterns.factory.EntityFactory;
import main.patterns.mapper.ClientToDTOMapper;

public class ViewPurchasesHandler implements ChainHandler {

    private ClientManagementFacade facade;
    private ClientToDTOMapper mapper;
    private EntityFactory factory;

    ViewPurchasesHandler(final ClientManagementFacade facade, final ClientToDTOMapper mapper, final EntityFactory factory) {
        this.facade = facade;
        this.mapper = mapper;
        this.factory = factory;
    }

    @Override
    public void handleRequest(final RequestTypes type) throws InterruptedException {

        if (type == RequestTypes.VIEW_PURCHASES) {
            facade.viewPurchases();
        } else {
            final ChainHandler nextHandler = new AllClientsRequestHandler(facade, factory, mapper);
            nextHandler.handleRequest(type);
        }
    }
}
