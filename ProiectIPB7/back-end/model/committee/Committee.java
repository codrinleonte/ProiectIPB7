package model.committee;

import model.scheduling.Timetable;
import model.users.types.Secretary;
import model.users.types.Teacher;

import java.util.Vector;

public class Committee {

    private Secretary secretary;
    private Teacher president;
    private Vector<Teacher> teachers;     // This is the main generator for instances
    private Vector<Teacher> coordinators; // Given the set of students who will be evaluated by this committee, this is the set of teachers that coordinate those students
    private Timetable timetable;

    // TODO Add any other necessary data members(might be complete, need to consult)





    public Committee() {
    }
    public Committee(Secretary secretary, Teacher president, Vector<Teacher> teachers) {
        this.secretary = secretary;
        this.president = president;
        this.teachers  = teachers;
        this.coordinators = new Vector<>();
        this.timetable    = new Timetable();
    }

    // TODO Add any other necessary constructors(might be complete, need to consult)





    // TODO Add any methods needed





    public Secretary getSecretary() {
        return secretary;
    }
    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }

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

    // TODO Add any other necessary setters/getters(might be complete, need to consult)
}
