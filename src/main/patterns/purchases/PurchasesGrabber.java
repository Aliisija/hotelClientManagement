package main.patterns.purchases;

import java.util.ArrayList;

public class PurchasesGrabber implements Subject {

    private ArrayList<Observer> observers;
    private int drinksPurchased;
    private int massagesPurchased;
    private int treatmentsPurchased;

    public PurchasesGrabber(){

        observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        System.out.println("Observer " + (observerIndex+1) + " deleted");
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers){
            observer.update(drinksPurchased, massagesPurchased, treatmentsPurchased);
        }
    }

    public void setDrinksPurchased(int newDrinksPurchased){
        this.drinksPurchased = newDrinksPurchased;
        notifyObserver();
    }

    public void setMassagesPurchased(int newMassagesPurchased){
        this.massagesPurchased = newMassagesPurchased;
        notifyObserver();
    }

    public void setTreatmentsPurchased(int newTreatmentsPurchased){
        this.treatmentsPurchased = newTreatmentsPurchased;
        notifyObserver();
    }
}
