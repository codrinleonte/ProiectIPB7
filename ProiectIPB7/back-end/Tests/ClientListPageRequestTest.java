package tests.requestsTests;

import com.fiiLicence.fiiLicence.models.requests.ClientListPageRequest;
import org.junit.Test;

import static org.junit.Assert.*;


public class ClientListPageRequestTest {
    @Test
    public void getPagenumber() throws Exception {
        ClientListPageRequest cl = new ClientListPageRequest();
        cl.setPagenumber(2);
        assertEquals(cl.getPagenumber(),2);

    }

    @Test
    public void setPagenumber() throws Exception {
        ClientListPageRequest cl = new ClientListPageRequest();
        cl.setPagenumber(2);
        assertEquals(cl.getPagenumber(),2);
    }

    @Test
    public void getPagesize() throws Exception {
        ClientListPageRequest c2 = new ClientListPageRequest();
        c2.getPagesize(5);
        assertEquals(c2.getPagesize(),5);
    }

    @Test
    public void setPagesize() throws Exception {
        ClientListPageRequest c3 = new ClientListPageRequest();
        c3.setPagesize(5);
        assertEquals(c3.getPagesize(),5);
    }

}