package MVCPatternExample.src;

public class MVCTest {
    public static void main(String[] args) {
        Student student = new Student("Alice", 1, "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.showStudent();
        System.out.println("--- updating ---");
        controller.updateStudent("Alice Smith", 1, "A+");
        controller.showStudent();
    }
}

