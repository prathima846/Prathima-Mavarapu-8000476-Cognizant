package ObserverPatternExample.src;

public class WebApp implements Observer {
    @Override
    public void update(String stockSymbol, double newPrice) {
        System.out.println("[WebApp] " + stockSymbol + " updated to $" + newPrice);
    }
}

