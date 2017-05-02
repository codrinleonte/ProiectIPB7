package committee;

import elements.users.types.Student;

import java.util.Vector;

public class StudentMark {

    private Vector<Integer> projectMarks;
    private Vector<Integer> oralMarks;

    private Student student;
    private Committee committee;

    // TODO Add any other necessary data members(might be complete, need to consult)





    public StudentMark() {
        this.oralMarks    = new Vector<>();
        this.projectMarks = new Vector<>();
        this.student      = new Student();
        this.committee    = new Committee();
    }
    public StudentMark(Vector<Integer> projectMarks, Vector<Integer> oralMarks) {
        this.projectMarks = projectMarks;
        this.oralMarks = oralMarks;
    }
    public StudentMark(Student student, Committee committee) {
        this.student = student;
        this.committee = committee;
    }
    public StudentMark(Vector<Integer> projectMarks, Vector<Integer> oralMarks, Student student, Committee committee) {
        this.projectMarks = projectMarks;
        this.oralMarks = oralMarks;
        this.student = student;
        this.committee = committee;
    }

    // TODO Add any other necessary constructors(might be complete, need to consult)





    public double finalMark() {
        int project = 0;
        int oral    = 0;

        for (Integer i : projectMarks)
            project += i;

        for (Integer i : oralMarks)
            oral += i;

        return (double)((int)(((project / projectMarks.size() + oral / oralMarks.size()) / 2.0) * 100)) / 100.0;
    }

    // TODO Add any other needed methods





    public Vector<Integer> getProjectMarks() {
        return projectMarks;
    }
    public void setProjectMarks(Vector<Integer> projectMarks) {
        this.projectMarks = projectMarks;
    }

    public Vector<Integer> getOralMarks() {
        return oralMarks;
    }
    public void setOralMarks(Vector<Integer> oralMarks) {
        this.oralMarks = oralMarks;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public Committee getCommittee() {
        return committee;
    }
    public void setCommittee(Committee committee) {
        this.committee = committee;
    }

    // TODO Add any other necessary getters/setters(might be complete, need to consult)
}
