package com.fiiLicence.fiiLicence.models.response;

public class StudentGrade {
    private int idProfesor;
    private int idComisie;
    private int nota1Oral;
    private int nota2Oral;
    private int nota3Oral;
    private int nota4Oral;
    private int nota5Oral;
    private int nota1Project;
    private int nota2Project;
    private int nota3Project;
    private int nota4Project;
    private int nota5Project;
    private String tipLicenta;
    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdComisie() {
        return idComisie;
    }

    public void setIdComisie(int idComisie) {
        this.idComisie = idComisie;
    }

    public int getNota1Oral() {
        return nota1Oral;
    }

    public void setNota1Oral(int nota1Oral) {
        this.nota1Oral = nota1Oral;
    }

    public int getNota2Oral() {
        return nota2Oral;
    }

    public void setNota2Oral(int nota2Oral) {
        this.nota2Oral = nota2Oral;
    }

    public int getNota3Oral() {
        return nota3Oral;
    }

    public void setNota3Oral(int nota3Oral) {
        this.nota3Oral = nota3Oral;
    }

    public int getNota4Oral() {
        return nota4Oral;
    }

    public void setNota4Oral(int nota4Oral) {
        this.nota4Oral = nota4Oral;
    }

    public int getNota5Oral() {
        return nota5Oral;
    }

    public void setNota5Oral(int nota5Oral) {
        this.nota5Oral = nota5Oral;
    }

    public int getNota1Project() {
        return nota1Project;
    }

    public void setNota1Project(int nota1Project) {
        this.nota1Project = nota1Project;
    }

    public int getNota2Project() {
        return nota2Project;
    }

    public void setNota2Project(int nota2Project) {
        this.nota2Project = nota2Project;
    }

    public int getNota3Project() {
        return nota3Project;
    }

    public void setNota3Project(int nota3Project) {
        this.nota3Project = nota3Project;
    }

    public int getNota4Project() {
        return nota4Project;
    }

    public void setNota4Project(int nota4Project) {
        this.nota4Project = nota4Project;
    }

    public int getNota5Project() {
        return nota5Project;
    }

    public void setNota5Project(int nota5Project) {
        this.nota5Project = nota5Project;
    }

    public String getTipLicenta() {
        return tipLicenta;
    }

    public void setTipLicenta(String tipLicenta) {
        this.tipLicenta = tipLicenta;
    }

    @Override
    public String toString() {
        return idProfesor +
                " " + idComisie +
                " " + nota1Oral +
                " " + nota2Oral +
                " " + nota3Oral +
                " " + nota4Oral +
                " " + nota5Oral +
                " " + nota1Project +
                " " + nota2Project +
                " " + nota3Project +
                " " + nota4Project +
                " " + nota5Project +
                " " + tipLicenta +
                " ";
    }
}

