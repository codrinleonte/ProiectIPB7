package usersTestPackage;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Vector;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import model.committee.Committee;
import model.marks.StudentMark;
import model.scheduling.Timetable;
import model.users.rights.AccessRights;
import model.users.rights.users.SecretaryRights;
import model.users.types.Secretary;
import model.users.types.Student;
import model.users.types.Teacher;

public class SecretaryRightsTest {

	@Test
	public void testSecretaryRights() {
		SecretaryRights secretaryRights = new SecretaryRights();
		assertFalse(secretaryRights == null);
	}

	@Test
	public void testExaminedStudents() {
		SecretaryRights secretaryRights =new SecretaryRights();
		Secretary secretar1 = new Secretary("leonte.lacra","Leonte Lacra","lacra.lacra00",secretaryRights);
	
		Teacher t1 = new Teacher();
		Teacher t2 = new Teacher();
		Teacher t3 = new Teacher();
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
	
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		Student s5 = new Student();
		Student s6 = new Student();
		Student s7 = new Student();
		
		Vector<Student> studentList1 = new Vector<Student> ();
		Vector<Student> studentList2 = new Vector<Student> ();
		Vector<Student> studentList3= new Vector<Student> ();
			
		Vector<Teacher>teacherList = new Vector<Teacher>();
		
		studentList1.add(s1);
		studentList1.add(s2);
		studentList1.add(s3);
		studentList1.add(s4);

		t1.setCoordinatedStudents(studentList1);
		teacherList.add(t1);
		
		studentList2.add(s1);
		studentList2.add(s2);
		studentList2.add(s3);
		studentList2.add(s4);
		studentList2.add(s5);
		studentList2.add(s6);

		t2.setCoordinatedStudents(studentList2);
		teacherList.add(t2);
		
		studentList3.add(s1);
		studentList3.add(s7);
		studentList3.add(s3);
		t3.setCoordinatedStudents(studentList3);
		teacherList.add(t3);
			
		Committee c1 = new Committee();
		c1.setCoordinators(teacherList);
		
		
		Vector<Student> expectedResult = new Vector<Student>();
		expectedResult.addAll(studentList1);
		expectedResult.addAll(studentList2);
		expectedResult.addAll(studentList3);
		
		assertEquals(expectedResult,secretaryRights.examinedStudents(c1));
	
	}

	@Test
	public void testViewFinalMarks() {
		SecretaryRights secretaryRights =new SecretaryRights();
		Vector<StudentMark> finalMarksList = new Vector<StudentMark>();
		assertEquals(finalMarksList,secretaryRights.viewFinalMarks());
	}

	@Test
	public void testSetCommittee() {
		SecretaryRights secretaryRights =new SecretaryRights();
		Secretary secretar1 = new Secretary("leonte.lacra","Leonte Lacra","lacra.lacra00",secretaryRights);
	
		Teacher t1 = new Teacher();
		Teacher t2 = new Teacher();
		Teacher t3 = new Teacher();
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
	
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		Student s5 = new Student();
		Student s6 = new Student();
		Student s7 = new Student();
		
		Vector<Student> studentList1 = new Vector<Student> ();
		Vector<Student> studentList2 = new Vector<Student> ();
		Vector<Student> studentList3= new Vector<Student> ();
			
		Vector<Teacher>teacherList = new Vector<Teacher>();
		
		studentList1.add(s1);
		studentList1.add(s2);
		studentList1.add(s3);
		studentList1.add(s4);

		t1.setCoordinatedStudents(studentList1);
		teacherList.add(t1);
		
		studentList2.add(s1);
		studentList2.add(s2);
		studentList2.add(s3);
		studentList2.add(s4);
		studentList2.add(s5);
		studentList2.add(s6);

		t2.setCoordinatedStudents(studentList2);
		teacherList.add(t2);
		
		studentList3.add(s1);
		studentList3.add(s7);
		studentList3.add(s3);
		t3.setCoordinatedStudents(studentList3);
		teacherList.add(t3);
			
		Committee c1 = new Committee();
		Timetable timetable= new Timetable();
		c1.setTimetable(timetable);
		c1.setPresident(t1);
		c1.setTeachers(teacherList);
		c1.setCoordinators(teacherList);
		
		Committee c2 = new Committee();
		c2=c1;
		c2.setSecretary(secretar1);
		secretaryRights.setCommittee(secretar1, c1);
		
		assertEquals(c2,c1);
		
	}

	@Test
	public void testAssignCommitteToTeacher() {
		SecretaryRights secretaryRights =new SecretaryRights();
		Secretary secretar1 = new Secretary("leonte.lacra","Leonte Lacra","lacra.lacra00",secretaryRights);
	
			
		Committee c1 = new Committee();
		Teacher t1 = new Teacher();
		
		secretaryRights.assignCommitteeToTeacher(c1,t1);
		
		assertEquals(t1, c1.getTeachers().lastElement());
	}

	
	@Test
	public void testModifyStudentMark() {
		fail("Not yet implemented");
	}

	@Test
	public void testProposeStudentTeacherArrangement() {
		SecretaryRights secretaryRights =new SecretaryRights();
		Secretary secretar1 = new Secretary("leonte.lacra","Leonte Lacra","lacra.lacra00",secretaryRights);
	
		Teacher t1 = new Teacher();
		Teacher t2 = new Teacher();
		Teacher t3 = new Teacher();
		Teacher t4 = new Teacher();
		Teacher t5 = new Teacher();
		Teacher t6 = new Teacher();
		Teacher t7 = new Teacher();
		Teacher t8 = new Teacher();
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		t1.setName("t4");
		t2.setName("t5");
		t3.setName("t6");
		
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		Student s5 = new Student();
		Student s6 = new Student();
		Student s7 = new Student();
		
		Vector<Student> studentList1 = new Vector<Student> ();
		Vector<Student> studentList2 = new Vector<Student> ();
		Vector<Student> studentList3= new Vector<Student> ();
		Vector<Student> studentList4 = new Vector<Student> ();
		Vector<Student> studentList5 = new Vector<Student> ();
		Vector<Student> studentList6 = new Vector<Student> ();
		Vector<Student> studentList7 = new Vector<Student> ();
		Vector<Student> studentList8 = new Vector<Student> ();
		
		
		Vector<Teacher>teacherList = new Vector<Teacher>();
		
		studentList1.add(s1);
		studentList1.add(s2);
		studentList1.add(s3);
		studentList1.add(s4);
		studentList1.add(s1);
		studentList1.add(s2);
		studentList1.add(s1);
		studentList1.add(s2);
		studentList1.add(s3);
		studentList1.add(s4);
		studentList1.add(s1);
		studentList1.add(s2);
		t1.setCoordinatedStudents(studentList1);
		teacherList.add(t1);
	
		studentList2.add(s1);
		studentList2.add(s2);
		studentList2.add(s3);
		studentList2.add(s4);
		studentList2.add(s5);
		studentList2.add(s6);
		studentList2.add(s1);
		studentList2.add(s2);
		studentList2.add(s3);
		studentList2.add(s4);
		studentList2.add(s5);
		studentList2.add(s6);
		studentList2.add(s1);
		studentList2.add(s2);
		studentList2.add(s3);
		studentList2.add(s4);
		studentList2.add(s5);
		studentList2.add(s6);
		t2.setCoordinatedStudents(studentList2);
		teacherList.add(t2);
		
		studentList3.add(s1);
		studentList3.add(s7);
		studentList3.add(s1);
		studentList3.add(s7);
		studentList3.add(s3);
		t3.setCoordinatedStudents(studentList3);
		teacherList.add(t3);
		
		
	
		studentList4.add(s3);
		studentList4.add(s4);
		studentList4.add(s5);
		studentList4.add(s6);
		t4.setCoordinatedStudents(studentList4);
		teacherList.add(t4);
		
		
		studentList5.add(s1);
		studentList5.add(s2);
		studentList5.add(s3);
		studentList5.add(s4);
		studentList5.add(s5);
		studentList5.add(s6);
		studentList5.add(s7);
		studentList5.add(s5);
		studentList5.add(s6);
		studentList5.add(s7);
		t5.setCoordinatedStudents(studentList5);
		teacherList.add(t5);
		
		
		
		studentList6.add(s1);
		studentList6.add(s2);
		studentList6.add(s3);
		studentList6.add(s7);
		studentList6.add(s5);
		studentList6.add(s6);
		studentList6.add(s7);
		t6.setCoordinatedStudents(studentList6);
		teacherList.add(t6);
		
		studentList7.add(s1);
		studentList7.add(s2);
		studentList7.add(s3);
		studentList7.add(s4);
		studentList7.add(s5);
		studentList7.add(s1);
		studentList7.add(s2);
		studentList7.add(s3);
		studentList7.add(s4);
		studentList7.add(s1);
		studentList7.add(s2);
		studentList7.add(s3);
		studentList7.add(s4);
		studentList7.add(s5);
		studentList7.add(s1);
		studentList7.add(s2);
		studentList7.add(s3);
		studentList7.add(s4);
		t7.setCoordinatedStudents(studentList7);
		teacherList.add(t7);
		
		
		studentList8.add(s1);
		studentList8.add(s2);
		studentList8.add(s3);
		studentList8.add(s4);
		studentList8.add(s1);
		studentList8.add(s2);
		studentList8.add(s3);
		studentList8.add(s4);

		t8.setCoordinatedStudents(studentList8);
		teacherList.add(t8);
		
		Committee c1 = new Committee();
		Committee c2 = new Committee();
		Committee c3 = new Committee();
		Committee c4 = new Committee();
		
		Vector<Committee> committeesList = new Vector<Committee>();
		committeesList.add(c1);
		committeesList.add(c2);
		committeesList.add(c3);
		committeesList.add(c4);
		Secretary secretary = new Secretary();
		secretary.setRights(secretaryRights);
		
		secretaryRights.proposeStudentTeacherArrangement(committeesList,teacherList, 0);
		
		for(Committee c:committeesList){
		assertFalse(secretaryRights.examinedStudents(c).size()<t4.getCoordinatedStudents().size());
		}
	}

	@Test
	public void testGenerateProgrammedStudentsPDFReport() {
		SecretaryRights secretaryRights =new SecretaryRights();
		String fileName = new String("Studenti");
		secretaryRights.generateProgrammedStudentsPDFReport(fileName);
		Document doc =new Document();
		try{
			String desktopPath = System.getProperty("user.home") + "/Desktop/";
			desktopPath.replace("\\", "/");
			PdfWriter.getInstance(doc, new FileOutputStream(desktopPath+fileName+".pdf"));
			
			File f = new File(desktopPath+"Studenti.pdf");
			assertTrue(f.exists() && !f.isDirectory()) ; 
			    
			}
			catch(Exception e){
				System.out.println(e.toString());
			}

	}

	@Test
	public void testGenerateDayStudentsMarksPDFReport() {
		SecretaryRights secretaryRights =new SecretaryRights();
		String fileName = new String("Lista ziua x");
		secretaryRights.generateProgrammedStudentsPDFReport(fileName);
		Document doc =new Document();
		try{
			String desktopPath = System.getProperty("user.home") + "/Desktop/";
			desktopPath.replace("\\", "/");
			PdfWriter.getInstance(doc, new FileOutputStream(desktopPath+fileName+".pdf"));
			
			File f = new File(desktopPath+"Studenti.pdf");
			assertTrue(f.exists() && !f.isDirectory()) ; 
			    
			}
			catch(Exception e){
				System.out.println(e.toString());
			}
	}

	@Test
	public void testGenerateFinalSituationPDFReport() {
		SecretaryRights secretaryRights =new SecretaryRights();
		String fileName = new String("ListaFinala");
		secretaryRights.generateProgrammedStudentsPDFReport(fileName);
		Document doc =new Document();
		try{
			String desktopPath = System.getProperty("user.home") + "/Desktop/";
			desktopPath.replace("\\", "/");
			PdfWriter.getInstance(doc, new FileOutputStream(desktopPath+fileName+".pdf"));
			
			File f = new File(desktopPath+"Studenti.pdf");
			assertTrue(f.exists() && !f.isDirectory()) ; 
			    
			}
			catch(Exception e){
				System.out.println(e.toString());
			}
	}

	

}
