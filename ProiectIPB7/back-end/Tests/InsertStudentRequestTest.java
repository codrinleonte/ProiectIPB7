package com.fiiLicence.fiiLicence.models.requests;

import org.junit.Test;

import static org.junit.Assert.*;


public class InsertStudentRequestTest {
    @Test
    public void getIdProf() throws Exception {
        DeleteStudentRequest p1 = new DeleteStudentRequest();
        p1.setIdProf(50);
        assertEquals(p1.getIdProf(),50);
    }

    @Test
    public void setIdProf() throws Exception {
        DeleteStudentRequest p1 = new DeleteStudentRequest();
        p1.setIdProf(50);
        assertEquals(p1.getIdProf(),50);
    }

    @Test
    public void getNumeStudent() throws Exception {
        InsertStudentRequest s1 = new InsertStudentRequest();
        s1.setNumeStudent("Popescu");
        assertEquals(s1.getNumeStudent(),"Popescu");
    }

    @Test
    public void setNumeStudent() throws Exception {
        InsertStudentRequest s1 = new InsertStudentRequest();
        s1.setNumeStudent("Popescu");
        assertEquals(s1.getNumeStudent(),"Popescu");
    }

    @Test
    public void getPrenumeStudent() throws Exception {
        InsertStudentRequest s1 = new InsertStudentRequest();
        s1.setPrenumeStudent("Marius");
        assertEquals(s1.getPrenumeStudent(),"Marius");
    }

    @Test
    public void setPrenumeStudent() throws Exception {
        InsertStudentRequest s1 = new InsertStudentRequest();
        s1.setPrenumeStudent("Marius");
        assertEquals(s1.getPrenumeStudent(),"Marius");
    }

}