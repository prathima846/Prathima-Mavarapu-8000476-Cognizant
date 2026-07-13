public class Main {
    public static void main(String[] args) {
        double current = 10000.0;
        double growthRate = 0.08; // 8%
        int years = 5;

        double v1 = Forecasting.futureValueRecursive(current, growthRate, years);
        double v2 = Forecasting.futureValueFastExp(current, growthRate, years);

        System.out.println("Current value: " + current);
        System.out.println("Growth rate: " + (growthRate * 100) + "%");
        System.out.println("Years: " + years);

        System.out.println("Future value (recursive O(years)): " + v1);
        System.out.println("Future value (fast exp O(log years)): " + v2);
    }
}

