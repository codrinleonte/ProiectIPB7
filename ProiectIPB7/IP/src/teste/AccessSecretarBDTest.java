package teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bd.*;

public class AccessSecretarBDTest {

	@Test
	public void testSelectMesaje() {
		
		BD bd = new BD();
		AccessBD access = bd.login("andreea.arusoaie", "parola");
		
		if( access.getTip().equals("Access_Secretary") )
		{
			AccessSecretarBD accessSecretar = (AccessSecretarBD) access;
			List<IntrareMesaje> result = accessSecretar.selectMesaje();
			List<IntrareMesaje> expect = new ArrayList<IntrareMesaje>();
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testSelectStudenti() {
		
		BD bd = new BD();
		AccessBD access = bd.login("andreea.arusoaie", "parola");
		
		if( access.getTip().equals("Access_Secretary") )
		{
			AccessSecretarBD accessSecretar = (AccessSecretarBD) access;
			List<IntrareStudenti> result = accessSecretar.selectStudenti();
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
		AccessBD access = bd.login("andreea.arusoaie", "parola");
		
		if( access.getTip().equals("Access_Secretary") )
		{
			AccessSecretarBD accessSecretar = (AccessSecretarBD) access;
			List<IntrareProfesori> result = accessSecretar.selectProfesori();
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
		AccessBD access = bd.login("andreea.arusoaie", "parola");
		
		if( access.getTip().equals("Access_Secretary") )
		{
			AccessSecretarBD accessSecretar = (AccessSecretarBD) access;
			List<IntrareComisii> result = accessSecretar.selectComisii();
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
	public void testSelectDetaliiLicente() {
		
		BD bd = new BD();
		AccessBD access = bd.login("andreea.arusoaie", "parola");
		
		if( access.getTip().equals("Access_Secretary") )
		{
			AccessSecretarBD accessSecretar = (AccessSecretarBD) access;
			List<IntrareDetaliiLicente> result = accessSecretar.selectDetaliiLicente();
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
	public void testSelectLicente() {
		
		BD bd = new BD();
		AccessBD access = bd.login("andreea.arusoaie", "parola");
		
		if( access.getTip().equals("Access_Secretary") )
		{
			AccessSecretarBD accessSecretar = (AccessSecretarBD) access;
			List<IntrareLicente> result = accessSecretar.selectLicente();
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
		AccessBD access = bd.login("andreea.arusoaie", "parola");
		
		if( access.getTip().equals("Access_Secretary") )
		{
			AccessSecretarBD accessSecretar = (AccessSecretarBD) access;
			List<IntrareSesiuni> result = accessSecretar.selectSesiuni();
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
	public void testUpdateStudent() {
		
		BD bd = new BD();
		AccessBD access = bd.login("andreea.arusoaie", "parola");
		
		if( access.getTip().equals("Access_Secretary") )
		{
			AccessSecretarBD accessSecretar = (AccessSecretarBD) access;
			IntrareStudenti student = new IntrareStudenti();
			
			student.setId(4);
			student.setIdCont(5);
			student.setNrMatricol("sv3456777");
			student.setNume("Stanescu");
			student.setPrenume("Mihai");
			student.setId_comisie(1);
			student.setIdSesiune(3);
			int result = accessSecretar.updateStudent(student);
			int expect = 0;
			
			assertEquals(expect, result);
			
			student.setId(200);
			student.setIdCont(5);
			student.setNrMatricol("sv3456777");
			student.setNume("Stanescu");
			student.setPrenume("Mihai");
			student.setId_comisie(1);
			student.setIdSesiune(3);
			result = accessSecretar.updateStudent(student);
		    expect = -1;
			
			assertEquals(expect, result);
		}

	}

	@Test
	public void testUpdateProfesor() {
		
		BD bd = new BD();
		AccessBD access = bd.login("andreea.arusoaie", "parola");
		
		if( access.getTip().equals("Access_Secretary") )
		{
			AccessSecretarBD accessSecretar = (AccessSecretarBD) access;
			IntrareStudenti student = new IntrareStudenti();
			
			student.setId(4);
			student.setIdCont(5);
			student.setNrMatricol("sv3456777");
			student.setNume("Stanescu");
			student.setPrenume("Mihai");
			student.setId_comisie(1);
			student.setIdSesiune(3);
			int result = accessSecretar.updateStudent(student);
			int expect = 0;
			
			assertEquals(expect, result);
			
			student.setId(200);
			student.setIdCont(5);
			student.setNrMatricol("sv3456777");
			student.setNume("Stanescu");
			student.setPrenume("Mihai");
			student.setId_comisie(1);
			student.setIdSesiune(3);
			result = accessSecretar.updateStudent(student);
		    expect = -1;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testUpdateComisie() {
		
		BD bd = new BD();
		AccessBD access = bd.login("andreea.arusoaie", "parola");
		
		if( access.getTip().equals("Access_Secretary") )
		{
			AccessSecretarBD accessSecretar = (AccessSecretarBD) access;
			IntrareComisii comisie = new IntrareComisii();
			
			comisie.setId(1);
			comisie.setIdProfSef(1);
			comisie.setIdProf2(2);
			comisie.setIdProf3(3);
			comisie.setIdProf4(0);
			comisie.setIdSecretar(2);
			comisie.setTipComisie("licenta");
			comisie.setSala("309");
			int result = accessSecretar.updateComisie(comisie);
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
			result = accessSecretar.updateComisie(comisie);
			expect = -1;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testUpdateDetaliiLicenta() {
		
		BD bd = new BD();
		AccessBD access = bd.login("andreea.arusoaie", "parola");
		
		if( access.getTip().equals("Access_Secretary") )
		{
			AccessSecretarBD accessSecretar = (AccessSecretarBD) access;
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
			
			int result = accessSecretar.updateDetaliiLicenta(licenta);
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
			
			result = accessSecretar.updateDetaliiLicenta(licenta);
			expect = -1;
			
			assertEquals(expect, result);		
		}

	}

	@Test
	public void testUpdateLicenta() {
		
		BD bd = new BD();
		AccessBD access = bd.login("andreea.arusoaie", "parola");
		
		if( access.getTip().equals("Access_Secretary") )
		{
			AccessSecretarBD accessSecretar = (AccessSecretarBD) access;
			IntrareLicente licenta = new IntrareLicente();
			
			licenta.setId(3);
			licenta.setTitlu("licenta3");
			licenta.setIdProfesor(3);
			licenta.setIdStudent(3);
			licenta.setMaterialeLicenta("www.github.com");
			licenta.setIdSesiune(1);
			licenta.setTipLucrare("LICENTA");
			int result = accessSecretar.updateLicenta(licenta);
			int expect = 0;
			
			assertEquals(expect, result);
			
			licenta.setId(-3);
			licenta.setTitlu("licenta3");
			licenta.setIdProfesor(3);
			licenta.setIdStudent(3);
			licenta.setMaterialeLicenta("www.github.com");
			licenta.setIdSesiune(1);
			licenta.setTipLucrare("LICENTA");
			result = accessSecretar.updateLicenta(licenta);
			expect = -1;
			
			assertEquals(expect, result);
		}
	}

	@Test
	public void testInsertComisie() {
		
		BD bd = new BD();
		AccessBD access = bd.login("andreea.arusoaie", "parola");
		
		if( access.getTip().equals("Access_Secretary") )
		{
			AccessSecretarBD accessSecretar = (AccessSecretarBD) access;
			IntrareComisii comisie = new IntrareComisii();
			
			comisie.setId(1);
			comisie.setIdProfSef(1);
			comisie.setIdProf2(2);
			comisie.setIdProf3(3);
			comisie.setIdProf4(0);
			comisie.setIdSecretar(2);
			comisie.setTipComisie("licenta");
			comisie.setSala("309");
			int result = accessSecretar.insertComisie(comisie);
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
			result = accessSecretar.insertComisie(comisie);
			expect = 0;
			
			assertEquals(expect, result);
		}
	}

}
