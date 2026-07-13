public class Main {
    public static void main(String[] args) {
        InventoryManagement im = new InventoryManagement();

        // Add products
        im.addProduct(new Product(101, "Keyboard", 50, 25.99));
        im.addProduct(new Product(102, "Mouse", 80, 15.49));
        im.addProduct(new Product(103, "Monitor", 10, 199.99));


        System.out.println("--- Inventory after adds ---");
        im.printInventory();

        // Update
        System.out.println("\nUpdate product 102...");
        boolean updated = im.updateProduct(102, 65, 14.99);
        System.out.println("Updated? " + updated);

        System.out.println("--- Inventory after update ---");
        im.printInventory();

        // Delete
        System.out.println("\nDelete product 101...");
        boolean deleted = im.deleteProduct(101);
        System.out.println("Deleted? " + deleted);

        System.out.println("--- Inventory after delete ---");
        im.printInventory();
    }
}

