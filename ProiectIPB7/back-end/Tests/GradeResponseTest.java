package com.fiiLicence.fiiLicence.models.response;

import org.junit.Test;

import static org.junit.Assert.*;

public class GradeResponseTest {
    @Test
    public void getGrade() throws Exception {
        GradeResponse g1 = new GradeResponse();
        g1.setGrade(9);
        assertEquals(g1.getGrade(),9,9);
    }

    @Test
    public void setGrade() throws Exception {
        GradeResponse g1 = new GradeResponse();
        g1.setGrade(9);
        assertEquals(g1.getGrade(),9,9);
    }

    @Test
    public void stringcaracter() throws Exception {
    }

}