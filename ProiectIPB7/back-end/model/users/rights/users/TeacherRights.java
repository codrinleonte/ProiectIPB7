package model.users.rights.users;

import model.committee.Committee;
import model.users.rights.AccessRights;
import model.users.types.Student;
import model.users.types.Teacher;

import java.util.Iterator;
import java.util.Vector;

public class TeacherRights extends AccessRights {

    // TODO Implements all the actions a Secretary might take in this class( editMarkOfStudent(String student, int mark) etc. )
    public Student student;
    public Integer oralMark;
    public Integer projectMark;
    public int maxStudents = 60;
    
    
    
	public Student getStudent() {
		return student;
	}
	
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	public Integer getOralMark() {
		return oralMark;
	}
	
	
	public void setOralMark(Integer oralMark) {
		this.oralMark = oralMark;
	}
	
	
	public Integer getProjectMark() {
		return projectMark;
	}
	
	
	public void setProjectMark(Integer projectMark) {
		this.projectMark = projectMark;
	}
    
	
	
    public void addMarkOfStudent(){
    	student.getMark().getOralMarks().add(oralMark);
    	student.getMark().getProjectMarks().add(projectMark);
    }
    
    
   
    public void addStudentToTeacher(Vector<Student>studenti,Student student){
    	studenti.add(student);
    }
    
    
    
    public void removeStudentfromTeacher(Vector<Student>studenti, Student student){
    	studenti.removeElement(student);
    }
    
    
    
    
    public int chooseCommittee(Vector<Committee>Com, Committee c, Teacher t){
    	int numberStudents = 0;

	    	
	    	if(c.getTeachers().size()<3 ){
		   
		    	for (Teacher teacher : c.getTeachers() ) {
					numberStudents += teacher.getCoordinatedStudents().size();
				}
		    	if( t.getCoordinatedStudents().size() + numberStudents > maxStudents){
		    		return -1; // se depaseste limita de studenti ce pot fi evaluati de o comsie
		    	}
		    	for (Committee committee : Com) {
		    		Iterator<Teacher> iter = committee.getTeachers().iterator();

		    		while (iter.hasNext()) {
		    		    Teacher teacher = iter.next();

		    		    if (t.equals(teacher))
		    		        iter.remove();
		    		}
				}
		    	c.getTeachers().add(t);
		    	
		    	return 1;//profesorul isi alege comisia dorita 
	    	}
	    	if(c.getTeachers().size()==3)
	    		return 0; //sunt exact 3 profesori in comisie si nu se poate adauga profesorul curent
	    	return -2; //ceva nu e in regula, sunt mai mult de 3 profesori intr-o comisie
  

    }
    
    
  
    public  Vector<Integer> getYourStudentOralMarks(Student s){
    	return s.getMark().getOralMarks();
    }
    
    public  Vector<Integer> getYourStudentProjectMarks(Student s){
    	return s.getMark().getProjectMarks();
    }
    
    public Vector<Student> getYourStudents(Teacher t){
    	return t.getCoordinatedStudents();
    }
    
    

	
}
