package com.fiiLicence.fiiLicence.services.bd;

import org.junit.Test;

import static org.junit.Assert.*;


public class IntrareConturiTest {
    @Test
    public void getId() throws Exception {
        IntrareConturi id = new IntrareConturi();
        id.setId(22);
        assertEquals(id.getId(), 22);
    }

    @Test
    public void setId() throws Exception {
        IntrareConturi id = new IntrareConturi();
        id.setId(22);
        assertEquals(id.getId(), 22);
    }

    @Test
    public void getUsername() throws Exception {
        IntrareConturi username = new IntrareConturi();
        username.setUsername("laur.ciucanu");
        assertEquals(username.getUsername(), "laur.ciucanu");
    }

    @Test
    public void setUsername() throws Exception {
        IntrareConturi username = new IntrareConturi();
        username.setUsername("laur.ciucanu");
        assertEquals(username.getUsername(), "laur.ciucanu");
    }

    @Test
    public void getHashparola() throws Exception {
        IntrareConturi passHash = new IntrareConturi();
        passHash.setHashparola("asd#123");
        assertEquals(passHash.getHashparola(), "asd#123");
    }

    @Test
    public void setHashparola() throws Exception {
        IntrareConturi passHash = new IntrareConturi();
        passHash.setHashparola("asd#123");
        assertEquals(passHash.getHashparola(), "asd#123");
    }

    @Test
    public void getEmail() throws Exception {
        IntrareConturi email = new IntrareConturi();
        email.setEmail("laur.ciucanu@info.uaic.ro");
        assertEquals(email.getEmail(), "laur.ciucanu@info.uaic.ro");
    }

    @Test
    public void setEmail() throws Exception {
        IntrareConturi email = new IntrareConturi();
        email.setEmail("laur.ciucanu@info.uaic.ro");
        assertEquals(email.getEmail(), "laur.ciucanu@info.uaic.ro");
    }

    @Test
    public void getTipUtilizator() throws Exception {
        IntrareConturi typeU = new IntrareConturi();
        typeU.setTipUtilizator("user");
        assertEquals(typeU.getTipUtilizator(), "user");
    }

    @Test
    public void setTipUtilizator() throws Exception {
        IntrareConturi typeU = new IntrareConturi();
        typeU.setTipUtilizator("user");
        assertEquals(typeU.getTipUtilizator(), "user");
    }

    @Test
    public void getStatus() throws Exception {
        IntrareConturi status = new IntrareConturi();
        status.setStatus(1);
        assertEquals(status.getStatus(), 1);
    }

    @Test
    public void setStatus() throws Exception {
        IntrareConturi status = new IntrareConturi();
        status.setStatus(1);
        assertEquals(status.getStatus(), 1);
    }

    @Test
    public void getCodActivare() throws Exception {
        IntrareConturi code = new IntrareConturi();
        code.setCodActivare("5467");
        assertEquals(code.getCodActivare(), "5467");
    }

    @Test
    public void setCodActivare() throws Exception {
        IntrareConturi code = new IntrareConturi();
        code.setCodActivare("5467");
        assertEquals(code.getCodActivare(), "5467");
    }

    @Test
    public void getToken() throws Exception {
        IntrareConturi tk = new IntrareConturi();
        tk.setToken("asdzxc");
        assertEquals(tk.getToken(), "asdzxc");
    }

    @Test
    public void setToken() throws Exception {
        IntrareConturi tk = new IntrareConturi();
        tk.setToken("asdzxc");
        assertEquals(tk.getToken(), "asdzxc");
    }

    @Test
    public void chars() throws Exception {
    }

}