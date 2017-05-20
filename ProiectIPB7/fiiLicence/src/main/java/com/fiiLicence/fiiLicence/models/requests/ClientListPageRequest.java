package com.fiiLicence.fiiLicence.models.requests;


public class ClientListPageRequest {
    private int pagenumber;
    private int pagesize;

    public int getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(int pagenumber) {
        this.pagenumber = pagenumber;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
}
