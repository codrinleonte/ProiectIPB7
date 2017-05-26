package com.fiiLicence.fiiLicence.models.response;

import org.junit.Test;

import static org.junit.Assert.*;


public class IdResponseTest {
    @Test
    public void getId() throws Exception {
        IdResponse id = new IdResponse();
        id.setId(10);
        assertEquals(id.getId(),10);
    }

    @Test
    public void setId() throws Exception {
        IdResponse id = new IdResponse();
        id.setId(10);
        assertEquals(id.getId(),10);
    }

}