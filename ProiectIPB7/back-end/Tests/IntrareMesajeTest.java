package com.fiiLicence.fiiLicence.services.bd;

import org.junit.Test;

import static org.junit.Assert.*;


public class IntrareMesajeTest {
    @Test
    public void getId() throws Exception {
        IntrareMesaje id = new IntrareMesaje();
        id.setId(56);
        assertEquals(id.getId(), 56);
    }

    @Test
    public void setId() throws Exception {
        IntrareMesaje id = new IntrareMesaje();
        id.setId(56);
        assertEquals(id.getId(), 56);
    }

    @Test
    public void getMesaj() throws Exception {
        IntrareMesaje message = new IntrareMesaje();
        message.setMesaj("message");
        assertEquals(message.getMesaj(), "message");
    }

    @Test
    public void setMesaj() throws Exception {
        IntrareMesaje message = new IntrareMesaje();
        message.setMesaj("message");
        assertEquals(message.getMesaj(), "message");
    }

    @Test
    public void getIdEmitator() throws Exception {
        IntrareMesaje emit = new IntrareMesaje();
        emit.setIdEmitator(22);
        assertEquals(emit.getIdEmitator(), 22);
    }

    @Test
    public void setIdEmitator() throws Exception {
        IntrareMesaje emit = new IntrareMesaje();
        emit.setIdEmitator(22);
        assertEquals(emit.getIdEmitator(), 22);
    }

    @Test
    public void getIdDestinatar() throws Exception {
        IntrareMesaje dest = new IntrareMesaje();
        dest.setIdDestinatar(78);
        assertEquals(dest.getIdDestinatar(), 78);
    }

    @Test
    public void setIdDestinatar() throws Exception {
        IntrareMesaje dest = new IntrareMesaje();
        dest.setIdDestinatar(78);
        assertEquals(dest.getIdDestinatar(), 78);
    }

    @Test
    public void chars() throws Exception {
    }

}