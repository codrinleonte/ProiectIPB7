package com.fiiLicence.fiiLicence.models.response;

public class LicenseDataResponse {
    private String numeLucrare;
    private String tip;
    private String coordonator;
    private byte[] continut;

    public String getNumeLucrare() {
        return numeLucrare;
    }

    public void setNumeLucrare(String numeLucrare) {
        this.numeLucrare = numeLucrare;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getCoordonator() {
        return coordonator;
    }

    public void setCoordonator(String coordonator) {
        this.coordonator = coordonator;
    }

    public byte[] getContinut() {
        return continut;
    }

    public void setContinut(byte[] continut) {
        this.continut = continut;
    }

    @Override
    public String toString() {
        return numeLucrare+" "+tip+" "+coordonator+" "+continut;
    }
}
