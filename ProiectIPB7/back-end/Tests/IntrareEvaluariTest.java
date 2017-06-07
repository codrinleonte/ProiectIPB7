package com.fiiLicence.fiiLicence.services.bd;

import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;


public class IntrareEvaluariTest {
    @Test
    public void setId() throws Exception {
        IntrareEvaluari id = new IntrareEvaluari();
        id.setId(298);
        assertEquals(id.getId(), 298);
    }

    @Test
    public void getIdSesiune() throws Exception {
        IntrareEvaluari id = new IntrareEvaluari();
        id.setId(298);
        assertEquals(id.getId(), 298);
    }

    @Test
    public void setIdSesiune() throws Exception {
        IntrareEvaluari S = new IntrareEvaluari();
        S.setIdSesiune(3);
        assertEquals(S.getIdSesiune(), 3);
    }

    @Test
    public void getIdComisie() throws Exception {
        IntrareEvaluari S = new IntrareEvaluari();
        S.setIdSesiune(3);
        assertEquals(S.getIdSesiune(), 3);
    }

    @Test
    public void getSala() throws Exception {
        IntrareEvaluari sala = new IntrareEvaluari();
        sala.setSala("C308");
        assertEquals(sala.getSala(), "C308");
    }

    @Test
    public void setSala() throws Exception {
        IntrareEvaluari sala = new IntrareEvaluari();
        sala.setSala("C308");
        assertEquals(sala.getSala(), "C308");
    }

    @Test
    public void setIdComisie() throws Exception {
        IntrareEvaluari com = new IntrareEvaluari();
        com.setIdComisie(10);
        assertEquals(com.getIdComisie(), 10);
    }

    @Test
    public void getInceputEvaluare() throws Exception {
        IntrareEvaluari begin = new IntrareEvaluari();
        begin.setInceputEvaluare(Timestamp.valueOf("2017-06-21 12:00:00.000000000"));
        assertEquals(begin.getInceputEvaluare(), Timestamp.valueOf("2017-06-21 12:00:00.000000000"));
    }

    @Test
    public void setInceputEvaluare() throws Exception {
        IntrareEvaluari begin = new IntrareEvaluari();
        begin.setInceputEvaluare(Timestamp.valueOf("2017-06-21 12:00:00.000000000"));
        assertEquals(begin.getInceputEvaluare(), Timestamp.valueOf("2017-06-21 12:00:00.000000000"));
    }

    @Test
    public void getSfarsitEvaluare() throws Exception {
        IntrareEvaluari end = new IntrareEvaluari();
        end.setSfarsitEvaluare(Timestamp.valueOf("2017-06-21 13:00:00.000000000"));
        assertEquals(end.getSfarsitEvaluare(), Timestamp.valueOf("2017-06-21 13:00:00.000000000"));
    }

    @Test
    public void setSfarsitEvaluare() throws Exception {
        IntrareEvaluari end = new IntrareEvaluari();
        end.setSfarsitEvaluare(Timestamp.valueOf("2017-06-21 13:00:00.000000000"));
        assertEquals(end.getSfarsitEvaluare(), Timestamp.valueOf("2017-06-21 13:00:00.000000000"));
    }

}