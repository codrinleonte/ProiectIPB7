package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import model.users.User;
import model.users.types.Teacher;

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
	
	public Vector <Teacher> fetchListaProfesori()
	{
		
		Vector<Teacher> rezultat = new Vector<Teacher>();
		
		try{
			
			Statement statement = conexiune.createStatement();
			ResultSet result    = statement.executeQuery("Select ID,Nume,Prenume from profesori");
			while( result.next() )
			{
				Teacher intrare = new Teacher("");
				intrare.setId(result.getInt(1));
				intrare.setLastName(result.getString(2));
				intrare.setFirstName(result.getString(3));
				rezultat.add(intrare);
			}
			
			return rezultat;
		}
		catch ( Exception e ){
			System.out.println("Exceptie la fetchListaProfesori: "+e.getMessage());
			return null;
		}
		

		
	}
	

	
}
