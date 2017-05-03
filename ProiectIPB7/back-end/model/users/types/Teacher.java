package model.users.types;

import java.util.Vector;

public class Teacher {

    private Vector<Student> coordinatedStudents;

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





    public Vector<Student> getCoordinatedStudents() {
        return coordinatedStudents;
    }
    public void setCoordinatedStudents(Vector<Student> coordinatedStudents) {
        this.coordinatedStudents = coordinatedStudents;
    }

    // TODO Add any other necessary data getters/setters
}
