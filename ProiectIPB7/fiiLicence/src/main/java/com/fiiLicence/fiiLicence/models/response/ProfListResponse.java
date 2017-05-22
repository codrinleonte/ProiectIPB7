package com.fiiLicence.fiiLicence.models.response;
public class ProfListResponse {
    private int id;
    private String numeProf;
    private String prenumeProf;
    private String emailProf;
    private int idComisie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeProf() {
        return numeProf;
    }

    public void setNumeProf(String numeProf) {
        this.numeProf = numeProf;
    }

    public String getPrenumeProf() {
        return prenumeProf;
    }

    public void setPrenumeProf(String prenumeProf) {
        this.prenumeProf = prenumeProf;
    }

    public String getEmailProf() {
        return emailProf;
    }

    public void setEmailProf(String emailProf) {
        this.emailProf = emailProf;
    }

    public int getIdComisie() {
        return idComisie;
    }

    public void setIdComisie(int idComisie) {
        this.idComisie = idComisie;
    }

    @Override
    public String toString() {
        return "ana are mere";
    }
}
