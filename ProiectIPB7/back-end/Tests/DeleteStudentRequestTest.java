package com.fiiLicence.fiiLicence.models.requests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteStudentRequestTest {
    @Test
    public void getIdProf() throws Exception {
        DeleteStudentRequest p1 = new DeleteStudentRequest();
        p1.setIdProf(130);
        assertEquals(p1.getIdProf(),130);
    }

    @Test
    public void setIdProf() throws Exception {
        DeleteStudentRequest p1 = new DeleteStudentRequest();
        p1.setIdProf(130);
        assertEquals(p1.getIdProf(),130);
    }

    @Test
    public void getIdStudent() throws Exception {
        DeleteStudentRequest s1 = new DeleteStudentRequest();
        s1.setIdStudent(10);
        assertEquals(s1.getIdStudent(),10);
    }

    @Test
    public void setIdStudent() throws Exception {
        DeleteStudentRequest s1 = new DeleteStudentRequest();
        s1.setIdStudent(10);
        assertEquals(s1.getIdStudent(),10);
    }

}