package model.users.types;


import model.users.User;
import model.users.rights.users.TeacherRights;

import java.util.Vector;



public class Teacher extends User {

    private Vector<Student> coordinatedStudents;

   // private AccessRights rights;
    private TeacherRights rights;

    // TODO Add any other necessary data members


    public Teacher() {
        super();
        this.coordinatedStudents = new Vector<>();
        rights = new TeacherRights();
    }
    public Teacher(Vector<Student> coordinatedStudents) {
        super();
        this.coordinatedStudents = coordinatedStudents;
    }

    // TODO Add any other necessary constructors





    // TODO Add any Teacher-specific methods like markStudent(student, mark) etc.
    // TODO use the AccessRights. In here the methods should look like  editMarkOf(String student, int mark) { rights.editMarkOf(student, mark); }
  
    
    public int getNumberOfStudents() {
		return this.getCoordinatedStudents().size();
	}
	
	public int compareTo(Teacher t){
		   Integer d1 = this.getNumberOfStudents();
		   Integer  d2 = t.getNumberOfStudents();
		   return d1.compareTo(d2);
		   
		 
	}


    public Vector<Student> getCoordinatedStudents() {
        return coordinatedStudents;
    }
    public void setCoordinatedStudents(Vector<Student> coordinatedStudents) {
        this.coordinatedStudents = coordinatedStudents;
    }

    public TeacherRights getRights() {
        return rights;
    }
    public void setRights(TeacherRights rights) {
        this.rights = rights;
    }

    // TODO Add any other necessary data getters/setters
}
