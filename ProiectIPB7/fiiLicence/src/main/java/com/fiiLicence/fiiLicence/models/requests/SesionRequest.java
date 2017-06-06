package com.fiiLicence.fiiLicence.models.requests;

public class SesionRequest {
    private String beginDate;
    private String endDate;
    private int numberOfCommitte;

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getNumberOfCommitte() {
        return numberOfCommitte;
    }

    public void setNumberOfCommitte(int numberOfCommitte) {
        this.numberOfCommitte = numberOfCommitte;
    }
}
