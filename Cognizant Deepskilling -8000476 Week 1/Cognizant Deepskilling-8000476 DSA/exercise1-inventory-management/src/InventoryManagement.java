import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class InventoryManagement {
    // Key: productId, Value: Product
    private final Map<Integer, Product> inventory = new HashMap<>();

    // Add a new product (or throw if productId already exists)
    public boolean addProduct(Product product) {
        if (product == null) return false;
        int id = product.getProductId();
        if (inventory.containsKey(id)) return false;
        inventory.put(id, product);
        return true;
    }

    // Update existing product details
    // Returns true if updated; false if product doesn't exist.
    public boolean updateProduct(int productId, int newQuantity, double newPrice) {
        Product existing = inventory.get(productId);
        if (existing == null) return false;
        existing.setQuantity(newQuantity);
        existing.setPrice(newPrice);
        return true;
    }

    // Delete product by id
    public boolean deleteProduct(int productId) {
        return inventory.remove(productId) != null;
    }

    // Optional helper for retrieval
    public Product getProduct(int productId) {
        return inventory.get(productId);
    }

    public void printInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    // ---------------- Analysis (Big-O) ----------------
    // Using HashMap: Average-case time complexities are:
    // addProduct:    O(1)
    // updateProduct: O(1)
    // deleteProduct: O(1)
    // Worst-case can degrade to O(n) if many keys collide (rare in practice).
    //
    // Optimization ideas:
    // - Ensure good hashCode/equals for keys (here key is Integer -> already optimized).
    // - Keep HashMap load factor reasonable (default is fine).
    // - Use initial capacity if you know approximate number of products to reduce rehashing.
    // - Consider thread-safe alternative (ConcurrentHashMap) if multi-threaded updates are required.
}

