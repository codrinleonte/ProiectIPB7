package model.users.types;

import model.users.rights.AccessRights;

import java.util.Vector;

public class Teacher {

    private Vector<Student> coordinatedStudents;

    private AccessRights rights;

    // TODO Add any other necessary data members





    public Teacher() {
        super();
        this.coordinatedStudents = new Vector<>();
    }
    public Teacher(Vector<Student> coordinatedStudents) {
        super();
        this.coordinatedStudents = coordinatedStudents;
    }

    // TODO Add any other necessary constructors





    // TODO Add any Teacher-specific methods like markStudent(student, mark) etc.
    // TODO use the AccessRights. In here the methods should look like  editMarkOf(String student, int mark) { rights.editMarkOf(student, mark); }





    public Vector<Student> getCoordinatedStudents() {
        return coordinatedStudents;
    }
    public void setCoordinatedStudents(Vector<Student> coordinatedStudents) {
        this.coordinatedStudents = coordinatedStudents;
    }

    public AccessRights getRights() {
        return rights;
    }
    public void setRights(AccessRights rights) {
        this.rights = rights;
    }

    // TODO Add any other necessary data getters/setters
}
