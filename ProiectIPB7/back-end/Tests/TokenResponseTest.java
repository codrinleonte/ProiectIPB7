package com.fiiLicence.fiiLicence.models.response;

import org.junit.Test;

import static org.junit.Assert.*;


public class TokenResponseTest {
    @Test
    public void getToken() throws Exception {
        TokenResponse token = new TokenResponse();
        token.setToken("asd123");
        assertEquals(token.getToken(), "asd123");

    }

    @Test
    public void setToken() throws Exception {
        TokenResponse token = new TokenResponse();
        token.setToken("asd123");
        assertEquals(token.getToken(), "asd123");
    }

}