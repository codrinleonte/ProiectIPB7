package com.fiiLicence.fiiLicence.models.response;

import com.fiiLicence.fiiLicence.models.requests.ProfNoteRequest;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProfListResponseTest {
    @Test
    public void getId() throws Exception {
        ProfListResponse id = new ProfListResponse();
        id.setId(20);
        assertEquals(id.getId(),20);
    }

    @Test
    public void setId() throws Exception {
        ProfListResponse id = new ProfListResponse();
        id.setId(20);
        assertEquals(id.getId(),20);
    }

    @Test
    public void getNumeProf() throws Exception {
        ProfListResponse nume = new ProfListResponse();
        nume.setNumeProf("Ionescu");
        assertEquals(nume.getNumeProf(), "Ionescu");
    }

    @Test
    public void setNumeProf() throws Exception {
        ProfListResponse nume = new ProfListResponse();
        nume.setNumeProf("Ionescu");
        assertEquals(nume.getNumeProf(), "Ionescu");
    }

    @Test
    public void getPrenumeProf() throws Exception {
        ProfListResponse prenume = new ProfListResponse();
        prenume.setPrenumeProf("Alexandru");
        assertEquals(prenume.getPrenumeProf(), "Alexandru");
    }

    @Test
    public void setPrenumeProf() throws Exception {
        ProfListResponse prenume = new ProfListResponse();
        prenume.setPrenumeProf("Alexandru");
        assertEquals(prenume.getPrenumeProf(), "Alexandru");
    }

    @Test
    public void getEmailProf() throws Exception {
        ProfListResponse email = new ProfListResponse();
        email.setEmailProf("ionescu@gmail.com");
        assertEquals(email.getEmailProf(), "ionescu@gmail.com");
    }

    @Test
    public void setEmailProf() throws Exception {
        ProfListResponse email = new ProfListResponse();
        email.setEmailProf("ionescu@gmail.com");
        assertEquals(email.getEmailProf(), "ionescu@gmail.com");
    }

    @Test
    public void getIdComisie() throws Exception {
        ProfListResponse idC = new ProfListResponse();
        idC.setIdComisie(3);
        assertEquals(idC.getIdComisie(), 3);
    }

    @Test
    public void setIdComisie() throws Exception {
        ProfListResponse idC = new ProfListResponse();
        idC.setIdComisie(3);
        assertEquals(idC.getIdComisie(), 3);
    }

}