package usersTestPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import model.users.User;
import model.users.rights.AccessRights;
import model.users.rights.users.SecretaryRights;
import model.users.types.Secretary;

public class SecretaryTest {

	@Test
	public void testSecretary() {
		Secretary s = new Secretary();
		assertFalse(s==null);
	}

	@Test
	public void testSecretaryStringStringStringAccessRights() {
		AccessRights secretaryRights = new SecretaryRights();
		String name = new String("Leonte Lacra");
		String username=new String("leonte.lacra");;
		String email=new String("lacra.lacra@gmail.com");
		Secretary s = new Secretary(username,name,email,secretaryRights);
		assertEquals(s.getName(),name);
		assertEquals(s.getUsername(),username);
		assertEquals(s.getEmail(),email);
		assertEquals(s.getRights(),secretaryRights);
	}

	@Test
	public void testUser() {
		User u = new Secretary();
		assertFalse(u==null);
	}

	@Test
	public void testGetUsername() {
		Secretary s = new Secretary();
		String name = new String("Leonte Lacra");
		s.setName(name);
		assertEquals(s.getName(),name);
	}

	@Test
	public void testSetUsername() {
		Secretary s = new Secretary();
		String userName = new String("leonte.lacra");
		s.setUsername(userName);
		assertEquals(s.getUsername(),userName);
	}

	@Test
	public void testGetName() {
		Secretary s = new Secretary();
		String name = new String("Leonte Lacra");
		s.setName(name);
		assertEquals(s.getName(),name);
	}

	@Test
	public void testSetName() {
		Secretary s = new Secretary();
		String name = new String("Leonte Lacra");
		s.setName(name);
		assertEquals(s.getName(),name);
	}

	@Test
	public void testGetEmail() {
		Secretary s = new Secretary();
		String email=new String("lacra.lacra@gmail.com");;
		s.setEmail(email);
		assertEquals(s.getEmail(),email);
	}

	@Test
	public void testSetEmail() {
		Secretary s = new Secretary();
		String email=new String("lacra.lacra@gmail.com");;
		s.setEmail(email);
		assertEquals(s.getEmail(),email);
	}

	@Test
	public void testGetRights() {
		AccessRights secretaryRights = new SecretaryRights();	
		Secretary s = new Secretary();
		s.setRights(secretaryRights);
		assertEquals(s.getRights(),secretaryRights);
	}

	@Test
	public void testSetRights() {
		AccessRights secretaryRights = new SecretaryRights();	
		Secretary s = new Secretary();
		s.setRights(secretaryRights);
		assertEquals(s.getRights(),secretaryRights);
	}

	@Test
	public void testToString() {
		AccessRights rights = new SecretaryRights();
		String name = new String("Leonte Lacra");
		String username=new String("leonte.lacra");;
		String email=new String("lacra.lacra@gmail.com");
		Secretary s = new Secretary(username,name,email,rights);
		StringBuilder expectedResult=new StringBuilder("User [username=" + username + ", name=" + name + ", email=" + email + "," + rights+"]");
		assertEquals(s.toString(),expectedResult.toString());
	}

}
