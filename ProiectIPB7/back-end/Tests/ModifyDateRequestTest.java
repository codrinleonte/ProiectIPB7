package com.fiiLicence.fiiLicence.models.requests;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.Test;

import static org.junit.Assert.*;


public class ModifyDateRequestTest {
    @Test
    public void getIdCommitte() throws Exception {
        ModifyDateRequest id = new ModifyDateRequest();
        id.setIdCommitte(11);
        assertEquals(id.getIdCommitte(),11);
    }

    @Test
    public void setIdCommitte() throws Exception {
        ModifyDateRequest id = new ModifyDateRequest();
        id.setIdCommitte(11);
        assertEquals(id.getIdCommitte(),11);
    }

    @Test
    public void getBeginDate() throws Exception {
        ModifyDateRequest bdate = new ModifyDateRequest();
        bdate.setBeginDate("20.06.2017");
        assertEquals(bdate.getBeginDate(), "20.06.2017");
    }

    @Test
    public void setBeginDate() throws Exception {
        ModifyDateRequest bdate = new ModifyDateRequest();
        bdate.setBeginDate("20.06.2017");
        assertEquals(bdate.getBeginDate(), "20.06.2017");
    }

    @Test
    public void getEndDate() throws Exception {
        ModifyDateRequest Edate = new ModifyDateRequest();
        Edate.setEndDate("10.07.2017");
        assertEquals(Edate.getEndDate(), "10.07.2017");
    }

    @Test
    public void setEndDate() throws Exception {
        ModifyDateRequest Edate = new ModifyDateRequest();
        Edate.setEndDate("10.07.2017");
        assertEquals(Edate.getEndDate(), "10.07.2017");
    }

}