package BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BD {
	
	private Connection connection;
	
	public BD() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Licente","ADMIN");	
	}
	
	public int login ( String username , String hashparola )
	//  0 Login  reusit
	// -1 Cont   inexistent
	// -2 Parola incorecta
	// -3 Cont   neactivat
	// -4 Eroare login
	{
		try{
			
			PreparedStatement ps = connection.prepareStatement("Select Count(*) from conturi where Username= ?");
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			int contor = rs.getInt(1);
			if( contor == 0 )
				return -1;
			
			ps = connection.prepareStatement("Select Count(*) from conturi where Username=? and Parola=?");
			ps.setString(1, username);
			ps.setString(2, hashparola);
			rs=ps.executeQuery();
			rs.next();
			contor = rs.getInt(1);
			if( contor == 0 )
				return -2;
			
			ps = connection.prepareStatement("Select * from conturi where Username=? and Parola=?");
			ps.setString(1, username);
			ps.setString(2,hashparola);
			rs = ps.executeQuery();
			rs.next();
			contor = rs.getInt(6);
			
			if( contor == 0 )
				return -3;
			
			return 0;
			
		}
		catch ( Exception e ){
			System.out.println("Exceptie login: "+e.getMessage());
			return -4;
		}
		
	}
	
	public int inregistrare ( String email , String hashparola )
	//  0 inregistrare reusita
	// -1 email  invalid
	// -2 email  folosit
	// -3 Eroare inregistrare
	{
		String username = "UNDEFINED";
		try{
			String[] partitionare = email.split("@");
			if( !partitionare[1].equals("info.uaic.ro") )
				return -1;
			username = partitionare[0];
		}
		catch( Exception e){
			System.out.println("Exceptie partitionare email: "+e.getMessage());
			return -1;
		}
		
		try {
			
			PreparedStatement ps = connection.prepareStatement("SELECT COUNT(ID) FROM CONTURI WHERE EMAIL= ? ");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int contor = rs.getInt(1);
			if( contor != 0 )
				return -2;
			
			ps = connection.prepareStatement("INSERT ALL INTO CONTURI VALUES(CONTURI_SEQ.nextval, ?, ?, ?,'UNDEFINED',0) INTO VERIFICARE VALUES('COD',CONTURI_SEQ.currval) SELECT * FROM DUAL");
			ps.setString(1, username);
			ps.setString(2, hashparola);
			ps.setString(3, email);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Exceptie inregistrare: "+e.getMessage());
			return -3;
		} 
		
		return 0;
		
		
	}
	
	public int verificare ( String hash )
	//  0 cont verificat
	// -1 cod_invalid
	{
		try{
			
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT ID_CONT FROM VERIFICARE WHERE COD_VERIFICARE ='"+hash+"'");
			rs.next();
			int id_cont = rs.getInt(1);
			
			PreparedStatement ps = connection.prepareStatement(" UPDATE CONTURI SET VERIFICAT = 1 WHERE ID= ?");
			ps.setInt(1,id_cont);
			ps.executeUpdate();
			ps.close();
			
			return 0;
		}
		catch ( Exception e ){
			System.out.println("Exceptie login: "+e.getMessage());
			return -1;
		}
		
	}
	
}
