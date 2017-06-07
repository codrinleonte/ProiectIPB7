package com.fiiLicence.fiiLicence.services.bd;

import com.fiiLicence.fiiLicence.models.old.User;
import org.junit.Test;

import static org.junit.Assert.*;


public class UserBDTest {
    @Test
    public void getTip() throws Exception {
        UserBD type = new UserBD();
        type.setTip("admin");
        assertEquals(type.getTip(), "admin");
    }

    @Test
    public void setTip() throws Exception {
        UserBD type = new UserBD();
        type.setTip("admin");
        assertEquals(type.getTip(), "admin");
    }

    @Test
    public void getId() throws Exception {
        UserBD id = new UserBD();
        id.setId(5434);
        assertEquals(id.getId(), 5434);
    }

    @Test
    public void setId() throws Exception {
        UserBD id = new UserBD();
        id.setId(5434);
        assertEquals(id.getId(), 5434);
    }

    @Test
    public void getUsername() throws Exception {
        UserBD username = new UserBD();
        username.setUsername("laur213");
        assertEquals(username.getUsername(), "laur213");
    }

    @Test
    public void setUsername() throws Exception {
        UserBD username = new UserBD();
        username.setUsername("laur213");
        assertEquals(username.getUsername(), "laur213");
    }

    @Test
    public void chars() throws Exception {
    }

}