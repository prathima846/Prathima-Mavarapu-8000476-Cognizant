public class Forecasting {

    /*
      Example model:
      futureValue = currentValue * (1 + growthRate)^years

      Implemented recursively using a helper.

      FV(y) = FV(y-1) * (1 + growthRate)
      Base: FV(0) = currentValue

      Time complexity (naive recursion): O(years)
    */
    public static double futureValueRecursive(double currentValue, double growthRate, int years) {
        if (years < 0) throw new IllegalArgumentException("years must be >= 0");
        return futureValueRecursiveHelper(currentValue, growthRate, years);
    }

    private static double futureValueRecursiveHelper(double currentValue, double growthRate, int yearsRemaining) {
        if (yearsRemaining == 0) return currentValue;
        return futureValueRecursiveHelper(currentValue * (1.0 + growthRate), growthRate, yearsRemaining - 1);
    }

    /*
      Optimization idea (avoid excessive computation):
      - The naive recursive method above is already O(years) because it makes 1 recursive call.
      - A faster approach is fast exponentiation (divide & conquer), which reduces time to O(log years).

      Implemented below.
    */
    public static double futureValueFastExp(double currentValue, double growthRate, int years) {
        if (years < 0) throw new IllegalArgumentException("years must be >= 0");
        double multiplier = powFast(1.0 + growthRate, years);
        return currentValue * multiplier;
    }

    private static double powFast(double base, int exp) {
        // O(log exp)
        if (exp == 0) return 1.0;
        if (exp == 1) return base;

        double half = powFast(base, exp / 2);
        double result = half * half;

        if (exp % 2 == 1) result *= base;
        return result;
    }

    // ---------------- Analysis ----------------
    // futureValueRecursive:
    // - Time: O(years)
    // - Space: O(years) recursion stack
    //
    // futureValueFastExp:
    // - Time: O(log years)
    // - Space: O(log years) recursion stack
    //
    // For recursive solutions with overlapping subproblems (e.g., Fibonacci), memoization reduces repeated work.
}

