package model.users.types;

import model.projects.Project;
import model.users.User;

public class Student extends User {

    private Project project;
    private Teacher coordinator;

    // TODO Add any other necessary data members(might be complete, need to consult)





    public Student() {
        super();
        this.project = new Project();
        this.coordinator = new Teacher();
    }
    public Student(Project project, Teacher coordinator) {
        super();
        this.project = project;
        this.coordinator = coordinator;
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

    // TODO Add any other necessary getters/setters(might be complete, need to consult)
}
