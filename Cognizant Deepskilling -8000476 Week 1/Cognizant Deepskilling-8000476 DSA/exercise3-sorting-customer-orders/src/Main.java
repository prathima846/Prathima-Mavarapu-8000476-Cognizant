public class Main {
    public static void main(String[] args) {
        Order[] orders1 = new Order[] {
                new Order(1, "Alice", 250.75),
                new Order(2, "Bob", 120.50),
                new Order(3, "Charlie", 310.10),
                new Order(4, "Diana", 99.99),
                new Order(5, "Ethan", 250.75)
        };

        Order[] orders2 = cloneArray(orders1);

        System.out.println("Original orders:");
        print(orders1);

        SortingAlgorithms.bubbleSortByTotalPrice(orders1);
        System.out.println("\nSorted by Bubble Sort (totalPrice asc):");
        print(orders1);

        SortingAlgorithms.quickSortByTotalPrice(orders2);
        System.out.println("\nSorted by Quick Sort (totalPrice asc):");
        print(orders2);
    }

    private static Order[] cloneArray(Order[] arr) {
        Order[] out = new Order[arr.length];
        System.arraycopy(arr, 0, out, 0, arr.length);
        return out;
    }

    private static void print(Order[] arr) {
        for (Order o : arr) {
            System.out.println(o);
        }
    }
}

