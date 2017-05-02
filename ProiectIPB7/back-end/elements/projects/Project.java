package elements.projects;

import elements.users.types.Student;

public class Project {

    private String title;
    private Student student;

    // TODO Add any other necessary data members


    public Project() {

    }
    public Project(String title, Student student) {
        this.title = title;
        this.student = student;
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

    // TODO Add any other necessary getters/setters
}
