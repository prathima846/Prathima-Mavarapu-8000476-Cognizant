public class Main {
    public static void main(String[] args) {
        EmployeeArrayList list = new EmployeeArrayList(2);

        list.add(new Employee(101, "John", "Manager", 90000));
        list.add(new Employee(102, "Sara", "Developer", 70000));
        list.add(new Employee(103, "Mike", "Analyst", 65000)); // triggers grow

        System.out.println("--- Employees ---");
        list.traverse();

        System.out.println("\nSearch employeeId=102");
        System.out.println(list.getById(102));

        System.out.println("\nDelete employeeId=101");
        System.out.println("Deleted? " + list.deleteById(101));

        System.out.println("\n--- Employees after delete ---");
        list.traverse();
    }
}

