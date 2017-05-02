package elements.scheduling;

import elements.users.types.Student;

import java.sql.Timestamp;
import java.util.Date;

public class Hearing {

    private Date time;
    private Student student;

    // TODO Add any other necessary data members(might be complete, need to consult)





    public Hearing() {
        this.time = new Date();
        this.student = new Student();
    }
    public Hearing(Date time, Student student) {
        this.time = time;
        this.student = student;
    }

    // TODO Add any other necessary constructors(might be complete, need to consult)





    // TODO Add any other necessary methods(might be complete, need to consult)





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
