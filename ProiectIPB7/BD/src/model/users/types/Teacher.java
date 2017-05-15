package model.users.types;
import java.util.Vector;
import  model.users.User;

public class Teacher extends User {
	
	private Vector<Student> coordinatedStudents;

	public Teacher()
	{
		this.tip = "Teacher";
	}
	
}
