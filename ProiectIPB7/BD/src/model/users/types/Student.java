package model.users.types;
import  model.users.User;

public class Student extends User {
	
	String  numarMatricol;
	
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
	
	
}
