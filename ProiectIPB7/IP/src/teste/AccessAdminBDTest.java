package teste;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bd.*;

public class AccessAdminBDTest {

	@Test
	public void testSetDataSustinere() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			int result = accessAdmin.setDataSustinere(1, java.sql.Timestamp.valueOf("2017-07-01 11:00:00.000000"));
			int expect = 0;
			
			assertEquals(expect, result);
			
			result = accessAdmin.setDataSustinere(-1, java.sql.Timestamp.valueOf("2017-07-01 11:00:00.000000"));
			expect = -7;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testGetDataSustinere() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			Timestamp result = accessAdmin.getDataSustinere(1);
			Timestamp expect = java.sql.Timestamp.valueOf("2017-07-01 11:00:00.000000");
			
			assertEquals(expect, result);
			
			result = accessAdmin.getDataSustinere(-1);
			expect = null;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testGetSala() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			String result = accessAdmin.getSala(2);
			String expect = "308";
			
			result.equals(expect);
			
			result = accessAdmin.getSala(-1);
			expect = null;
			
			//result.equals(expect);
		}
	}

	@Test
	public void testSetComisieProfesor() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			int result = accessAdmin.setComisieProfesor(13, 4);
			int expect = 0;
			
			assertEquals(expect, result);
			
			result = accessAdmin.setComisieProfesor(-1, 4);
			expect = -7;
			
			assertEquals(expect, result);
			
			result = accessAdmin.setComisieProfesor(13, -7);
			expect = -7;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testSetMembruComisie() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			int result = accessAdmin.setMembruComisie(-1, 1, 4);
			int expect = -2;
			
			assertEquals(expect, result);
			
			result = accessAdmin.setMembruComisie(5, 1, 4);
			expect = -2;
			
			assertEquals(expect, result);
			
			result = accessAdmin.setMembruComisie(2, 1, 3);
			expect = 0;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testSetSalaComisie() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			int result = accessAdmin.setSalaComisie(1, "405");
			int expect = 0;
			
			assertEquals(expect, result);
			
			result = accessAdmin.setSalaComisie(1, null);
			expect = 0;
			
			assertEquals(expect, result);
			
			result = accessAdmin.setSalaComisie(-2, "302");
			expect = -7;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testSetFisierLucrare() {
		

		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			byte[] data = {1, 2, 3, 4, 5};
			int result = accessAdmin.setFisierLucrare(1, data);
			int expect = 0;
			
			assertEquals(expect, result);
			
			result = accessAdmin.setFisierLucrare(-1, null);
			expect = -7;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testGetFisierLucrare() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			byte[] result = accessAdmin.getFisierLucrare(1);
			byte[] expect = {1, 2, 3, 4, 5};
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testUpdateSesiuneActive() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			int result = accessAdmin.updateSesiuneActive(10);
			int expect = 0;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testProfesoriCoordonatoriFaraComisie() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			List<IntrareProfesori> result = accessAdmin.profesoriCoordonatoriFaraComisie();
			List<IntrareProfesori> expect = new ArrayList<IntrareProfesori>();
			IntrareProfesori prof = new IntrareProfesori();
			
			prof.setId(2);
			prof.setNume("Arusoaie");
			prof.setPrenume("Andreea");
			prof.setGradDidactic("Asist. DR.");
			expect.add(prof);
			
			prof = new IntrareProfesori();
			prof.setId(4);
			prof.setNume("Asimioanei");
			prof.setPrenume("Ion");
			prof.setGradDidactic("Lect.");
			expect.add(prof);
			
			prof = new IntrareProfesori();
			prof.setId(38);
			prof.setNume("Varlan");
			prof.setPrenume("Cosmin");
			prof.setGradDidactic("Lect. Dr.");
			expect.add(prof);
			
			result.equals(expect);
		}
	}

	@Test
	public void testCreareComisie() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			int result = accessAdmin.creareComisie(0);
			int expect = 0;
			
			assertEquals(expect, result);
			
			result = accessAdmin.creareComisie(-1);
			expect = 0;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testSchimbaComisie() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			int result = accessAdmin.schimbaComisie(5, 2, 3);
			int expect = 1;
			
			assertEquals(expect, result);
			
			result = accessAdmin.schimbaComisie(10, 2, 3);
			expect = -1;
			
			assertEquals(expect, result);
			
			result = accessAdmin.schimbaComisie(6, -2, 2);
			expect = -1;
			
			assertEquals(expect, result);
			
			result = accessAdmin.schimbaComisie(6, 2, -2);
			expect = -1;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testSelectCoordonatori() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			int[] result = accessAdmin.selectCoordonatori(2);
			int[] expect = {6, 7};
			
			//for(int i = 0 ;i<result.length;i++)
				//result[i] == expect[i]
			
			result = accessAdmin.selectCoordonatori(-2);
			expect = new int[5];
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testSelectMesaje() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			List<IntrareMesaje> result = accessAdmin.selectMesaje();
			List<IntrareMesaje> expect = new ArrayList<IntrareMesaje>();
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testSelectConturi() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			List<IntrareConturi> result = accessAdmin.selectConturi();
			List<IntrareConturi> expect = new ArrayList<IntrareConturi>();
			IntrareConturi cont = new IntrareConturi();
			
			cont.setId(1);
			cont.setUsername("Admin");
			cont.setHashparola("Root");
			cont.setEmail("Admin");
			cont.setTipUtilizator("Admin");
			cont.setStatus(1);
			cont.setCodActivare("0");
			cont.setToken("0");
			expect.add(cont);
			
			cont.setId(2);
			cont.setUsername("ionescu.mircea");
			cont.setHashparola("parola");
			cont.setEmail("ionescu.mircea@info.uiac.ro");
			cont.setTipUtilizator("Student");
			cont.setStatus(1);
			cont.setCodActivare("blabla");
			cont.setToken("token1");
			expect.add(cont);
			
			cont.setId(3);
			cont.setUsername("polonescu.mia");
			cont.setHashparola("parola");
			cont.setEmail("polonescu.mia@info.uaic.ro");
			cont.setTipUtilizator("Student");
			cont.setStatus(1);
			cont.setCodActivare("blabla");
			cont.setToken("token2");
			expect.add(cont);
			
			cont.setId(4);
			cont.setUsername("agapei.ioana");
			cont.setHashparola("parola");
			cont.setEmail("agapei.ioana@info.uaic.ro");
			cont.setTipUtilizator("Student");
			cont.setStatus(1);
			cont.setCodActivare("blabla");
			cont.setToken("token3");
			expect.add(cont);
			
			cont.setId(5);
			cont.setUsername("stanescu.mihai");
			cont.setHashparola("parola");
			cont.setEmail("stanescu.mihai@info.uaic.ro");
			cont.setTipUtilizator("Student");
			cont.setStatus(1);
			cont.setCodActivare("blabla");
			cont.setToken("token4");
			expect.add(cont);
			
			cont.setId(6);
			cont.setUsername("mardare.radu");
			cont.setHashparola("parola");
			cont.setEmail("mardare.radu@info.uaic.ro");
			cont.setTipUtilizator("Student");
			cont.setStatus(1);
			cont.setCodActivare("blabla");
			cont.setToken("token5");
			expect.add(cont);
			
			cont.setId(7);
			cont.setUsername("lupu.irina");
			cont.setHashparola("parola");
			cont.setEmail("lupu.irina@info.uaic.ro");
			cont.setTipUtilizator("Student");
			cont.setStatus(1);
			cont.setCodActivare("blabla");
			cont.setToken("token6");
			expect.add(cont);
			
			cont.setId(8);
			cont.setUsername("lupascu.mioara");
			cont.setHashparola("parola");
			cont.setEmail("lupascu.mioara@info.uaic.ro");
			cont.setTipUtilizator("Student");
			cont.setStatus(1);
			cont.setCodActivare("blabla");
			cont.setToken("token7");
			expect.add(cont);
			
			cont.setId(9);
			cont.setUsername("cristea.irina");
			cont.setHashparola("parola");
			cont.setEmail("cristea.irina@info.uaic.ro");
			cont.setTipUtilizator("Student");
			cont.setStatus(1);
			cont.setCodActivare("blabla");
			cont.setToken("token8");
			expect.add(cont);
			
			cont.setId(10);
			cont.setUsername("jimmy.grigory");
			cont.setHashparola("parola");
			cont.setEmail("jimmy.grigory@info.uaic.ro");
			cont.setTipUtilizator("Student");
			cont.setStatus(1);
			cont.setCodActivare("blabla");
			cont.setToken("token9");
			expect.add(cont);
			
			cont.setId(11);
			cont.setUsername("lenuta.alboaie");
			cont.setHashparola("parola");
			cont.setEmail("lenuta.alboaie@info.uaic.ro");
			cont.setTipUtilizator("Profesor");
			cont.setStatus(1);
			cont.setCodActivare("0");
			cont.setToken("0");
			expect.add(cont);
			
			cont.setId(12);
			cont.setUsername("andreea.arusoaie");
			cont.setHashparola("parola");
			cont.setEmail("andreea.arusoaie@info.uaic.ro");
			cont.setTipUtilizator("Profesor");
			cont.setStatus(1);
			cont.setCodActivare("0");
			cont.setToken("0");
			expect.add(cont);
			
			cont.setId(13);
			cont.setUsername("andrei.arusoaie");
			cont.setHashparola("parola");
			cont.setEmail("andrei.arusoaie@info.uaic.ro");
			cont.setTipUtilizator("Profesor");
			cont.setStatus(1);
			cont.setCodActivare("0");
			cont.setToken("0");
			expect.add(cont);
			
			cont.setId(14);
			cont.setUsername("razvan.benchea");
			cont.setHashparola("parola");
			cont.setEmail("razvan.benchea@info.uaic.ro");
			cont.setTipUtilizator("Profesor");
			cont.setStatus(1);
			cont.setCodActivare("0");
			cont.setToken("0");
			expect.add(cont);
			
			cont.setId(15);
			cont.setUsername("catalin.birjoveanu");
			cont.setHashparola("parola");
			cont.setEmail("catalin.birjoveanu@info.uaic.ro");
			cont.setTipUtilizator("Student");
			cont.setStatus(1);
			cont.setCodActivare("0");
			cont.setToken("0");
			expect.add(cont);
			
			cont.setId(16);
			cont.setUsername("mihaela.breaban");
			cont.setHashparola("parola");
			cont.setEmail("mihaela.breaban@info.uaic.ro");
			cont.setTipUtilizator("Profesor");
			cont.setStatus(1);
			cont.setCodActivare("0");
			cont.setToken("0");
			expect.add(cont);
			
			cont.setId(17);
			cont.setUsername("oana.captarencu");
			cont.setHashparola("parola");
			cont.setEmail("oana.captarencu@info.uaic.ro");
			cont.setTipUtilizator("Profesor");
			cont.setStatus(1);
			cont.setCodActivare("0");
			cont.setToken("0");
			expect.add(cont);
			
			cont.setId(18);
			cont.setUsername("stefan.ciobaca");
			cont.setHashparola("parola");
			cont.setEmail("stefan.ciobaca@info.uaic.ro");
			cont.setTipUtilizator("Profesor");
			cont.setStatus(1);
			cont.setCodActivare("0");
			cont.setToken("0");
			expect.add(cont);
			
			cont.setId(19);
			cont.setUsername("liviu.ciortuz");
			cont.setHashparola("parola");
			cont.setEmail("liviu.ciortuz@info.uaic.ro");
			cont.setTipUtilizator("Profesor");
			cont.setStatus(1);
			cont.setCodActivare("0");
			cont.setToken("0");
			expect.add(cont);
			
			cont.setId(20);
			cont.setUsername("cornelius.croitoru");
			cont.setHashparola("parola");
			cont.setEmail("cornelius.croitoru@info.uaic.ro");
			cont.setTipUtilizator("Profesor");
			cont.setStatus(1);
			cont.setCodActivare("0");
			cont.setToken("0");
			expect.add(cont);
			
			cont.setId(21);
			cont.setUsername("corina.forascu");
			cont.setHashparola("parola");
			cont.setEmail("corina.forascu@info.uaic.ro");
			cont.setTipUtilizator("Profesor");
			cont.setStatus(1);
			cont.setCodActivare("0");
			cont.setToken("0");
			expect.add(cont);
			
			cont.setId(22);
			cont.setUsername("cristian.frasinaru");
			cont.setHashparola("parola");
			cont.setEmail("cristian.frasinaru@info.uaic.ro");
			cont.setTipUtilizator("Profesor");
			cont.setStatus(1);
			cont.setCodActivare("0");
			cont.setToken("0");
			expect.add(cont);
			
			cont.setId(23);
			cont.setUsername("cristian.gatu");
			cont.setHashparola("parola");
			cont.setEmail("cristian.gatu@info.uaic.ro");
			cont.setTipUtilizator("Profesor");
			cont.setStatus(1);
			cont.setCodActivare("0");
			cont.setToken("0");
			expect.add(cont);
			
			result.equals(expect);
		}
	}

	@Test
	public void testSelectStudenti() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			List<IntrareStudenti> result = accessAdmin.selectStudenti();
			List<IntrareStudenti> expect = new ArrayList<IntrareStudenti>();
			IntrareStudenti student = new IntrareStudenti();
			
			student.setId(1);
			student.setIdCont(2);
			student.setNrMatricol("sv3456781");
			student.setNume("Ionescu");
			student.setPrenume("Mircea");
			student.setId_comisie(1);
			student.setIdSesiune(1);
			expect.add(student);
						
			student.setId(2);
			student.setIdCont(3);
			student.setNrMatricol("sv3456782");
			student.setNume("Polonescu");
			student.setPrenume("Mia");
			student.setId_comisie(1);
			student.setIdSesiune(1);
			expect.add(student);
			
			student.setId(3);
			student.setIdCont(4);
			student.setNrMatricol("sv3456783");
			student.setNume("Agapei");
			student.setPrenume("Ioana");
			student.setId_comisie(1);
			student.setIdSesiune(2);
			expect.add(student);
			
			student.setId(4);
			student.setIdCont(5);
			student.setNrMatricol("sv3456784");
			student.setNume("Stanescu");
			student.setPrenume("Mihai");
			student.setId_comisie(1);
			student.setIdSesiune(3);
			expect.add(student);
			
			student.setId(5);
			student.setIdCont(6);
			student.setNrMatricol("sv3456785");
			student.setNume("Mardare");
			student.setPrenume("Radu");
			student.setId_comisie(1);
			student.setIdSesiune(4);
			expect.add(student);
			
			student.setId(6);
			student.setIdCont(7);
			student.setNrMatricol("sv3456786");
			student.setNume("Lupu");
			student.setPrenume("Irina");
			student.setId_comisie(1);
			student.setIdSesiune(1);
			expect.add(student);
			
			student.setId(7);
			student.setIdCont(8);
			student.setNrMatricol("sv3456787");
			student.setNume("Lupascu");
			student.setPrenume("Mioara");
			student.setId_comisie(1);
			student.setIdSesiune(3);
			expect.add(student);
			
			student.setId(8);
			student.setIdCont(9);
			student.setNrMatricol("sv3456788");
			student.setNume("Cristea");
			student.setPrenume("Irina");
			student.setId_comisie(1);
			student.setIdSesiune(4);
			expect.add(student);
			
			student.setId(9);
			student.setIdCont(10);
			student.setNrMatricol("sv3456789");
			student.setNume("Jimmy");
			student.setPrenume("Grygory");
			student.setId_comisie(1);
			student.setIdSesiune(1);
			expect.add(student);
			
			result.equals(expect);
		}
	}

	@Test
	public void testSelectProfesori() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			List<IntrareProfesori> result = accessAdmin.selectProfesori();
			List<IntrareProfesori> expect = new ArrayList<IntrareProfesori>();
			IntrareProfesori prof = new IntrareProfesori();
			
			prof.setId(1);
			prof.setNume("Alboaie");
			prof.setPrenume("Lenuta");
			prof.setIdCont(11);
			prof.setGradDidactic("Conf. DR.");
			prof.setIdComisie(1);
			prof.setFunctieComisie("Presedinte");
			expect.add(prof);
			
			prof.setId(2);
			prof.setIdCont(12);
			prof.setNume("Arusoaie");
			prof.setPrenume("Andreea");
			prof.setGradDidactic("Asist. DR.");
			prof.setIdComisie(1);
			prof.setFunctieComisie("Secretar");
			expect.add(prof);
			
			prof.setId(3);
			prof.setIdCont(13);
			prof.setNume("Arusoaie");
			prof.setPrenume("Andrei");
			prof.setGradDidactic("Lect. DR.");
			prof.setIdComisie(1);
			prof.setFunctieComisie("Evaluator");
			expect.add(prof);
			
			prof.setId(4);
			prof.setNume("Asimioanei");
			prof.setPrenume("Ion");
			prof.setGradDidactic("Lect.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(5);
			prof.setIdCont(14);
			prof.setNume("Benchea");
			prof.setPrenume("Razvan");
			prof.setGradDidactic("Lect. DR.");
			prof.setIdComisie(2);
			prof.setFunctieComisie("Presedinte");
			expect.add(prof);
			
			prof.setId(6);
			prof.setIdCont(15);
			prof.setNume("Birjoveanu");
			prof.setPrenume("Catalin");
			prof.setGradDidactic("Lect. DR.");
			prof.setIdComisie(2);
			prof.setFunctieComisie("Secretar");
			expect.add(prof);
			
			prof.setId(7);
			prof.setIdCont(16);
			prof.setNume("Breaban");
			prof.setPrenume("Mihaela");
			prof.setGradDidactic("Conf. DR.");
			prof.setIdComisie(2);
			prof.setFunctieComisie("Evaluator");
			expect.add(prof);
			
			prof.setId(8);
			prof.setNume("Buraga");
			prof.setPrenume("Sabin");
			prof.setGradDidactic("Conf. DR.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(9);
			prof.setIdCont(17);
			prof.setNume("Captarencu");
			prof.setPrenume("Oana");
			prof.setGradDidactic("Lect. DR.");
			prof.setIdComisie(3);
			prof.setFunctieComisie("Presedinte");
			expect.add(prof);
			
			prof.setId(10);
			prof.setIdCont(18);
			prof.setNume("Ciobaca");
			prof.setPrenume("Steafan");
			prof.setGradDidactic("Conf. DR.");
			prof.setIdComisie(3);
			prof.setFunctieComisie("Secretar");
			expect.add(prof);
			
			prof.setId(11);
			prof.setIdCont(19);
			prof.setNume("Ciortuz");
			prof.setPrenume("Liviu");
			prof.setGradDidactic("Conf. DR.");
			prof.setIdComisie(3);
			prof.setFunctieComisie("Evaluator");
			expect.add(prof);
			
			prof.setId(12);
			prof.setNume("Cristea");
			prof.setPrenume("Dan");
			prof.setGradDidactic("Prof. DR.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(13);
			prof.setIdCont(20);
			prof.setNume("Croitoru");
			prof.setPrenume("Cornelius");
			prof.setGradDidactic("Prof. DR.");
			prof.setIdComisie(4);
			prof.setFunctieComisie("Presedinte");
			expect.add(prof);
			
			prof.setId(14);
			prof.setIdCont(21);
			prof.setNume("Forascu");
			prof.setPrenume("Corina");
			prof.setGradDidactic("Conf. DR.");
			prof.setIdComisie(4);
			prof.setFunctieComisie("Secretar");
			expect.add(prof);
			
			prof.setId(15);
			prof.setIdCont(22);
			prof.setNume("Frasinaru");
			prof.setPrenume("Cristian");
			prof.setGradDidactic("Lect. DR.");
			prof.setIdComisie(4);
			prof.setFunctieComisie("Evaluator");
			expect.add(prof);
			
			prof.setId(16);
			prof.setIdCont(23);
			prof.setNume("Gatu");
			prof.setPrenume("Cristian");
			prof.setGradDidactic("Conf. DR.");
			prof.setIdComisie(4);
			prof.setFunctieComisie("Evaluator");
			expect.add(prof);
			
			prof.setId(17);
			prof.setNume("Gavrilut");
			prof.setPrenume("Dragos");
			prof.setGradDidactic("Conf. DR.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(18);
			prof.setNume("Ghirvu");
			prof.setPrenume("Lucian");
			prof.setGradDidactic("Lect. DR.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(19);
			prof.setNume("Grigoras");
			prof.setPrenume("Gheorghe");
			prof.setGradDidactic("Prof. DR.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(20);
			prof.setNume("Iacob");
			prof.setPrenume("Florin");
			prof.setGradDidactic("Lect. DR.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(21);
			prof.setNume("Iftene");
			prof.setPrenume("Adrian");
			prof.setGradDidactic("Conf. DR.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(22);
			prof.setNume("Iftene");
			prof.setPrenume("Sorin");
			prof.setGradDidactic("");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(23);
			prof.setNume("Ignat");
			prof.setPrenume("Anca");
			prof.setGradDidactic("Lect. DR.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(24);
			prof.setNume("Lucanu");
			prof.setPrenume("Dorel");
			prof.setGradDidactic("Prof. DR.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(25);
			prof.setNume("Luchian");
			prof.setPrenume("Henri");
			prof.setGradDidactic("Prof. DR.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(26);
			prof.setNume("Masalagiu");
			prof.setPrenume("Cristian");
			prof.setGradDidactic("Prof. DR.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(27);
			prof.setNume("Moruz");
			prof.setPrenume("Alex");
			prof.setGradDidactic("Lect. DR.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(28);
			prof.setNume("Olariu");
			prof.setPrenume("Florentin");
			prof.setGradDidactic("Lect. DR.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(29);
			prof.setNume("Onica");
			prof.setPrenume("Emanuel");
			prof.setGradDidactic("Lect. DR.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(30);
			prof.setNume("Onofrei");
			prof.setPrenume("Paula");
			prof.setGradDidactic("Lect. Dr.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(31);
			prof.setNume("Oprea");
			prof.setPrenume("Dumitru");
			prof.setGradDidactic("Prof. Dr.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(32);
			prof.setNume("Patrut");
			prof.setPrenume("Bogdan");
			prof.setGradDidactic("Lect. Dr.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(33);
			prof.setNume("Pistol");
			prof.setPrenume("Ionut");
			prof.setGradDidactic("Lect. Dr.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(34);
			prof.setNume("Radulescu");
			prof.setPrenume("Vlad");
			prof.setGradDidactic("Lect. Dr.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(35);
			prof.setNume("Teodorescu");
			prof.setPrenume("Horia");
			prof.setGradDidactic("Prof. Dr.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(36);
			prof.setNume("Tiplea");
			prof.setPrenume("Ferucio");
			prof.setGradDidactic("Prof. Dr.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(37);
			prof.setNume("Trandabat");
			prof.setPrenume("Diana");
			prof.setGradDidactic("Conf. Dr.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(38);
			prof.setNume("Varlan");
			prof.setPrenume("Cosmin");
			prof.setGradDidactic("Lect. Dr.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(39);
			prof.setNume("Vidrascu");
			prof.setPrenume("Cristian");
			prof.setGradDidactic("Lect. Dr.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			prof.setId(40);
			prof.setNume("Vitcu");
			prof.setPrenume("Anca");
			prof.setGradDidactic("Conf. Dr.");
			prof.setIdComisie(0);
			expect.add(prof);
			
			result.equals(expect);
		}
	}

	@Test
	public void testSelectComisii() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			List<IntrareComisii> result = accessAdmin.selectComisii();
			List<IntrareComisii> expect = new ArrayList<IntrareComisii>();
			IntrareComisii comisie = new IntrareComisii();
			
			comisie.setId(1);
			comisie.setIdProfSef(1);
			comisie.setIdProf2(2);
			comisie.setIdProf3(3);
			comisie.setIdProf4(0);
			comisie.setIdSecretar(2);
			comisie.setTipComisie("licenta");
			comisie.setSala("307");
			expect.add(comisie);
			
			comisie.setId(2);
			comisie.setIdProfSef(5);
			comisie.setIdProf2(6);
			comisie.setIdProf3(7);
			comisie.setIdProf4(0);
			comisie.setIdSecretar(6);
			comisie.setTipComisie("licenta");
			comisie.setSala("308");
			expect.add(comisie);
			
			comisie.setId(3);
			comisie.setIdProfSef(9);
			comisie.setIdProf2(10);
			comisie.setIdProf3(11);
			comisie.setIdProf4(0);
			comisie.setIdSecretar(10);
			comisie.setTipComisie("dizertatie");
			comisie.setSala("309");
			expect.add(comisie);
			
			comisie.setId(4);
			comisie.setIdProfSef(13);
			comisie.setIdProf2(14);
			comisie.setIdProf3(15);
			comisie.setIdProf4(16);
			comisie.setIdSecretar(14);
			comisie.setTipComisie("dizertatie");
			comisie.setSala("407");
			expect.add(comisie);
			
			result.equals(expect);
		}
	}

	@Test
	public void testSelectLicente() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			List<IntrareLicente> result = accessAdmin.selectLicente();
			List<IntrareLicente> expect = new ArrayList<IntrareLicente>();
			IntrareLicente licenta = new IntrareLicente();
			
			licenta.setId(1);
			licenta.setTitlu("licenta1");
			licenta.setIdProfesor(2);
			licenta.setIdStudent(1);
			licenta.setMaterialeLicenta("www.google.ro");
			licenta.setIdSesiune(1);
			licenta.setTipLucrare("LICENTA");
			expect.add(licenta);
			
			licenta.setId(2);
			licenta.setTitlu("licenta2");
			licenta.setIdProfesor(5);
			licenta.setIdStudent(2);
			licenta.setMaterialeLicenta("www.google.ro");
			licenta.setIdSesiune(1);
			licenta.setTipLucrare("LICENTA");
			expect.add(licenta);
			
			licenta.setId(3);
			licenta.setTitlu("licenta3");
			licenta.setIdProfesor(3);
			licenta.setIdStudent(3);
			licenta.setMaterialeLicenta("www.google.ro");
			licenta.setIdSesiune(1);
			licenta.setTipLucrare("LICENTA");
			expect.add(licenta);
			
			licenta.setId(4);
			licenta.setTitlu("licenta4");
			licenta.setIdProfesor(1);
			licenta.setIdStudent(4);
			licenta.setMaterialeLicenta("www.google.ro");
			licenta.setIdSesiune(1);
			licenta.setTipLucrare("LICENTA");
			expect.add(licenta);
			
			licenta.setId(5);
			licenta.setTitlu("licenta5");
			licenta.setIdProfesor(3);
			licenta.setIdStudent(5);
			licenta.setMaterialeLicenta("www.google.ro");
			licenta.setIdSesiune(1);
			licenta.setTipLucrare("LICENTA");
			expect.add(licenta);
			
			licenta.setId(6);
			licenta.setTitlu("licenta6");
			licenta.setIdProfesor(6);
			licenta.setIdStudent(6);
			licenta.setMaterialeLicenta("www.google.ro");
			licenta.setIdSesiune(1);
			licenta.setTipLucrare("LICENTA");
			expect.add(licenta);
			
			licenta.setId(7);
			licenta.setTitlu("licenta7");
			licenta.setIdProfesor(4);
			licenta.setIdStudent(7);
			licenta.setMaterialeLicenta("www.google.ro");
			licenta.setIdSesiune(1);
			licenta.setTipLucrare("LICENTA");
			expect.add(licenta);
			
			licenta.setId(8);
			licenta.setTitlu("licenta8");
			licenta.setIdProfesor(7);
			licenta.setIdStudent(8);
			licenta.setMaterialeLicenta("www.google.ro");
			licenta.setIdSesiune(1);
			licenta.setTipLucrare("LICENTA");
			expect.add(licenta);
			
			licenta.setId(9);
			licenta.setTitlu("licenta9");
			licenta.setIdProfesor(38);
			licenta.setIdStudent(9);
			licenta.setMaterialeLicenta("wwww.google.ro");
			licenta.setIdSesiune(1);
			licenta.setTipLucrare("LICENTA");
			expect.add(licenta);
			
			result.equals(expect);
		}
	}

	@Test
	public void testSelectSesiuni() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			List<IntrareSesiuni> result = accessAdmin.selectSesiuni();
			List<IntrareSesiuni> expect = new ArrayList<IntrareSesiuni>();
			IntrareSesiuni sesiune = new IntrareSesiuni();
			
			sesiune.setId(1);
			sesiune.setInceputSesiune(java.sql.Timestamp.valueOf("2018-07-01 00:00:00.000000"));
			sesiune.setSfarsitSesiune(java.sql.Timestamp.valueOf("2018-08-01 00:00:00.000000"));
			sesiune.setActive(10);
			expect.add(sesiune);
			
			result.equals(expect);
		}
	}

	@Test
	public void testSelectDetaliiLicente() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			List<IntrareDetaliiLicente> result = accessAdmin.selectDetaliiLicente();
			List<IntrareDetaliiLicente> expect = new ArrayList<IntrareDetaliiLicente>();
			IntrareDetaliiLicente licenta = new IntrareDetaliiLicente();
			
			licenta.setId(1);
			licenta.setIdComisie(1);
			licenta.setNota1Oral(5);
			licenta.setNota1Proiect(5);
			licenta.setNota2Oral(5);
			licenta.setNota2Proiect(5);
			licenta.setNota3Oral(5);
			licenta.setNota3Proiect(5);
			licenta.setNota4Oral(0);
			licenta.setNota4Proiect(0);
			licenta.setNota5Oral(0);
			licenta.setNota5Proiect(0);
			licenta.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-07-01 10:00:00.000000"));
			expect.add(licenta);
			
			licenta.setId(2);
			licenta.setIdComisie(2);
			licenta.setNota1Oral(5);
			licenta.setNota1Proiect(5);
			licenta.setNota2Oral(5);
			licenta.setNota2Proiect(5);
			licenta.setNota3Oral(5);
			licenta.setNota3Proiect(5);
			licenta.setNota4Oral(0);
			licenta.setNota4Proiect(0);
			licenta.setNota5Oral(5);
			licenta.setNota5Proiect(5);
			licenta.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-07-01 12:00:00.000000"));
			expect.add(licenta);
			
			licenta.setId(3);
			licenta.setIdComisie(2);
			licenta.setNota1Oral(5);
			licenta.setNota1Proiect(5);
			licenta.setNota2Oral(5);
			licenta.setNota2Proiect(5);
			licenta.setNota3Oral(5);
			licenta.setNota3Proiect(5);
			licenta.setNota4Oral(0);
			licenta.setNota4Proiect(0);
			licenta.setNota5Oral(5);
			licenta.setNota5Proiect(5);
			licenta.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-07-02 12:30:00.000000"));
			expect.add(licenta);
			
			licenta.setId(4);
			licenta.setIdComisie(3);
			licenta.setNota1Oral(5);
			licenta.setNota1Proiect(5);
			licenta.setNota2Oral(5);
			licenta.setNota2Proiect(5);
			licenta.setNota3Oral(5);
			licenta.setNota3Proiect(5);
			licenta.setNota4Oral(0);
			licenta.setNota4Proiect(0);
			licenta.setNota5Oral(5);
			licenta.setNota5Proiect(5);
			licenta.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-07-04 13:00:00.000000"));
			expect.add(licenta);
			
			licenta.setId(5);
			licenta.setIdComisie(4);
			licenta.setNota1Oral(5);
			licenta.setNota1Proiect(5);
			licenta.setNota2Oral(5);
			licenta.setNota2Proiect(5);
			licenta.setNota3Oral(5);
			licenta.setNota3Proiect(5);
			licenta.setNota4Oral(0);
			licenta.setNota4Proiect(0);
			licenta.setNota5Oral(5);
			licenta.setNota5Proiect(5);
			licenta.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-07-05 12:00:00.000000"));
			expect.add(licenta);
			
			licenta.setId(6);
			licenta.setIdComisie(1);
			licenta.setNota1Oral(5);
			licenta.setNota1Proiect(5);
			licenta.setNota2Oral(5);
			licenta.setNota2Proiect(5);
			licenta.setNota3Oral(5);
			licenta.setNota3Proiect(5);
			licenta.setNota4Oral(0);
			licenta.setNota4Proiect(0);
			licenta.setNota5Oral(5);
			licenta.setNota5Proiect(5);
			licenta.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-07-02 14:00:00.000000"));
			expect.add(licenta);
			
			licenta.setId(7);
			licenta.setIdComisie(2);
			licenta.setNota1Oral(5);
			licenta.setNota1Proiect(5);
			licenta.setNota2Oral(5);
			licenta.setNota2Proiect(5);
			licenta.setNota3Oral(5);
			licenta.setNota3Proiect(5);
			licenta.setNota4Oral(0);
			licenta.setNota4Proiect(0);
			licenta.setNota5Oral(5);
			licenta.setNota5Proiect(5);
			licenta.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-07-06 12:00:00.000000"));
			expect.add(licenta);
			
			licenta.setId(8);
			licenta.setIdComisie(3);
			licenta.setNota1Oral(5);
			licenta.setNota1Proiect(5);
			licenta.setNota2Oral(5);
			licenta.setNota2Proiect(5);
			licenta.setNota3Oral(5);
			licenta.setNota3Proiect(5);
			licenta.setNota4Oral(0);
			licenta.setNota4Proiect(0);
			licenta.setNota5Oral(5);
			licenta.setNota5Proiect(5);
			licenta.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-07-03 12:00:00.000000"));
			expect.add(licenta);
			
			licenta.setId(9);
			licenta.setIdComisie(1);
			licenta.setNota1Oral(5);
			licenta.setNota1Proiect(5);
			licenta.setNota2Oral(5);
			licenta.setNota2Proiect(5);
			licenta.setNota3Oral(5);
			licenta.setNota3Proiect(5);
			licenta.setNota4Oral(0);
			licenta.setNota4Proiect(0);
			licenta.setNota5Oral(5);
			licenta.setNota5Proiect(5);
			licenta.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-07-08 14:00:00.000000"));
			expect.add(licenta);
			
			result.equals(expect);
		}
	}

	@Test
	public void testUpdateCont() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareConturi cont = new IntrareConturi();
			cont.setId(10);
			cont.setUsername("jimmy.grigory");
			cont.setHashparola("parola");
			cont.setEmail("jimmy.grygory@info.uaic.ro");
			cont.setTipUtilizator("Student");
			cont.setStatus(1);
			cont.setCodActivare("blabla");
			cont.setToken("9token");
			int result = accessAdmin.updateCont(cont);
			int expect  = 0;
			
			assertEquals(expect, result);
			
			cont.setId(-10);
			cont.setUsername("jimmy.grigory");
			cont.setHashparola("parola");
			cont.setEmail("jimmy.grygory@info.uaic.ro");
			cont.setTipUtilizator("Student");
			cont.setStatus(1);
			cont.setCodActivare("blabla");
			cont.setToken("9token");
			result = accessAdmin.updateCont(cont);
			expect = -1;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testUpdateStudent() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareStudenti student = new IntrareStudenti();
			
			student.setId(4);
			student.setIdCont(5);
			student.setNrMatricol("sv3456777");
			student.setNume("Stanescu");
			student.setPrenume("Mihai");
			student.setId_comisie(1);
			student.setIdSesiune(3);
			int result = accessAdmin.updateStudent(student);
			int expect = 0;
			
			assertEquals(expect, result);
			
			student.setId(200);
			student.setIdCont(5);
			student.setNrMatricol("sv3456777");
			student.setNume("Stanescu");
			student.setPrenume("Mihai");
			student.setId_comisie(1);
			student.setIdSesiune(3);
			result = accessAdmin.updateStudent(student);
		    expect = -1;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testUpdateProfesor() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareProfesori prof = new IntrareProfesori();
			
			prof.setId(2);
			prof.setIdCont(12);
			prof.setNume("Arusoaie");
			prof.setPrenume("Andreea");
			prof.setGradDidactic("Lect. DR.");
			prof.setIdComisie(1);
			prof.setFunctieComisie("Secretar");
			int result = accessAdmin.updateProfesor(prof);
			int expect = 0;
			
			assertEquals(expect, result);
			
			prof.setId(200);
			prof.setIdCont(12);
			prof.setNume("Arusoaie");
			prof.setPrenume("Andreea");
			prof.setGradDidactic("Lect. DR.");
			prof.setIdComisie(1);
			prof.setFunctieComisie("Secretar");
			result = accessAdmin.updateProfesor(prof);
			expect = -1;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testUpdateComisie() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareComisii comisie = new IntrareComisii();
			
			comisie.setId(1);
			comisie.setIdProfSef(1);
			comisie.setIdProf2(2);
			comisie.setIdProf3(3);
			comisie.setIdProf4(0);
			comisie.setIdSecretar(2);
			comisie.setTipComisie("licenta");
			comisie.setSala("309");
			int result = accessAdmin.updateComisie(comisie);
			int expect = 0;
			
			assertEquals(expect, result);
			
			comisie.setId(1000);
			comisie.setIdProfSef(1);
			comisie.setIdProf2(2);
			comisie.setIdProf3(3);
			comisie.setIdProf4(0);
			comisie.setIdSecretar(2);
			comisie.setTipComisie("licenta");
			comisie.setSala("309");
			result = accessAdmin.updateComisie(comisie);
			expect = -1;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testUpdateDetaliiLicenta() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareDetaliiLicente licenta = new IntrareDetaliiLicente();
			
			licenta.setId(8);
			licenta.setIdComisie(1);
			licenta.setNota1Oral(5);
			licenta.setNota1Proiect(5);
			licenta.setNota2Oral(5);
			licenta.setNota2Proiect(5);
			licenta.setNota3Oral(5);
			licenta.setNota3Proiect(5);
			licenta.setNota4Oral(0);
			licenta.setNota4Proiect(0);
			licenta.setNota5Oral(0);
			licenta.setNota5Proiect(0);
			licenta.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-07-01 16:00:00.000000"));
			
			int result = accessAdmin.updateDetaliiLicenta(licenta);
			int expect = 0;
			
			assertEquals(expect, result);
			

			licenta.setId(-10);
			licenta.setIdComisie(1);
			licenta.setNota1Oral(5);
			licenta.setNota1Proiect(5);
			licenta.setNota2Oral(5);
			licenta.setNota2Proiect(5);
			licenta.setNota3Oral(5);
			licenta.setNota3Proiect(5);
			licenta.setNota4Oral(0);
			licenta.setNota4Proiect(0);
			licenta.setNota5Oral(0);
			licenta.setNota5Proiect(0);
			licenta.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-07-01 16:00:00.000000"));
			
			result = accessAdmin.updateDetaliiLicenta(licenta);
			expect = -1;
			
			assertEquals(expect, result);		
		}
	}

	@Test
	public void testUpdateLicenta() {
			
			BD bd = new BD();
			AccessBD access = bd.login("Admin", "Root");
			
			if( access.getTip().equals("Access_Admin") )
			{
				AccessAdminBD accessAdmin = (AccessAdminBD) access;
				IntrareLicente licenta = new IntrareLicente();
				
				licenta.setId(3);
				licenta.setTitlu("licenta3");
				licenta.setIdProfesor(3);
				licenta.setIdStudent(3);
				licenta.setMaterialeLicenta("www.github.com");
				licenta.setIdSesiune(1);
				licenta.setTipLucrare("LICENTA");
				int result = accessAdmin.updateLicenta(licenta);
				int expect = 0;
				
				assertEquals(expect, result);
				
				licenta.setId(-3);
				licenta.setTitlu("licenta3");
				licenta.setIdProfesor(3);
				licenta.setIdStudent(3);
				licenta.setMaterialeLicenta("www.github.com");
				licenta.setIdSesiune(1);
				licenta.setTipLucrare("LICENTA");
				result = accessAdmin.updateLicenta(licenta);
				expect = -1;
				
				assertEquals(expect, result);
			}
	}

	@Test
	public void testUpdateSesiune() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareSesiuni sesiune = new IntrareSesiuni();
			
			sesiune.setId(1);
			sesiune.setInceputSesiune(java.sql.Timestamp.valueOf("2018-07-01 08:00:00.000000"));
			sesiune.setSfarsitSesiune(java.sql.Timestamp.valueOf("2018-08-01 00:00:00.000000"));
			sesiune.setActive(10);
			int result = accessAdmin.updateSesiune(sesiune);
			int expect = 0;
			
			assertEquals(expect, result);
			
			sesiune.setId(-1);
			sesiune.setInceputSesiune(java.sql.Timestamp.valueOf("2018-07-01 08:00:00.000000"));
			sesiune.setSfarsitSesiune(java.sql.Timestamp.valueOf("2018-08-01 00:00:00.000000"));
			sesiune.setActive(10);
			result = accessAdmin.updateSesiune(sesiune);
			expect = -1;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testInsertCont() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareConturi cont = new IntrareConturi();
			cont.setId(10);
			cont.setUsername("jimmy.grigory");
			cont.setHashparola("parola");
			cont.setEmail("jimmy.grygory@info.uaic.ro");
			cont.setTipUtilizator("Student");
			cont.setStatus(1);
			cont.setCodActivare("blabla");
			cont.setToken("9token");
			int result = accessAdmin.insertCont(cont);
			int expect  = -1;
			
			assertEquals(expect, result);
			
			cont = new IntrareConturi();
			//cont.setId(10);
			cont.setUsername("andreea.aungurenci");
			cont.setHashparola("parola");
			cont.setEmail("andreea.aungurenci@info.uaic.ro");
			cont.setTipUtilizator("Student");
			cont.setStatus(1);
			cont.setCodActivare("blabla");
			cont.setToken("10token");
			result = accessAdmin.insertCont(cont);
			expect  = 0;
			
			assertEquals(expect, result);
			
		}
	}

	@Test
	public void testInsertStudent() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareStudenti student = new IntrareStudenti();
			
			student.setId(4);
			student.setIdCont(5);
			student.setNrMatricol("sv3456777");
			student.setNume("Stanescu");
			student.setPrenume("Mihai");
			student.setId_comisie(1);
			student.setIdSesiune(3);
			int result = accessAdmin.insertStudent(student);
			int expect = -1;
			
			assertEquals(expect, result);
			
			student = new IntrareStudenti();
			student.setIdCont(5);
			student.setNrMatricol("sv3456999");
			student.setNume("Aungurenci");
			student.setPrenume("Andreea");
			student.setId_comisie(1);
			student.setIdSesiune(3);
			result = accessAdmin.insertStudent(student);
			expect = 0;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testInsertProfesor() {
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareProfesori prof = new IntrareProfesori();
			
			prof.setId(45);
			prof.setNume("Popescu");
			prof.setPrenume("Ionut");
			prof.setGradDidactic("Lect. Dr.");
			prof.setIdComisie(0);
			int result = accessAdmin.insertProfesor(prof);
			int expect = 0;
			
			assertEquals(expect, result);
			
			prof = new IntrareProfesori();
			prof.setId(40);
			prof.setNume("Popescu");
			prof.setPrenume("Andreea");
			prof.setGradDidactic("Lect. DR.");
			prof.setIdComisie(0);
			result = accessAdmin.insertProfesor(prof);
			expect = -1;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testInsertComisie() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareComisii comisie = new IntrareComisii();
			
			comisie.setId(1);
			comisie.setIdProfSef(1);
			comisie.setIdProf2(2);
			comisie.setIdProf3(3);
			comisie.setIdProf4(0);
			comisie.setIdSecretar(2);
			comisie.setTipComisie("licenta");
			comisie.setSala("309");
			int result = accessAdmin.insertComisie(comisie);
			int expect = -1;
			
			assertEquals(expect, result);
			
			comisie = new IntrareComisii();
			comisie.setIdProfSef(1);
			comisie.setIdProf2(2);
			comisie.setIdProf3(3);
			comisie.setIdProf4(0);
			comisie.setIdSecretar(2);
			comisie.setTipComisie("licenta");
			comisie.setSala("309");
			result = accessAdmin.insertComisie(comisie);
			expect = 0;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testInsertDetaliiLicenta() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareDetaliiLicente licenta = new IntrareDetaliiLicente();
			
			licenta.setId(8);
			licenta.setIdComisie(1);
			licenta.setNota1Oral(5);
			licenta.setNota1Proiect(5);
			licenta.setNota2Oral(5);
			licenta.setNota2Proiect(5);
			licenta.setNota3Oral(5);
			licenta.setNota3Proiect(5);
			licenta.setNota4Oral(0);
			licenta.setNota4Proiect(0);
			licenta.setNota5Oral(0);
			licenta.setNota5Proiect(0);
			licenta.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-07-01 16:00:00.000000"));
			
			int result = accessAdmin.insertDetaliiLicenta(licenta);
			int expect = -1;
			
			assertEquals(expect, result);
			
			licenta = new IntrareDetaliiLicente();
			licenta.setIdComisie(2);
			licenta.setNota1Oral(5);
			licenta.setNota1Proiect(5);
			licenta.setNota2Oral(5);
			licenta.setNota2Proiect(5);
			licenta.setNota3Oral(5);
			licenta.setNota3Proiect(5);
			licenta.setNota4Oral(0);
			licenta.setNota4Proiect(0);
			licenta.setNota5Oral(0);
			licenta.setNota5Proiect(0);
			licenta.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-07-01 16:00:00.000000"));
			
			result = accessAdmin.insertDetaliiLicenta(licenta);
			expect = 0;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testInsertLicenta() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareLicente licenta = new IntrareLicente();
			
			licenta.setId(20);
			licenta.setTitlu("licenta3");
			licenta.setIdProfesor(3);
			licenta.setIdStudent(3);
			licenta.setMaterialeLicenta("www.github.com");
			licenta.setIdSesiune(1);
			licenta.setTipLucrare("LICENTA");
			int result = accessAdmin.insertLicenta(licenta);
			int expect = 0;
			
			assertEquals(expect, result);
			
			licenta.setId(20);
			licenta.setTitlu("licenta3");
			licenta.setIdProfesor(3);
			licenta.setIdStudent(3);
			licenta.setMaterialeLicenta("www.github.com");
			licenta.setIdSesiune(1);
			licenta.setTipLucrare("LICENTA");
			result = accessAdmin.insertLicenta(licenta);
			expect = -1;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testInsertSesiune() {
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareSesiuni sesiune = new IntrareSesiuni();
			
			sesiune.setId(2);
			sesiune.setInceputSesiune(java.sql.Timestamp.valueOf("2018-07-01 08:00:00.000000"));
			sesiune.setSfarsitSesiune(java.sql.Timestamp.valueOf("2018-08-01 00:00:00.000000"));
			sesiune.setActive(10);
			int result = accessAdmin.insertSesiune(sesiune);
			int expect = 0;
			
			assertEquals(expect, result);
			
			sesiune.setId(1);
			sesiune.setInceputSesiune(java.sql.Timestamp.valueOf("2018-07-01 08:00:00.000000"));
			sesiune.setSfarsitSesiune(java.sql.Timestamp.valueOf("2018-08-01 00:00:00.000000"));
			sesiune.setActive(10);
			result = accessAdmin.insertSesiune(sesiune);
			expect = -1;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testDropCont() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareConturi cont = new IntrareConturi();
			cont.setId(10);
			cont.setUsername("jimmy.grigory");
			cont.setHashparola("parola");
			cont.setEmail("jimmy.grygory@info.uaic.ro");
			cont.setTipUtilizator("Student");
			cont.setStatus(1);
			cont.setCodActivare("blabla");
			cont.setToken("9token");
			int result = accessAdmin.dropCont(cont);
			int expect  = 0;
			
			assertEquals(expect, result);
			
			cont = new IntrareConturi();
			cont.setId(100);
			cont.setUsername("jimmy.grigory");
			cont.setHashparola("parola");
			cont.setEmail("jimmy.grygory@info.uaic.ro");
			cont.setTipUtilizator("Student");
			cont.setStatus(1);
			cont.setCodActivare("blabla");
			cont.setToken("9token");
			result = accessAdmin.dropCont(cont);
			expect  = -1;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testDropStudent() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareStudenti student = new IntrareStudenti();
			
			student.setId(10);
			student.setIdCont(5);
			student.setNrMatricol("sv3456777");
			student.setNume("Stanescu");
			student.setPrenume("Mihai");
			student.setId_comisie(1);
			student.setIdSesiune(3);
			int result = accessAdmin.dropStudent(student);
			int expect = 0;
			
			assertEquals(expect, result);
			
            student = new IntrareStudenti();
			
			student.setId(-10);
			student.setIdCont(5);
			student.setNrMatricol("sv3456777");
			student.setNume("Stanescu");
			student.setPrenume("Mihai");
			student.setId_comisie(1);
			student.setIdSesiune(3);
			result = accessAdmin.dropStudent(student);
			expect = -1;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testDropProfesor() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareProfesori prof = new IntrareProfesori();
			
			prof.setId(45);
			prof.setNume("Popescu");
			prof.setPrenume("Ionut");
			prof.setGradDidactic("Lect. Dr.");
			prof.setIdComisie(0);
			int result = accessAdmin.dropProfesor(prof);
			int expect = 0;
			
			assertEquals(expect, result);
			
			prof.setId(45);
			prof.setNume("Popescu");
			prof.setPrenume("Ionut");
			prof.setGradDidactic("Lect. Dr.");
			prof.setIdComisie(0);
			result = accessAdmin.dropProfesor(prof);
			expect = -1;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testDropComisie() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareComisii comisie = new IntrareComisii();
			
			comisie.setId(100);
			comisie.setIdProfSef(1);
			comisie.setIdProf2(2);
			comisie.setIdProf3(3);
			comisie.setIdProf4(0);
			comisie.setIdSecretar(2);
			comisie.setTipComisie("licenta");
			comisie.setSala("309");
			int result = accessAdmin.dropComisie(comisie);
			int expect = -1;
			
			assertEquals(expect, result); 
			
			comisie.setId(5);
			comisie.setIdProfSef(1);
			comisie.setIdProf2(2);
			comisie.setIdProf3(3);
			comisie.setIdProf4(0);
			comisie.setIdSecretar(2);
			comisie.setTipComisie("licenta");
			comisie.setSala("309");
			result = accessAdmin.dropComisie(comisie);
			expect = 0;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testDropDetaliiLicenta() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareDetaliiLicente licenta = new IntrareDetaliiLicente();
			
			licenta.setId(800);
			licenta.setIdComisie(1);
			licenta.setNota1Oral(5);
			licenta.setNota1Proiect(5);
			licenta.setNota2Oral(5);
			licenta.setNota2Proiect(5);
			licenta.setNota3Oral(5);
			licenta.setNota3Proiect(5);
			licenta.setNota4Oral(0);
			licenta.setNota4Proiect(0);
			licenta.setNota5Oral(0);
			licenta.setNota5Proiect(0);
			licenta.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-07-01 16:00:00.000000"));
			
			int result = accessAdmin.dropDetaliiLicenta(licenta);
			int expect = -1;
			
			assertEquals(expect, result);
			

			licenta.setId(10);
			licenta.setIdComisie(1);
			licenta.setNota1Oral(5);
			licenta.setNota1Proiect(5);
			licenta.setNota2Oral(5);
			licenta.setNota2Proiect(5);
			licenta.setNota3Oral(5);
			licenta.setNota3Proiect(5);
			licenta.setNota4Oral(0);
			licenta.setNota4Proiect(0);
			licenta.setNota5Oral(0);
			licenta.setNota5Proiect(0);
			licenta.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-07-01 16:00:00.000000"));
			
			result = accessAdmin.dropDetaliiLicenta(licenta);
			expect = 0;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testDropLicenta() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareLicente licenta = new IntrareLicente();
			
			licenta.setId(9);
			licenta.setTitlu("licenta3");
			licenta.setIdProfesor(3);
			licenta.setIdStudent(3);
			licenta.setMaterialeLicenta("www.github.com");
			licenta.setIdSesiune(1);
			licenta.setTipLucrare("LICENTA");
			int result = accessAdmin.dropLicenta(licenta);
			int expect = 0;
			
			assertEquals(expect, result);
			
			licenta.setId(0);
			result = accessAdmin.dropLicenta(licenta);
			expect = -1;
			
			assertEquals(expect, result);
			
			licenta.setId(200);
			result = accessAdmin.dropLicenta(licenta);
			expect = -1;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testDropSesiune() {
		
		BD bd = new BD();
		AccessBD access = bd.login("Admin", "Root");
		
		if( access.getTip().equals("Access_Admin") )
		{
			AccessAdminBD accessAdmin = (AccessAdminBD) access;
			IntrareSesiuni sesiune = new IntrareSesiuni();
			
			sesiune.setId(2);
			sesiune.setInceputSesiune(java.sql.Timestamp.valueOf("2018-07-01 08:00:00.000000"));
			sesiune.setSfarsitSesiune(java.sql.Timestamp.valueOf("2018-08-01 00:00:00.000000"));
			sesiune.setActive(10);
			int result = accessAdmin.dropSesiune(sesiune);
			int expect = 0;
			
			assertEquals(expect, result);
			
			sesiune.setId(-2);
			sesiune.setInceputSesiune(java.sql.Timestamp.valueOf("2018-07-01 08:00:00.000000"));
			sesiune.setSfarsitSesiune(java.sql.Timestamp.valueOf("2018-08-01 00:00:00.000000"));
			sesiune.setActive(10);
			result = accessAdmin.dropSesiune(sesiune);
			expect = -1;
			
			assertEquals(expect, result);
		}
	}

}
