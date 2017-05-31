package com.fiiLicence.fiiLicence.models.response;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserinfoResponseTest {
    @Test
    public void getNume() throws Exception {
        UserinfoResponse nume = new UserinfoResponse();
        nume.setNume("Ionescu");
        assertEquals(nume.getNume(), "Ionescu");
    }

    @Test
    public void setNume() throws Exception {
        UserinfoResponse nume = new UserinfoResponse();
        nume.setNume("Ionescu");
        assertEquals(nume.getNume(), "Ionescu");
    }

    @Test
    public void getPrenume() throws Exception {
        UserinfoResponse prenume = new UserinfoResponse();
        prenume.setPrenume("Ioana");
        assertEquals(prenume.getPrenume(), "Ioana");
    }

    @Test
    public void setPrenume() throws Exception {
        UserinfoResponse prenume = new UserinfoResponse();
        prenume.setPrenume("Ioana");
        assertEquals(prenume.getPrenume(), "Ioana");
    }

    @Test
    public void getEmail() throws Exception {
        UserinfoResponse email = new UserinfoResponse();
        email.setEmail("ionescu.ioana@gmail.com");
        assertEquals(email.getEmail(), "ionescu.ioana@gmail.com");
    }

    @Test
    public void setEmail() throws Exception {
        UserinfoResponse email = new UserinfoResponse();
        email.setEmail("ionescu.ioana@gmail.com");
        assertEquals(email.getEmail(), "ionescu.ioana@gmail.com");
    }

    @Test
    public void getTip() throws Exception {
        UserinfoResponse type = new UserinfoResponse();
        type.setTip("admin");
        assertEquals(type.getTip(), "admin");
    }

    @Test
    public void setTip() throws Exception {
        UserinfoResponse type = new UserinfoResponse();
        type.setTip("admin");
        assertEquals(type.getTip(), "admin");
    }

}