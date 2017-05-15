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

	public void setId ( int id ){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setTitle( String titlu ){
		this.title = titlu;
	}
	
	public String getTilte(){
		return title;
	}
	
	public void setDocumentLinks ( Vector<String> documentLinks ){
		this.documentLinks=documentLinks;
	}
	
    public Vector<String> getDocumentLinks(){
	   return documentLinks;
    }
   
    public void setTime( Timestamp time ){
    	this.time=time;
    }
    
    public Timestamp getTime(){
    	return time;
    }
    
    public void setMark( Mark mark ){
    	this.mark=mark;
    }
    
    public Mark getMark(){
    	return mark;
    }

	public Committee getCommittee() {
		return committee;
	}

	public void setCommittee(Committee committee) {
		this.committee = committee;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	
}
