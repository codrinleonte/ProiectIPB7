package model.scheduling;

import model.users.types.Student;

import java.util.Date;

public class Hearing {

    private Date time;
    private Student student;


    public Hearing() {
        this.time = new Date();
        this.student = new Student();
    }
    public Hearing(Date time, Student student) {
        this.time = time;
        this.student = student;
    }



    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    // TODO Add any other necessary data members(might be complete, need to consult)
}
