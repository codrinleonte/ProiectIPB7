package com.fiiLicence.fiiLicence.models.requests;

import org.junit.Test;
import sun.rmi.runtime.Log;

import static org.junit.Assert.*;


public class LoginRequestTest {
    @Test
    public void getEmail() throws Exception {
        LoginRequest log = new LoginRequest();
        log.setEmail("asd@gmail.com");
        assertEquals(log.getEmail(),"asd@gmail.com");
    }

    @Test
    public void setEmail() throws Exception {
        LoginRequest log = new LoginRequest();
        log.setEmail("asd@gmail.com");
        assertEquals(log.getEmail(),"asd@gmail.com");
    }

    @Test
    public void getPassword() throws Exception {
        LoginRequest pass = new LoginRequest();
        pass.setPassword("123");
        assertEquals(pass.getPassword(),"123");
    }

    @Test
    public void setPassword() throws Exception {
        LoginRequest pass = new LoginRequest();
        pass.setPassword("123");
        assertEquals(pass.getPassword(),"123");
    }

}