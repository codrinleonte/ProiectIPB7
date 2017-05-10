package rights;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import org.junit.Test;

import Committee.Committee;
import StudentMark.StudentMark;
import types.Student;
import types.Teacher;

public class StudentRightsTest {

	@Test
	public void testGetMarksOfStudents() {
		
		Teacher t1 = new Teacher();
		Teacher t2 = new Teacher();
		Teacher t3 = new Teacher();
		Teacher t4 = new Teacher();
		Teacher t5 = new Teacher();
		Teacher t6 = new Teacher();
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		t4.setName("t4");
		t5.setName("t5");
		t6.setName("t6");
		
		Student s1 = new Student();
		s1.setName("viorel");
		Student s2 = new Student();
		s2.setName("johny");
		Student s3 = new Student();
		s3.setName("Tony");
		Student s4 = new Student();
		s4.setName("geani");
		Student s5 = new Student();
		s5.setName("titi");
		Student s6 = new Student();
		s6.setName("Didi");
		Student s7 = new Student();
		s7.setName("Frm");
		
		StudentMark sm1 = new StudentMark();
		sm1.getOralMarks().add(6);
		sm1.getOralMarks().add(7);
		sm1.getOralMarks().add(8);
		sm1.getProjectMarks().add( 9);
		sm1.getProjectMarks().add( 9);
		sm1.getProjectMarks().add( 9);
		s1.setMark(sm1);
		
		//System.out.println("Notele sunt: "+sm1.getProjectMarks());
		
		StudentMark sm2 = new StudentMark();
		sm2.getOralMarks().add(6);
		sm2.getOralMarks().add(7);
		sm2.getOralMarks().add(8);
		sm2.getProjectMarks().add( 9);
		sm2.getProjectMarks().add( 9);
		sm2.getProjectMarks().add( 9);
		s2.setMark(sm2);
		
		StudentMark sm3 = new StudentMark();
		sm3.getOralMarks().add(6);
		sm3.getOralMarks().add(7);
		sm3.getOralMarks().add(8);
		sm3.getProjectMarks().add( 9);
		sm3.getProjectMarks().add(9);
		sm3.getProjectMarks().add(9);
		s3.setMark(sm3);
		
		StudentMark sm4 = new StudentMark();
		sm4.getOralMarks().add(6);
		sm4.getOralMarks().add(7);
		sm4.getOralMarks().add(8);
		sm4.getProjectMarks().add( 9);
		sm4.getProjectMarks().add(9);
		sm4.getProjectMarks().add(9);
		s4.setMark(sm4);
		
		StudentMark sm5 = new StudentMark();
		sm5.getOralMarks().add(6);
		sm5.getOralMarks().add(7);
		sm5.getOralMarks().add(8);
		sm5.getProjectMarks().add( 9);
		sm5.getProjectMarks().add(9);
		sm5.getProjectMarks().add( 9);
		s5.setMark(sm5);
		
		StudentMark sm6 = new StudentMark();
		sm6.getOralMarks().add(6);
		sm6.getOralMarks().add(7);
		sm6.getOralMarks().add(8);
		sm6.getProjectMarks().add( 9);
		sm6.getProjectMarks().add( 9);
		sm6.getProjectMarks().add( 9);
		s6.setMark(sm6);
		
		StudentMark sm7 = new StudentMark();
		sm7.getOralMarks().add(6);
		sm7.getOralMarks().add(7);
		sm7.getOralMarks().add(8);
		sm7.getProjectMarks().add( 9);
		sm7.getProjectMarks().add(9);
		sm7.getProjectMarks().add( 9);
		s7.setMark(sm7);
		
		
		
		
		Vector<Student> studentList1 = new Vector<Student> ();
		Vector<Student> studentList2 = new Vector<Student> ();
		Vector<Student> studentList3= new Vector<Student> ();
		Vector<Student> studentList4 = new Vector<Student> ();
		Vector<Student> studentList5 = new Vector<Student> ();
		Vector<Student> studentList6 = new Vector<Student> ();
		
		
		Vector<Teacher>teacherList = new Vector<Teacher>();
		
		studentList1.add(s1);
		studentList1.add(s2);
		studentList1.add(s3);
		studentList1.add(s4);
		studentList1.add(s1);
		studentList1.add(s2);

		t1.setCoordinatedStudents(studentList1);
		teacherList.add(t1);
		
		System.out.println(teacherList.elementAt(0).getName());
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
		studentList3.add(s1);
		studentList3.add(s1);
		studentList3.add(s2);
		studentList3.add(s3);
		t3.setCoordinatedStudents(studentList3);
		teacherList.add(t3);
		
		
		studentList4.add(s1);
		studentList4.add(s2);
		studentList4.add(s3);
		studentList4.add(s4);
		studentList4.add(s5);
		studentList4.add(s6);
		studentList4.add(s7);
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
		
		
		Committee c1 = new Committee();
		Committee c2 = new Committee();
		Committee c3 = new Committee();
		Committee c4 = new Committee();

		Vector<Committee> committeesList = new Vector<Committee>();
		committeesList.add(c1);
		committeesList.add(c2);
		committeesList.add(c3);
		committeesList.add(c4);
		
		
	
		
		System.out.println(t1.getRights().getYourStudentOralMarks(s1));
		
		t1.getRights().chooseCommittee(committeesList, c2, t1);
		t2.getRights().chooseCommittee(committeesList, c2, t2);
		t3.getRights().chooseCommittee(committeesList, c2, t3);
		System.out.println(c2.getTeachers());
		t1.getRights().chooseCommittee(committeesList, c3, t1);
		
		System.out.println(c2.getTeachers());
		System.out.println(c3.getTeachers());
		
		
		Map <String, Double> c = new HashMap <String, Double>();
		c.putAll(s1.getRights().getMarksOfStudents(committeesList));
		Vector<Double> d = new Vector<>();
		d.add(8.0);d.add(8.0);d.add(8.0);d.add(8.0);d.add(8.0);d.add(8.0);d.add(8.0);d.add(8.0);d.add(8.0);d.add(8.0);
		d.add(8.0);d.add(8.0);d.add(8.0);d.add(8.0);d.add(8.0);d.add(8.0);d.add(8.0);d.add(8.0);d.add(8.0);d.add(8.0);
		
		for (Entry<String, Double> entry : c.entrySet())
		{
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		assertEquals(c,d);
	}

}
