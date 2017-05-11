package model.committee;

import model.scheduling.Timetable;
import model.users.types.Secretary;
import model.users.types.Teacher;

import java.util.Vector;

public class Committee {

    private int id;
    private Secretary secretary;
    private Teacher president;
    private Vector<Teacher> teachers;     // This is the main generator for instances
    private Vector<Teacher> coordinators; // Given the set of students who will be evaluated by this committee, this is the set of teachers that coordinate those students
    private Timetable timetable;




    public Committee() {
    }
    public Committee(Secretary secretary, Teacher president, Vector<Teacher> teachers) {
        this.secretary = secretary;
        this.president = president;
        this.teachers  = teachers;
        this.coordinators = new Vector<>();
        this.timetable    = new Timetable();
    }






    public Teacher getPresident() {return president;}
    public void setPresident() { this.president = president;}


    public Secretary getSecretary() {
        return secretary;
    }
    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }


    public Vector<Teacher>  getCoordinators() { return coordinators; }
    public void setCoordinators (Vector<Teacher> coordinators){ this.coordinators = coordinators; }

    public Vector<Teacher> getTeachers() {
        return teachers;
    }
    public void setTeachers(Vector<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Timetable getTimetable() {
        return timetable;
    }
    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }


}
