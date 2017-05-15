package bd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.Properties;
import java.util.Random;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import model.users.types.*;


public class BD {
	
	private boolean    connected = false;
	private Connection conexiune;
	@SuppressWarnings("unused")
	private String     domeniu="";
	private AccessBD   access;
	private boolean    loged  = false;
		
	private void createAccess( String username ){
		
		String apel = " { ? = call get_type( ? ) }";
		int rezultat;
		
		try {
			CallableStatement statement = conexiune.prepareCall(apel);
			statement.registerOutParameter(1, Types.INTEGER);
			statement.setString(2, username);
			statement.execute();
			rezultat=statement.getInt(1);
			
			if( rezultat==0 )
			{
				Admin utilizator = new Admin();
				this.access = new AccessAdminBD( conexiune , utilizator );
			}
			else if ( rezultat ==1 )
			{
				
				Student utilizator = new Student();
				
				utilizator.setUsername(username);
				utilizator.setEmail(username+"@info.uaic.ro");
				utilizator.setFirstName(username.split("\\.")[0]);
				utilizator.setLastName(username.split("\\.")[1]);
				
				PreparedStatement preparedStatement = conexiune.prepareStatement("SELECT NR_MATRICOL FROM STUDENTI S JOIN CONTURI C ON S.ID_CONT=C.ID WHERE C.USERNAME = ? ");
				preparedStatement.setString(1, username);
				ResultSet result = preparedStatement.executeQuery();
				result.next();	
				utilizator.setNumarMatricol(result.getString(1));
				
				preparedStatement = conexiune.prepareStatement("SELECT ID FROM PROFESORI WHERE NUME=UPPER(?) AND PRENUME=UPPER(?) ");
				preparedStatement.setString(1, utilizator.getLastName());
				preparedStatement.setString(2, utilizator.getFirstName());
				result=preparedStatement.executeQuery();
				result.next();
				utilizator.setId(result.getInt(1));

	
				this.access = new AccessStudBD( conexiune , utilizator );
				
				
			}
			else if ( rezultat == 2 )
			{
				Teacher utilizator = new Teacher();
				utilizator.setUsername(username);
				utilizator.setEmail(username+"info.uaic.ro");
				utilizator.setFirstName(username.split("\\.")[0]);
				utilizator.setLastName(username.split("\\.")[1]);
				
				PreparedStatement preparedStatement = conexiune.prepareStatement("SELECT ID FROM PROFESORI WHERE NUME=UPPER(?) AND PRENUME=UPPER(?) ");
				preparedStatement.setString(1, utilizator.getLastName());
				preparedStatement.setString(2, utilizator.getFirstName());
				ResultSet result=preparedStatement.executeQuery();
				result.next();
				utilizator.setId(result.getInt(1));
				
				this.access = new AccessProfBD( conexiune , utilizator);
			}
			else
			{
				Secretary utilizator = new Secretary();
				utilizator.setUsername(username);
				utilizator.setEmail(username+"info.uaic.ro");
				utilizator.setFirstName(username.split("\\.")[0]);
				utilizator.setLastName(username.split("\\.")[1]);
				
				PreparedStatement preparedStatement = conexiune.prepareStatement("SELECT S.ID FROM PROFESORI S JOIN CONTURI C ON S.ID_CONT=C.ID WHERE C.USERNAME = UPPER( ? ) ");
				preparedStatement.setString(1, username);
				ResultSet result=preparedStatement.executeQuery();
				result.next();
				utilizator.setId(result.getInt(1));
				
				this.access = new AccessSecrBD( conexiune , utilizator);
			}
			
		}
		catch( Exception e )
		{
			System.out.println("Exceptie la createAccess: "+e.getMessage());
		}
		
	}
	
	@SuppressWarnings("unused")
	private int sendEmail( String adresa , String mesaj ) 
	{
		String from = "licente@info.uaic.ro";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "localhost");
		properties.setProperty("mail.user", "myuser");
		properties.setProperty("mail.password", "mypwd");
		Session session = Session.getDefaultInstance(properties);
		
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(adresa));
			message.setSubject("Licente Info UAIC");
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(mesaj);
			Transport.send(message);
		}
		catch ( Exception e )
		{
			System.out.println("Exceptie sendEmail: "+ e.getMessage());
			return -1;
		}
		
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
	
	public boolean isLoged(){
		return loged;
	}
	
	public boolean isConnected(){
		return connected;
	}
	
	public void setDomeniu( String domeniu ){
		this.domeniu=domeniu;
	}
	
	public AccessBD getAccess(){
		if (loged == false || connected ==false)
			return null;
		else
		return access;
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
			 
			 if( rezultat == 0 )
			 {	 
				 createAccess( username );
				 loged = true; 
			 }
			 else
				 loged = false;
			 
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
			
			//if(sendEmail( email, "Click pentru activare: "+ domeniu + "\\activate\\" + hashcod )==-1)
				//return -5;
			
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
