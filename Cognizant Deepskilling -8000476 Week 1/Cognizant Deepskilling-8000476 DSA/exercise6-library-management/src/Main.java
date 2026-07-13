public class Main {
    public static void main(String[] args) {
        Book[] booksSortedByTitle = new Book[] {
                new Book(1, "A Tale of Two Cities", "Charles Dickens"),
                new Book(2, "Animal Farm", "George Orwell"),
                new Book(3, "Brave New World", "Aldous Huxley"),
                new Book(4, "Catcher in the Rye", "J.D. Salinger"),
                new Book(5, "Dune", "Frank Herbert")
        };

        String target = "Catcher in the Rye";

        int lin = LibrarySearch.linearSearchByTitle(booksSortedByTitle, target);
        int bin = LibrarySearch.binarySearchByTitle(booksSortedByTitle, target);

        System.out.println("Target: " + target);
        System.out.println("Linear index: " + lin);
        System.out.println("Binary index: " + bin);
        System.out.println("Book (binary): " + (bin == -1 ? "not found" : booksSortedByTitle[bin]));

        String missing = "The Hobbit";
        System.out.println("\nMissing: " + missing);
        System.out.println("Linear index: " + LibrarySearch.linearSearchByTitle(booksSortedByTitle, missing));
        System.out.println("Binary index: " + LibrarySearch.binarySearchByTitle(booksSortedByTitle, missing));
    }
}

