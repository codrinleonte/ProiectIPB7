package com.fiiLicence.fiiLicence.models.response;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentResponseTest {
    @Test
    public void getIdStudent() throws Exception {
        StudentResponse id = new StudentResponse();
        id.setIdStudent(155);
        assertEquals(id.getIdStudent(), 155);
    }

    @Test
    public void setIdStudent() throws Exception {
        StudentResponse id = new StudentResponse();
        id.setIdStudent(155);
        assertEquals(id.getIdStudent(), 155);
    }

    @Test
    public void getNumeStudent() throws Exception {
        StudentResponse nume = new StudentResponse();
        nume.setNumeStudent("Ionescu");
        assertEquals(nume.getNumeStudent(), "Ionescu");
    }

    @Test
    public void setNumeStudent() throws Exception {
        StudentResponse id = new StudentResponse();
        id.setIdStudent(155);
        assertEquals(id.getIdStudent(), 155);
    }

    @Test
    public void getPrenumeStudent() throws Exception {
        StudentResponse prenume = new StudentResponse();
        prenume.setNumeStudent("Alin");
        assertEquals(prenume.getNumeStudent(), "Alin");
    }

    @Test
    public void setPrenumeStudent() throws Exception {
        StudentResponse prenume = new StudentResponse();
        prenume.setNumeStudent("Alin");
        assertEquals(prenume.getNumeStudent(), "Alin");
    }

}