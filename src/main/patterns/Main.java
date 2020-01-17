package main.patterns;

import main.patterns.controller.ClientManagementController;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final ClientManagementController controller = new ClientManagementController();
        controller.createMenu();
    }
}