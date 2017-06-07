package com.fiiLicence.fiiLicence.services.bd;

import org.junit.Test;

import static org.junit.Assert.*;


public class IntrareProfesoriTest {
    @Test
    public void getId() throws Exception {
        IntrareProfesori id = new IntrareProfesori();
        id.setId(2876);
        assertEquals(id.getId(), 2876);
    }

    @Test
    public void setId() throws Exception {
        IntrareProfesori id = new IntrareProfesori();
        id.setId(2876);
        assertEquals(id.getId(), 2876);
    }

    @Test
    public void getIdCont() throws Exception {
        IntrareProfesori cont = new IntrareProfesori();
        cont.setIdCont(231);
        assertEquals(cont.getIdCont(), 231);
    }

    @Test
    public void setIdCont() throws Exception {
        IntrareProfesori cont = new IntrareProfesori();
        cont.setIdCont(231);
        assertEquals(cont.getIdCont(), 231);
    }

    @Test
    public void getNume() throws Exception {
        IntrareProfesori nume = new IntrareProfesori();
        nume.setNume("Popescu");
        assertEquals(nume.getNume(), "Popescu");
    }

    @Test
    public void setNume() throws Exception {
        IntrareProfesori nume = new IntrareProfesori();
        nume.setNume("Popescu");
        assertEquals(nume.getNume(), "Popescu");
    }

    @Test
    public void getPrenume() throws Exception {
        IntrareProfesori prenume = new IntrareProfesori();
        prenume.setPrenume("Ion");
        assertEquals(prenume.getPrenume(), "Ion");
    }

    @Test
    public void setPrenume() throws Exception {
        IntrareProfesori prenume = new IntrareProfesori();
        prenume.setPrenume("Ion");
        assertEquals(prenume.getPrenume(), "Ion");
    }

    @Test
    public void getGradDidactic() throws Exception {
        IntrareProfesori grad = new IntrareProfesori();
        grad.setGradDidactic("doctor");
        assertEquals(grad.getGradDidactic(), "doctor");
    }

    @Test
    public void setGradDidactic() throws Exception {
        IntrareProfesori grad = new IntrareProfesori();
        grad.setGradDidactic("doctor");
        assertEquals(grad.getGradDidactic(), "doctor");
    }

    @Test
    public void getIdComisie() throws Exception {
        IntrareProfesori comisie = new IntrareProfesori();
        comisie.setIdComisie(38);
        assertEquals(comisie.getIdComisie(), 38);
    }

    @Test
    public void setIdComisie() throws Exception {
        IntrareProfesori comisie = new IntrareProfesori();
        comisie.setIdComisie(38);
        assertEquals(comisie.getIdComisie(), 38);
    }

    @Test
    public void getFunctieComisie() throws Exception {
        IntrareProfesori functie = new IntrareProfesori();
        functie.setFunctieComisie("evaluare");
        assertEquals(functie.getFunctieComisie(), "evaluare");
    }

    @Test
    public void setFunctieComisie() throws Exception {
        IntrareProfesori functie = new IntrareProfesori();
        functie.setFunctieComisie("evaluare");
        assertEquals(functie.getFunctieComisie(), "evaluare");
    }

    @Test
    public void chars() throws Exception {
    }

}