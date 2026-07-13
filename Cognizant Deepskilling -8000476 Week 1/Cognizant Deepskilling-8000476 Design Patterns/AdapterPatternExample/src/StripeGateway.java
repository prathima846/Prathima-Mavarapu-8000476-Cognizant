package AdapterPatternExample.src;

public class StripeGateway {
    public void payWithStripe(double amount) {
        System.out.println("Stripe processing payment of $" + amount);
    }
}

