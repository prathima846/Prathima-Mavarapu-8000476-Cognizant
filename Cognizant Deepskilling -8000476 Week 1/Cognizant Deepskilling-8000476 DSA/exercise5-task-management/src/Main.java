public class Main {
    public static void main(String[] args) {
        SinglyLinkedList tasks = new SinglyLinkedList();

        tasks.add(new Task(1, "Pay bills", "Pending"));
        tasks.add(new Task(2, "Submit report", "In Progress"));
        tasks.add(new Task(3, "Team meeting", "Done"));

        System.out.println("--- Traverse ---");
        tasks.traverse();

        int searchId = 2;
        System.out.println("\nSearch taskId=" + searchId);
        System.out.println(tasks.searchById(searchId));

        System.out.println("\nDelete taskId=1");
        System.out.println("Deleted? " + tasks.deleteById(1));

        System.out.println("\n--- After delete ---");
        tasks.traverse();
    }
}

