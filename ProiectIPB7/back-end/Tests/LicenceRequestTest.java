package com.fiiLicence.fiiLicence.models.requests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LicenceRequestTest {

    @Test
    public void getNameOfLicence() throws Exception {
        LicenceRequest l1 = new LicenceRequest();
        l1.setNameOfLicence("asd");
        assertEquals(l1.getNameOfLicence(), "asd");
    }


    @Test
    public void setNameOfLicence() throws Exception {
        LicenceRequest l1 = new LicenceRequest();
        l1.setNameOfLicence("asd");
        assertEquals(l1.getNameOfLicence(), "asd");
    }

    @Test
    public void getIdProfesor() throws Exception {
        LicenceRequest p1 = new LicenceRequest();
        p1.setIdProfesor(200);
        assertEquals(p1.getIdProfesor(),200);
    }


    @Test
    public void setIdProfesor() throws Exception {
        LicenceRequest p1 = new LicenceRequest();
        p1.setIdProfesor(200);
        assertEquals(p1.getIdProfesor(),200);
    }


    @Test
    public void getDescriptionOfLicence() throws Exception {
        LicenceRequest d1 = new LicenceRequest();
        d1.setDescriptionOfLicence("asdasd");
        assertEquals(d1.getDescriptionOfLicence(),"asdasd");

    }

    @Test
    public void setDescriptionOfLicence() throws Exception {
        LicenceRequest d1 = new LicenceRequest();
        d1.setDescriptionOfLicence("asdasd");
        assertEquals(d1.getDescriptionOfLicence(),"asdasd");
    }

}