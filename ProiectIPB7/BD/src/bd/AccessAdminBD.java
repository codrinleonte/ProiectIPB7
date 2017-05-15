package bd;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import model.messages.MessageBD;
import model.users.User;
import model.users.types.*;

public class AccessAdminBD extends AccessBD {

	AccessAdminBD( Connection conexiune , User user )
	{
		this.conexiune = conexiune;
		this.tip = "Access_Admin";
		this.user = user;
	}
	
	public Vector<Account> fetchConturi(){
		Vector<Account> rezultat = new Vector<Account>();
		try{
			
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from Conturi");
			
			while(result.next()){
				Account intrare = new Account();
				intrare.setID(result.getInt(1));
				intrare.setUsername(result.getString(2));
				intrare.setHashparola(result.getString(3));
				intrare.setEmail(result.getString(4));
				intrare.setTip(result.getString(5));
				intrare.setStatus( 0 != result.getInt(6) );
				intrare.setCod_activare(result.getString(7));
				
				rezultat.add(intrare);
			}
			
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la fetchConturi:"+e.getMessage());
			return null;
		}
	}
	
	public Vector<MessageBD> fetchMesaje(){
		Vector<MessageBD> rezultat = new Vector<MessageBD>();
		try{
			
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from Mesaje");
			
			while(result.next()){
				MessageBD intrare = new MessageBD();
				intrare.setId(result.getInt(1));
			}
			
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la fetchConturi:"+e.getMessage());
			return null;
		}
		
		
	}
	
	public Vector<Student> fetchStudenti(){
		Vector<Student> rezultat = new Vector<Student>();
		
		try{
			
			Student intrare = new Student();
			Statement statement = conexiune.createStatement();
			ResultSet result = statement.executeQuery("Select * from Studenti");
			while(result.next()){
				intrare.setId(result.getInt(1));
				intrare.setIdCont(result.getInt(2));
				intrare.setNumarMatricol(result.getString(3));
				intrare.setLastName(result.getString(4));
				intrare.setFirstName(result.getString(5));
				rezultat.add(intrare);
			}
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la fetchStudenti: "+e.getMessage());
			return null;
		}
	}

	
}
