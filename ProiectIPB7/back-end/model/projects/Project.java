package model.projects;

import model.users.types.Student;
import model.users.types.Teacher;

public class Project {

    private String title;
    private Student student;
    private Teacher coordinator;

    // TODO Add any other necessary data members


    public Project() {
        this.student     = new Student();
        this.coordinator = new Teacher();
    }
    public Project(String title, Student student, Teacher coordinator) {
        this.title = title;
        this.student = student;
        this.coordinator = coordinator;
    }

    // TODO Add any other necessary constructors





    // TODO Add any other necessary metods





    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getCoordinator() {
        return coordinator;
    }
    public void setCoordinator(Teacher coordinator) {
        this.coordinator = coordinator;
    }

    // TODO Add any other necessary getters/setters
}
