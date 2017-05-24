package com.fiiLicence.fiiLicence.models.requests;

import org.junit.Test;

import static org.junit.Assert.*;


public class MoveProfRequestTest {
    @Test
    public void getIdProf() throws Exception {
        MoveProfRequest idP = new MoveProfRequest();
        idP.setIdProf(234);
        assertEquals(idP.getIdProf(),234);
    }

    @Test
    public void setIdProf() throws Exception {
        MoveProfRequest idP = new MoveProfRequest();
        idP.setIdProf(234);
        assertEquals(idP.getIdProf(),234);
    }

    @Test
    public void getIdCommitte() throws Exception {
        MoveProfRequest idC = new MoveProfRequest();
        idC.setIdCommitte(3);
        assertEquals(idC.getIdCommitte(),3);
    }

    @Test
    public void setIdCommitte() throws Exception {
        MoveProfRequest idC = new MoveProfRequest();
        idC.setIdCommitte(3);
        assertEquals(idC.getIdCommitte(),3);
    }

}