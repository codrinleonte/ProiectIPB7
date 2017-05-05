package model.users.types;

import model.marks.StudentMark;
import model.projects.Project;
import model.users.User;

public class Student extends User {

    private Project project;
    private Teacher coordinator;
    private StudentMark mark;

    // TODO Add any other necessary data members(might be complete, need to consult)





    public Student() {
        super();
        this.project = new Project();
        this.coordinator = new Teacher();
        this.mark = new StudentMark();
    }
    public Student(Project project, Teacher coordinator) {
        super();
        this.project = project;
        this.coordinator = coordinator;
        this.mark = new StudentMark();
    }

    // TODO Add any other necessary constructors(might be complete, need to consult)





    // TODO Implement Student-specific methods like uploading a document





    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }

    public Teacher getCoordinator() {
        return coordinator;
    }
    public void setCoordinator(Teacher coordinator) {
        this.coordinator = coordinator;
    }

    public StudentMark getMark() {
        return mark;
    }
    public void setMark(StudentMark mark) {
        this.mark = mark;
    }

    // TODO Add any other necessary getters/setters(might be complete, need to consult)
}
