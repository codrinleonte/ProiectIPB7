package com.fiiLicence.fiiLicence.services.bd;

import org.junit.Test;

import static org.junit.Assert.*;


public class IntrareStudentiTest {
    @Test
    public void getId() throws Exception {
        IntrareStudenti id = new IntrareStudenti();
        id.setId(2876);
        assertEquals(id.getId(), 2876);
    }

    @Test
    public void setId() throws Exception {
        IntrareStudenti id = new IntrareStudenti();
        id.setId(2876);
        assertEquals(id.getId(), 2876);
    }

    @Test
    public void getIdCont() throws Exception {
        IntrareStudenti cont = new IntrareStudenti();
        cont.setIdCont(231);
        assertEquals(cont.getIdCont(), 231);
    }

    @Test
    public void setIdCont() throws Exception {
        IntrareStudenti cont = new IntrareStudenti();
        cont.setIdCont(231);
        assertEquals(cont.getIdCont(), 231);
    }

    @Test
    public void getNrMatricol() throws Exception {
        IntrareStudenti matricol = new IntrareStudenti();
        matricol.setNrMatricol("123");
        assertEquals(matricol.getNrMatricol(), "123");
    }

    @Test
    public void setNrMatricol() throws Exception {
        IntrareStudenti matricol = new IntrareStudenti();
        matricol.setNrMatricol("123");
        assertEquals(matricol.getNrMatricol(), "123");
    }

    @Test
    public void getNume() throws Exception {
        IntrareStudenti nume = new IntrareStudenti();
        nume.setNume("Ionescu");
        assertEquals(nume.getNume(), "Ionescu");
    }

    @Test
    public void setNume() throws Exception {
        IntrareStudenti nume = new IntrareStudenti();
        nume.setNume("Ionescu");
        assertEquals(nume.getNume(), "Ionescu");
    }

    @Test
    public void getPrenume() throws Exception {
        IntrareStudenti prenume = new IntrareStudenti();
        prenume.setPrenume("Andrei");
        assertEquals(prenume.getPrenume(), "Andrei");
    }

    @Test
    public void setPrenume() throws Exception {
        IntrareStudenti prenume = new IntrareStudenti();
        prenume.setPrenume("Andrei");
        assertEquals(prenume.getPrenume(), "Andrei");
    }

    @Test
    public void getIdSesiune() throws Exception {
        IntrareStudenti sess = new IntrareStudenti();
        sess.setIdSesiune(43);
        assertEquals(sess.getNrMatricol(), 43,43);
    }

    @Test
    public void setIdSesiune() throws Exception {
        IntrareStudenti sess = new IntrareStudenti();
        sess.setIdSesiune(43);
        assertEquals(sess.getNrMatricol(), 43,43);
    }

    @Test
    public void chars() throws Exception {
    }

    @Test
    public void getId_comisie() throws Exception {
        IntrareStudenti com = new IntrareStudenti();
        com.setId_comisie(21);
        assertEquals(com.getId_comisie(), 21);
    }

    @Test
    public void setId_comisie() throws Exception {
        IntrareStudenti com = new IntrareStudenti();
        com.setId_comisie(21);
        assertEquals(com.getId_comisie(), 21);
    }

}