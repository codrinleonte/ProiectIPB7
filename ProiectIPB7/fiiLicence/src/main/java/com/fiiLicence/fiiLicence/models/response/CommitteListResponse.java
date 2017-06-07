package com.fiiLicence.fiiLicence.models.response;

public class CommitteListResponse {
    int id;
    String numeComisie;
    String dataExaminare;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumeComisie() {
        return numeComisie;
    }
    public void setNumeComisie(String numeComisie) {
        this.numeComisie = numeComisie;
    }
    public String getDataExaminare() {
        return dataExaminare;
    }
    public void setDataExaminare(String dataExaminare) {
        this.dataExaminare = dataExaminare;
    }
}
