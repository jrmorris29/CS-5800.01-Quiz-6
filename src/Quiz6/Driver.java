package Quiz6;

import java.util.Random;

public class Driver {

    public static void main(String[] args) {
        Stock tesla = new Stock("TSLA", 220.00);
        PriceTracker traderDisplay = new PriceTracker();

        tesla.addObserver(traderDisplay);

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            double change = (random.nextDouble() * 10.0) - 5.0;
            double newPrice = tesla.getPrice() + change;

            tesla.setPrice(newPrice);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
}

