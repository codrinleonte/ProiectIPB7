package model.scheduling;

import model.scheduling.Hearing;

import java.util.Vector;

public class Timetable {

    private Vector<Hearing> hearings;

    // TODO Add any other necessary data members(might be complete, need to consult)





    public Timetable() {
        this.hearings = new Vector<>();
    }
    public Timetable(Vector<Hearing> hearings) {
        this.hearings = hearings;
    }

    // TODO Add any other necessary constructors(might be complete, need to consult)





    // TODO Add any other necessary methods(might be complete, need to consult)





    public Vector<Hearing> getHearings() {
        return hearings;
    }
    public void setHearings(Vector<Hearing> hearings) {
        this.hearings = hearings;
    }

    // TODO Add any other necessary data members(might be complete, need to consult)
}
