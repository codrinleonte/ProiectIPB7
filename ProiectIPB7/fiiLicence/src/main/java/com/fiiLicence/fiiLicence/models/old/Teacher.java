package com.fiiLicence.fiiLicence.models.old;


import java.util.Vector;

public class Teacher extends User {

    private Vector<Student> coordinatedStudents;


    // TODO Add any other necessary data members


    public Teacher() {
        super();
        this.coordinatedStudents = new Vector<>();
        rights = new TeacherRights();
    }
    public Teacher(Vector<Student> coordinatedStudents) {
        super();
        this.coordinatedStudents = coordinatedStudents;
    }


    public int getNumberOfStudents() {
        return this.getCoordinatedStudents().size();
    }

    public int compareTo(Teacher t){
        Integer d1 = this.getNumberOfStudents();
        Integer  d2 = t.getNumberOfStudents();
        return d1.compareTo(d2);


    }


    public Vector<Student> getCoordinatedStudents() {
        return coordinatedStudents;
    }
    public void setCoordinatedStudents(Vector<Student> coordinatedStudents) {
        this.coordinatedStudents = coordinatedStudents;
    }
}
