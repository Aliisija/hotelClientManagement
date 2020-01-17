package main.patterns.facade.impl;

import main.patterns.domain.Entity;
import main.patterns.dto.ClientDTO;

import java.util.Map;

/**
 * Structural pattern - Facade pattern.
 */
public interface ClientManagementFacade {

    Entity createClient();

    void viewPurchases() throws InterruptedException;

    Map<Long, ClientDTO> getAllClients();

    void deleteClient(Long id);

}
