package main.patterns.purchases;

/**
 * Behavioral pattern - Observer pattern
 */
public interface Observer {
    public void update(int drinksPurchased, int massagesPurchased, int treatmentsPurchased);
}
