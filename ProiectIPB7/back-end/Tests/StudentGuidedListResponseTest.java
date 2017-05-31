package com.fiiLicence.fiiLicence.models.response;

import com.fiiLicence.fiiLicence.models.old.Student;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentGuidedListResponseTest {
    @Test
    public void getIdStudent() throws Exception {
        StudentGuidedListResponse idS = new StudentGuidedListResponse();
        idS.setIdStudent(20);
        assertEquals(idS.getIdStudent(), 20);
    }

    @Test
    public void setIdStudent() throws Exception {
        StudentGuidedListResponse idS = new StudentGuidedListResponse();
        idS.setIdStudent(20);
        assertEquals(idS.getIdStudent(), 20);
    }

    @Test
    public void getNumeStudent() throws Exception {
        StudentGuidedListResponse numeS = new StudentGuidedListResponse();
        numeS.setNumeStudent("Popescu");
        assertEquals(numeS.getNumeStudent(), "Popescu");
    }

    @Test
    public void setNumeStudent() throws Exception {
        StudentGuidedListResponse numeS = new StudentGuidedListResponse();
        numeS.setNumeStudent("Popescu");
        assertEquals(numeS.getNumeStudent(), "Popescu");
    }

    @Test
    public void getPrenumStudent() throws Exception {
        StudentGuidedListResponse prenumeS = new StudentGuidedListResponse();
        prenumeS.setPrenumStudent("Andrei");
        assertEquals(prenumeS.getPrenumStudent(), "Andrei");
    }

    @Test
    public void setPrenumStudent() throws Exception {
        StudentGuidedListResponse prenumeS = new StudentGuidedListResponse();
        prenumeS.setPrenumStudent("Andrei");
        assertEquals(prenumeS.getPrenumStudent(), "Andrei");
    }

    @Test
    public void getNotaFinala() throws Exception {
        StudentGuidedListResponse notaF = new StudentGuidedListResponse();
        notaF.setNotaFinala(10);
        assertEquals(notaF.getNotaFinala(), 9, 9);
    }

    @Test
    public void setNotaFinala() throws Exception {
        StudentGuidedListResponse notaF = new StudentGuidedListResponse();
        notaF.setNotaFinala(10);
        assertEquals(notaF.getNotaFinala(), 9, 9);
    }

    @Test
    public void getNota1oral() throws Exception {
        StudentGuidedListResponse no1 = new StudentGuidedListResponse();
        no1.setNota1oral(8);
        assertEquals(no1.getNota1oral(), 8);
    }

    @Test
    public void setNota1oral() throws Exception {
        StudentGuidedListResponse no1 = new StudentGuidedListResponse();
        no1.setNota1oral(8);
        assertEquals(no1.getNota1oral(), 8);
    }

    @Test
    public void getNota2oral() throws Exception {
        StudentGuidedListResponse no2 = new StudentGuidedListResponse();
        no2.setNota2oral(10);
        assertEquals(no2.getNota2oral(), 10);
    }

    @Test
    public void setNota2oral() throws Exception {
        StudentGuidedListResponse no2 = new StudentGuidedListResponse();
        no2.setNota2oral(10);
        assertEquals(no2.getNota2oral(), 10);
    }

    @Test
    public void getNota3oral() throws Exception {
        StudentGuidedListResponse no3 = new StudentGuidedListResponse();
        no3.setNota3oral(9);
        assertEquals(no3.getNota3oral(), 9);
    }

    @Test
    public void setNota3oral() throws Exception {
        StudentGuidedListResponse no3 = new StudentGuidedListResponse();
        no3.setNota3oral(9);
        assertEquals(no3.getNota3oral(), 9);
    }

    @Test
    public void getNota4oral() throws Exception {
        StudentGuidedListResponse no4 = new StudentGuidedListResponse();
        no4.setNota4oral(10);
        assertEquals(no4.getNota4oral(), 10);
    }

    @Test
    public void setNota4oral() throws Exception {
        StudentGuidedListResponse no4 = new StudentGuidedListResponse();
        no4.setNota4oral(10);
        assertEquals(no4.getNota4oral(), 10);
    }

    @Test
    public void getNota1project() throws Exception {
        StudentGuidedListResponse np1 = new StudentGuidedListResponse();
        np1.setNota1project(10);
        assertEquals(np1.getNota1project(), 10);
    }

    @Test
    public void setNota1project() throws Exception {
        StudentGuidedListResponse np1 = new StudentGuidedListResponse();
        np1.setNota1project(10);
        assertEquals(np1.getNota1project(), 10);
    }

    @Test
    public void getNota2project() throws Exception {
        StudentGuidedListResponse np2 = new StudentGuidedListResponse();
        np2.setNota2project(10);
        assertEquals(np2.getNota2project(), 10);
    }

    @Test
    public void setNota2project() throws Exception {
        StudentGuidedListResponse np2 = new StudentGuidedListResponse();
        np2.setNota2project(10);
        assertEquals(np2.getNota2project(), 10);
    }

    @Test
    public void getNota3project() throws Exception {
        StudentGuidedListResponse np3 = new StudentGuidedListResponse();
        np3.setNota3project(9);
        assertEquals(np3.getNota3project(), 9);
    }

    @Test
    public void setNota3project() throws Exception {
        StudentGuidedListResponse np3 = new StudentGuidedListResponse();
        np3.setNota3project(10);
        assertEquals(np3.getNota3project(), 10);
    }

    @Test
    public void getNota4project() throws Exception {
        StudentGuidedListResponse np4 = new StudentGuidedListResponse();
        np4.setNota4project(10);
        assertEquals(np4.getNota4project(), 10);
    }

    @Test
    public void setNota4project() throws Exception {
        StudentGuidedListResponse np4 = new StudentGuidedListResponse();
        np4.setNota4project(10);
        assertEquals(np4.getNota4project(), 10);
    }

    @Test
    public void getNota5oral() throws Exception {
        StudentGuidedListResponse no5 = new StudentGuidedListResponse();
        no5.setNota5oral(9);
        assertEquals(no5.getNota5oral(), 9);
    }

    @Test
    public void setNota5oral() throws Exception {
        StudentGuidedListResponse no5 = new StudentGuidedListResponse();
        no5.setNota5oral(9);
        assertEquals(no5.getNota5oral(), 9);
    }

    @Test
    public void getNota5project() throws Exception {
        StudentGuidedListResponse np5 = new StudentGuidedListResponse();
        np5.setNota5project(10);
        assertEquals(np5.getNota5project(), 10);
    }

    @Test
    public void setNota5project() throws Exception {
        StudentGuidedListResponse np5 = new StudentGuidedListResponse();
        np5.setNota5project(10);
        assertEquals(np5.getNota5project(), 10);
    }

    @Test
    public void characters() throws Exception {
    }

}