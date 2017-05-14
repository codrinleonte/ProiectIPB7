package bd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.Random;


public class BD {
	
	private boolean    connected = false;
	private Connection conexiune;
	private String     domeniu="";
	
	private int sendEmail( String adresa , String mesaj )
	{
		return 0;
	}
	
	public BD() 
	{
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			this.conexiune = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Licente","ADMIN");
			this.connected = true;
			
		} 
		catch ( Exception e) {
			
			System.out.println("Exceptie la conectare: "+e.getMessage());
			this.connected = false;
			
		}	
	}
	
	public boolean isConnected(){
		return connected;
	}
	
	public void setDomeniu( String domeniu ){
		this.domeniu=domeniu;
	}
	
	public AccessBD getAccess(){
		
		AccessBD rezultat = new AccessBD();
		return rezultat;
		
	}

	public int login ( String username, String hashparola )
	{
		String apel = "{ ? = call login( ?, ? ) }";
		int    rezultat;
		try{
			
			 CallableStatement statement = conexiune.prepareCall(apel);
			 statement.registerOutParameter( 1, Types.INTEGER );
			 statement.setString(2, username);
			 statement.setString(3, hashparola);
			 statement.execute();
			 rezultat=statement.getInt(1);
			 
			 return rezultat;
			 
		}
		catch(Exception e){
			System.out.println("Exceptie la login: "+e.getMessage());
			return -7;
		}
		
	}
	
	public int verificare ( String hashcod )
	{
		String apel = "{ ? = call verificare( ? ) }";
		int    rezultat;
		try{
			
			 CallableStatement statement = conexiune.prepareCall(apel);
			 statement.registerOutParameter( 1, Types.INTEGER );
			 statement.setString( 2, hashcod);
			 statement.execute();
			 rezultat=statement.getInt(1);
			 return rezultat; 
		}
		catch(Exception e){
			System.out.println("Exceptie la login: "+e.getMessage());
			return -7;
		}
		
	}

	public int inregistrare_stud ( String email , String hashparola )
	{
		Random random;
		String hashcod;
		boolean unic;
		int rezultat = 0;
		
		try{
			String username = email.split("@")[0];
			if(!email.split("@")[1].equals("info.uaic.ro") || username.split("\\.")[0].equals(username) )
				return -1;
		}
		catch( Exception e ){
			System.out.println("Email invalid inregistrare_stud: "+e.getMessage());
			return -1;
		}
		
		String apel = "SELECT COUNT(ID) FROM CONTURI WHERE COD_ACTIVARE='";
		
		do{
			random = new Random();
			unic = true;
			hashcod = "";
			for( int i = 0; i<20; i++ )
				hashcod = hashcod + random.nextInt(9);
			try{
				Statement statement = conexiune.createStatement();
				ResultSet resultSet = statement.executeQuery(apel+hashcod+"'");

				resultSet.next();
				if(resultSet.getInt(1) !=0 )
					unic = false;
			}
			catch( Exception e ){
				System.out.println("Exceptie la generare cod random la inregistrare_stud: "+e.getMessage());
				return -7;
			}
		}while( !unic );
		
		apel = "{ ? = call inregistrare_stud( ?, ?, ? ) }";
		try {
			CallableStatement statement = conexiune.prepareCall(apel);
			statement.registerOutParameter(1, Types.INTEGER);
			statement.setString( 2, email.split("@")[0] );
			statement.setString( 3, hashparola );
			statement.setString( 4, hashcod );
			statement.execute();
			rezultat = statement.getInt(1);
			
			sendEmail( email, "Click pentru activare: "+ domeniu + "\\activate\\" + hashcod );
			
			return rezultat;
		} 
		catch ( Exception e ) {
			System.out.println("Exceptie la inregistrare_stud: "+e.getMessage());
			return -7;
		}
	}
	
	public int inregistrare_prof ( String username , String hashparola )
	{
		String apel = " { ? = call inregistrare_prof( ? , ? ) }";
		int rezultat;
		try{
			CallableStatement statement = conexiune.prepareCall(apel);
			statement.registerOutParameter(1, Types.INTEGER);
			statement.setString(2, username );
			statement.setString(3, hashparola);
			statement.execute();
			rezultat=statement.getInt(1);
			return rezultat;
		}
		catch ( Exception e ){
			System.out.println("Exceptie inregistrare_prof: "+e.getMessage());
			return -7;
		}
	}
	
}
