package StrategyPatternExample.src;

public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment());
        context.executePay(250.0);

        context.setStrategy(new PayPalPayment());
        context.executePay(99.99);
    }
}

