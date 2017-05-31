package com.fiiLicence.fiiLicence.models.response;

import org.junit.Test;

import static org.junit.Assert.*;


public class CommitteListResponseTest {
    @Test
    public void getId() throws Exception {
        CommitteListResponse ID = new CommitteListResponse();
        ID.setId(12);
        assertEquals(ID.getId(),12);
    }

    @Test
    public void setId() throws Exception {
        CommitteListResponse ID = new CommitteListResponse();
        ID.setId(12);
        assertEquals(ID.getId(),12);
    }

    @Test
    public void getNumeComisie() throws Exception {
        CommitteListResponse numeC = new CommitteListResponse();
        numeC.setNumeComisie("comisie 1");
        assertEquals(numeC.getNumeComisie(), "comisie 1");
    }

    @Test
    public void setNumeComisie() throws Exception {
        CommitteListResponse numeC = new CommitteListResponse();
        numeC.setNumeComisie("comisie 1");
        assertEquals(numeC.getNumeComisie(), "comisie 1");
    }

    @Test
    public void getBeginDate() throws Exception {
        CommitteListResponse Bdate = new CommitteListResponse();
        Bdate.setBeginDate("11.06.2017");
        assertEquals(Bdate.getBeginDate(), "11.06.2017");
    }

    @Test
    public void setBeginDate() throws Exception {
        CommitteListResponse Bdate = new CommitteListResponse();
        Bdate.setBeginDate("11.06.2017");
        assertEquals(Bdate.getBeginDate(), "11.06.2017");
    }

    @Test
    public void getEndDate() throws Exception {
        CommitteListResponse eDate = new CommitteListResponse();
        eDate.setEndDate("11.07.2017");
        assertEquals(eDate.getEndDate(), "11.07.2017");
    }

    @Test
    public void setEndDate() throws Exception {
        CommitteListResponse eDate = new CommitteListResponse();
        eDate.setEndDate("11.07.2017");
        assertEquals(eDate.getEndDate(), "11.07.2017");
    }

}