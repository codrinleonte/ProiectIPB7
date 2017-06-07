package com.fiiLicence.fiiLicence.services.bd;

import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;

import static org.junit.Assert.*;


public class IntrareLicenteTest {
    @Test
    public void getId() throws Exception {
        IntrareLicente id = new IntrareLicente();
        id.setId(22);
        assertEquals(id.getId(), 22);
    }

    @Test
    public void setId() throws Exception {
        IntrareLicente id = new IntrareLicente();
        id.setId(22);
        assertEquals(id.getId(), 22);
    }

    @Test
    public void getTitlu() throws Exception {
        IntrareLicente title = new IntrareLicente();
        title.setTitlu("Smart house applications");
        assertEquals(title.getTitlu(), "Smart house applications");
    }

    @Test
    public void setTitlu() throws Exception {
        IntrareLicente title = new IntrareLicente();
        title.setTitlu("Smart house applications");
        assertEquals(title.getTitlu(), "Smart house applications");
    }

    @Test
    public void getIdProfesor() throws Exception {
        IntrareLicente prof = new IntrareLicente();
        prof.setIdProfesor(212);
        assertEquals(prof.getIdProfesor(), 212);
    }

    @Test
    public void setIdProfesor() throws Exception {
        IntrareLicente prof = new IntrareLicente();
        prof.setIdProfesor(212);
        assertEquals(prof.getIdProfesor(), 212);
    }

    @Test
    public void getIdStudent() throws Exception {
        IntrareLicente stud = new IntrareLicente();
        stud.setIdStudent(546);
        assertEquals(stud.getIdStudent(), 546);
    }

    @Test
    public void setIdStudent() throws Exception {
        IntrareLicente stud = new IntrareLicente();
        stud.setIdStudent(546);
        assertEquals(stud.getIdStudent(), 546);
    }

    @Test
    public void getMaterialeLicenta() throws Exception {
        IntrareLicente materiale = new IntrareLicente();
        materiale.setMaterialeLicenta("licenta.pdf");
        assertEquals(materiale.getMaterialeLicenta(), "licenta.pdf");
    }

    @Test
    public void setMaterialeLicenta() throws Exception {
        IntrareLicente materiale = new IntrareLicente();
        materiale.setMaterialeLicenta("licenta.pdf");
        assertEquals(materiale.getMaterialeLicenta(), "licenta.pdf");
    }

    @Test
    public void getIdSesiune() throws Exception {
        IntrareLicente ses = new IntrareLicente();
        ses.setIdSesiune(29);
        assertEquals(ses.getIdSesiune(), 29);
    }

    @Test
    public void setIdSesiune() throws Exception {
        IntrareLicente ses = new IntrareLicente();
        ses.setIdSesiune(29);
        assertEquals(ses.getIdSesiune(), 29);
    }

    @Test
    public void getTipLucrare() throws Exception {
        IntrareLicente type = new IntrareLicente();
        type.setTipLucrare("Licenta");
        assertEquals(type.getTipLucrare(), "Licenta");
    }

    @Test
    public void setTipLucrare() throws Exception {
        IntrareLicente type = new IntrareLicente();
        type.setTipLucrare("Licenta");
        assertEquals(type.getTipLucrare(), "Licenta");
    }

}