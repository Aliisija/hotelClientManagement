package main.patterns.handlers;

import main.patterns.constants.RequestTypes;

/**
 * Behavioral pattern - Chain of responsibility pattern.
 */
public interface ChainHandler {

    void handleRequest(RequestTypes types) throws InterruptedException;
}
