package main.patterns.domain;

import main.patterns.constants.Status;

public class Client extends Entity {
    private Status status;
    private int daysStaying;

    @Override
    public Client setId(final Long id) {
        super.id = id;
        return this;
    }

    @Override
    public Client setName(final String name) {
        super.name = name;
        return this;
    }

    @Override
    public Client setSurname(final String surname) {
        super.surname = surname;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Client setStatus(final Status status) {
        this.status = status;
        return this;
    }

    public int getDaysStaying() {
        return daysStaying;
    }

    public Client setDaysStaying(final int daysStaying) {
        this.daysStaying = daysStaying;
        return this;
    }
}
