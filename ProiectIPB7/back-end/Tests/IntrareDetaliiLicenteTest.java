package com.fiiLicence.fiiLicence.services.bd;

import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;


public class IntrareDetaliiLicenteTest {
    @Test
    public void getId() throws Exception {
        IntrareDetaliiLicente id = new IntrareDetaliiLicente();
        id.setId(213);
        assertEquals(id.getId(), 213);
    }

    @Test
    public void setId() throws Exception {
        IntrareDetaliiLicente id = new IntrareDetaliiLicente();
        id.setId(213);
        assertEquals(id.getId(), 213);
    }

    @Test
    public void getIdComisie() throws Exception {
        IntrareDetaliiLicente idCom = new IntrareDetaliiLicente();
        idCom.setIdComisie(19);
        assertEquals(idCom.getIdComisie(), 19);
    }

    @Test
    public void setIdComisie() throws Exception {
        IntrareDetaliiLicente idCom = new IntrareDetaliiLicente();
        idCom.setIdComisie(19);
        assertEquals(idCom.getIdComisie(), 19);
    }

    @Test
    public void getNota1Oral() throws Exception {
        IntrareDetaliiLicente n1o = new IntrareDetaliiLicente();
        n1o.setNota1Oral(10);
        assertEquals(n1o.getNota1Oral(), 10);
    }

    @Test
    public void setNota1Oral() throws Exception {
        IntrareDetaliiLicente n1o = new IntrareDetaliiLicente();
        n1o.setNota1Oral(10);
        assertEquals(n1o.getNota1Oral(), 10);
    }

    @Test
    public void getNota1Proiect() throws Exception {
        IntrareDetaliiLicente n1p = new IntrareDetaliiLicente();
        n1p.setNota1Proiect(10);
        assertEquals(n1p.getNota1Proiect(), 10);
    }

    @Test
    public void setNota1Proiect() throws Exception {
        IntrareDetaliiLicente n1p = new IntrareDetaliiLicente();
        n1p.setNota1Proiect(10);
        assertEquals(n1p.getNota1Proiect(), 10);
    }

    @Test
    public void getNota2Oral() throws Exception {
        IntrareDetaliiLicente n2o = new IntrareDetaliiLicente();
        n2o.setNota2Oral(10);
        assertEquals(n2o.getNota2Oral(), 10);
    }

    @Test
    public void setNota2Oral() throws Exception {
        IntrareDetaliiLicente n2o = new IntrareDetaliiLicente();
        n2o.setNota2Oral(10);
        assertEquals(n2o.getNota2Oral(), 10);
    }

    @Test
    public void getNota2Proiect() throws Exception {
        IntrareDetaliiLicente n2p = new IntrareDetaliiLicente();
        n2p.setNota2Proiect(9);
        assertEquals(n2p.getNota2Proiect(), 9);
    }

    @Test
    public void setNota2Proiect() throws Exception {
        IntrareDetaliiLicente n2p = new IntrareDetaliiLicente();
        n2p.setNota2Proiect(9);
        assertEquals(n2p.getNota2Proiect(), 9);
    }

    @Test
    public void getNota3Oral() throws Exception {
        IntrareDetaliiLicente n3o = new IntrareDetaliiLicente();
        n3o.setNota3Oral(9);
        assertEquals(n3o.getNota3Oral(), 9);
    }

    @Test
    public void setNota3Oral() throws Exception {
        IntrareDetaliiLicente n3o = new IntrareDetaliiLicente();
        n3o.setNota3Oral(9);
        assertEquals(n3o.getNota3Oral(), 9);
    }

    @Test
    public void getNota3Proiect() throws Exception {
        IntrareDetaliiLicente n3p = new IntrareDetaliiLicente();
        n3p.setNota3Proiect(10);
        assertEquals(n3p.getNota3Proiect(), 10);
    }

    @Test
    public void setNota3Proiect() throws Exception {
        IntrareDetaliiLicente n3p = new IntrareDetaliiLicente();
        n3p.setNota3Proiect(10);
        assertEquals(n3p.getNota3Proiect(), 10);
    }

    @Test
    public void getNota4Oral() throws Exception {
        IntrareDetaliiLicente n4o = new IntrareDetaliiLicente();
        n4o.setNota4Oral(8);
        assertEquals(n4o.getNota3Oral(), 8, 8);
    }

    @Test
    public void setNota4Oral() throws Exception {
        IntrareDetaliiLicente n4o = new IntrareDetaliiLicente();
        n4o.setNota4Oral(8);
        assertEquals(n4o.getNota3Oral(), 8, 8);
    }

    @Test
    public void getNota4Proiect() throws Exception {
        IntrareDetaliiLicente n4p = new IntrareDetaliiLicente();
        n4p.setNota4Proiect(9);
        assertEquals(n4p.getNota4Proiect(), 9);
    }

    @Test
    public void setNota4Proiect() throws Exception {
        IntrareDetaliiLicente n4p = new IntrareDetaliiLicente();
        n4p.setNota4Proiect(9);
        assertEquals(n4p.getNota4Proiect(), 9);
    }

    @Test
    public void getNota5Oral() throws Exception {
        IntrareDetaliiLicente n5o = new IntrareDetaliiLicente();
        n5o.setNota5Oral(9);
        assertEquals(n5o.getNota5Oral(), 9, 9);
    }

    @Test
    public void setNota5Oral() throws Exception {
        IntrareDetaliiLicente n5o = new IntrareDetaliiLicente();
        n5o.setNota5Oral(9);
        assertEquals(n5o.getNota5Oral(), 9, 9);
    }

    @Test
    public void getNota5Proiect() throws Exception {
        IntrareDetaliiLicente n5p = new IntrareDetaliiLicente();
        n5p.setNota5Proiect(10);
        assertEquals(n5p.getNota5Proiect(), 10);
    }

    @Test
    public void setNota5Proiect() throws Exception {
        IntrareDetaliiLicente n5p = new IntrareDetaliiLicente();
        n5p.setNota5Proiect(10);
        assertEquals(n5p.getNota5Proiect(), 10);
    }

    @Test
    public void getDataOraSustinerii() throws Exception {
        IntrareDetaliiLicente date = new IntrareDetaliiLicente();
        date.setDataOraSustinerii(Timestamp.valueOf("2017-06-21 12:00:00.000000000"));
        assertEquals(date.getDataOraSustinerii(), Timestamp.valueOf("2017-06-21 12:00:00.000000000"));
    }

    @Test
    public void setDataOraSustinerii() throws Exception {
        IntrareDetaliiLicente date = new IntrareDetaliiLicente();
        date.setDataOraSustinerii(Timestamp.valueOf("2017-06-21 12:00:00.000000000"));
        assertEquals(date.getDataOraSustinerii(), Timestamp.valueOf("2017-06-21 12:00:00.000000000"));
    }

}