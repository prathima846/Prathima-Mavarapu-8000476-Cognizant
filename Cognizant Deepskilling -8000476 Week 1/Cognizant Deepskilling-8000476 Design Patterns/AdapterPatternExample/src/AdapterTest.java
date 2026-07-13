package AdapterPatternExample.src;

public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        PaymentProcessor payPal = new PayPalAdapter(new PayPalGateway());

        stripe.processPayment(120.50);
        payPal.processPayment(75.00);
    }
}

