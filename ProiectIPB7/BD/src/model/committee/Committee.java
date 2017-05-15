package model.committee;

import java.sql.Timestamp;
import java.util.Vector;
import model.users.types.Secretary;
import model.users.types.Teacher;

public class Committee {

	private int id;
	private Secretary       secretary;
	private Vector<Teacher> teachers;
	private Timestamp       start;
	private Timestamp       end;
	private String          tip;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Secretary getSecretary() {
		return secretary;
	}
	
	public void setSecretary(Secretary secretary) {
		this.secretary = secretary;
	}
	
	public Vector<Teacher> getTeachers() {
		return teachers;
	}
	
	public void setTeachers(Vector<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	public Timestamp getStart() {
		return start;
	}
	
	public void setStart(Timestamp start) {
		this.start = start;
	}
	
	public Timestamp getEnd() {
		return end;
	}
	
	public void setEnd(Timestamp end) {
		this.end = end;
	}
	
	public String getTip() {
		return tip;
	}
	
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	

}
