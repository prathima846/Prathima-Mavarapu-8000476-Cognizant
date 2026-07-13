public class LibrarySearch {

    // Linear search by title
    // Returns index of matching title, else -1
    public static int linearSearchByTitle(Book[] books, String targetTitle) {
        if (books == null || targetTitle == null) return -1;

        for (int i = 0; i < books.length; i++) {
            if (targetTitle.equals(books[i].getTitle())) {
                return i;
            }
        }
        return -1;
    }

    // Binary search by title (books must be sorted by title)
    public static int binarySearchByTitle(Book[] books, String targetTitle) {
        if (books == null || targetTitle == null) return -1;

        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = targetTitle.compareTo(books[mid].getTitle());

            if (cmp == 0) return mid;
            if (cmp < 0) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }

    // ---------------- Analysis ----------------
    // Linear search:
    // - Best: O(1)
    // - Avg/Worst: O(n)
    //
    // Binary search (sorted list):
    // - Best: O(1)
    // - Avg/Worst: O(log n)
    //
    // When to use:
    // - Linear: unsorted data or very small n
    // - Binary: large n + data kept sorted / can be sorted ahead of time
}

