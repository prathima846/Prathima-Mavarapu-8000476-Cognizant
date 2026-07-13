package MVCPatternExample.src;

public class StudentController {
    private final Student model;
    private final StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void updateStudent(String newName, int newId, String newGrade) {
        model.setName(newName);
        model.setId(newId);
        model.setGrade(newGrade);
    }

    public void showStudent() {
        view.displayStudentDetails(model);
    }
}

