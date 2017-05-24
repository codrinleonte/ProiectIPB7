package com.fiiLicence.fiiLicence.models.requests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ConfirmRegistrationRequestTest {
    @Test
    public void getConfirmToken() throws Exception {
        ConfirmRegistrationRequest t1 = new ConfirmRegistrationRequest();
        t1.setConfirmToken("asd123");
        assertEquals(t1.getConfirmToken(),"asd123");

    }

    @Test
    public void setConfirmToken() throws Exception {
        ConfirmRegistrationRequest t1 = new ConfirmRegistrationRequest();
        t1.setConfirmToken("asd123");
        assertEquals(t1.getConfirmToken(),"asd123");
    }

}