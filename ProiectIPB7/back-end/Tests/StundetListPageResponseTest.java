package com.fiiLicence.fiiLicence.models.response;

import org.junit.Test;

import static org.junit.Assert.*;


public class StundetListPageResponseTest {
    @Test
    public void getNumeStudent() throws Exception {
        StundetListPageResponse nume = new StundetListPageResponse();
        nume.setNumeStudent("Georgescu");
        assertEquals(nume.getNumeStudent(), "Georgescu");
    }

    @Test
    public void setNumeStudent() throws Exception {
        StundetListPageResponse nume = new StundetListPageResponse();
        nume.setNumeStudent("Georgescu");
        assertEquals(nume.getNumeStudent(), "Georgescu");
    }

    @Test
    public void getPrenumeStudent() throws Exception {
        StundetListPageResponse prenume = new StundetListPageResponse();
        prenume.setPrenumeStudent("Ionut");
        assertEquals(prenume.getPrenumeStudent(), "Ionut");
    }

    @Test
    public void setPrenumeStudent() throws Exception {
        StundetListPageResponse prenume = new StundetListPageResponse();
        prenume.setPrenumeStudent("Ionut");
        assertEquals(prenume.getPrenumeStudent(), "Ionut");
    }

    @Test
    public void getNotaFinala() throws Exception {
        StundetListPageResponse nf = new StundetListPageResponse();
        nf.setNotaFinala(10);
        assertEquals(nf.getNotaFinala(), 10, 10);
    }

    @Test
    public void setNotaFinala() throws Exception {
        StundetListPageResponse nf = new StundetListPageResponse();
        nf.setNotaFinala(10);
        assertEquals(nf.getNotaFinala(), 10, 10);
    }

}