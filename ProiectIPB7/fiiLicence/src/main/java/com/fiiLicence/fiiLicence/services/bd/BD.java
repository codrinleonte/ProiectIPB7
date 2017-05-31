package com.fiiLicence.fiiLicence.services.bd;

import com.fiiLicence.fiiLicence.models.response.StudentGuidedListResponse;

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
<<<<<<< HEAD

    private boolean connected = false;
    private Connection conexiune;
    @SuppressWarnings("unused")
    private String domeniu = "";
    private AccessBD access;
    private boolean loged = false;

    private void createAccess(String username) {

        String apel = " { ? = call get_type( ? ) }";
        int rezultat;
        int idCont;


        try {
            Statement stmt = conexiune.createStatement();
            ResultSet rs = stmt.executeQuery("Select ID from CONTURI where username = '" + username + "'");
            rs.next();
            idCont = rs.getInt(1);
            CallableStatement statement = conexiune.prepareCall(apel);
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setString(2, username);
            statement.execute();
            rezultat = statement.getInt(1);

            if (rezultat == 0) {
                UserBD utilizator = new UserBD();
                utilizator.setId(0);
                utilizator.setTip("Admin");
                utilizator.setUsername("Admin");
                this.access = new AccessAdminBD(conexiune, utilizator);
                this.access.setIdCont(idCont);
            } else if (rezultat == 1) {
                UserBD utilizator = new UserBD();
                PreparedStatement statement2 = conexiune.prepareStatement("Select STUDENTI.ID FROM STUDENTI JOIN CONTURI on STUDENTI.ID_CONT=CONTURI.ID WHERE CONTURI.USERNAME=?");
                statement2.setString(1, username);
                ResultSet result = statement2.executeQuery();
                result.next();
                utilizator.setId(result.getInt(1));
                utilizator.setTip("Student");
                utilizator.setUsername(username);

                this.access = new AccessAdminBD(conexiune, utilizator);
                this.access.setIdCont(idCont);

            } else if (rezultat == 2) {
                UserBD utilizator = new UserBD();
                PreparedStatement statement2 = conexiune.prepareStatement("Select PROFESORI.ID FROM PROFESORI JOIN CONTURI on PROFESORI.ID_CONT=CONTURI.ID WHERE CONTURI.USERNAME=?");
                statement2.setString(1, username);
                ResultSet result = statement2.executeQuery();
                result.next();
                utilizator.setId(result.getInt(1));
                utilizator.setTip("Profesor");
                utilizator.setUsername(username);
                this.access = new AccessAdminBD(conexiune, utilizator);
                this.access.setIdCont(idCont);

            } else {
                UserBD utilizator = new UserBD();
                PreparedStatement statement2 = conexiune.prepareStatement("Select PROFESORI.ID FROM PROFESORI JOIN CONTURI on PROFESORI.ID_CONT=CONTURI.ID WHERE CONTURI.USERNAME=?");
                statement2.setString(1, username);
                ResultSet result = statement2.executeQuery();
                result.next();
                utilizator.setId(result.getInt(1));
                utilizator.setTip("Secretar");
                utilizator.setUsername(username);
                this.access = new AccessAdminBD(conexiune, utilizator);
                this.access.setIdCont(idCont);

            }

        } catch (Exception e) {
            System.out.println("Exceptie la createAccess: " + e.getMessage());
        }

    }

    @SuppressWarnings("unused")
    private int sendEmail(String adresa, String mesaj) {

        return 0;
    }

    public BD() {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.conexiune = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Licente", "ADMIN");
            this.connected = true;

        } catch (Exception e) {

            System.out.println("Exceptie la conectare: " + e.getMessage());
            this.connected = false;

        }
    }

    public boolean isLoged() {
        return loged;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setDomeniu(String domeniu) {
        this.domeniu = domeniu;
    }

    public AccessBD getAccess() {
        if (loged == false || connected == false)
            return null;
        else
            return access;
    }

    public int login(String username, String hashparola) {
        String apel = "{ ? = call login( ?, ? ) }";
        int rezultat;
        try {

            CallableStatement statement = conexiune.prepareCall(apel);
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setString(2, username);
            statement.setString(3, hashparola);
            statement.execute();
            rezultat = statement.getInt(1);

            if (rezultat == 0) {
                createAccess(username);
                loged = true;
            } else
                loged = false;

            return rezultat;
        } catch (Exception e) {
            System.out.println("Exceptie la login: " + e.getMessage());
            return -7;
        }

    }

    public IntrareConturi getContByToken(String token) {
        IntrareConturi cont = new IntrareConturi();
        try {
            Statement stmt = conexiune.createStatement();
            ResultSet rs = stmt.executeQuery("Select Count(*) from conturi where token='" + token + "'");
            rs.next();
            if (rs.getInt(1) == 0) {
                System.out.println("Intrare Inexistenta");
                return null;
            }

            Statement statement = conexiune.createStatement();
            ResultSet result = statement.executeQuery("Select * from conturi where token='" + token + "'");
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
        } catch (Exception e) {
            System.out.println("Exceptie la getContByToken: " + e.getMessage());
            return null;
        }

    }

    public int setTokenByIdCont(int id, String token) {
        try {
            Statement stmt = conexiune.createStatement();
            ResultSet rs = stmt.executeQuery("Select Count(*) from conturi where id=" + id);
            rs.next();
            if (rs.getInt(1) == 0) {
                System.out.println("Intrare Inexistenta");
                return -1;
            }

            Statement statement = conexiune.createStatement();
            statement.executeUpdate("UPDATE CONTURI SET Token = '" + token + "' Where id=" + id);
            return 0;
        } catch (Exception e) {
            System.out.println("Exceptie la setTokenByIdCont: " + e.getMessage());
            return 0;
        }
    }

    public int setTokenByIdCont(String email, String token) {
        try {
            Statement stmt = conexiune.createStatement();
            ResultSet rs = stmt.executeQuery("Select Count(*) from conturi where email= '" + email + "'");
            rs.next();
            if (rs.getInt(1) == 0) {
                System.out.println("Intrare Inexistenta");
                return -1;
            }

            Statement statement = conexiune.createStatement();
            statement.executeUpdate("UPDATE CONTURI SET Token = '" + token + "' Where email='" + email + "'");
            return 0;
        } catch (Exception e) {
            System.out.println("Exceptie la setTokenByIdCont: " + e.getMessage());
            return 0;
        }
    }


    public int verificare(String hashcod) {
        String apel = "{ ? = call verificare( ? ) }";
        int rezultat;
        try {

            CallableStatement statement = conexiune.prepareCall(apel);
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setString(2, hashcod);
            statement.execute();
            rezultat = statement.getInt(1);
            return rezultat;
        } catch (Exception e) {
            System.out.println("Exceptie la login: " + e.getMessage());
            return -7;
        }

    }

    public int inregistrare_stud(String email, String hashparola) {
        Random random;
        String hashcod;
        boolean unic;
        int rezultat = 0;

        try {
            String username = email.split("@")[0];
            if (!email.split("@")[1].equals("info.uaic.ro") || username.split("\\.")[0].equals(username))
                return -1;
        } catch (Exception e) {
            System.out.println("Email invalid inregistrare_stud: " + e.getMessage());
            return -1;
        }

        String apel = "SELECT COUNT(ID) FROM CONTURI WHERE COD_ACTIVARE='";

        do {
            random = new Random();
            unic = true;
            hashcod = "";
            for (int i = 0; i < 20; i++)
                hashcod = hashcod + random.nextInt(9);
            try {
                Statement statement = conexiune.createStatement();
                ResultSet resultSet = statement.executeQuery(apel + hashcod + "'");

                resultSet.next();
                if (resultSet.getInt(1) != 0)
                    unic = false;
            } catch (Exception e) {
                System.out.println("Exceptie la generare cod random la inregistrare_stud: " + e.getMessage());
                return -7;
            }
        } while (!unic);

        apel = "{ ? = call inregistrare_stud( ?, ?, ? ) }";
        try {
            CallableStatement statement = conexiune.prepareCall(apel);
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setString(2, email.split("@")[0]);
            statement.setString(3, hashparola);
            statement.setString(4, hashcod);
            statement.execute();
            rezultat = statement.getInt(1);

            //if(sendEmail( email, "Click pentru activare: "+ domeniu + "\\activate\\" + hashcod )==-1)
            //return -5;

            return rezultat;
        } catch (Exception e) {
            System.out.println("Exceptie la inregistrare_stud: " + e.getMessage());
            return -7;
        }
    }

    public int inregistrare_prof(String username, String hashparola) {
        String apel = " { ? = call inregistrare_prof( ? , ? ) }";
        int rezultat;
        try {
            CallableStatement statement = conexiune.prepareCall(apel);
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setString(2, username);
            statement.setString(3, hashparola);
            statement.execute();
            rezultat = statement.getInt(1);
            return rezultat;
        } catch (Exception e) {
            System.out.println("Exceptie inregistrare_prof: " + e.getMessage());
            return -7;
        }
    }

    private String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    public String getHas(String email, String password) {
        email.concat(password);
        return MD5(email);
    }

    // de implementat
    public int getNotaStudent(int idStudent) {
        int grade;
        IntrareDetaliiLicente intrare = new IntrareDetaliiLicente();
        try {

            Statement statement = conexiune.createStatement();
            ResultSet result = statement.executeQuery("Select * from detalii_licente");

            intrare.setId(result.getInt(1));
            intrare.setIdComisie(result.getInt(2));
            intrare.setNota1Oral(result.getInt(3));
            intrare.setNota1Proiect(result.getInt(4));
            intrare.setNota2Oral(result.getInt(5));
            intrare.setNota2Proiect(result.getInt(6));
            intrare.setNota3Oral(result.getInt(7));
            intrare.setNota3Proiect(result.getInt(8));
            intrare.setNota4Oral(result.getInt(9));
            intrare.setNota4Proiect(result.getInt(10));
            intrare.setNota5Oral(result.getInt(11));
            intrare.setNota5Proiect(result.getInt(12));
            intrare.setDataOraSustinerii(result.getTimestamp(13));
        } catch (Exception e) {
            System.out.println("Exceptie la selectDetaliiLicente: " + e.getMessage());
        }


        return 0;
    }

    public IntrareStudenti selectStudentByIdCont(int idCont) {
        String apel = " Select * from studenti where id_cont = ? ";
        try {
            PreparedStatement statement = conexiune.prepareStatement(apel);
            statement.setInt(1, idCont);
            ResultSet result = statement.executeQuery();
            IntrareStudenti intrare = new IntrareStudenti();


            while (result.next()) {
                intrare.setId(result.getInt(1));
                intrare.setIdCont(result.getInt(2));
                intrare.setNrMatricol(result.getString(3));
                intrare.setNume(result.getString(4));
                intrare.setPrenume(result.getString(5));
                intrare.setId_comisie(result.getInt(6));
                intrare.setIdSesiune(result.getInt(7));

            }
            return intrare;
        } catch (Exception e) {
            System.out.println("Exceptie la selectStudenti:" + e.getMessage());
            return null;
        }
    }


    //15.functie : luam toti studentii in functie de un profesor

    public List<StudentGuidedListResponse> getStudentsOfATeacher(int idTeacher) {
        List<StudentGuidedListResponse> result_return = new ArrayList<>();
        String apel = "select distinct st.id,st.nume,st.prenume,d.NOTA_1_ORAL,d.NOTA_2_ORAL,d.NOTA_3_ORAL,d.NOTA_4_ORAL_DIZERTATIE,d.NOTA_1_proiect,d.NOTA_2_proiect,d.NOTA_3_proiect,d.NOTA_4_PROIECT_DIZERTATIE  from detalii_licente d join comisii c on d.id_comisie=c.id join evaluari e on e.id_comisie=c.id join sesiuni s on s.id=e.id_sesiune join studenti st on s.id=st.id_sesiune join profesori p on p.ID_COMISIE=c.id where p.id= ?";

        try {

            PreparedStatement statement = conexiune.prepareStatement(apel);
            statement.setInt(1, idTeacher);
            ResultSet result = statement.executeQuery();
            System.out.println("ceao marocanii " + result.getFetchSize());
            while (result.next()) { //something wrong i do, but i don't know what :(
                int nrProjectMarks = 4;
                int nrOralMarks = 4;
                StudentGuidedListResponse student = new StudentGuidedListResponse();
                IntrareDetaliiLicente det = new IntrareDetaliiLicente();
                //if(result.wasNull())
                //{
                student.setIdStudent(result.getInt(1));
                //}
                student.setNumeStudent(result.getString(2));
                student.setPrenumStudent(result.getString(3));
                student.setNota1oral(result.getInt(4));
                student.setNota2oral(result.getInt(5));
                student.setNota3oral(result.getInt(6));
                student.setNota4oral(result.getInt(7));
                student.setNota1project(result.getInt(8));
                student.setNota2project(result.getInt(9));
                student.setNota3project(result.getInt(10));
                student.setNota4project(result.getInt(11));
                Double project = 0.0;
                Double oral = 0.0;
                // project =
                project = (double) (student.getNota1project() + student.getNota2project() + student.getNota3project() + student.getNota4project());
                oral = (double) (student.getNota1oral() + student.getNota2oral() + student.getNota3oral() + student.getNota4oral());
                student.setNotaFinala(Math.floor((Math.floor(project / nrProjectMarks * 100) / 100 + Math.floor(oral / nrOralMarks * 100) / 100) / 2.0 * 100) / 100.0);
                result_return.add(student);
            }
            return result_return;
        } catch (Exception e) {
            System.out.println("Exceptie la obtinerea studentilor: " + e.getMessage());
            return null;
        }

        //inca nu e functionala functia asta, nu imi dau seama de ce nu-mi intra in while...

    }


    //16.functie: un profesor poate sa adauge un student

    public int getIdStudentByName(String numeStudent, String prenumeStudent) {
        String apelSelect = "Select id from studenti where nume = ? and prenume = ?";
        int idStudent = 0;
        try {
            PreparedStatement statementSelect = conexiune.prepareStatement(apelSelect);
            statementSelect.setString(1, numeStudent);
            statementSelect.setString(2, prenumeStudent);
            ResultSet result = statementSelect.executeQuery();
            while (result.next()) {
                idStudent = result.getInt(1);
            }
            return idStudent;
        } catch (Exception e) {
            System.out.println("Exceptie la obtinerea studentilor: " + e.getMessage());
            return 0;
        }
    }

    public boolean addStudent(int idTeacher, String numeStudent, String prenumeStudent) {
        String apel = " Update licente set ID_PROFESOR = ? where  ID_STUDENT = ? ";
        int idStudent = getIdStudentByName(numeStudent, prenumeStudent);
        try {
            PreparedStatement statement = conexiune.prepareStatement(apel);
            statement.setInt(1, idTeacher);
            statement.setInt(2, idStudent);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Exceptie la obtinerea studentilor: " + e.getMessage());
            return false;
        }
    }


    //17.functie:un profesor poate scoate un student din lista sa

    public boolean removeStudent(int idTeacher, int idStudent) {
        String apel = " Update licente set ID_PROFESOR = null where ID_Profesor = ? and id_student = ? ";
        try {

            PreparedStatement statement = conexiune.prepareStatement(apel);
            statement.setInt(1, idTeacher);
            statement.setInt(2, idStudent);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Exceptie la obtinerea studentilor: " + e.getMessage());
            return false;
        }
    }

    //18. functie: se poate edita data de examinare a unei comisii
    public boolean editExaminationDate(int idComisie, String beginDate, String endDate) {
        String apel = "update  evaluari e set e.INCEPUT_EVALUARE=to_date(?),e.sfarsit_evaluare=to_date(?)where e.id_comisie=?";
        try {

            PreparedStatement statement = conexiune.prepareStatement(apel);
            statement.setString(1, beginDate);
            statement.setString(2, endDate);
            statement.setInt(3, idComisie);
            statement.executeQuery();

            return true;
        } catch (Exception e) {
            System.out.println("Exceptie la obtinerea studentilor: " + e.getMessage());
            return false;
        }
    }


    //15 inca nu e functionala, iar 19 si 20 le pun cand e gata si baza de date
=======
	
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

	public List<StudentGuidedListResponse> getStudentsOfATeacher(int idTeacher){
		List<StudentGuidedListResponse> result_return = new ArrayList<>();
		String apel = "select distinct st.id,st.nume,st.prenume,d.NOTA_1_ORAL,d.NOTA_2_ORAL,d.NOTA_3_ORAL,d.NOTA_4_ORAL_DIZERTATIE,d.NOTA_1_proiect,d.NOTA_2_proiect,d.NOTA_3_proiect,d.NOTA_4_PROIECT_DIZERTATIE  from detalii_licente d join comisii c on d.id_comisie=c.id join evaluari e on e.id_comisie=c.id join sesiuni s on s.id=e.id_sesiune join studenti st on s.id=st.id_sesiune join profesori p on p.ID_COMISIE=c.id where p.id= ?";

		try{

			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1, idTeacher);
			ResultSet result  =statement.executeQuery();
			System.out.println("ceao marocanii "+result.getFetchSize());
			while(result.next()){ //something wrong i do, but i don't know what :(
				int nrProjectMarks=4;
				int nrOralMarks=4;
				StudentGuidedListResponse  student = new StudentGuidedListResponse();
				IntrareDetaliiLicente det = new IntrareDetaliiLicente();
				//if(result.wasNull())
				//{
				student.id_stud=result.getInt(1);
				//}
				student.nume_stud= result.getString(2);
				student.prenume_stud= result.getString(3);
				student.nota1oral=result.getInt(4);
				student.nota2oral=result.getInt(5);
				student.nota3oral=result.getInt(6);
				student.nota4oral=result.getInt(7);
				student.nota1project=result.getInt(8);
				student.nota2project=result.getInt(9);
				student.nota3project=result.getInt(10);
				student.nota4project=result.getInt(11);
				  Double project = 0.0;
			      Double oral    = 0.0;
			     // project = 
				
		
				project =(double) (student.nota1project+student.nota2project+student.nota3project+student.nota4project);
				oral =(double) (student.nota1oral+student.nota2oral+student.nota3oral+student.nota4oral);
				student.nota_finala = Math.floor((Math.floor(project/nrProjectMarks * 100) / 100 + Math.floor(oral/nrOralMarks * 100) / 100) / 2.0 * 100) / 100.0;
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


	//18. functie: se poate edita data de examinare a unei comisii
	
	public boolean editExaminationDate(int idComisie,String beginDate,String endDate)
	{
		String apel = "update  evaluari e set e.INCEPUT_EVALUARE=to_date(?),e.sfarsit_evaluare=to_date(?)where e.id_comisie=?";
		try{

			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setString(1, beginDate);
			statement.setString(2, endDate);
			statement.setInt(3, idComisie);
			statement.executeQuery();

			return true;
		}
		catch( Exception e ){
			System.out.println("Exceptie la obtinerea studentilor: "+e.getMessage());
			return false;
		}
	}
	
	//19.functie: obtinem toti studentii cu notele lor finale
	
	public List<StundetListPageResponse> getStudentsMarks(){
	List<StundetListPageResponse>studenti = new ArrayList<>();
	
	String apel = "select s.nume,s.prenume,d.NOTA_1_ORAL,d.NOTA_2_ORAL,d.NOTA_3_ORAL,d.NOTA_4_ORAL_DIZERTATIE,d.NOTA_5_ORAL_COORDONATOR,d.NOTA_1_proiect,d.NOTA_2_proiect,d.NOTA_3_proiect,d.NOTA_4_PROIECT_DIZERTATIE,d.NOTA_5_PROIECT_COORDONATOR from detalii_licente d join licente l on d.id=l.id join studenti s on s.ID=l.ID_STUDENT";
	try{
      
		
		PreparedStatement statement = conexiune.prepareStatement(apel);
		ResultSet result  =statement.executeQuery();
		
		Vector<Integer>notePosibile = new Vector<>();
		
		notePosibile.add(1);notePosibile.add(2);notePosibile.add(3);notePosibile.add(4);
		notePosibile.add(5);notePosibile.add(6);notePosibile.add(7);notePosibile.add(8);
		notePosibile.add(9);notePosibile.add(10);
		
		while(result.next()){ 
			  int nrNoteOral = 0;
		      int nrNoteProiect = 0;
				Vector<Integer>noteOral = new Vector<>();
				Vector<Integer>noteProiect = new Vector<>();
			StundetListPageResponse student = new StundetListPageResponse();
			student.numeStudent = result.getString(1);
			System.out.println(result.getString(1));
			student.prenumeStudent= result.getString(2);
			if(notePosibile.contains(result.getInt(3))){
				noteOral.add(result.getInt(3));
				nrNoteOral = nrNoteOral + 1;
			}
			if(notePosibile.contains(result.getInt(4))){
				noteOral.add(result.getInt(4));
				nrNoteOral = nrNoteOral + 1;
			}
			if(notePosibile.contains(result.getInt(5))){
				noteOral.add(result.getInt(5));
				nrNoteOral = nrNoteOral + 1;
			}
			if(notePosibile.contains(result.getInt(6))){
				noteOral.add(result.getInt(6));
				nrNoteOral = nrNoteOral + 1;
			}
			if(notePosibile.contains(result.getInt(7))){
				noteOral.add(result.getInt(7));
				nrNoteOral = nrNoteOral + 1;
			}
			if(notePosibile.contains(result.getInt(8))){
				noteProiect.add(result.getInt(8));
				nrNoteProiect = nrNoteProiect + 1;
			}
			if(notePosibile.contains(result.getInt(9))){
				noteProiect.add(result.getInt(9));
				nrNoteProiect = nrNoteProiect + 1;
			}
			if(notePosibile.contains(result.getInt(10))){
				noteProiect.add(result.getInt(10));
				nrNoteProiect = nrNoteProiect + 1;
			}
			if(notePosibile.contains(result.getInt(11))){
				noteProiect.add(result.getInt(11));
				nrNoteProiect = nrNoteProiect + 1;
			}
			if(notePosibile.contains(result.getInt(12))){
				noteProiect.add(result.getInt(12));
				nrNoteProiect = nrNoteProiect + 1;
			}
		
			  Double project = 0.0;
		      Double oral    = 0.0;
		    
			
	         for (Integer notaPrj : noteProiect) {
				project = project + (double)notaPrj;
			}
	         for (Integer notaOrl : noteProiect) {
					project = project + (double)notaOrl;
			}
	         
			
			student.notaFinala= Math.floor((Math.floor(project/nrNoteProiect * 100) / 100 + Math.floor(oral/nrNoteOral * 100) / 100) / 2.0 * 100) / 100.0;
			studenti.add(student);
		}
		return studenti;
	}
	catch( Exception e ){
		System.out.println("Exceptie la obtinerea notelor studentilor: "+e.getMessage());
		return null;
	}

	
	}
	
	//20. functie: obtinem distributia pe sali a studentilor
	
	public List<DistributionOnHallsResponse>getDistributionOnHalls(){
		List<DistributionOnHallsResponse>distribution = new ArrayList<>();
		String apel = "select distinct s.nume,s.prenume,e.sala,c.id,to_char(d.DATA_ORA_SUSTINERE, 'HH24:MI'),to_char(d.DATA_ORA_SUSTINERE + (.000694 * 21), 'HH24:MI')";
		apel =apel+"from studenti s join comisii c on c.id=s.id_comisie join evaluari e on e.id_comisie=c.id join detalii_licente d on d.ID_COMISIE=c.id";
		try{

			PreparedStatement statement = conexiune.prepareStatement(apel);
			ResultSet result  =statement.executeQuery();
			while(result.next()){ 
			
				DistributionOnHallsResponse hall = new DistributionOnHallsResponse();
				hall.numeStudent=result.getString(1);
				hall.prenumeStudent=result.getString(2);
				hall.sala=result.getString(3);
				hall.idComisie=result.getInt(4);
				hall.oraDeInceput=result.getString(5);
				hall.oraDeSfarsit=result.getString(6);
		        distribution.add(hall);
			}
			return distribution;
		}
		catch( Exception e ){
			System.out.println("Exceptie la obtinerea studentilor: "+e.getMessage());
			return null;
		}
	}
	
	
	
}

