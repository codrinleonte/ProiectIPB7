package bd;

import java.sql.Connection;

public class AccessBD{

	protected  int           idCont;
	protected  String        tip;
	protected  UserBD        user;
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
	
	public int getIdCont(){
		return idCont;
	}
	
	public UserBD getUser(){
		return user;
	}
		
}
