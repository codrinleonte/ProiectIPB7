package com.fiiLicence.fiiLicence.models.requests;

public class InsertStudentRequest {
    private int idProf;
    private String email;

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
