package com.fiiLicence.fiiLicence.services.bd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
				UserBD utilizator = new UserBD();
				utilizator.setId(0);
				utilizator.setTip("Admin");
				utilizator.setUsername("Admin");
				this.access = new AccessAdminBD( conexiune , utilizator );
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
				
				this.access = new AccessAdminBD(conexiune,utilizator);
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
				this.access = new AccessAdminBD(conexiune,utilizator);
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
				this.access = new AccessAdminBD(conexiune,utilizator);
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

	//15.functie : luam toti studentii in functie de un profesor

	public List<IntrareStudenti> getStudentsOfATeacher(int idTeacher){
		List<IntrareStudenti>result_return = new ArrayList<>();
		String apel = "select distinct st.id,st.nume,st.prenume,d.NOTA_1_ORAL,d.NOTA_2_ORAL,d.NOTA_3_ORAL,d.NOTA_4_ORAL_DIZERTATIE,d.NOTA_1_proiect,d.NOTA_2_proiect,d.NOTA_3_proiect,d.NOTA_4_PROIECT_DIZERTATIE  from detalii_licente d join comisii c on d.id_comisie=c.id join evaluari e on e.id_comisie=c.id join sesiuni s on s.id=e.id_sesiune join studenti st on s.id=st.id_sesiune join profesori p on p.ID_COMISIE=c.id where p.id= ?";

		try{

			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1, idTeacher);
			ResultSet result  =statement.executeQuery();
			System.out.println("ceao marocanii "+result.getFetchSize());
			while(result.next()){ //something wrong i do, but i don't know what :(
				System.out.println("ceao marocanii");
				IntrareStudenti student = new IntrareStudenti();
				IntrareDetaliiLicente det = new IntrareDetaliiLicente();
				student.setId(result.getInt(1));
				System.out.println("id este: "+result.getInt(1));
				student.setNume(result.getString(2));
				student.setPrenume(result.getString(3));
				det.setNota1Oral(result.getInt(4));
				det.setNota2Oral(result.getInt(5));
				det.setNota3Oral(result.getInt(6));
				det.setNota4Oral(result.getInt(7));
				det.setNota1Proiect(result.getInt(8));
				det.setNota2Proiect(result.getInt(9));
				det.setNota3Proiect(result.getInt(10));
				det.setNota4Proiect(result.getInt(11));
				student.setDetaliiLicenta(det);

				result_return.add(student);
			}
			return result_return;
		}
		catch( Exception e ){
			System.out.println("Exceptie la obtinerea studentilor: "+e.getMessage());
			return null;
		}

		//inca nu e functionala functia asta, nu imi dau seama de ce nu-mi intra in while...

	}



	//16.functie: un profesor poate sa adauge un student

	public boolean addStudent(int idTeacher,String numeStud,String prenumeStud){
		int idLicenta=0;
		int idStud=0;
		int idSes=0;
		String apel = "select id,id_sesiune from studenti where nume=? and prenume=?";
		try{

			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setString(1, numeStud);
			statement.setString(2, prenumeStud);
			ResultSet result =statement.executeQuery();


			if(result.next()){

				idStud=result.getInt(1);
				idSes=result.getInt(2);
				System.out.println(idStud);
				System.out.println(idSes);

			}
			if(idStud==0 && idSes==0)// verificam daca exista studentul in baza de date;
				return false;

			String apel2="select max(id) from licente";
			PreparedStatement statement2 = conexiune.prepareStatement(apel2);
			ResultSet result2 =statement2.executeQuery();


			if(result2.next()){

				idLicenta=result2.getInt(1)+1;
				System.out.println(idLicenta);

			}
			System.out.println(idLicenta);
			System.out.println(idStud);
			System.out.println(idSes);
			String apel3="insert into licente(id,id_profesor,id_student,id_sesiune) values(?,?,?,?)";
			PreparedStatement statement3 = conexiune.prepareStatement(apel3);
			statement3.setInt(1, idLicenta);
			statement3.setInt(2, idTeacher);
			statement3.setInt(3, idStud);
			statement3.setInt(4, idSes);
			statement3.executeUpdate();




			return true;
		}
		catch( Exception e ){
			System.out.println("Exceptie la obtinerea studentilor: "+e.getMessage());
			return false;
		}
	}


	//17.functie:un profesor poate scoate un student din lista sa

	public boolean removeStudent(int idTeacher,int idStudent){
		String apel = "delete from licente where ID_PROFESOR=? and ID_STUDENT=?";
		try{

			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1, idTeacher);
			statement.setInt(2, idStudent);
			statement.executeUpdate();

			return true;
		}
		catch( Exception e ){
			System.out.println("Exceptie la obtinerea studentilor: "+e.getMessage());
			return false;
		}
	}


	//18,19 si 20 urmeaza sa le fac :) ( RAZVAN )
}

