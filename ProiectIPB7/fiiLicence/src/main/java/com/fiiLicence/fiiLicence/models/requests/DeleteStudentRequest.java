package com.fiiLicence.fiiLicence.models.requests;

public class DeleteStudentRequest {
    private int idProf;
    private int idStudent;

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
}
