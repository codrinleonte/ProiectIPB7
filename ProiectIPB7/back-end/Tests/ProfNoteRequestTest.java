package com.fiiLicence.fiiLicence.models.requests;

import org.junit.Test;

import static org.junit.Assert.*;


public class ProfNoteRequestTest {
    @Test
    public void getIdProf() throws Exception {
        ProfNoteRequest idP = new ProfNoteRequest();
        idP.setIdProf(23);
        assertEquals(idP.getIdProf(),23);
    }

    @Test
    public void setIdProf() throws Exception {
        ProfNoteRequest idP = new ProfNoteRequest();
        idP.setIdProf(23);
        assertEquals(idP.getIdProf(),23);
    }

    @Test
    public void getIdStudent() throws Exception {
        ProfNoteRequest idS = new ProfNoteRequest();
        idS.setIdStudent(221);
        assertEquals(idS.getIdStudent(),221);
    }

    @Test
    public void setIdStudent() throws Exception {
        ProfNoteRequest idS = new ProfNoteRequest();
        idS.setIdStudent(221);
        assertEquals(idS.getIdStudent(),221);
    }

    @Test
    public void getGradeOral() throws Exception {
        ProfNoteRequest gO = new ProfNoteRequest();
        gO.setGradeOral(10);
        assertEquals(gO.getGradeOral(),10);
    }

    @Test
    public void setGradeOral() throws Exception {
        ProfNoteRequest gO = new ProfNoteRequest();
        gO.setGradeOral(10);
        assertEquals(gO.getGradeOral(),10);
    }

    @Test
    public void getGradeProiect() throws Exception {
        ProfNoteRequest gP = new ProfNoteRequest();
        gP.setGradeProiect(10);
        assertEquals(gP.getGradeProiect(),10);
    }

    @Test
    public void setGradeProiect() throws Exception {
        ProfNoteRequest gP = new ProfNoteRequest();
        gP.setGradeProiect(10);
        assertEquals(gP.getGradeProiect(),10);
    }

}