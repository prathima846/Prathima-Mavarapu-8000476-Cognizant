public class SinglyLinkedList {

    private static class Node {
        Task data;
        Node next;

        Node(Task data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Add to end
    public void add(Task task) {
        if (task == null) return;
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // Search by taskId: returns node position (1-based) or 0 if not found
    public int searchPositionById(int taskId) {
        int pos = 1;
        Node curr = head;
        while (curr != null) {
            if (curr.data.getTaskId() == taskId) return pos;
            pos++;
            curr = curr.next;
        }
        return 0;
    }

    public Task searchById(int taskId) {
        Node curr = head;
        while (curr != null) {
            if (curr.data.getTaskId() == taskId) return curr.data;
            curr = curr.next;
        }
        return null;
    }

    public void traverse() {
        if (head == null) {
            System.out.println("No tasks.");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    // Delete by taskId
    public boolean deleteById(int taskId) {
        if (head == null) return false;

        if (head.data.getTaskId() == taskId) {
            head = head.next;
            return true;
        }

        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.data.getTaskId() == taskId) {
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }

        return false;
    }

    // ---------------- Analysis ----------------
    // For singly linked list:
    // add at end: O(n)
    // search: O(n)
    // traverse: O(n)
    // delete: O(n) due to search for the node + pointer update
    //
    // Advantages over arrays:
    // - No contiguous memory requirement
    // - Insert/delete (given a node reference) can be O(1)
    // - Dynamic size without shifting elements
    //
    // Note: To make add O(1), we would maintain a tail pointer.
}

