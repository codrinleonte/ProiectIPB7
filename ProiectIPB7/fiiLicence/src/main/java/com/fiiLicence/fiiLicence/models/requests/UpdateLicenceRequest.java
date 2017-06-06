package com.fiiLicence.fiiLicence.models.requests;

public class UpdateLicenceRequest {
    private int idStudent;
    private byte[] data;

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
