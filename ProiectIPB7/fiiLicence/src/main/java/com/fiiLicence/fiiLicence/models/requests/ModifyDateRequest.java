package com.fiiLicence.fiiLicence.models.requests;

public class ModifyDateRequest {
    private int idCommitte;
    private  String beginDate;
    private  String endDate;;

    public int getIdCommitte() {
        return idCommitte;
    }

    public void setIdCommitte(int idCommitte) {
        this.idCommitte = idCommitte;
    }

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
}
