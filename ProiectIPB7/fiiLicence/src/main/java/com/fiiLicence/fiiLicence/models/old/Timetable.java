package com.fiiLicence.fiiLicence.models.old;

import com.fiiLicence.fiiLicence.models.old.Hearing;
import com.fiiLicence.fiiLicence.models.old.Student;

import java.util.Vector;
import java.util.Date;

public class Timetable {
    public static final long MIN = 60L * 1000L;

    private Vector<Hearing> hearings;



    public Timetable() {
        this.hearings = new Vector<>();
    }
    public Timetable(Vector<Hearing> hearings) {
        this.hearings = hearings;
    }

    public Vector<Hearing> setTimeToStart(Vector<Student> students, Date startDate) {

        hearings.elementAt(0).setStudent(students.elementAt(0));
        hearings.elementAt(0).setTime(startDate);

        for (int index = 1, size = students.size(); index < size; index++) {
            Date newDate = new Date(startDate.getTime() + 2L * MIN);//add 20 min to date
            hearings.elementAt(index).setStudent(students.elementAt(index));
            hearings.elementAt(index).setTime(newDate);
            startDate = newDate;
        }
        return this.hearings;
    }




    public Vector<Hearing> getHearings() {
        return hearings;
    }
    public void setHearings(Vector<Hearing> hearings) {
        this.hearings = hearings;
    }

    // TODO Add any other necessary data members(might be complete, need to consult)
}
