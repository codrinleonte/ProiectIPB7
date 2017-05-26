package com.fiiLicence.fiiLicence.models.response;

import org.junit.Test;

import static org.junit.Assert.*;


public class ProfsFromCommitteTest {
    @Test
    public void getProfesor1() throws Exception {
        ProfsFromCommitte p1 = new ProfsFromCommitte();
        p1.setProfesor1(1);
        assertEquals(p1.getProfesor1(),1);
    }

    @Test
    public void setProfesor1() throws Exception {
        ProfsFromCommitte p1 = new ProfsFromCommitte();
        p1.setProfesor1(1);
        assertEquals(p1.getProfesor1(),1);
    }

    @Test
    public void getProfesor2() throws Exception {
        ProfsFromCommitte p2 = new ProfsFromCommitte();
        p2.setProfesor1(2);
        assertEquals(p2.getProfesor1(),2);
    }

    @Test
    public void setProfesor2() throws Exception {
        ProfsFromCommitte p2 = new ProfsFromCommitte();
        p2.setProfesor1(2);
        assertEquals(p2.getProfesor1(),2);
    }

    @Test
    public void getProfesor3() throws Exception {
        ProfsFromCommitte p3 = new ProfsFromCommitte();
        p3.setProfesor1(1);
        assertEquals(p3.getProfesor1(),1);
    }

    @Test
    public void setProfesor3() throws Exception {
        ProfsFromCommitte p3 = new ProfsFromCommitte();
        p3.setProfesor1(3);
        assertEquals(p3.getProfesor1(),3);
    }

    @Test
    public void getProfesor4() throws Exception {
        ProfsFromCommitte p4 = new ProfsFromCommitte();
        p4.setProfesor1(4);
        assertEquals(p4.getProfesor1(),4);
    }

    @Test
    public void setProfesor4() throws Exception {
        ProfsFromCommitte p4 = new ProfsFromCommitte();
        p4.setProfesor1(4);
        assertEquals(p4.getProfesor1(),4);
    }

    @Test
    public void caractere() throws Exception {

    }

    @Test
    public void containsId() throws Exception {

    }

}