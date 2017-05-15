package model.marks;

import java.util.Vector;
import model.committee.Committee;

public class Mark {

    private Vector<Integer> projectMarks;
    private Vector<Integer> oralMarks;

    private Committee committee;

    public Mark() {
        this.oralMarks    = new Vector<>();
        this.projectMarks = new Vector<>();
        this.committee    = new Committee();
    }
    public Mark(Vector<Integer> projectMarks, Vector<Integer> oralMarks) {
        this.projectMarks = projectMarks;
        this.oralMarks = oralMarks;
    }
    public Mark(Committee committee) {
        this.committee = committee;
    }
    public Mark(Vector<Integer> projectMarks, Vector<Integer> oralMarks, Committee committee) {
        this.projectMarks = projectMarks;
        this.oralMarks = oralMarks;
        this.committee = committee;
    }
    
    public double finalMark() {
        Double project = 0.0;
        Double oral    = 0.0;

        for (Integer i : projectMarks)
            project += i;

        for (Integer i : oralMarks)
            oral += i;

        // Average project marks. Truncate to 2 decimals
        // Average oral    marks. Truncate to 2 decimals
        // Average the 2 above values. Truncate to 2 decimals

        return Math.floor((Math.floor(project/projectMarks.size() * 100) / 100 + Math.floor(oral/oralMarks.size() * 100) / 100) / 2.0 * 100) / 100.0;
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

    public Committee getCommittee() {
        return committee;
    }
    public void setCommittee(Committee committee) {
        this.committee = committee;
    }

    // TODO Add any other necessary getters/setters(might be complete, need to consult)
}