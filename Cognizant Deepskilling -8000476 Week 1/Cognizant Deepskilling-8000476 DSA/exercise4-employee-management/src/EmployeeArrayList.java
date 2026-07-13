public class EmployeeArrayList {
    private Employee[] employees;
    private int size;

    public EmployeeArrayList(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public boolean add(Employee emp) {
        if (emp == null) return false;
        if (size == employees.length) {
            // Simple growth strategy
            grow();
        }
        employees[size++] = emp;
        return true;
    }

    // Search by employeeId (linear scan)
    public int searchIndexById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) return i;
        }
        return -1;
    }

    public Employee getById(int employeeId) {
        int idx = searchIndexById(employeeId);
        return idx == -1 ? null : employees[idx];
    }

    public void traverse() {
        if (size == 0) {
            System.out.println("No employees.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteById(int employeeId) {
        int idx = searchIndexById(employeeId);
        if (idx == -1) return false;

        // Shift left to keep array compact
        for (int i = idx; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[size - 1] = null;
        size--;
        return true;
    }

    private void grow() {
        int newCap = employees.length * 2 + 1;
        Employee[] newArr = new Employee[newCap];
        for (int i = 0; i < size; i++) {
            newArr[i] = employees[i];
        }
        employees = newArr;
    }

    // ---------------- Analysis ----------------
    // For an array-backed structure:
    // add at end (with enough capacity): O(1)
    // add with growth: amortized O(1) but worst-case O(n) due to copying
    // search by id (linear): O(n)
    // traverse: O(n)
    // delete by id: O(n) search + O(n) shifting => O(n)
    //
    // Limitations:
    // - Fixed-size nature -> resizing needed
    // - Insert/delete in middle requires shifting elements
    // - For dynamic frequent updates, linked list or specialized structures may perform better
}

