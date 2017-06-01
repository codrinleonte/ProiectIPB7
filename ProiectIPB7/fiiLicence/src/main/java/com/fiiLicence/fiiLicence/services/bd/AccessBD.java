package com.fiiLicence.fiiLicence.services.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AccessBD {

    protected int idCont;
    protected String tip;
    protected UserBD user;
    protected Connection conexiune;

    public AccessBD() {

    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getTip() {
        return tip;
    }

    public void setIdCont(int idCont) {
        this.idCont = idCont;
    }

    public int getIdCont() {
        return idCont;
    }

    public UserBD getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "AccessBD [idCont=" + idCont + ", tip=" + tip + ", user=" + user + ", conexiune=" + conexiune + "]";
    }
    /*
      * functie care returneaza o istanta
      * IntrareComisii cu atributele corespunzatoare
      * id-ului dat ca parametru
     */
    

    public List<IntrareProfesori> selectProfesori(){
		List<IntrareProfesori> rezultat = new ArrayList<IntrareProfesori>();
		Statement statement = null;
		try{
			statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from profesori"); 
			while(result.next()){
				IntrareProfesori intrare = new IntrareProfesori();
				intrare.setId(result.getInt(1));
				intrare.setIdCont(result.getInt(2));
				intrare.setNume(result.getString(3));
				intrare.setPrenume(result.getString(4));
				intrare.setGradDidactic(result.getString(5));
				intrare.setFunctieComisie(result.getString(6));
				rezultat.add(intrare);
			}
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectProfesori :"+e.getMessage());
			return null;
		}	
		finally {
		try {
			if (statement != null)
				statement.close();

		}

		catch (SQLException se) {
			System.out.println("Oups .. " + se);

		}

	}

	}
    
    public List<IntrareProfesori> getProfesorsWithoutCommittee() {
        List<IntrareProfesori> rezultat = new ArrayList<IntrareProfesori>();
    	Statement statement = null;
        try {
            statement = conexiune.createStatement();
            ResultSet result = statement.executeQuery("select * from profesori p join Licente l on p.id = l.id_profesor  join  DETALII_LICENTE  d on L.id = d.id where d.id_comisie is null ");
            while (result.next()) {
                IntrareProfesori intrare = new IntrareProfesori();
                intrare.setId(result.getInt(1));
                intrare.setIdCont(result.getInt(2));
                intrare.setNume(result.getString(3));
                intrare.setPrenume(result.getString(4));
                intrare.setGradDidactic(result.getString(5));
                intrare.setFunctieComisie(result.getString(7));
                rezultat.add(intrare);
            }
            return rezultat;
        } catch (Exception e) {
            System.out.println("Exceptie la getProfesorsWithoutCommittee :" + e.getMessage());
            return null;
        }
        finally {
    		try {
    			if (statement != null)
    				statement.close();

    		}

    		catch (SQLException se) {
    			System.out.println("Oups .. " + se);

    		}

    	}
    }
    
    public int updateComisie( IntrareComisii intrare ){
		if(intrare.getId()==0) return -1;
		String apel=" Update comisii set ID_Prof1 = ? , ID_Prof2 = ? , ID_Prof3 =?, ID_Prof4_Dizertatie = ?, ID_Secretar = ?, Tip_Comisie = ?, ID_Evaluare = ? where id = ? ";
		Statement stmt = null;
		PreparedStatement statement = null;
		try{
	
			stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from comisii where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			statement = conexiune.prepareStatement(apel);
			statement.setInt(1, intrare.getIdProfSef());
			statement.setInt(2, intrare.getIdProf2());
			statement.setInt(3, intrare.getIdProf3());
			statement.setInt(4, intrare.getIdProf4());
			statement.setInt(5, intrare.getIdSecretar());
			statement.setString(6, intrare.getTipComisie());
			statement.setInt(7, intrare.getIdEvaluare());
			statement.setInt(8, intrare.getId());
			statement.executeUpdate();	
			conexiune.commit();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateComisie" + e.getMessage());
			return -7;
		}
		
	}
	
	public int updateEvaluare( IntrareEvaluari intrare ){
		if(intrare.getId()==0) return -1;
		String apel=" Update evaluari set id_sesiune = ?, id_comisie = ?, inceput_evaluare = ?, sfarsit_evaluare = ? , sala =? where id = ? ";
		Statement stmt = null;
		PreparedStatement statement=null;
		try{
			
			stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from evaluari where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
		    statement = conexiune.prepareStatement(apel);
			statement.setInt(1, intrare.getIdSesiune());
			statement.setInt(2, intrare.getIdComisie());
			statement.setTimestamp(3, intrare.getInceputEvaluare());
			statement.setTimestamp(4, intrare.getSfarsitEvaluare());
			statement.setInt(5, intrare.getId());
			statement.setString(6, intrare.getSala());
			statement.executeUpdate();
			conexiune.commit();
			
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateEvaluare" + e.getMessage());
			return -7;
		}	
		finally {
			try {
				if (stmt != null)
					stmt.close();
				if (statement != null)
					statement.close();

			}

			catch (SQLException se) {
				System.out.println("Oups .. " + se);

			}

		}
	}
    
    
    //------------------------------Secratary Rights------------------------------------
    
	
	public IntrareComisii getCommitteByProf(int idProf){
		 IntrareComisii intrare = new IntrareComisii();
		 PreparedStatement pStatement = null;
			try{		
				
				pStatement = conexiune.prepareStatement("select * from comisii c join profesori p on c.id = p.id_comisie where p.id = ?");
				pStatement.setInt(1, idProf);
				ResultSet result = pStatement.executeQuery(); 
				if(result.next()){
					
					intrare.setId(result.getInt(1));
					intrare.setIdProfSef(result.getInt(2));
					intrare.setIdProf2(result.getInt(3));
					intrare.setIdProf3(result.getInt(4));
					intrare.setIdProf4(result.getInt(5));
					intrare.setIdSecretar(result.getInt(6));
					intrare.setTipComisie(result.getString(7));
					intrare.setIdEvaluare(result.getInt(8));	
					
				}
				return intrare;
				
			}
			catch( SQLException e ){
				System.out.println("Exceptie la selectComisii: " + e.getMessage());
				return null;
			}
			finally {
				try {
					
					if (pStatement != null)
						pStatement.close();

				}

				catch (SQLException se) {
					System.out.println("Oups .. " + se);

				}

			}
			
		}
	

	public IntrareComisii getCommitteByStudent(int idStudent){
		 IntrareComisii intrare = new IntrareComisii();
		 PreparedStatement pStatement = null;
			try{		
				pStatement = conexiune.prepareStatement("select * from comisii c join studenti s on c.id = s.id_comisie where s.id = ?");
				pStatement.setInt(1, idStudent);
				ResultSet result = pStatement.executeQuery(); 
				if(result.next() && result!=null){
					
					intrare.setId(result.getInt(1));
					intrare.setIdProfSef(result.getInt(2));
					intrare.setIdProf2(result.getInt(3));
					intrare.setIdProf3(result.getInt(4));
					intrare.setIdProf4(result.getInt(5));
					intrare.setIdSecretar(result.getInt(6));
					intrare.setTipComisie(result.getString(7));
					intrare.setIdEvaluare(result.getInt(8));	
						
				}
				return intrare;
				
			}
			catch( Exception e ){
				System.out.println("Exceptie la selectComisii: "+e.getMessage());
				return null;
			}
			finally {
				try {
					
					if (pStatement != null)
						pStatement.close();

				}

				catch (SQLException se) {
					System.out.println("Oups .. " + se);

				}

			}
		}
	
	
	public IntrareComisii getCommitteeById(int idCommittee) {
        IntrareComisii rezultat = new IntrareComisii();
        PreparedStatement statement=null;
        try {
            statement = conexiune.prepareStatement("Select * from comisii where id = ?");
            statement.setInt(1, idCommittee);
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                rezultat.setId(result.getInt(1));
                rezultat.setIdProfSef(result.getInt(2));
                rezultat.setIdProf2(result.getInt(3));
                rezultat.setIdProf3(result.getInt(4));
                rezultat.setIdProf4(result.getInt(5));
                rezultat.setIdSecretar(result.getInt(6));
                rezultat.setTipComisie(result.getString(7));
                rezultat.setIdEvaluare(result.getInt(8));
            }
            return rezultat;
            
        } catch (SQLException e) {
            System.out.println("Exceptie la selectComisii: " + e.getMessage());
            return null;
        }
        finally {
			try {
				if (statement != null)
					statement.close();

			}

			catch (SQLException se) {
				System.out.println("Oups .. " + se);

			}

		}

    }
	
	
	public IntrareProfesori getProfesorById(int idProf) {
		IntrareProfesori intrare = new IntrareProfesori();
		Statement statement=null;
		try{
			statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from profesori"); 
			while(result.next()){
				
				intrare.setId(result.getInt(1));
				intrare.setIdCont(result.getInt(2));
				intrare.setNume(result.getString(3));
				intrare.setPrenume(result.getString(4));
				intrare.setGradDidactic(result.getString(5));
				intrare.setFunctieComisie(result.getString(6));
				
			}
			return intrare;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectProfesori :"+e.getMessage());
			return null;
		}
		finally {
			try {
				if (statement != null)
					statement.close();

			}

			catch (SQLException se) {
				System.out.println("Oups .. " + se);

			}

		}

    }
	
	
	public List<IntrareStudenti> getStudentsByCommitte(int idCommitte){
		List<IntrareStudenti> listaStudenti = new ArrayList<IntrareStudenti>();
		PreparedStatement statement = null;
		try{
				statement=conexiune.prepareStatement("Select * from studenti where id_comisie = ?");
				statement.setInt(1,idCommitte);
				ResultSet result   =statement.executeQuery();
				
				while(result.next()){
					IntrareStudenti intrare = new IntrareStudenti();
					intrare.setId(result.getInt(1));
					intrare.setIdCont(result.getInt(2));
					intrare.setNrMatricol(result.getString(3));
					intrare.setNume(result.getString(4));
					intrare.setPrenume(result.getString(5));
					intrare.setId_comisie(result.getInt(6));
					intrare.setIdSesiune(result.getInt(7));
					listaStudenti.add(intrare);
				}
				return listaStudenti;
			}
		catch( Exception e ){
				System.out.println("Exceptie la selectStudenti:"+e.getMessage());
				return null;
			}	
		
		finally {
			try {
				if (statement != null)
					statement.close();

			}

			catch (SQLException se) {
				System.out.println("Oups .. " + se);

			}

		}
	}
	
	//--------------------------------------------------------------------------------
	

	
	//---------------------------------Profesor Access------------------------
	
	public int getProfIndex(int idProf, int idCommitte){
		 
		 IntrareComisii rezultat = new IntrareComisii();
		 PreparedStatement statement = null;
		try{
				statement=conexiune.prepareStatement("Select * from comisii where id = ?");
				statement.setInt(1,idCommitte);
				ResultSet result   =statement.executeQuery();
				
				while(result.next()){

					rezultat.setId(result.getInt(1));
					rezultat.setIdProfSef(result.getInt(2));
					rezultat.setIdProf2(result.getInt(3));
					rezultat.setIdProf3(result.getInt(4));
					rezultat.setIdProf4(result.getInt(5));
					rezultat.setIdSecretar(result.getInt(6));
					rezultat.setTipComisie(result.getString(7));
					rezultat.setIdEvaluare(result.getInt(8));	
					
				}
				
			}
			catch( Exception e ){
				System.out.println("Exceptie la selectStudenti:"+e.getMessage());
				return 0;
			}	
		finally {
			try {
				if (statement != null)
					statement.close();

			}

			catch (SQLException se) {
				System.out.println("Oups .. " + se);

			}

		}
		
		if(rezultat.getIdProfSef()==idProf){
			return 1;
		 }
		else if(rezultat.getIdProf2()==idProf){
			return 2;
		 }
		else if(rezultat.getIdProf3()==idProf){
			return 3;
		 }
		else if(rezultat.getIdProf4()==idProf){
			return 4;
		 }
		else 
			return 0;
		 
	}

	
	public boolean updateNotaStudent(int indexProf, int idStudent, int tipExamen,int notaOral, int notaProiect){
		if(tipExamen == 1 && (indexProf !=1 && indexProf !=2 && indexProf !=3 &&  indexProf !=5)){
			
			return false;
	
		}
		else if(tipExamen == 2 && (indexProf !=1 && indexProf !=2 && indexProf !=3 && indexProf !=4 && indexProf !=5)){
			
			return false;
		}
		
		PreparedStatement statement = null;
		try{
		statement = conexiune.prepareStatement("Select id from licente where id_student = ?");
		statement.setInt(1,idStudent);
		ResultSet result =statement.executeQuery();
		result.next();
		

		int idLicenta = result.getInt(1);
		
		
		if(indexProf !=5 ){
			PreparedStatement statement2 = conexiune.prepareStatement(" update DETALII_LICENTE  set nota_"+indexProf+"_oral = ?,nota_"+indexProf+"_proiect = ? where id = ? ");
			statement2.setInt(1,notaOral);
			statement2.setInt(2,notaProiect);
			statement2.setInt(3,idLicenta);
			statement2.executeUpdate();
			return true;
		}
		
		else {
			PreparedStatement statement2 = conexiune.prepareStatement(" update DETALII_LICENTE  set nota_"+indexProf+"_oral_coordonator = ?,nota_"+indexProf+"_proiect_coordonator = ? where id = ? ");
			statement2.setInt(1,notaOral);
			statement2.setInt(2,notaProiect);
			statement2.setInt(3,idLicenta);
			statement2.executeUpdate();
			return true;
		}
		
		}
		catch( Exception e ){
			System.out.println("Exceptie la update nota:"+e.getMessage());
			return false;
		}
		
		finally {
			try {
				if (statement != null)
					statement.close();

			}

			catch (SQLException se) {
				System.out.println("Oups .. " + se);

			}

		}
		
		
	}
	

	public boolean moveProfToCommitte(int idProf, int idCommitte ){
	
		PreparedStatement statement  = null;
		try{
		
			statement = conexiune.prepareStatement(
					"UPDATE "+
					"(SELECT detalii_licente.id_comisie as COMISIE "+
					" FROM detalii_licente "+
					" INNER JOIN licente "+
					" ON detalii_licente.id = licente.id "+
					" WHERE licente.id_profesor=? "+
					") t "+
					"SET t.Comisie = ? ");
			statement.setInt(1,idProf);
			statement.setInt(2,idCommitte);
			statement.executeUpdate();
			return true;
		
		}
		catch( Exception e ){
			System.out.println("Exceptie la update comisieProf:"+e.getMessage());
			return false;
		}	
		finally {
			try {
				if (statement != null)
					statement.close();

			}

			catch (SQLException se) {
				System.out.println("Oups .. " + se);

			}

		}
		
		
	}
	
	
	public int setDataSustinere( int idStudent, Timestamp inceput ){
		Statement statement = null;
		try{
			int idLicenta;
			statement = conexiune.createStatement();
			ResultSet result = statement.executeQuery("Select * from licente where id_student="+idStudent);
			result.next();
			idLicenta=result.getInt(1);
			statement.close();
			result.close();
			
			PreparedStatement preparedStatement = conexiune.prepareStatement("Update detalii_licente set data_ora_sustinere = ? where id="+idLicenta);
			preparedStatement.setTimestamp(1, inceput);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la setDataSustinere: "+e.getMessage());
			e.printStackTrace();
			return -7;
		}
		finally {
			try {
				if (statement != null)
					statement.close();

			}

			catch (SQLException se) {
				System.out.println("Oups .. " + se);

			}

		}
	}
	
	public Timestamp getDataSustinere(int idStudent) {
		Statement statement=null;
		try{
			int idLicenta;
		    statement = conexiune.createStatement();
			ResultSet result = statement.executeQuery("Select * from licente where id_student="+idStudent);
			result.next();
			idLicenta=result.getInt(1);
			statement.close();
			result.close();
			
			statement = conexiune.createStatement();
			result = statement.executeQuery("Select data_ora_sustinere from detalii_licente where id="+idLicenta);
			result.next();
			return result.getTimestamp(1);
		}
		catch( Exception e ){
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				if (statement != null)
					statement.close();

			}

			catch (SQLException se) {
				System.out.println("Oups .. " + se);

			}

		}
	}
    
	public String getSala(int idComisie) {
		Statement statement = null;
		try{
			statement = conexiune.createStatement();
			ResultSet result    = statement.executeQuery("Select sala from comisii where id="+idComisie);
			result.next();
			return result.getString(1);
		}
		catch( Exception e ){
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				if (statement != null)
					statement.close();

			}

			catch (SQLException se) {
				System.out.println("Oups .. " + se);

			}

		}
	}
	
	public int setComisieProfesor(int idProfesor, int idComisie) {
		Statement statement = null;
		try{
			statement = conexiune.createStatement();
			statement.executeUpdate("UPDATE profesori set id_comisie="+idComisie+" where id="+idProfesor);
			statement.close();
			
			statement = conexiune.createStatement();
			ResultSet result = statement.executeQuery("Select id,id_student from licente where id_profesor="+idProfesor);
			while(result.next())
			{
				Statement statementLoop = conexiune.createStatement();
				statementLoop.executeUpdate("UPDATE studenti set id_comisie="+idComisie+" where id="+result.getInt(2));
				statementLoop.close();
				
				statementLoop = conexiune.createStatement();
				statementLoop.executeUpdate("UPDATE detalii_licente set id_comisie="+idComisie+" where id="+result.getInt(1));
				statementLoop.close();
			}
			
			
			return 0;
		
		}
		catch( Exception e ){
			System.out.println("Exceptie la setComisieProfesor: "+e.getMessage());
			
			return -7;
		}
		
		finally {
			try {
				if (statement != null)
					statement.close();

			}

			catch (SQLException se) {
				System.out.println("Oups .. " + se);
				return -7;
			}

		}
	}
	
	

}
