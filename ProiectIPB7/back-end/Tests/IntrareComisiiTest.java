package com.fiiLicence.fiiLicence.services.bd;

import org.junit.Test;

import static org.junit.Assert.*;


public class IntrareComisiiTest {
    @Test
    public void getId() throws Exception {
        IntrareComisii id = new IntrareComisii();
        id.setId(12);
        assertEquals(id.getId(), 12);
    }

    @Test
    public void setId() throws Exception {
        IntrareComisii id = new IntrareComisii();
        id.setId(12);
        assertEquals(id.getId(), 12);
    }

    @Test
    public void getIdProfSef() throws Exception {
        IntrareComisii idP = new IntrareComisii();
        idP.setIdProfSef(22);
        assertEquals(idP.getIdProfSef(), 22);
    }

    @Test
    public void setIdProfSef() throws Exception {
        IntrareComisii idP = new IntrareComisii();
        idP.setIdProfSef(22);
        assertEquals(idP.getIdProfSef(), 22);
    }

    @Test
    public void getIdProf2() throws Exception {
        IntrareComisii id2 = new IntrareComisii();
        id2.setIdProf2(14);
        assertEquals(id2.getIdProf2(), 14);
    }

    @Test
    public void setIdProf2() throws Exception {
        IntrareComisii id2 = new IntrareComisii();
        id2.setIdProf2(14);
        assertEquals(id2.getIdProf2(), 14);
    }

    @Test
    public void getIdProf3() throws Exception {
        IntrareComisii id3 = new IntrareComisii();
        id3.setIdProf3(50);
        assertEquals(id3.getIdProf3(), 50);
    }

    @Test
    public void setIdProf3() throws Exception {
        IntrareComisii id3 = new IntrareComisii();
        id3.setIdProf3(50);
        assertEquals(id3.getIdProf3(), 50);
    }

    @Test
    public void getIdProf4() throws Exception {
        IntrareComisii id4 = new IntrareComisii();
        id4.setIdProf4(21);
        assertEquals(id4.getIdProf4(), 21);
    }

    @Test
    public void setIdProf4() throws Exception {
        IntrareComisii id4 = new IntrareComisii();
        id4.setIdProf4(21);
        assertEquals(id4.getIdProf4(), 21);
    }

    @Test
    public void getIdSecretar() throws Exception {
        IntrareComisii idS = new IntrareComisii();
        idS.setIdSecretar(3);
        assertEquals(idS.getIdSecretar(), 3);
    }

    @Test
    public void setIdSecretar() throws Exception {
        IntrareComisii idS = new IntrareComisii();
        idS.setIdSecretar(3);
        assertEquals(idS.getIdSecretar(), 3);
    }

    @Test
    public void getTipComisie() throws Exception {
        IntrareComisii type = new IntrareComisii();
        type.setTipComisie("evaluare");
        assertEquals(type.getTipComisie(), "evaluare");
    }

    @Test
    public void setTipComisie() throws Exception {
        IntrareComisii type = new IntrareComisii();
        type.setTipComisie("evaluare");
        assertEquals(type.getTipComisie(), "evaluare");
    }

    @Test
    public void getIdEvaluare() throws Exception {
        IntrareComisii idE = new IntrareComisii();
        idE.setIdEvaluare(1);
        assertEquals(idE.getIdEvaluare(), 1);
    }

    @Test
    public void setIdEvaluare() throws Exception {
        IntrareComisii idE = new IntrareComisii();
        idE.setIdEvaluare(1);
        assertEquals(idE.getIdEvaluare(), 1);
    }

    @Test
    public void getBeginDate() throws Exception {
        IntrareComisii bd = new IntrareComisii();
        bd.setBeginDate("21.06.2017");
        assertEquals(bd.getBeginDate(), "21.06.2017");
    }

    @Test
    public void setBeginDate() throws Exception {
        IntrareComisii bd = new IntrareComisii();
        bd.setBeginDate("21.06.2017");
        assertEquals(bd.getBeginDate(), "21.06.2017");
    }

    @Test
    public void getEndDate() throws Exception {
        IntrareComisii ed = new IntrareComisii();
        ed.setEndDate("30.06.2017");
        assertEquals(ed.getEndDate(), "30.06.2017");
    }

    @Test
    public void setEndDate() throws Exception {
        IntrareComisii ed = new IntrareComisii();
        ed.setEndDate("30.06.2017");
        assertEquals(ed.getEndDate(), "30.06.2017");
    }

    @Test
    public void getNumeComisie() throws Exception {
        IntrareComisii nume = new IntrareComisii();
        nume.setNumeComisie("Comisie 10");
        assertEquals(nume.getNumeComisie(), "Comisie 10");
    }

    @Test
    public void setNumeComisie() throws Exception {
        IntrareComisii nume = new IntrareComisii();
        nume.setNumeComisie("Comisie 10");
        assertEquals(nume.getNumeComisie(), "Comisie 10");
    }

    @Test
    public void chars() throws Exception {
    }

}