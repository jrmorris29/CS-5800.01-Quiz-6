package Quiz6;

import java.util.HashMap;
import java.util.Map;

public class PriceTracker implements Observer {

    private Map<String, Double> lastPrices = new HashMap<>();

    @Override
    public void update(String symbol, double price) {
        Double lastPrice = lastPrices.get(symbol);

        if (lastPrice != null) {
            String movement;
            if (price > lastPrice) {
                movement = "price went UP";
            } else if (price < lastPrice) {
                movement = "price went DOWN";
            } else {
                movement = "price stayed the same";
            }

            System.out.printf("Stock: %s | Price: %.2f | %s%n",
                    symbol, price, movement);
        }

        lastPrices.put(symbol, price);
    }
}
