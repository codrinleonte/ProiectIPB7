package model.marks;

import model.committee.Committee;

import java.util.Vector;

public class StudentMark {

    private Vector<Integer> projectMarks;
    private Vector<Integer> oralMarks;

    private Committee committee;


    public StudentMark() {
        this.oralMarks    = new Vector<>();
        this.projectMarks = new Vector<>();
        this.committee    = new Committee();
    }

    public StudentMark(Vector<Integer> projectMarks, Vector<Integer> oralMarks) {
        this.projectMarks = projectMarks;
        this.oralMarks = oralMarks;
    }


    public StudentMark(Committee committee) {
        this.committee = committee;
    }


    public StudentMark(Vector<Integer> projectMarks, Vector<Integer> oralMarks, Committee committee) {
        this.projectMarks = projectMarks;
        this.oralMarks = oralMarks;
        this.committee = committee;
    }




    public double finalMark() {
        Double project = 0.0;
        Double oral    = 0.0;

        for (Integer i : projectMarks)
            project += i; // summing all integers and getting something double

        for (Integer i : oralMarks)
            oral += i; // summing all integers and getting something double

        // Average project marks. Truncate to 2 decimals
        // Average oral    marks. Truncate to 2 decimals
        // Average the 2 above values. Truncate to 2 decimals



        return Math.floor((Math.floor(project/projectMarks.size() * 100) / 100 + Math.floor(oral/oralMarks.size() * 100) / 100) / 2.0 * 100) / 100.0;
    }




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


    public Committee getCommittee() {
        return committee;
    }
    public void setCommittee(Committee committee) {
        this.committee = committee;
    }

}
