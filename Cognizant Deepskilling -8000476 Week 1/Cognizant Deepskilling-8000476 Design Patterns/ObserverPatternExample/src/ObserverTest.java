package ObserverPatternExample.src;

public class ObserverTest {
    public static void main(String[] args) {
        StockMarket market = new StockMarket("AAPL", 150.0);

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        market.registerObserver(mobile);
        market.registerObserver(web);

        market.setPrice(155.25);
        market.setPrice(160.00);

        market.deregisterObserver(web);
        market.setPrice(162.5);
    }
}

