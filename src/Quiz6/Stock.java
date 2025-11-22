package Quiz6;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    private String symbol;
    private double price;
    private final List<Observer> observers = new ArrayList<>();

    public Stock(String symbol, double startingPrice) {
        this.symbol = symbol;
        this.price = startingPrice;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
        observer.update(symbol, price);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setPrice(double newPrice) {
        if (newPrice == this.price) {
            return;
        }
        this.price = newPrice;
        notifyObservers();
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(symbol, price);
        }
    }
}
