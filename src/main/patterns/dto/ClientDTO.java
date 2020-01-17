package main.patterns.dto;

import main.patterns.constants.Status;

public class ClientDTO {

    private Long clientId;
    private String name;
    private String surname;
    private Status status;
    private int daysStaying;

    public Long getClientId() {
        return clientId;
    }

    public ClientDTO setClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ClientDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public ClientDTO setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public ClientDTO setStatus(Status status) {
        this.status = status;
        return this;
    }

    public int getDaysStaying() {
        return daysStaying;
    }

    public void setDaysStaying(int daysStaying) {
        this.daysStaying = daysStaying;
    }
}
