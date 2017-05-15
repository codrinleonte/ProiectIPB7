package model.users.types;
import model.session.Session;
import  model.users.User;

public class Student extends User {
	
	String  numarMatricol;
	Session sesiune;
	
	public Student()
	{
		this.tip = "Student";
	}
	
	public void setNumarMatricol( String numarMatricol){
		this.numarMatricol = numarMatricol;
	}
	
	public String getNumarMatricol(){
		return numarMatricol;
	}
	
	public void setSesiune ( Session sesiune ){
		this.sesiune=sesiune;
	}
	
	public Session getSesiune(){
		return sesiune;
	}
	
}
