package com.fiiLicence.fiiLicence.models.response;

import org.junit.Test;

import static org.junit.Assert.*;


public class RegistrationResponseTest {
    @Test
    public void isResponse() throws Exception {
        RegistrationResponse res = new RegistrationResponse();
        res.setResponse(true);
        assertTrue(String.valueOf(res), true);
    }

    @Test
    public void setResponse() throws Exception {
        RegistrationResponse res = new RegistrationResponse();
        res.setResponse(true);
        assertTrue(String.valueOf(res), true);
    }

}