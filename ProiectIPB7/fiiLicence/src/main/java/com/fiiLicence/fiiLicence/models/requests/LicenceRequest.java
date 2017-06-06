package com.fiiLicence.fiiLicence.models.requests;

public class LicenceRequest {
    private String nameOfLicence;
    private int idProfesor;
    private String descriptionOfLicence;
    private byte[] data;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getNameOfLicence() {
        return nameOfLicence;
    }

    public void setNameOfLicence(String nameOfLicence) {
        this.nameOfLicence = nameOfLicence;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getDescriptionOfLicence() {
        return descriptionOfLicence;
    }

    public void setDescriptionOfLicence(String descriptionOfLicence) {
        this.descriptionOfLicence = descriptionOfLicence;
    }
}
