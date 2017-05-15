package model.projects;
import java.sql.Timestamp;
import java.util.Vector;
import model.committee.Committee;
import model.marks.Mark;
import model.users.types.Student;

public class Projects {
	
	private int       id;
	private String    title;
	private Student   student;
	private Vector<String> documentLinks;
	private String    tip;
	private Committee committee;
	private Timestamp time;
	private Mark      mark; 

}
