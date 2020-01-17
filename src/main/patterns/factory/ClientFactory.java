package main.patterns.factory;

import main.patterns.constants.Names;
import main.patterns.constants.Status;
import main.patterns.constants.Surnames;
import main.patterns.domain.Client;
import main.patterns.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClientFactory {

    private Names names;
    private Surnames surnames;
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    ClientFactory(final Names names, final Surnames surnames) {
        this.names = names;
        this.surnames = surnames;
    }

    Client create(final Integer amountOfClients) {
        final Client client = new Client()
                .setId(amountOfClients.longValue() + 1L)
                .setName(generateRandomName())
                .setSurname(generateRandomSurname());
        client.setStatus(generateRandomStatus())
                .setDaysStaying(generateRandomDaysStaying());
        return client;
    }

    private Status generateRandomStatus() {
        final List<Status> statuses = Collections.unmodifiableList(Arrays.asList(Status.ECONOMY, Status.REGULAR, Status.VIP));
        return statuses.get(randomNumberGenerator.generate(statuses.size()) - 1);
    }

    private String generateRandomSurname() {
        return surnames.getName(randomNumberGenerator.generate(surnames.getSize()) - 1);
    }

    private String generateRandomName() {
        return names.getName(randomNumberGenerator.generate(names.getSize()) - 1);
    }

    private int generateRandomDaysStaying() {
        List<Integer> numbers = new ArrayList<Integer>(10);

        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        return numbers.get(randomNumberGenerator.generate(numbers.size()) - 1);
    }

}
