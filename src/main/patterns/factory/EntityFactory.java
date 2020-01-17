package main.patterns.factory;

import main.patterns.constants.Names;
import main.patterns.constants.Surnames;
import main.patterns.domain.Entity;

/**
 * Creational pattern - Factory method
 */
public class EntityFactory {

    private Names names;
    private Surnames surnames;

    public EntityFactory(final Names names, final Surnames surnames) {
        this.names = names;
        this.surnames = surnames;
    }

    public Entity createEntity(String type, Integer amountOfEntities) {
        if (type.equals("Client")) {
            ClientFactory clientFactory = new ClientFactory(names, surnames);
            return clientFactory.create(amountOfEntities);
        }
        return null;
    }
}
