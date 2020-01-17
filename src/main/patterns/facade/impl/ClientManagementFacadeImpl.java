package main.patterns.facade.impl;

import main.patterns.domain.Client;
import main.patterns.domain.Entity;
import main.patterns.dto.ClientDTO;
import main.patterns.factory.EntityFactory;
import main.patterns.mapper.ClientToDTOMapper;
import main.patterns.purchases.PurchaseObserver;
import main.patterns.purchases.PurchasesGrabber;
import main.patterns.repository.ClientRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ClientManagementFacadeImpl implements ClientManagementFacade {

    private ClientRepository repository;

    private EntityFactory factory;

    private ClientToDTOMapper clientToDTOMapper;

    public ClientManagementFacadeImpl(final ClientRepository repository, final EntityFactory factory,
                                        final ClientToDTOMapper clientToDTOMapper) {
        this.repository = repository;
        this.factory = factory;
        this.clientToDTOMapper = clientToDTOMapper;
    }

    @Override
    public Entity createClient() {
        final Entity client = factory.createEntity("Client", repository.getAmountOfClients());
        repository.saveClient((Client) client);
        return client;
    }

    @Override
    public void viewPurchases() throws InterruptedException {
        PurchasesGrabber purchasesGrabber = new PurchasesGrabber();
        PurchaseObserver observer1 = new PurchaseObserver(purchasesGrabber);
        int drinks = 1;
        int massages = 1;
        int treatments = 1;
        for (int i = 1; i <= 10; i++) {
            purchasesGrabber.setDrinksPurchased(drinks);
            purchasesGrabber.setMassagesPurchased(massages);
            purchasesGrabber.setTreatmentsPurchased(treatments);
            drinks = drinks + 2;
            massages = massages + 1;
            treatments = treatments + 3;
            TimeUnit.SECONDS.sleep(5);
        }
    }

    @Override
    public Map<Long, ClientDTO> getAllClients() {
        final Map<Long, Client> clients = repository.getAllClients();
        final Map<Long, ClientDTO> mappedClients = new HashMap<>();
        clients.forEach((id, client) -> mappedClients.put(id, clientToDTOMapper.map(client)));
        return mappedClients;
    }

    @Override
    public void deleteClient(final Long id) {
        repository.deleteClient(id);
    }
}
