public class SortingAlgorithms {

    // Bubble Sort - O(n^2) worst/average, O(n) best if already sorted (with early exit)
    public static void bubbleSortByTotalPrice(Order[] orders) {
        if (orders == null) return;

        boolean swapped;
        for (int i = 0; i < orders.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < orders.length - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order tmp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break; // best-case optimization
        }
    }

    // Quick Sort - average O(n log n), worst O(n^2)
    // Sorts ascending by totalPrice
    public static void quickSortByTotalPrice(Order[] orders) {
        if (orders == null || orders.length <= 1) return;
        quickSort(orders, 0, orders.length - 1);
    }

    private static void quickSort(Order[] orders, int low, int high) {
        if (low >= high) return;

        int pivotIndex = partition(orders, low, high);
        quickSort(orders, low, pivotIndex - 1);
        quickSort(orders, pivotIndex + 1, high);
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order tmp = orders[i];
                orders[i] = orders[j];
                orders[j] = tmp;
            }
        }

        Order tmp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = tmp;

        return i + 1;
    }

    // ---------------- Analysis ----------------
    // Bubble Sort:
    // - Best:  O(n) if early-exit is used and array is already sorted
    // - Avg:   O(n^2)
    // - Worst: O(n^2)
    //
    // Quick Sort:
    // - Best/Average: O(n log n) when partitions are reasonably balanced
    // - Worst: O(n^2) when pivot choices cause highly unbalanced partitions
    //
    // Why Quick Sort is generally preferred:
    // - Lower average time complexity (n log n vs n^2)
    // - In-place partitioning uses O(log n) extra space (recursion stack)
    // - Strong cache locality in typical implementations
}

