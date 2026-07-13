public class SearchAlgorithms {

    /**
     * Linear search for productName.
     * Returns index of matching name, else -1.
     */
    public static int linearSearch(Product[] products, String targetName) {
        if (products == null || targetName == null) return -1;

        for (int i = 0; i < products.length; i++) {
            if (targetName.equals(products[i].getProductName())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Binary search for productName.
     * Assumes products is sorted by productName in ascending order.
     * Returns index of matching name, else -1.
     */
    public static int binarySearch(Product[] products, String targetName) {
        if (products == null || targetName == null) return -1;

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = targetName.compareTo(products[mid].getProductName());

            if (cmp == 0) return mid;
            if (cmp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // ---------------- Analysis (Big-O) ----------------
    // Linear search:
    // - Best case: O(1) (target is at index 0)
    // - Average case: O(n)
    // - Worst case: O(n) (target not found or at end)
    //
    // Binary search (on sorted array):
    // - Best case: O(1) (target is at middle)
    // - Average case: O(log n)
    // - Worst case: O(log n) (target not found)
    //
    // Optimization ideas:
    // - Keep array sorted by productName (but note: insert/delete cost if using array).
    // - Use better indexing like HashMap<productName, index> or Trie for prefix search.
    // - For high-read workloads with infrequent updates, binary search is often suitable.
}

