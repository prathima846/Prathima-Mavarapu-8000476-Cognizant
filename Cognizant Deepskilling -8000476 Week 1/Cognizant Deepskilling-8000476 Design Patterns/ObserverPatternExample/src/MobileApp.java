package ObserverPatternExample.src;

public class MobileApp implements Observer {
    @Override
    public void update(String stockSymbol, double newPrice) {
        System.out.println("[MobileApp] " + stockSymbol + " updated to $" + newPrice);
    }
}

