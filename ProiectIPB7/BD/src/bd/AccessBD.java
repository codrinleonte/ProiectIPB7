package bd;

import java.sql.Connection;

import model.users.User;

public class AccessBD{

	protected  int        idCont;
	protected  String     tip;
	protected  User       user;
	protected  Connection conexiune;
	
	public AccessBD(){
		
	}
	
	public void setTip( String tip ){
		this.tip = tip;
	}
	
	public String getTip(){
		return tip;
	}
	
	public void setIdCont( int idCont ){
		this.idCont = idCont;
	}
	
	public int getIdCont( int idCont ){
		return idCont;
	}
	
	public User getUser(){
		return user;
	}
	

	
}
