public class Main {
    public static void main(String[] args) {
        // Sample products array (sorted by productName for binary search)
        Product[] products = new Product[] {
                new Product(1, "AirPods", "Electronics"),
                new Product(2, "Keyboard", "Electronics"),
                new Product(3, "Laptop", "Computers"),
                new Product(4, "Monitor", "Computers"),
                new Product(5, "Mouse", "Electronics")
        };

        String target = "Monitor";

        int linearIndex = SearchAlgorithms.linearSearch(products, target);
        System.out.println("Linear search index for '" + target + "' = " + linearIndex);

        int binaryIndex = SearchAlgorithms.binarySearch(products, target);
        System.out.println("Binary search index for '" + target + "' = " + binaryIndex);

        // Not found case
        String target2 = "Phone";
        System.out.println("Linear search for '" + target2 + "' = " +
                SearchAlgorithms.linearSearch(products, target2));
        System.out.println("Binary search for '" + target2 + "' = " +
                SearchAlgorithms.binarySearch(products, target2));
    }
}

