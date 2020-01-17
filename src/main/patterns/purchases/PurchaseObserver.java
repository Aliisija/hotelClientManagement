package main.patterns.purchases;

public class PurchaseObserver implements Observer {

    private int drinksPurchased;
    private int massagesPurchased;
    private int treatmentsPurchased;

    private static int observerIDTracker = 0;
    private int observerID;
    private Subject purchasesGrabber;

    public PurchaseObserver(Subject purchasesGrabber){
        this.purchasesGrabber = purchasesGrabber;
        this.observerID = ++observerIDTracker;
        System.out.println("New Observer " + this.observerID);
        purchasesGrabber.register(this);
    }

    @Override
    public void update(int drinksPurchased, int massagesPurchased, int treatmentsPurchased) {
        this.drinksPurchased = drinksPurchased;
        this.massagesPurchased = massagesPurchased;
        this.treatmentsPurchased = treatmentsPurchased;

        printThePurchases();
    }

    public void printThePurchases(){
        System.out.println("\ndrinks: " + drinksPurchased +
                "\nmassages: " + massagesPurchased + "\ntreatments: " + treatmentsPurchased + "\n");
    }
}
