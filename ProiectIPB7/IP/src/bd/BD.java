package bd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.Random;


public class BD {

	private boolean    connected = false;
	private Connection conexiune;
	@SuppressWarnings("unused")
	private String     domeniu="";
	private AccessBD   access;

	private void createAccess( String username ){

		String apel = " { ? = call get_type( ? ) }";
		int rezultat;
		int idCont;

		try {

			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select ID from CONTURI where username = '"+username+"'");
			rs.next();
			idCont=rs.getInt(1);

			CallableStatement statement = conexiune.prepareCall(apel);
			statement.registerOutParameter(1, Types.INTEGER);
			statement.setString(2, username);
			statement.execute();
			rezultat=statement.getInt(1);

			if( rezultat==0 )
			{
				UserBD utilizator = new UserBD();
				utilizator.setId(0);
				utilizator.setTip("Admin");
				utilizator.setUsername("Admin");
				this.access = new AccessAdminBD( conexiune , utilizator );
				this.access.setIdCont(idCont);
			}
			else if ( rezultat == 1 )
			{
				UserBD utilizator = new UserBD();
				PreparedStatement statement2 = conexiune.prepareStatement("Select STUDENTI.ID FROM STUDENTI JOIN CONTURI on STUDENTI.ID_CONT=CONTURI.ID WHERE CONTURI.USERNAME=?");
				statement2.setString(1, username);
				ResultSet result = statement2.executeQuery();
				result.next();
				utilizator.setId(result.getInt(1));
				utilizator.setTip("Student");
				utilizator.setUsername(username);

				this.access = new AccessStudentBD(conexiune,utilizator);
				this.access.setIdCont(idCont);
			}
			else if ( rezultat == 2 )
			{
				UserBD utilizator = new UserBD();
				PreparedStatement statement2 = conexiune.prepareStatement("Select PROFESORI.ID FROM PROFESORI JOIN CONTURI on PROFESORI.ID_CONT=CONTURI.ID WHERE CONTURI.USERNAME=?");
				statement2.setString(1, username);
				ResultSet result = statement2.executeQuery();
				result.next();
				utilizator.setId(result.getInt(1));
				utilizator.setTip("Profesor");
				utilizator.setUsername(username);
				this.access = new AccessProfesorBD(conexiune,utilizator);
				this.access.setIdCont(idCont);
			}
			else
			{
				UserBD utilizator = new UserBD();
				PreparedStatement statement2 = conexiune.prepareStatement("Select PROFESORI.ID FROM PROFESORI JOIN CONTURI on PROFESORI.ID_CONT=CONTURI.ID WHERE CONTURI.USERNAME=?");
				statement2.setString(1, username);
				ResultSet result = statement2.executeQuery();
				result.next();
				utilizator.setId(result.getInt(1));
				utilizator.setTip("Secretar");
				utilizator.setUsername(username);
				this.access = new AccessSecretarBD(conexiune,utilizator);
				this.access.setIdCont(idCont);
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

	public IntrareConturi getContByToken( String token )
	{
		IntrareConturi cont = new IntrareConturi();
		try{
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from conturi where token='"+token+"'");
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return null;
			}

			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from conturi where token='"+token+"'");
			result.next();
			cont.setId(result.getInt(1));
			cont.setUsername(result.getString(2));
			cont.setHashparola(result.getString(3));
			cont.setEmail(result.getString(4));
			cont.setTipUtilizator(result.getString(5));
			cont.setStatus(result.getInt(6));
			cont.setCodActivare(result.getString(7));
			cont.setToken(result.getString(8));
			return cont;

		}
		catch( Exception e ){
			System.out.println("Exceptie la getContByToken: "+e.getMessage());
			return null;
		}

	}

	public int setTokenByIdCont( int id , String token )
	{
		try{
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from conturi where id="+id);
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}

			Statement statement=conexiune.createStatement();
			statement.executeUpdate("UPDATE CONTURI SET Token = '"+token+"' Where id="+id);
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la setTokenByIdCont: "+e.getMessage());
			return 0;
		}
	}

	public AccessBD login ( String username, String hashparola )
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
				 return this.access;
			 }
			 else
				 return null;
			 
		}
		catch(Exception e){
			System.out.println("Exceptie la login: "+e.getMessage());
			return null;
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
