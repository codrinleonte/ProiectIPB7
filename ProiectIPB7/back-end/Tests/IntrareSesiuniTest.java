package com.fiiLicence.fiiLicence.services.bd;

import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;


public class IntrareSesiuniTest {
    @Test
    public void getId() throws Exception {
        IntrareSesiuni id = new IntrareSesiuni();
        id.setId(13);
        assertEquals(id.getId(), 13);
    }

    @Test
    public void setId() throws Exception {
        IntrareSesiuni id = new IntrareSesiuni();
        id.setId(13);
        assertEquals(id.getId(), 13);
    }

    @Test
    public void getInceputSesiune() throws Exception {
        IntrareSesiuni begin = new IntrareSesiuni();
        begin.setInceputSesiune(Timestamp.valueOf("2017-06-25 16:00:00.000000000"));
        assertEquals(begin.getInceputSesiune(), Timestamp.valueOf("2017-06-25 16:00:00.000000000"));
    }

    @Test
    public void setInceputSesiune() throws Exception {
        IntrareSesiuni begin = new IntrareSesiuni();
        begin.setInceputSesiune(Timestamp.valueOf("2017-06-25 16:00:00.000000000"));
        assertEquals(begin.getInceputSesiune(), Timestamp.valueOf("2017-06-25 16:00:00.000000000"));
    }

    @Test
    public void getSfarsitSesiune() throws Exception {
        IntrareSesiuni end = new IntrareSesiuni();
        end.setSfarsitSesiune(Timestamp.valueOf("2017-06-25 17:00:00.000000000"));
        assertEquals(end.getSfarsitSesiune(), Timestamp.valueOf("2017-06-25 17:00:00.000000000"));
    }

    @Test
    public void setSfarsitSesiune() throws Exception {
        IntrareSesiuni end = new IntrareSesiuni();
        end.setSfarsitSesiune(Timestamp.valueOf("2017-06-25 17:00:00.000000000"));
        assertEquals(end.getSfarsitSesiune(), Timestamp.valueOf("2017-06-25 17:00:00.000000000"));
    }

}