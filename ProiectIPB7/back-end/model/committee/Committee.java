package model.committee;

import model.scheduling.Timetable;
import model.users.types.Secretary;
import model.users.types.Teacher;

import java.util.Vector;

public class Committee {

    private Secretary secretary;
    private Vector<Teacher> teachers;
    private Timetable timetable;

    // TODO Add any other necessary data members(might be complete, need to consult)





    public Committee() {
        this.secretary = new Secretary();
        this.teachers  = new Vector<>();
        this.timetable = new Timetable();
    }
    public Committee(Secretary secretary, Vector<Teacher> teachers, Timetable timetable) {
        this.secretary = secretary;
        this.teachers  = teachers;
        this.timetable = timetable;
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
