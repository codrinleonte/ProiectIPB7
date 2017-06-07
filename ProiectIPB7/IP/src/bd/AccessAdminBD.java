package bd;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class AccessAdminBD extends AccessBD {
	
	AccessAdminBD( Connection conexiune , UserBD user )
	{
		this.conexiune = conexiune;
		this.tip = "Access_Admin";
		this.user = user;
	}
	
	public int setDataSustinere( int idStudent, Timestamp inceput ){
		try{
			int idLicenta;
			Statement statement = conexiune.createStatement();
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
	}
	
	public Timestamp getDataSustinere(int idStudent) {
		try{
			int idLicenta;
			Statement statement = conexiune.createStatement();
			ResultSet result = statement.executeQuery("Select * from licente where id_student="+idStudent);
			result.next();
			idLicenta=result.getInt(1);
			statement.close();
			result.close();
			
			statement = conexiune.createStatement();
			result = statement.executeQuery("Select data_ora_sustinere from detalii_licente where id="+idLicenta);
			result.next();
			result.close();
			statement.close();
			return result.getTimestamp(1);
		}
		catch( Exception e ){
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
    
	public String getSala(int idComisie) {
		try{
			Statement statement = this.conexiune.createStatement();
			ResultSet result    = statement.executeQuery("Select sala from comisii where id="+idComisie);
			result.next();
			result.close();
			statement.close();
			return result.getString(1);
		}
		catch( Exception e ){
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public int setComisieProfesor(int idProfesor, int idComisie) {
        try {
            Statement statement = conexiune.createStatement();
            String sql = new String();
            if(idComisie == 0){
                sql = "UPDATE profesori set id_comisie = null where id = " + idProfesor;
                }
             else
                sql = "UPDATE profesori set id_comisie=" + idComisie + " where id=" + idProfesor;
            
            System.out.println(sql);
            statement.executeUpdate(sql);
            
            statement.close();


            statement = conexiune.createStatement();
            ResultSet result = statement.executeQuery("Select id,id_student from licente where id_profesor=" + idProfesor);
            while (result.next()) {
                Statement statementLoop = conexiune.createStatement();
                statementLoop.executeUpdate("UPDATE studenti set id_comisie=" + idComisie + " where id=" + result.getInt(2));
                statementLoop.close();

                statementLoop = conexiune.createStatement();
                statementLoop.executeUpdate("UPDATE detalii_licente set id_comisie=" + idComisie + " where id=" + result.getInt(1));
                statementLoop.close();
            }


            return 0;

       	   } catch (Exception e) {
        	    System.out.println("Exceptie la setComisieProfesor: " + e.getMessage());
            	    return -7;
        }
       }
	
	public int setMembruComisie( int pozitie , int idComisie, int idProfesor ){
		if(pozitie<1 || pozitie>4 ) return -2; // pozitie invalida
		Statement statement = null;
		ResultSet result = null;
		try{
			String tipComisie = "";
			//int idComisieProfesor;
			statement = conexiune.createStatement();
			result = statement.executeQuery("SELECT TIP_COMISIE FROM COMISII WHERE ID="+idComisie);
			result.next();
			try{
				tipComisie = result.getString(1);
			}
			catch( Exception exceptie ){
				statement.close();
				result.close();
				return -1; // Comisie Inexistenta
			}
			statement.close();
			result.close();
			if(pozitie > 3 && tipComisie.toUpperCase().equals("LICENTA")) return -2; //pozitie invalida
			
			/*
			statement = conexiune.createStatement();
			result = statement.executeQuery("SELECT ID_COMISIE FROM PROFESORI WHERE ID="+idProfesor);
			result.next();
			if(result.getInt(1)!=0) return -3; //profesorul este deja un membru al unei comisii
			statement.close();
			result.close();
			*/
			
			statement = conexiune.createStatement();
			if(pozitie<4)
			{
				statement.executeUpdate("UPDATE COMISII SET ID_PROF"+pozitie+"="+idProfesor+" WHERE ID="+idComisie);
				if(pozitie==1)
					statement.executeUpdate("UPDATE PROFESORI SET FUNCTIE_COMISIE='Presedinte' WHERE ID="+idProfesor);
				else if(pozitie==2)
				{
					statement.executeQuery("UPDATE PROFESORI SET FUNCTIE_COMISIE='Secretar' WHERE ID="+idProfesor);
					statement.executeUpdate("UPDATE COMISII SET ID_SECRETAR="+idProfesor+" WHERE ID="+idComisie);
				}
				else
					statement.executeUpdate("UPDATE PROFESORI SET FUNCTIE_COMISIE='Evaluator' WHERE ID="+idProfesor);
			    }
			else{
				statement.executeUpdate("UPDATE COMISII SET ID_PROF4_DIZERTATIE="+idProfesor+" WHERE ID="+idComisie);
				statement.executeUpdate("UPDATE PROFESORI SET FUNCTIE_COMISIE='Evaluator' WHERE ID="+idProfesor);
			}
			return this.setComisieProfesor(idProfesor,idComisie);
		}
		catch( Exception e ){
			System.out.println("Exceptie la setMembruComisie:"+e.getMessage());
			return -7;
		}
	}
	
	public int setSalaComisie( int idComisie , String sala ){
		PreparedStatement statement = null;
		try{
			PreparedStatement pstmt = conexiune.prepareStatement("select count(*) from comisii where id = ?");
			pstmt.setInt(1, idComisie);
			ResultSet result = pstmt.executeQuery();
			result.next();
			if(result.getInt(1) == 0)
				return -7;
			result.close();
			pstmt.close();
			
			statement=conexiune.prepareStatement("UPDATE COMISII SET SALA = ? WHERE ID = ? ");
			statement.setString(1, sala);
			statement.setInt(2, idComisie);
			statement.executeUpdate();
			statement.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la setSalaComisie:"+e.getMessage());
			return -7;
		}
	}
	
	public int setFisierLucrare( int idStudent , byte[] data ){
		PreparedStatement statement = null;
		try{
			PreparedStatement pstmt = conexiune.prepareStatement("select count(*) from studenti where id = ?");
			pstmt.setInt(1, idStudent);
			ResultSet result = pstmt.executeQuery();
			result.next();
			if(result.getInt(1) == 0)
				return -7;
			result.close();
			pstmt.close();
			
			statement = conexiune.prepareStatement("UPDATE LICENTE SET FISIER = ? WHERE id_student = ? ");
			statement.setInt(2, idStudent);
			statement.setBytes(1, data);
			statement.executeUpdate();
			statement.close();
			
			return 0;
		}
		catch( Exception e){
			try{
				statement.close();
			}
			catch( Exception exceptie ){}
			System.out.println("Exceptie scriere fisier lucrare:" +e.getMessage());
			e.printStackTrace();
			return -7;
		}
	}
	
	public byte[] getFisierLucrare( int idStudent){
		PreparedStatement statement = null;
		ResultSet result = null;
		try{
			byte[] data;
			Blob blob;
			statement = conexiune.prepareStatement("SELECT FISIER FROM LICENTE WHERE ID_STUDENT = ?");
			statement.setInt(1, idStudent);
			result=statement.executeQuery();
			result.next();
			blob = result.getBlob(1);
			data = blob.getBytes(1, (int) blob.length());
			return data;
		}
		catch ( Exception e ){
			System.out.println("Exceptie citire fisier lucrare:" +e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public int updateSesiuneActive( int val )
	{
		Statement statement = null;
		try{
			statement = conexiune.createStatement();
			statement.executeUpdate("UPDATE SESIUNI SET ACTIVE ="+val);
			statement.close();
			return 0;
		}
		catch( Exception e ){
			try{statement.close();}
			catch(Exception exceptie){};
			System.out.println();
			return -7;
		}
	}
	
	public List<IntrareProfesori> profesoriCoordonatoriFaraComisie(){
		List<IntrareProfesori> rezultat = new ArrayList<IntrareProfesori>();
		List<IntrareProfesori> profesori = selectProfesori();
		PreparedStatement statement = null;
		ResultSet result = null;
		for(int i=0; i<profesori.size(); i++)
		{
			try{
				statement = conexiune.prepareStatement("SELECT COUNT(*) FROM LICENTE WHERE ID_PROFESOR=?");
				statement.setInt(1, profesori.get(i).getId());
				result = statement.executeQuery();
				result.next();
				if(result.getInt(1)>0 && profesori.get(i).getIdComisie()==0){
					rezultat.add(profesori.get(i));
					System.out.println(result.getInt(1));
				}
				result.close();
				statement.close();
			}
			catch( Exception e ){
				try{
					statement.close();
					result.close();
				}catch( Exception exceptie ){}
				return null;
			}
		}
		return rezultat;
	}
	
	public int creareComisie( int tip )
	{
		IntrareComisii comisie = new IntrareComisii();
		if(tip==0) comisie.setTipComisie("Licenta");
		else	   comisie.setTipComisie("Dizertatie");
		return insertComisie(comisie);
	}
	
	public int schimbaComisie(int idProf, int idComisieVeche, int idComisieNoua) //returneaza 1 daca profesorul a fost mutat de la comisia veche la comisia noua, -1 altfel
	{
		
		try {
			int IDProf = -2;
			PreparedStatement pstmt = conexiune.prepareStatement("Select count(*) from comisii where id = ?");
			pstmt.setInt(1, idComisieNoua);
			ResultSet nr = pstmt.executeQuery();
			nr.next();
			if(nr.getInt(1)==0)
				return -1;
			pstmt.close();
			
			pstmt = conexiune.prepareStatement("select count(*) from comisii where id = ?");
			pstmt.setInt(1, idComisieVeche);
			nr = pstmt.executeQuery();
			nr.next();
			if(nr.getInt(1) == 0)
				return -1;
			pstmt.close();
			
			pstmt = conexiune.prepareStatement("select count(*) from profesori where id = ? ");
			pstmt.setInt(1, idProf);
			nr = pstmt.executeQuery();
			nr.next();
			if(nr.getInt(1) == 0)
				return -1;
			pstmt.close();
			
			pstmt = conexiune.prepareStatement("select * from comisii where id = ? and ( id_prof1 = ? or id_prof2 = ? or id_prof3 = ? or id_prof4_dizertatie = ?)");
			pstmt.setInt(1, idComisieVeche);
			pstmt.setInt(2, idProf);
			pstmt.setInt(3, idProf);
			pstmt.setInt(4, idProf);
			pstmt.setInt(5, idProf);
			
			ResultSet result = pstmt.executeQuery();
			pstmt.close();
			
			if(result == null) 
				return -1;
			else 
				{
				
				ResultSet prof;
				pstmt = conexiune.prepareStatement("select id_prof1 from comisii where id = ?");
				pstmt.setInt(1, idComisieVeche);
				prof = pstmt.executeQuery();

				if (prof != null)
				{
					 prof.next();
					 IDProf = prof.getInt(1);
				     if (IDProf == idProf)
				    	{
				    	 pstmt = conexiune.prepareStatement("select id_prof1 from comisii where id = ?");
				     	 pstmt.setInt(1, idComisieNoua);
				     	 prof = pstmt.executeQuery();
				     	
				     	 prof.next();
				     	 IDProf = prof.getInt(1);
				   
				     	 pstmt = conexiune.prepareStatement("update comisii set id_prof1 = ? where id = ?");
				     	 pstmt.setInt(1, idProf);
				     	 pstmt.setInt(2, idComisieNoua);
				     	 pstmt.executeUpdate();
				     	 pstmt.close();
				     	 
				     	 pstmt = conexiune.prepareStatement("update comisii set id_prof1 = ? where id = ?");
				     	 pstmt.setInt(1, IDProf);
				     	 pstmt.setInt(2, idComisieVeche);
				     	 pstmt.executeUpdate();
				     	 pstmt.close();
				     	 conexiune.commit();
				     	 
				     	 return 1;
				     	}
				     else
					   {
				    	 pstmt.close();
				    	 prof.close();
						 pstmt = conexiune.prepareStatement("select id_prof2 from comisii where id = ?");
						 pstmt.setInt(1, idComisieVeche);
						 prof = pstmt.executeQuery();
						 
						 if (prof != null)
						   {  prof.next();
						      IDProf = prof.getInt(1);
					          if (IDProf == idProf)
					    	  {
					        	  pstmt = conexiune.prepareStatement("select id_prof2 from comisii where id = ?");
					        	  pstmt.setInt(1, idComisieNoua);
					        	  prof = pstmt.executeQuery();
					        	  
					        	  prof.next();
					        	  IDProf = prof.getInt(1);
					        	  pstmt = conexiune.prepareStatement("update comisii set id_prof2 = ? where id = ?");
					        	  pstmt.setInt(1, idProf);
					        	  pstmt.setInt(2, idComisieNoua);
					        	  pstmt.executeUpdate();
					        	  pstmt.close();
					        	  
					        	  pstmt = conexiune.prepareStatement("update comisii set id_prof2 = ? where id = ?");
					        	  pstmt.setInt(1, IDProf);
					        	  pstmt.setInt(2, idComisieVeche);
					        	  pstmt.executeUpdate();
					        	  pstmt.close();
					        	  conexiune.commit();
					        	  
					        	  return 1;
					    	  }
					          else
							     {
					        	    pstmt.close();
							    	prof.close();
								 	pstmt = conexiune.prepareStatement("select id_prof3 from comisii where id = ?");
								 	pstmt.setInt(1, idComisieVeche);
								 	prof = pstmt.executeQuery();
								 	
								 	if (prof != null)
								 		{  prof.next();
								 		   IDProf = prof.getInt(1);
							               if (IDProf == idProf)
							               {
							            	   pstmt = conexiune.prepareStatement("select id_prof3 from comisii where id = ?");
							            	   pstmt.setInt(1, idComisieNoua);
							            	   prof = pstmt.executeQuery();
							            	   pstmt.close();
							            	   prof.next();
							            	   IDProf = prof.getInt(1);
							            	   pstmt = conexiune.prepareStatement("update comisii set id_prof3 = ? where id = ?");
							            	   pstmt.setInt(1, idProf);
							            	   pstmt.setInt(2, idComisieNoua);
							            	   pstmt.executeUpdate();
							            	   pstmt.close();
							     	 
							            	   pstmt = conexiune.prepareStatement("update comisii set id_prof3 = ? where id = ?");
							            	   pstmt.setInt(1, IDProf);
							            	   pstmt.setInt(2, idComisieVeche);
							            	   pstmt.executeUpdate();
							            	   pstmt.close();
							            	   conexiune.commit();
							            	   
							            	   return 1;
							               }
							               else 
									 	    {
							            	   pstmt.close();
										       prof.close();
									 		   pstmt = conexiune.prepareStatement("select id_prof4_dizertatie from comisii where id = ?");
										 	   pstmt.setInt(1, idComisieVeche);
										 	   prof = pstmt.executeQuery();
										 	   
										  	   if (prof != null)
										  	   		{  prof.next();
										  	   		   IDProf = prof.getInt(1);
										  	   		   if (IDProf == idProf)
										  	   		   {
										  	   			   pstmt = conexiune.prepareStatement("select id_prof4_dizertatie from comisii where id = ?");
										  	   			   pstmt.setInt(1, idComisieNoua);
										  	   			   prof = pstmt.executeQuery();
										  	   			   pstmt.close();
										  	   			   prof.next();
										  	   			   IDProf = prof.getInt(1);
										  	   			   
										  	   			   if(IDProf == 0)
												     	   {
												     		 pstmt = conexiune.prepareStatement("select tip_comisie from comisii where id = ?");
													     	 pstmt.setInt(1, idComisieNoua);
													     	 prof = pstmt.executeQuery();
													     	 pstmt.close();
													     	 prof.next();
													     	 String tip = prof.getString(1);
													     	 if (tip.equals("licenta"))
													     		 return -1;
												     	   }
										  	   			   pstmt = conexiune.prepareStatement("update comisii set id_prof4_dizertatie = ? where id = ?");
										  	   			   pstmt.setInt(1, idProf);
										  	   			   pstmt.setInt(2, idComisieNoua);
										  	   			   pstmt.executeUpdate();
										  	   			   pstmt.close();
									     	 
										  	   			   pstmt = conexiune.prepareStatement("update comisii set id_prof4_dizertatie = ? where id = ?");
										  	   			   pstmt.setInt(1, IDProf);
										  	   			   pstmt.setInt(2, idComisieVeche);
										  	   			   pstmt.executeUpdate();
										  	   			   pstmt.close();
										  	   			   conexiune.commit();
										  	   			   
										  	   			   return 1;
										  	   		   }
										  	   		   else return -1;
										  	   		}
										  	   else  return -1;
									 	     }
								 		}
								 	else return -1;
							     }
						   }
						 else return -1;
					   }
				     }
				  else return -1;
				}
		   } catch (Exception e) {
			System.out.println("Exceptie la schimbaComisie: "+e.getMessage());
			e.printStackTrace();
			return -1;
		}
	
	}
	
	public int[] selectCoordonatori(int idComisie)
	{
		try 
		   {
			  int[] coordonatori;
			  
			  PreparedStatement pstmt = conexiune.prepareStatement("select count(*) from comisii where id = ?");
			  pstmt.setInt(1, idComisie);
			  ResultSet nr = pstmt.executeQuery();
			  nr.next();
			  if(nr.getInt(1)==0)
				  return new int[5];
			  nr.close();
			  pstmt.close();
			  
			  pstmt = conexiune.prepareStatement("select unique l.id_profesor from comisii c join licente l on (c.id_prof1 = l.id_profesor or c.id_prof2 = l.id_profesor or c.id_prof3 = l.id_profesor or c.id_prof4_dizertatie = l.id_profesor) where c.id = ? order by 1");
			  pstmt.setInt(1, idComisie);
			  ResultSet result = pstmt.executeQuery();
			  
			  pstmt = conexiune.prepareStatement("select count(*) from (select unique l.id_profesor from comisii c join licente l on (c.id_prof1 = l.id_profesor or c.id_prof2 = l.id_profesor or c.id_prof3 = l.id_profesor or c.id_prof4_dizertatie = l.id_profesor) where c.id = ?)");
			  pstmt.setInt(1, idComisie);
			  nr  = pstmt.executeQuery();
			  nr.next();
			  int NR = nr.getInt(1);
			  nr.close();
			  coordonatori = new int [NR];
			  int i = 0;
			  while(result.next())
			  {
				  coordonatori[i] = result.getInt(1);
				  i++;
			  }
			  pstmt.close();
			  result.close();
			  return coordonatori;
		   }
		catch (Exception e)
		{
			System.out.println("Exceptie la selectCoordonatori :"+e.getMessage());
			return new int[5];
		}
	}
	
	public List<IntrareMesaje> selectMesaje(){
		List<IntrareMesaje> rezultat = new ArrayList<IntrareMesaje>();
		try{
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from mesaje"); 
			while(result.next()){
				IntrareMesaje intrare = new IntrareMesaje();
				intrare.setId(result.getInt(1));
				intrare.setIdEmitator(result.getInt(2));
				intrare.setIdDestinatar(result.getInt(3));
				intrare.setMesaj(result.getString(4));
				rezultat.add(intrare);
			}
			
			statement.close();
			result.close();
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectMesaje: "+e.getMessage());
			return null;
		}
		
	}

	public List<IntrareConturi> selectConturi(){
		List<IntrareConturi> rezultat = new ArrayList<IntrareConturi>();
		try{
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from conturi"); 
			while(result.next()){
				IntrareConturi intrare = new IntrareConturi();
				intrare.setId(result.getInt(1));
				intrare.setUsername(result.getString(2));
				intrare.setHashparola(result.getString(3));
				intrare.setEmail(result.getString(4));
				intrare.setTipUtilizator(result.getString(5));
				intrare.setStatus(result.getInt(6));
				intrare.setCodActivare(result.getString(7));
				intrare.setToken(result.getString(8));
				rezultat.add(intrare);
			}
			statement.close();
			result.close();
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectConturi :"+e.getMessage());
			return null;
		}
	}

	public List<IntrareStudenti> selectStudenti(){
		List<IntrareStudenti> rezultat = new ArrayList<IntrareStudenti>();
		try{
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from studenti"); 
			while(result.next()){
				IntrareStudenti intrare = new IntrareStudenti();
				intrare.setId(result.getInt(1));
				intrare.setIdCont(result.getInt(2));
				intrare.setNrMatricol(result.getString(3));
				intrare.setNume(result.getString(4));
				intrare.setPrenume(result.getString(5));
				intrare.setId_comisie(result.getInt(6));
				intrare.setIdSesiune(result.getInt(7));
				rezultat.add(intrare);
			}
			statement.close();
			result.close();
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectStudenti:"+e.getMessage());
			return null;
		}		
	}

	public List<IntrareProfesori> selectProfesori(){
		List<IntrareProfesori> rezultat = new ArrayList<IntrareProfesori>();
		try{
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from profesori"); 
			while(result.next()){
				IntrareProfesori intrare = new IntrareProfesori();
				intrare.setId(result.getInt(1));
				intrare.setIdCont(result.getInt(2));
				intrare.setNume(result.getString(3));
				intrare.setPrenume(result.getString(4));
				intrare.setGradDidactic(result.getString(5));
				intrare.setIdComisie(result.getInt(6));
				intrare.setFunctieComisie(result.getString(7));
				rezultat.add(intrare);
			}
			statement.close();
			result.close();
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectProfesori :"+e.getMessage());
			return null;
		}		
	}
	
	public List<IntrareComisii> selectComisii(){
		List<IntrareComisii> rezultat = new ArrayList<IntrareComisii>();
		try{
			
			PreparedStatement pStatement = conexiune.prepareStatement("Select * from comisii");
			ResultSet result = pStatement.executeQuery(); 
			while(result.next() && result!=null){
				IntrareComisii intrare = new IntrareComisii();
				intrare.setId(result.getInt(1));
				intrare.setIdProfSef(result.getInt(2));
				intrare.setIdProf2(result.getInt(3));
				intrare.setIdProf3(result.getInt(4));
				intrare.setIdProf4(result.getInt(5));
				intrare.setIdSecretar(result.getInt(6));
				intrare.setTipComisie(result.getString(7));
				intrare.setSala(result.getString(8));
				rezultat.add(intrare);
			}
			
			pStatement.close();
			result.close();
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectComisii: "+e.getMessage());
			return null;
		}
	}
	
	public List<IntrareLicente> selectLicente(){
		List<IntrareLicente> rezultat = new ArrayList<IntrareLicente>();
		try{
			
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from licente"); 
			while(result.next()){
				IntrareLicente intrare = new IntrareLicente();
				intrare.setId(result.getInt(1));
				intrare.setTitlu(result.getString(2));
				intrare.setIdProfesor(result.getInt(3));
				intrare.setIdStudent(result.getInt(4));
				intrare.setMaterialeLicenta(result.getString(5));
				intrare.setIdSesiune(result.getInt(6));
				intrare.setTipLucrare(result.getString(7));
				
				rezultat.add(intrare);
			}
			
			statement.close();
			result.close();
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectLicente: "+e.getMessage());
			return null;
		}
	}
	
	public List<IntrareSesiuni> selectSesiuni(){
		List<IntrareSesiuni> rezultat = new ArrayList<IntrareSesiuni>();
		try{
			
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from sesiuni"); 
			while(result.next()){
				IntrareSesiuni intrare = new IntrareSesiuni();
				intrare.setId(result.getInt(1));
				intrare.setInceputSesiune(result.getTimestamp(2));
				intrare.setSfarsitSesiune(result.getTimestamp(3));
				intrare.setActive(result.getInt(4));
				rezultat.add(intrare);
			}
			
			statement.close();
			result.close();
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectSesiuni: "+e.getMessage());
			return null;
		}	
	}
	
	public List<IntrareDetaliiLicente> selectDetaliiLicente(){
		List<IntrareDetaliiLicente> rezultat = new ArrayList<IntrareDetaliiLicente>();
		try{
			
			Statement statement=conexiune.createStatement();
			ResultSet result   =statement.executeQuery("Select * from detalii_licente"); 
			while(result.next()){
				IntrareDetaliiLicente intrare = new IntrareDetaliiLicente();
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
				
				rezultat.add(intrare);
			}
			
			statement.close();
			result.close();
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectDetaliiLicente: "+e.getMessage());
			return null;
		}
	}
	
	private int updateMesaj( IntrareMesaje intrare ){
		if(intrare.getId()==0) return -1;
		String apel=" Update Mesaje set iD_Emitator = ? , ID_Destinatar = ? , Mesaj = ? where id = ? ";
		try{
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from mesaje where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				stmt.close();
				rs.close();
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1, intrare.getIdEmitator());
			statement.setInt(2, intrare.getIdDestinatar());
			statement.setString(3, intrare.getMesaj());
			statement.setInt(4, intrare.getId());
			statement.executeUpdate();
			stmt.close();
			statement.close();
			rs.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateMesaj" + e.getMessage());
			return -7;
		}
		
	}

	private int updateCont( IntrareConturi intrare ){
		if(intrare.getId()==0) return -1;
		String apel=" Update Conturi set USERNAME = ? , PAROLA = ? , EMAIL = ? ,  TIP_UTILIZATOR=? , STATUS=? ,COD_ACTIVARE=?,Token=? where id = ? ";
		try{
			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from conturi where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				stmt.close();
				rs.close();
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setString(1, intrare.getUsername());
			statement.setString(2,intrare.getHashparola());
			statement.setString(3, intrare.getEmail());
			statement.setString(4,intrare.getTipUtilizator());
			statement.setInt(5, intrare.getStatus());
			statement.setString(6,intrare.getCodActivare());
			statement.setString(7,intrare.getToken());
			statement.setInt(8, intrare.getId());
			statement.executeUpdate();	
			statement.close();
			stmt.close();
			rs.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateMesaj" + e.getMessage());
			return -7;
		}
		
	}
	
	private int updateStudent( IntrareStudenti intrare ){
		if(intrare.getId()==0) return -1;
		String apel=" Update studenti set ID_CONT = ? , NR_MATRICOL = ? , NUME = ? ,  PRENUME=? , ID_COMISIE = ? , ID_SESIUNE=? where id = ? ";
		try{
			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from studenti where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				stmt.close();
				rs.close();
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1, intrare.getIdCont());
			statement.setString(2, intrare.getNrMatricol());
			statement.setString(3, intrare.getNume());
			statement.setString(4, intrare.getPrenume());
			statement.setInt(5, intrare.getIdSesiune());
			statement.setInt(6, intrare.getId_comisie());
			statement.setInt(7, intrare.getId());
			statement.executeUpdate();	
			statement.close();
			stmt.close();
			rs.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateStudent" + e.getMessage());
			return -7;
		}	
	}
	
	private int updateProfesor( IntrareProfesori intrare){
		if(intrare.getId()==0) return -1;
		String apel=" Update profesori set ID_CONT = ? ,NUME = ? ,  PRENUME=? ,GRAD_DIDACTIC=?,ID_COMISIE=?,FUNCTIE_COMISIE=? where id = ? ";
		try{
			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from profesori where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				stmt.close();
				rs.close();
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1,intrare.getIdCont());
			statement.setString(2, intrare.getNume());
			statement.setString(3, intrare.getPrenume());
			statement.setString(4,intrare.getGradDidactic());
			statement.setInt(5, intrare.getIdComisie());
			statement.setString(6, intrare.getFunctieComisie());
			statement.setInt(7, intrare.getId());
			statement.executeUpdate();	
			statement.close();
			stmt.close();
			rs.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateProfesor" + e.getMessage());
			return -7;
		}	
		
	}

	private int updateComisie( IntrareComisii intrare ){
		if(intrare.getId()==0) return -1;
		String apel=" Update comisii set ID_Prof1 = ? , ID_Prof2 = ? , ID_Prof3 =?, ID_Prof4_Dizertatie = ?, ID_Secretar = ?, Tip_Comisie = ?, Sala = ? where id = ? ";
		try{
	
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from comisii where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				stmt.close();
				rs.close();
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1, intrare.getIdProfSef());
			statement.setInt(2, intrare.getIdProf2());
			statement.setInt(3, intrare.getIdProf3());
			statement.setInt(4, intrare.getIdProf4());
			statement.setInt(5, intrare.getIdSecretar());
			statement.setString(6, intrare.getTipComisie());
			statement.setString(7, intrare.getSala());
			statement.setInt(8, intrare.getId());
			statement.executeUpdate();	
			conexiune.commit();
			
			statement.close();
			stmt.close();
			rs.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateComisie" + e.getMessage());
			return -7;
		}
		
	}
	
	private int updateDetaliiLicenta( IntrareDetaliiLicente intrare){
		if(intrare.getId()==0) return -1;
		String apel=" Update detalii_licente set id_comisie = ?, nota_1_oral = ?, nota_1_proiect = ?, nota_2_oral = ?, nota_2_proiect = ?, nota_3_oral = ?, nota_3_proiect = ?, nota_4_oral_dizertatie = ?, nota_4_proiect_dizertatie = ?, nota_5_oral_coordonator=?, nota_5_proiect_coordonator=?, data_ora_sustinere = ? where id = ? ";
		try{
			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from detalii_licente where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1, intrare.getIdComisie());
			statement.setInt(2, intrare.getNota1Oral());
			statement.setInt(3, intrare.getNota1Proiect());
			statement.setInt(4, intrare.getNota2Oral());
			statement.setInt(5, intrare.getNota2Proiect());
			statement.setInt(6, intrare.getNota3Oral());
			statement.setInt(7, intrare.getNota3Proiect());
			statement.setInt(8, intrare.getNota4Oral());
			statement.setInt(9, intrare.getNota4Proiect());
			statement.setInt(10, intrare.getNota5Oral());
			statement.setInt(11, intrare.getNota5Proiect());
			statement.setTimestamp(12, intrare.getDataOraSustinerii());
			statement.setInt(13, intrare.getId());
			statement.executeUpdate();
			conexiune.commit();
			
			statement.close();
			stmt.close();
			rs.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateDetaliiLicenta" + e.getMessage());
			return -7;
		}	
		
	}
	
	private int updateLicenta( IntrareLicente intrare){
		if(intrare.getId()==0) return -1;
		String apel=" Update licente set titlu = ?, id_profesor = ?, id_student = ?, materiale_licenta = ?, id_sesiune = ?, tip = ? where id = ? ";
		try{			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from licente where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				stmt.close();
				rs.close();
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setString(1, intrare.getTitlu());
			statement.setInt(2, intrare.getIdProfesor());
			statement.setInt(3, intrare.getIdStudent());
			statement.setString(4, intrare.getMaterialeLicenta());
			statement.setInt(5, intrare.getIdSesiune());
			statement.setString(6, intrare.getTipLucrare());
			statement.setInt(7, intrare.getId());
			statement.executeUpdate();
			conexiune.commit();
			
			statement.close();
			stmt.close();
			rs.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateLicenta" + e.getMessage());
			return -7;
		}	
		
	}
	
	private int updateSesiune( IntrareSesiuni intrare){
		if(intrare.getId()==0) return -1;
		String apel=" Update sesiuni set inceput_sesiune = ?, sfarsit_sesiune = ? , active= ? where id = ? ";
		try{
			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from sesiuni where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				stmt.close();
				rs.close();
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setTimestamp(1, intrare.getInceputSesiune());
			statement.setTimestamp(2, intrare.getSfarsitSesiune());
			statement.setInt(3,intrare.getActive());
			statement.setInt(4, intrare.getId());
			statement.executeUpdate();
			conexiune.commit();
			
			statement.close();
			stmt.close();
			rs.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateSesiune" + e.getMessage());
			return -7;
		}	
		
	}
	
	private int insertMesaj( IntrareMesaje intrare ){
		String apel;	
		try{
			
			if(intrare.getId()==0){
				apel = " Insert into Mesaje Values(Mesaje_SEQ.NEXTVAL, ?, ? ,?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1, intrare.getIdEmitator());
				statement.setInt(2, intrare.getIdDestinatar());
				statement.setString(3, intrare.getMesaj());
				statement.executeUpdate();
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select MESAJE_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				
				statement.close();
				stmt.close();
				rs.close();
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from MESAJE where id ="+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					stmt.close();
					rs.close();
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
				
				apel = " Insert into Mesaje Values(?, ?, ? ,?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getId());
				statement.setInt(2, intrare.getIdEmitator());
				statement.setInt(3, intrare.getIdDestinatar());
				statement.setString(4, intrare.getMesaj());
				statement.executeUpdate();
				
				statement.close();
				stmt.close();
				rs.close();
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertMesaj: "+e.getMessage());
			return -7;
		}
	}

	private int insertCont( IntrareConturi intrare){
		String apel;	
		try{
			
			if(intrare.getId()==0){
				apel = " Insert into Conturi Values(CONTURI_SEQ.NEXTVAL, ?, ? ,?, ?, ? , ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setString(1, intrare.getUsername());
				statement.setString(2, intrare.getHashparola());
				statement.setString(3, intrare.getEmail());
				statement.setString(4, intrare.getTipUtilizator());	
				statement.setInt(5, intrare.getStatus());
				statement.setString(6, intrare.getCodActivare());
				statement.setString(7, intrare.getToken());
				statement.executeUpdate();
				
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select CONTURI_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				
				statement.close();
				stmt.close();
				rs.close();
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from CONTURI where id ="+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					stmt.close();
					rs.close();
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
				
				apel = " Insert into Conturi Values(? , ?, ? ,?, ?, ? , ?,?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getId());
				statement.setString(2, intrare.getUsername());
				statement.setString(3, intrare.getHashparola());
				statement.setString(4, intrare.getEmail());
				statement.setString(5, intrare.getTipUtilizator());
				statement.setInt(6, intrare.getStatus());
				statement.setString(7, intrare.getCodActivare());
				statement.setString(8, intrare.getToken());
				statement.executeUpdate();
				
				statement.close();
				stmt.close();
				rs.close();				
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertCont: "+e.getMessage());
			return -7;
		}		
	}
	
	private int insertStudent( IntrareStudenti intrare){
		
		String apel;	
		try{
			
			if(intrare.getId()==0){
				apel = " Insert into STUDENTI Values(STUDENTI_SEQ.NEXTVAL, ?, ? ,?, ?,?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getIdCont());
				statement.setString(2,intrare.getNrMatricol());
				statement.setString(3,intrare.getNume());
				statement.setString(4,intrare.getPrenume());
				statement.setInt(5, intrare.getId_comisie());
				statement.setInt(6,intrare.getIdSesiune());
				statement.executeUpdate();
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select STUDENTI_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				statement.close();
				stmt.close();
				rs.close();
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from STUDENTI where id ="+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					stmt.close();
					rs.close();
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
				
				apel = " Insert into Studenti Values(?, ?, ? ,?,?,?,?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getId());
				statement.setInt(2,intrare.getIdCont());
				statement.setString(3,intrare.getNrMatricol());
				statement.setString(4,intrare.getNume());
				statement.setString(5,intrare.getPrenume());
				statement.setInt(6, intrare.getId_comisie());
				statement.setInt(7,intrare.getIdSesiune());
				statement.executeUpdate();
				conexiune.commit();
				statement.close();
				stmt.close();
				rs.close();
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertStudent: "+e.getMessage());
			return -7;
		}		
		
	}
	
	private int insertProfesor( IntrareProfesori intrare){
		
		String apel;	
		try{
			
			if(intrare.getId()==0){
				apel = " Insert into Profesori Values(PROFESORI_SEQ.NEXTVAL, ?, ? ,?, ?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getIdCont());
				statement.setString(2, intrare.getNume());
				statement.setString(3, intrare.getPrenume());
				statement.setString(4, intrare.getGradDidactic());
				statement.setInt(5,intrare.getIdComisie());
				statement.setString(6,intrare.getFunctieComisie());
				statement.executeUpdate();
				conexiune.commit();
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select PROFESORI_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				statement.close();
				stmt.close();
				rs.close();
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from PROFESORI where id ="+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
		
				apel = " Insert into Profesori Values(?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getId());
				statement.setInt(2,intrare.getIdCont());
				statement.setString(3, intrare.getNume());
				statement.setString(4, intrare.getPrenume());
				statement.setString(5, intrare.getGradDidactic());
				statement.setInt(6,intrare.getIdComisie());
				statement.setString(7,intrare.getFunctieComisie());
				
				statement.executeUpdate();
				conexiune.commit();
				
				statement.close();
				stmt.close();
				rs.close();
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertProfesori: "+e.getMessage());
			return -7;
		}		
		
	}
	
	private int insertComisie( IntrareComisii intrare){
		
		String apel = new String();	
		try{
			
			if(intrare.getId()==0){
				apel = " Insert into Comisii (ID, ID_Prof1, ID_Prof2, ID_Prof3, ID_Prof4_Dizertatie, ID_Secretar, Tip_Comisie, Sala) Values(to_number(COMISII_SEQ.NEXTVAL), ?, ? ,?, ?, ?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getIdProfSef());
				statement.setInt(2,intrare.getIdProf2());
				statement.setInt(3,intrare.getIdProf3());
				statement.setInt(4,intrare.getIdProf4());
				statement.setInt(5,intrare.getIdSecretar());
				statement.setString(6, intrare.getTipComisie());
				statement.setString(7, intrare.getSala());
				statement.executeUpdate();
				conexiune.commit();
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select COMISII_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				
				statement.close();
				stmt.close();
				rs.close();
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from COMISII where id = "+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					stmt.close();
					rs.close();
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
				
				apel = " Insert into Comisii Values(?, ?, ?, ? ,?, ?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getId());
				statement.setInt(2,intrare.getIdProfSef());
				statement.setInt(3, intrare.getIdProf2());
				statement.setInt(4,intrare.getIdProf3());
				statement.setInt(5,intrare.getIdProf4());
				statement.setInt(6,intrare.getIdSecretar());
				statement.setString(7,intrare.getTipComisie());
				statement.setString(8, intrare.getSala());
				statement.executeUpdate();
				conexiune.commit();
				
				statement.close();
				stmt.close();
				rs.close();
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertComisie: "+e.getMessage());
			return -7;
		}		
		
	}
  
	private int insertDetaliiLicenta( IntrareDetaliiLicente intrare ){
		String apel = new String();	
		try{
			
			if(intrare.getId()==0){
				apel = " Insert into Detalii_licente Values(Detalii_SEQ.NEXTVAL, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1, intrare.getIdComisie());
				statement.setInt(2, intrare.getNota1Oral());
				statement.setInt(3, intrare.getNota1Proiect());
				statement.setInt(4, intrare.getNota2Oral());
				statement.setInt(5, intrare.getNota2Proiect());
				statement.setInt(6, intrare.getNota3Oral());
				statement.setInt(7, intrare.getNota3Proiect());
				statement.setInt(8, intrare.getNota4Oral());
				statement.setInt(9, intrare.getNota4Proiect());
				statement.setInt(10,  intrare.getNota5Oral());
				statement.setInt(11, intrare.getNota5Proiect());
				statement.setTimestamp(12, intrare.getDataOraSustinerii());
				statement.executeUpdate();
				conexiune.commit();
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Detalii_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				
				statement.close();
				stmt.close();
				rs.close();
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from detalii_licente where id = "+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					stmt.close();
					rs.close();
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
				
				apel = " Insert into detalii_licente Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1, intrare.getId());
				statement.setInt(2, intrare.getIdComisie());
				statement.setInt(3, intrare.getNota1Oral());
				statement.setInt(4, intrare.getNota1Proiect());
				statement.setInt(5, intrare.getNota2Oral());
				statement.setInt(6, intrare.getNota2Proiect());
				statement.setInt(7, intrare.getNota3Oral());
				statement.setInt(8, intrare.getNota3Proiect());
				statement.setInt(9, intrare.getNota4Oral());
				statement.setInt(10, intrare.getNota4Proiect());
				statement.setInt(11,  intrare.getNota5Oral());
				statement.setInt(12, intrare.getNota5Proiect());
				statement.setTimestamp(13, intrare.getDataOraSustinerii());
				statement.executeUpdate();
				conexiune.commit();
				
				statement.close();
				stmt.close();
				rs.close();
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertDetaliiLicente: "+e.getMessage());
			return -7;
		}
	}
    
	private int insertLicenta( IntrareLicente intrare ){
		String apel;	
		try{
			if(intrare.getId()==0){
				apel = " Insert into Licente Values(Licente_SEQ.NEXTVAL, ?, ? ,?, ?, ?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setString(1, intrare.getTitlu());
				statement.setInt(2, intrare.getIdProfesor());
				statement.setInt(3, intrare.getIdStudent());
				statement.setString(4, intrare.getMaterialeLicenta());
				statement.setInt(5, intrare.getIdSesiune());
				statement.setString(6, intrare.getTipLucrare());
				statement.executeUpdate();
				conexiune.commit();
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select LICENTE_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				
				statement.close();
				stmt.close();
				rs.close();
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from LICENTE where id ="+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					stmt.close();
					rs.close();
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
				
				apel = " Insert into LICENTE Values(to_number(Licente_SEQ.NEXTVAL), ?, ?, ?, ?, ?, ?,?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getId());
				statement.setString(2, intrare.getTitlu());
				statement.setInt(3, intrare.getIdProfesor());
				statement.setInt(4, intrare.getIdStudent());
				statement.setString(5, intrare.getMaterialeLicenta());
				statement.setInt(6, intrare.getIdSesiune());
				statement.setString(7, intrare.getTipLucrare());
				statement.executeUpdate();
				conexiune.commit();
				statement.close();
				
				stmt.close();
				rs.close();
				stmt = conexiune.createStatement();
				rs   = stmt.executeQuery("Select LICENTE_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				rs.close();
				stmt.close();
				
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertLicenta: "+e.getMessage());
			return -7;
		}
	}
  
	private int insertSesiune( IntrareSesiuni intrare ){
		String apel;	
		try{
			if(intrare.getId()==0){
				apel = " Insert into sesiuni Values(SESIUNI_SEQ.NEXTVAL, ?, ?,? )";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setTimestamp(1, intrare.getInceputSesiune());
				statement.setTimestamp(2, intrare.getSfarsitSesiune());
				statement.setInt(3, intrare.getActive());
				statement.executeUpdate();
				conexiune.commit();
				statement.close();
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Sesiuni_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				
				statement.close();
				stmt.close();
				rs.close();
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from SESIUNI where id ="+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					stmt.close();
					rs.close();
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
				
				apel = " Insert into SESIUNI Values(?, ?, ?,?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getId());
				statement.setTimestamp(2, intrare.getInceputSesiune());
				statement.setTimestamp(3, intrare.getSfarsitSesiune());
				statement.setInt(4, intrare.getActive());
				statement.executeUpdate();
				conexiune.commit();
				
				statement.close();
				stmt.close();
				rs.close();
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertSesiune: "+e.getMessage());
			return -7;
		}
	}
    
	private int dropMesaj( IntrareMesaje intrare ){
		try{
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from mesaje where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				stmt.close();
				rs.close();
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from Mesaje where id ="+intrare.getId());
			conexiune.commit();
			
			statement.close();
			stmt.close();
			rs.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropMesaj:" + e.getMessage());
			return -7;
		}
	}

	private int dropCont( IntrareConturi intrare ){
		try{
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from Conturi where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				stmt.close();
				rs.close();
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from Conturi where id ="+intrare.getId());
			conexiune.commit();
			
			statement.close();
			stmt.close();
			rs.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropCont:" + e.getMessage());
			return -7;
		}
	}
	
	private int dropStudent( IntrareStudenti intrare ){
		try{
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from Studenti where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				stmt.close();
				rs.close();
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from Studenti where id ="+intrare.getId());
			conexiune.commit();
			
			statement.close();
			stmt.close();
			rs.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropStudent:" + e.getMessage());
			return -7;
		}
	}

	private int dropProfesor( IntrareProfesori intrare ){
		try{
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from Profesori where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				stmt.close();
				rs.close();
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from Profesori where id ="+intrare.getId());
			conexiune.commit();
			
			statement.close();
			stmt.close();
			rs.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropProfesor:" + e.getMessage());
			return -7;
		}
	}
    
    private int dropComisie( IntrareComisii intrare ){
		try{
			
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from Comisii where id = "+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				stmt.close();
				rs.close();
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from Comisii where id ="+intrare.getId());
			conexiune.commit();
			
			statement.close();
			stmt.close();
			rs.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropComisie:" + e.getMessage());
			return -7;
		}
	}
    

	private int dropDetaliiLicenta( IntrareDetaliiLicente intrare ){
		try{
			
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from DETALII_LICENTE where id = "+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				stmt.close();
				rs.close();
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from DETALII_LICENTE where id ="+intrare.getId());
			conexiune.commit();
			
			statement.close();
			stmt.close();
			rs.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropDetaliiLicenta:" + e.getMessage());
			return -7;
		}
	}
    
    private int dropLicenta( IntrareLicente intrare ){
		try{
			
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from LICENTE where id = "+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				stmt.close();
				rs.close();
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from LICENTE where id ="+intrare.getId());
			conexiune.commit();
			
			statement.close();
			stmt.close();
			rs.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropLicenta:" + e.getMessage());
			return -7;
		}
	}
    
    private int dropSesiune( IntrareSesiuni intrare ){
		try{
			
			if(intrare.getId()==0) return -1;
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from Sesiuni where id = "+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				stmt.close();
				rs.close();
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			Statement statement = conexiune.createStatement();
			statement.executeUpdate("Delete from SESIUNI where id ="+intrare.getId());
			conexiune.commit();
			
			statement.close();
			stmt.close();
			rs.close();
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la dropSesiune:" + e.getMessage());
			return -7;
		}
	}
}

