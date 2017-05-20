package com.fiiLicence.fiiLicence.models.requests;

public class ProfNoteRequest {
    private int idProf;
    private int idStudent;
    private int gradeOral;
    private int gradeProiect;

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getGradeOral() {
        return gradeOral;
    }

    public void setGradeOral(int gradeOral) {
        this.gradeOral = gradeOral;
    }

    public int getGradeProiect() {
        return gradeProiect;
    }

    public void setGradeProiect(int gradeProiect) {
        this.gradeProiect = gradeProiect;
    }
}
