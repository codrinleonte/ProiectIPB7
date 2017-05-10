package types;

import static org.junit.Assert.*;

import org.junit.Test;

import Project.Project;

public class StudentTest {

	@Test
	public void testStudent() {
		Student s = new Student();
		
		assertFalse(s==null);
	}

	@Test
	public void testStudentProjectTeacher() {
		Project p = new Project();
		Teacher t = new Teacher();
		Student s =  new Student(p,t);
		assertEquals(t,s.getCoordinator());
		assertEquals(t,s.getProject());
	}
  /*
	@Test
	public void testGetProject() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetProject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCoordinator() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCoordinator() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMark() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMark() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRights() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRights() {
		fail("Not yet implemented");
	}

	@Test
	public void testUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEmail() {
		fail("Not yet implemented");
	}
*/
}
