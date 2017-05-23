package teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bd.*;

public class AccessStudentBDTest {

	@Test
	public void testSelectDetaliiLicente() {
		
		BD bd = new BD();
		bd.login("jimmy.jimmy", "jimmy");
		AccessBD access = bd.getAccess();
		AccessStudentBD  test = ((AccessStudentBD) access);
		
        List<IntrareDetaliiLicente> result = test.selectDetaliiLicente();
		
		List<IntrareDetaliiLicente> expect = new ArrayList<IntrareDetaliiLicente>();
		IntrareDetaliiLicente dlic = new IntrareDetaliiLicente();
		
		dlic.setId(1);
		dlic.setIdComisie(1);
		dlic.setNota1Oral(5);
		dlic.setNota1Proiect(5);
		dlic.setNota2Oral(5);
		dlic.setNota2Proiect(5);
		dlic.setNota3Oral(5);
		dlic.setNota3Proiect(5);
		dlic.setNota4Oral(5);
		dlic.setNota4Proiect(5);
		dlic.setNota5Oral(5);
		dlic.setNota5Proiect(5);
		dlic.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-09-10 12:00:00"));
		expect.add(dlic);
		
		dlic = new IntrareDetaliiLicente();
		dlic.setId(2);
		dlic.setIdComisie(1);
		dlic.setNota1Oral(5);
		dlic.setNota1Proiect(5);
		dlic.setNota2Oral(5);
		dlic.setNota2Proiect(5);
		dlic.setNota3Oral(5);
		dlic.setNota3Proiect(5);
		dlic.setNota4Oral(5);
		dlic.setNota4Proiect(5);
		dlic.setNota5Oral(5);
		dlic.setNota5Proiect(5);
		dlic.setDataOraSustinerii(java.sql.Timestamp.valueOf("2018-01-01 12:30:00"));
		expect.add(dlic);
		
		dlic = new IntrareDetaliiLicente();
		dlic.setId(3);
		dlic.setIdComisie(1);
		dlic.setNota1Oral(5);
		dlic.setNota1Proiect(5);
		dlic.setNota2Oral(5);
		dlic.setNota2Proiect(5);
		dlic.setNota3Oral(5);
		dlic.setNota3Proiect(5);
		dlic.setNota4Oral(5);
		dlic.setNota4Proiect(5);
		dlic.setNota5Oral(5);
		dlic.setNota5Proiect(5);
		dlic.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-09-10 12:00:00"));
		expect.add(dlic);
		
		dlic = new IntrareDetaliiLicente();
		dlic.setId(4);
		dlic.setIdComisie(1);
		dlic.setNota1Oral(5);
		dlic.setNota1Proiect(5);
		dlic.setNota2Oral(5);
		dlic.setNota2Proiect(5);
		dlic.setNota3Oral(5);
		dlic.setNota3Proiect(5);
		dlic.setNota4Oral(5);
		dlic.setNota4Proiect(5);
		dlic.setNota5Oral(5);
		dlic.setNota5Proiect(5);
		dlic.setDataOraSustinerii(java.sql.Timestamp.valueOf("2018-01-01 12:30:00"));
		expect.add(dlic);
		
		result.equals(expect);
	}

	@Test
	public void testSelectLicente() {
		
		BD bd = new BD();
		bd.login("jimmy.jimmy", "jimmy");
		AccessBD access = bd.getAccess();
		AccessStudentBD  test = ((AccessStudentBD) access);
		
        List<IntrareLicente> result = test.selectLicente();
		
		List<IntrareLicente> expect = new ArrayList<IntrareLicente>();
		IntrareLicente lic = new IntrareLicente();
		
		lic.setId(1);
		lic.setTitlu("Licenta lui Jimmy");
		lic.setIdProfesor(1);
		lic.setIdStudent(1);
		lic.setMaterialeLicenta("https://www.google.ro/search?q=jimmy");
		lic.setIdSesiune(1);
		lic.setTipLucrare("Licenta");
		expect.add(lic);
		
		lic = new IntrareLicente();
		lic.setId(2);
		lic.setTitlu("Licenta lui Grigory");
		lic.setIdProfesor(1);
		lic.setIdStudent(2);
		lic.setMaterialeLicenta("https://www.google.ro/search?q=grigory");
		lic.setIdSesiune(1);
		lic.setTipLucrare("Dizertatie");
		expect.add(lic);
		
		lic = new IntrareLicente();
		lic.setId(3);
		lic.setTitlu("Licenta lui Jimmy");
		lic.setIdProfesor(1);
		lic.setIdStudent(1);
		lic.setMaterialeLicenta("https://www.google.ro/search?q=jimmy");
		lic.setIdSesiune(1);
		lic.setTipLucrare("Licenta");
		expect.add(lic);
		
		lic = new IntrareLicente();
		lic.setId(2);
		lic.setTitlu("Licenta lui Grigory");
		lic.setIdProfesor(1);
		lic.setIdStudent(2);
		lic.setMaterialeLicenta("https://www.google.ro/search?q=grigory");
		lic.setIdSesiune(1);
		lic.setTipLucrare("Dizertatie");
		expect.add(lic);
		
		result.equals(expect);
	}

	@Test
	public void testSelectSesiuni() {
		
		BD bd = new BD();
		bd.login("jimmy.jimmy", "jimmy");
		AccessBD access = bd.getAccess();
		AccessStudentBD  test = ((AccessStudentBD) access);
		
        List<IntrareSesiuni> result = test.selectSesiuni();
		
		List<IntrareSesiuni> expect = new ArrayList<IntrareSesiuni>();
		IntrareSesiuni sesiune = new IntrareSesiuni();
		
		sesiune.setId(1);
		sesiune.setInceputSesiune(java.sql.Timestamp.valueOf("2018-01-01 00:00:00"));
		sesiune.setSfarsitSesiune(java.sql.Timestamp.valueOf("2018-02-01 00:00:00"));
		expect.add(sesiune);
		
		sesiune = new IntrareSesiuni();
		sesiune.setId(2);
		sesiune.setInceputSesiune(java.sql.Timestamp.valueOf("2018-01-01 00:00:00"));
		sesiune.setSfarsitSesiune(java.sql.Timestamp.valueOf("2018-02-01 00:00:00"));
		expect.add(sesiune);
		
		result.equals(expect);
	}

	@Test
	public void testSelectMesaje() {
		
		BD bd = new BD();
		bd.login("jimmy.jimmy", "jimmy");
		AccessBD access = bd.getAccess();
		AccessStudentBD  test = ((AccessStudentBD) access);
		
		List<IntrareMesaje> result = test.selectMesaje();
		  
		  List<IntrareMesaje> expect = new ArrayList<IntrareMesaje>();
		  IntrareMesaje mess = new IntrareMesaje();
		  mess.setId(1);
		  mess.setIdDestinatar(3);
		  mess.setIdEmitator(2);
		  mess.setMesaj("hey Grigory, sunt eu Jimmy");
		  expect.add(mess);
		
		  mess = new IntrareMesaje();
	 	  mess.setId(2);
		  mess.setIdDestinatar(2);
		  mess.setIdEmitator(3);
		  mess.setMesaj("Go home Jimmy");
		  expect.add(mess);
		
	      mess = new IntrareMesaje();
		  mess.setId(3);
		  mess.setIdDestinatar(3);
		  mess.setIdEmitator(2);
		  mess.setMesaj("hey Grigory, sunt eu Jimmy");
		  expect.add(mess);
		
		  mess = new IntrareMesaje();
		  mess.setId(4);
		  mess.setIdDestinatar(2);
		  mess.setIdEmitator(3);
		  mess.setMesaj("Go home Jimmy");
		  expect.add(mess);
		
		  result.equals(expect);
	}

	@Test
	public void testSelectStudenti() {
		
		BD bd = new BD();
		bd.login("jimmy.jimmy", "jimmy");
		AccessBD access = bd.getAccess();
		AccessStudentBD  test = ((AccessStudentBD) access);
		
		List<IntrareStudenti> result = test.selectStudenti();
		
		List<IntrareStudenti> expect = new ArrayList<IntrareStudenti>();
		IntrareStudenti stud = new IntrareStudenti();
		
		stud.setId(1);
		stud.setIdCont(2);
		stud.setNrMatricol("nr_matricol_jimmy");
		stud.setNume("jimmy");
		stud.setPrenume("jimmy");
		stud.setId_comisie(1);
		stud.setIdSesiune(1);
		expect.add(stud);
		
		stud = new IntrareStudenti();
		stud.setId(2);
		stud.setIdCont(3);
		stud.setNrMatricol("nr_matricol_grigory");
		stud.setNume("grigory");
		stud.setPrenume("grigory");
		stud.setId_comisie(1);
		stud.setIdSesiune(1);
		expect.add(stud);
		
		stud = new IntrareStudenti();
		stud.setId(5);
		stud.setIdCont(6);
		stud.setNrMatricol("1234SL46486");
		stud.setNume("robert");
		stud.setPrenume("otrocol");
		stud.setId_comisie(1);
		stud.setIdSesiune(2);
		expect.add(stud);
		
	    result.equals(expect);
	}

	@Test
	public void testSelectProfesori() {
		
		BD bd = new BD();
		bd.login("jimmy.jimmy", "jimmy");
		AccessBD access = bd.getAccess();
		AccessStudentBD  test = ((AccessStudentBD) access);
		
		List<IntrareProfesori> result = test.selectProfesori();
		
		List<IntrareProfesori> expect = new ArrayList<IntrareProfesori>();
		IntrareProfesori prof = new IntrareProfesori();
		
		prof.setId(1);
		prof.setNume("ALBOAIE");
		prof.setPrenume("LENUTA");
		prof.setGradDidactic("Conf. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(2);
		prof.setNume("ARUSOAIE");
		prof.setPrenume("ANDREEA");
		prof.setGradDidactic("Asist. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(3);
		prof.setNume("ARUSOAIE");
		prof.setPrenume("ANDREI");
		prof.setGradDidactic("Lect. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(4);
		prof.setNume("ASIMIOANEI");
		prof.setPrenume("ION");
		prof.setGradDidactic("Lect.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(5);
		prof.setNume("BENCHEA");
		prof.setPrenume("RAZVAN");
		prof.setGradDidactic("Lect. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(6);
		prof.setNume("BIRJOVEANU");
		prof.setPrenume("CATALIN");
		prof.setGradDidactic("Lect. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(7);
		prof.setNume("BREABAN");
		prof.setPrenume("MIHAELA");
		prof.setGradDidactic("Conf. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(8);
		prof.setNume("BURAGA");
		prof.setPrenume("SABIN CORNELIU");
		prof.setGradDidactic("Conf. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(9);
		prof.setNume("CAPTARENCU");
		prof.setPrenume("OANA");
		prof.setGradDidactic("Lect. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(10);
		prof.setNume("CIOBACA");
		prof.setPrenume("STEFAN");
		prof.setGradDidactic("Conf. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(11);
		prof.setNume("CIORTUZ");
		prof.setPrenume("LIVIU");
		prof.setGradDidactic("Conf. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(12);
		prof.setNume("CRISTEA");
		prof.setPrenume("DAN");
		prof.setGradDidactic("Prof. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(13);
		prof.setNume("CROITORU");
		prof.setPrenume("CORNELIUS");
		prof.setGradDidactic("Prof. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(14);
		prof.setNume("FORASCU");
		prof.setPrenume("CORINA");
		prof.setGradDidactic("CORINA");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(15);
		prof.setNume("FRASINARU");
		prof.setPrenume("FRASINARU");
		prof.setGradDidactic("Lect. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(16);
		prof.setNume("GATU");
		prof.setPrenume("CRISTIAN");
		prof.setGradDidactic("Conf. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(17);
		prof.setNume("GAVRILUT");
		prof.setPrenume("DRAGOS");
		prof.setGradDidactic("Conf. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(18);
		prof.setNume("GHIRVU");
		prof.setPrenume("LUCIAN");
		prof.setGradDidactic("Lect. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(19);
		prof.setNume("GRIGORAS");
		prof.setPrenume("GHEORGHE");
		prof.setGradDidactic("");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(20);
		prof.setNume("IACOB");
		prof.setPrenume("FLORIN");
		prof.setGradDidactic("Lect. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(21);
		prof.setNume("IFTENE");
		prof.setPrenume("ADRIAN");
		prof.setGradDidactic("Conf. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(22);
		prof.setNume("IFTENE");
		prof.setPrenume("SORIN");
		prof.setGradDidactic("");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(23);
		prof.setNume("IGNAT");
		prof.setPrenume("ANCA");
		prof.setGradDidactic("Lect. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(24);
		prof.setNume("LUCANU");
		prof.setPrenume("DOREL");
		prof.setGradDidactic("Prof. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(25);
		prof.setNume("LUCHIAN");
		prof.setPrenume("HENRI");
		prof.setGradDidactic("Prof. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(26);
		prof.setNume("MASALAGIU");
		prof.setPrenume("CRISTIAN");
		prof.setGradDidactic("Prof. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(27);
		prof.setNume("MORUZ");
		prof.setPrenume("ALEX");
		prof.setGradDidactic("Lect. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(28);
		prof.setNume("OALRIU");
		prof.setPrenume("FLORENTIN");
		prof.setGradDidactic("Lect. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(29);
		prof.setNume("ONICA");
		prof.setPrenume("EMANUEL");
		prof.setGradDidactic("Lect. DR.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(30);
		prof.setNume("ONOFREI");
		prof.setPrenume("PAULA");
		prof.setGradDidactic("Lect. Dr.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(31);
		prof.setNume("OPREA");
		prof.setPrenume("DUMITRU");
		prof.setGradDidactic("Prof. Dr.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(32);
		prof.setNume("PATRUT");
		prof.setPrenume("BOGDAN");
		prof.setGradDidactic("Lect. Dr.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(33);
		prof.setNume("PISTOL");
		prof.setPrenume("IONUT");
		prof.setGradDidactic("Lect. Dr.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(34);
		prof.setNume("RADULESCU");
		prof.setPrenume("VLAD");
		prof.setGradDidactic("Lect. Dr.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(35);
		prof.setNume("TEODORESCU");
		prof.setPrenume("HORIA");
		prof.setGradDidactic("Prof. Dr.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(36);
		prof.setNume("TIPLEA");
		prof.setPrenume("FERUCIO");
		prof.setGradDidactic("Prof. Dr.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(37);
		prof.setNume("TRANDABAT");
		prof.setPrenume("DIANA");
		prof.setGradDidactic("Conf. Dr.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(38);
		prof.setNume("VARLAN");
		prof.setPrenume("COSMIN");
		prof.setGradDidactic("Lect. Dr.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(39);
		prof.setNume("VIDRASCU");
		prof.setPrenume("CRISTIAN");
		prof.setGradDidactic("Lect. Dr.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		prof.setId(40);
		prof.setNume("VITCU");
		prof.setPrenume("ANCA");
		prof.setGradDidactic("Conf. Dr.");
		prof.setIdComisie(0);
		expect.add(prof);
		
		result.equals(expect);
	}

	@Test
	public void testSelectEvaluari() {
		
		BD bd = new BD();
		bd.login("jimmy.jimmy", "jimmy");
		AccessBD access = bd.getAccess();
		AccessStudentBD  test = ((AccessStudentBD) access);
		
		List<IntrareEvaluari> result = test.selectEvaluari();
		
		List<IntrareEvaluari> expect = new ArrayList<IntrareEvaluari>();
		IntrareEvaluari eval = new IntrareEvaluari();
		
		eval.setId(1);
		eval.setIdSesiune(1);
		eval.setIdComisie(1);
		eval.setInceputEvaluare(java.sql.Timestamp.valueOf("2018-01-01 00:00:00"));
		eval.setSfarsitEvaluare(java.sql.Timestamp.valueOf("2018-01-03 00:00:00"));
		eval.setSala("C302");
		expect.add(eval);
		
		eval = new IntrareEvaluari();
		eval.setId(2);
		eval.setIdSesiune(1);
		eval.setIdComisie(2);
		eval.setInceputEvaluare(java.sql.Timestamp.valueOf("2018-01-01 00:00:00"));
		eval.setSfarsitEvaluare(java.sql.Timestamp.valueOf("2018-01-03 00:00:00"));
		eval.setSala("C301");
		expect.add(eval);
		
		eval = new IntrareEvaluari();
		eval.setId(3);
		eval.setIdSesiune(1);
		eval.setIdComisie(1);
		eval.setInceputEvaluare(java.sql.Timestamp.valueOf("2018-01-01 00:00:00"));
		eval.setSfarsitEvaluare(java.sql.Timestamp.valueOf("2018-01-03 00:00:00"));
		eval.setSala("C302");
		expect.add(eval);
		
		eval = new IntrareEvaluari();
		eval.setId(4);
		eval.setIdSesiune(1);
		eval.setIdComisie(2);
		eval.setInceputEvaluare(java.sql.Timestamp.valueOf("2018-01-01 00:00:00"));
		eval.setSfarsitEvaluare(java.sql.Timestamp.valueOf("2018-01-03 00:00:00"));
		eval.setSala("C301");
		expect.add(eval);
		
		result.equals(expect);
	}

	@Test
	public void testUpdateStudent() {
		
IntrareStudenti stud = new IntrareStudenti();
		
		BD bd = new BD();
		bd.login("jimmy.jimmy", "jimmy");
		AccessBD access = bd.getAccess();
		AccessStudentBD  test = ((AccessStudentBD) access);

		stud.setId(2);
		stud.setNrMatricol("6894SL45648");
		stud.setNume("grigory");
		stud.setPrenume("grigory");
		stud.setId_comisie(1);
		stud.setIdSesiune(1);
		int result = test.updateStudent(stud);
		int expect = 0;
		
		assertEquals(expect, result);
		
        stud = new IntrareStudenti();
		
		stud.setId(2000);
		stud.setNrMatricol("6894SL45648");
		stud.setNume("grigory");
		stud.setPrenume("grigory");
		stud.setId_comisie(1);
		stud.setIdSesiune(1);
		result = test.updateStudent(stud);
		expect = -1;
		
		assertEquals(expect, result);
	}

	@Test
	public void testUpdateLicenta() {
		
		BD bd = new BD();
		bd.login("jimmy.jimmy", "jimmy");
		AccessBD access = bd.getAccess();
		AccessStudentBD  test = ((AccessStudentBD) access);
		
		IntrareLicente licenta = new IntrareLicente();
		licenta.setId(2);
		licenta.setTitlu("Licenta in inforamtica");
		licenta.setIdProfesor(1);
		licenta.setIdStudent(1);
		licenta.setMaterialeLicenta("https://www.google.ro/search?q=jimmy");
		licenta.setIdSesiune(1);
		licenta.setTipLucrare("Licenta");
		int result = test.updateLicenta(licenta);
		int expect = 0;
		
		assertEquals(expect, result);
		
		licenta = new IntrareLicente();
		licenta.setId(10000);
		licenta.setTitlu("Licenta in inforamtica");
		licenta.setIdProfesor(1);
		licenta.setIdStudent(1);
		licenta.setMaterialeLicenta("https://www.google.ro/search?q=jimmy");
		licenta.setIdSesiune(1);
		licenta.setTipLucrare("Licenta");
		result = test.updateLicenta(licenta);
		expect = -1;
		
		assertEquals(expect, result);
	}

	@Test
	public void testInsertDetaliiLicenta() {
		
		BD bd = new BD();
		bd.login("jimmy.jimmy", "jimmy");
		AccessBD access = bd.getAccess();
		AccessStudentBD  test = ((AccessStudentBD) access);
		
		IntrareDetaliiLicente dlic = new IntrareDetaliiLicente();
		dlic.setId(7);
		dlic.setIdComisie(1);
		dlic.setNota1Oral(7);
		dlic.setNota1Proiect(9);
		dlic.setNota2Oral(7);
		dlic.setNota2Proiect(8);
		dlic.setNota3Oral(9);
		dlic.setNota3Proiect(8);
		dlic.setNota4Oral(0);
		dlic.setNota4Proiect(0);
		dlic.setNota5Oral(7);
		dlic.setNota5Proiect(8);
		dlic.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-09-10 13:30:00"));
		int result = test.insertDetaliiLicenta(dlic);
		int expect = 0;
		
		assertEquals(expect, result);
		
		dlic = new IntrareDetaliiLicente();
		dlic.setIdComisie(1);
		dlic.setNota1Oral(10);
		dlic.setNota1Proiect(9);
		dlic.setNota2Oral(7);
		dlic.setNota2Proiect(8);
		dlic.setNota3Oral(9);
		dlic.setNota3Proiect(8);
		dlic.setNota4Oral(0);
		dlic.setNota4Proiect(0);
		dlic.setNota5Oral(7);
		dlic.setNota5Proiect(8);
		dlic.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-09-10 13:30:00"));
		result = test.insertDetaliiLicenta(dlic);
		expect = 0;
		
		assertEquals(expect, result);
		
		dlic = new IntrareDetaliiLicente();
		dlic.setId(1);
		dlic.setIdComisie(1);
		dlic.setNota1Oral(7);
		dlic.setNota1Proiect(9);
		dlic.setNota2Oral(7);
		dlic.setNota2Proiect(8);
		dlic.setNota3Oral(9);
		dlic.setNota3Proiect(8);
		dlic.setNota4Oral(0);
		dlic.setNota4Proiect(0);
		dlic.setNota5Oral(7);
		dlic.setNota5Proiect(8);
		dlic.setDataOraSustinerii(java.sql.Timestamp.valueOf("2017-09-10 13:30:00"));
		result = test.insertDetaliiLicenta(dlic);
		expect = -1;
		
		assertEquals(expect, result);
	}

	@Test
	public void testInsertLicenta() {
		
		BD bd = new BD();
		bd.login("jimmy.jimmy", "jimmy");
		AccessBD access = bd.getAccess();
		AccessStudentBD  test = ((AccessStudentBD) access);
		
		IntrareMesaje mesaj = new IntrareMesaje();
		mesaj.setId(50);
		mesaj.setIdDestinatar(3);
		mesaj.setIdEmitator(2);
		mesaj.setMesaj("Schimba ora evaluarii");
		int result = test.insertMesaj(mesaj);
		int expect = 0;
		
		assertEquals(expect, result);
		
		mesaj = new IntrareMesaje();
		mesaj.setIdDestinatar(3);
		mesaj.setIdEmitator(2);
		mesaj.setMesaj("Ora evaluarii a fost schimbata");
		result = test.insertMesaj(mesaj);
		expect = 0;
		
		assertEquals(expect, result);
		
		mesaj = new IntrareMesaje();
		mesaj.setId(1);
		mesaj.setIdDestinatar(3);
		mesaj.setIdEmitator(2);
		mesaj.setMesaj("Schimba ora evaluarii");
		result = test.insertMesaj(mesaj);
		expect = -1;
		
		assertEquals(expect, result);
	}

	@Test
	public void testInsertMesaj() {
		
		BD bd = new BD();
		bd.login("jimmy.jimmy", "jimmy");
		AccessBD access = bd.getAccess();
		AccessStudentBD  test = ((AccessStudentBD) access);
		
		IntrareMesaje mesaj = new IntrareMesaje();
		mesaj.setId(5);
		mesaj.setIdDestinatar(3);
		mesaj.setIdEmitator(2);
		mesaj.setMesaj("Schimba ora evaluarii");
		int result = test.insertMesaj(mesaj);
		int expect = 0;
		
		assertEquals(expect, result);
		
		mesaj = new IntrareMesaje();
		mesaj.setIdDestinatar(3);
		mesaj.setIdEmitator(2);
		mesaj.setMesaj("Ora evaluarii a fost schimbata");
		result = test.insertMesaj(mesaj);
		expect = 0;
		
		assertEquals(expect, result);
		
		mesaj = new IntrareMesaje();
		mesaj.setId(1);
		mesaj.setIdDestinatar(3);
		mesaj.setIdEmitator(2);
		mesaj.setMesaj("Schimba ora evaluarii");
		result = test.insertMesaj(mesaj);
		expect = -1;
		
		assertEquals(expect, result);
	}

}
