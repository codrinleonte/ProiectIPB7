package bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class AccessAdminBD extends AccessBD {

	AccessAdminBD( Connection conexiune , UserBD user )
	{
		this.conexiune = conexiune;
		this.tip = "Access_Admin";
		this.user = user;
	}
	
	public Vector<IntrareMesaje> selectMesaje(){
		Vector<IntrareMesaje> rezultat = new Vector<IntrareMesaje>();
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
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectMesaje: "+e.getMessage());
			return null;
		}
		
	}

	public Vector<IntrareConturi> selectConturi(){
		Vector<IntrareConturi> rezultat = new Vector<IntrareConturi>();
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
				rezultat.add(intrare);
			}
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectConturi :"+e.getMessage());
			return null;
		}
	}

	public Vector<IntrareStudenti> selectStudenti(){
		Vector<IntrareStudenti> rezultat = new Vector<IntrareStudenti>();
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
				intrare.setIdSesiune(result.getInt(6));
				rezultat.add(intrare);
			}
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectStudenti:"+e.getMessage());
			return null;
		}		
	}

	public Vector<IntrareProfesori> selectProfesori(){
		Vector<IntrareProfesori> rezultat = new Vector<IntrareProfesori>();
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
				intrare.setFunctieComisie(result.getString(6));
				rezultat.add(intrare);
			}
			return rezultat;
		}
		catch( Exception e ){
			System.out.println("Exceptie la selectProfesori :"+e.getMessage());
			return null;
		}		
	}

	public int updateMesaj( IntrareMesaje intrare ){
		if(intrare.getId()==0) return -1;
		String apel=" Update Mesaje set iD_Emitator = ? , ID_Destinatar = ? , Mesaj = ? where id = ? ";
		try{
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from mesaje where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1, intrare.getIdEmitator());
			statement.setInt(2, intrare.getIdDestinatar());
			statement.setString(3, intrare.getMesaj());
			statement.setInt(4, intrare.getId());
			statement.executeUpdate();	
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateMesaj" + e.getMessage());
			return -7;
		}
		
	}

	public int updateCont( IntrareConturi intrare ){
		if(intrare.getId()==0) return -1;
		String apel=" Update Conturi set USERNAME = ? , PAROLA = ? , EMAIL = ? ,  TIP_UTILIZATOR=? , STATUS=? ,COD_ACTIVARE=? where id = ? ";
		try{
			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from conturi where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setString(1, intrare.getUsername());
			statement.setString(2,intrare.getHashparola());
			statement.setString(3, intrare.getEmail());
			statement.setString(4,intrare.getTipUtilizator());
			statement.setInt(5, intrare.getStatus());
			statement.setString(6,intrare.getCodActivare());
			statement.setInt(7, intrare.getId());
			statement.executeUpdate();	
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateMesaj" + e.getMessage());
			return -7;
		}
		
	}

	public int updateStudent( IntrareStudenti intrare ){
		if(intrare.getId()==0) return -1;
		String apel=" Update studenti set ID_CONT = ? , NR_MATRICOL = ? , NUME = ? ,  PRENUME=? , ID_SESIUNE=? where id = ? ";
		try{
			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from studenti where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
				System.out.println("Intrare Inexistenta");
				return -1;
			}
			
			PreparedStatement statement = conexiune.prepareStatement(apel);
			statement.setInt(1, intrare.getIdCont());
			statement.setString(2, intrare.getNrMatricol());
			statement.setString(3, intrare.getNume());
			statement.setString(4, intrare.getPrenume());
			statement.setInt(5, intrare.getIdSesiune());
			statement.setInt(6, intrare.getId());
			statement.executeUpdate();	
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateStudent" + e.getMessage());
			return -7;
		}	
	}
	
	public int updateProfesor( IntrareProfesori intrare){
		if(intrare.getId()==0) return -1;
		String apel=" Update profesori set ID_CONT = ? ,NUME = ? ,  PRENUME=? ,GRAD_DIDACTIC=?,ID_COMISIE=?,FUNCTIE_COMISIE=? where id = ? ";
		try{
			
			Statement  stmt = conexiune.createStatement();
			ResultSet  rs   = stmt.executeQuery("Select Count(*) from profesori where id ="+intrare.getId());
			rs.next();
			if( rs.getInt(1) == 0 ) {
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
			return 0;
		}
		catch( Exception e ){
			System.out.println("Exceptie la updateProfesor" + e.getMessage());
			return -7;
		}	
		
	}

	public int insertMesaj( IntrareMesaje intrare ){
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
				
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from MESAJE where id ="+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
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
				
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertMesaj: "+e.getMessage());
			return -7;
		}
	}

	public int insertCont( IntrareConturi intrare){
		String apel;	
		try{
			
			if(intrare.getId()==0){
				apel = " Insert into Conturi Values(CONTURI_SEQ.NEXTVAL, ?, ? ,?, ?, ? , ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setString(1, intrare.getUsername());
				statement.setString(2, intrare.getHashparola());
				statement.setString(3, intrare.getEmail());
				statement.setString(4, intrare.getTipUtilizator());	
				statement.setInt(5, intrare.getStatus());
				statement.setString(6, intrare.getCodActivare());
				statement.executeUpdate();
				
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select CONTURI_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from CONTURI where id ="+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
				
				apel = " Insert into Conturi Values(? , ?, ? ,?, ?, ? , ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getId());
				statement.setString(2, intrare.getUsername());
				statement.setString(3, intrare.getHashparola());
				statement.setString(4, intrare.getEmail());
				statement.setString(5, intrare.getTipUtilizator());
				statement.setInt(6, intrare.getStatus());
				statement.setString(7, intrare.getCodActivare());
				statement.executeUpdate();
				
				
				
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertCont: "+e.getMessage());
			return -7;
		}		
	}
	
	public int insertStudent( IntrareStudenti intrare){
		
		String apel;	
		try{
			
			if(intrare.getId()==0){
				apel = " Insert into STUDENTI Values(STUDENTI_SEQ.NEXTVAL, ?, ? ,?, ?, ?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getIdCont());
				statement.setString(2,intrare.getNrMatricol());
				statement.setString(3,intrare.getNume());
				statement.setString(4,intrare.getPrenume());
				statement.setInt(5,intrare.getIdSesiune());
				statement.executeUpdate();
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select STUDENTI_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
				return 0;
			}
			else{
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select Count(*) from STUDENTI where id ="+intrare.getId());
				rs.next();
				if( rs.getInt(1) > 0 ) {
					System.out.println("Intrare Existenta. Update?");
					return -1;
				}
				
				apel = " Insert into Studenti Values(?, ?, ? ,?)";
				PreparedStatement statement = conexiune.prepareStatement(apel);
				statement.setInt(1,intrare.getId());
				statement.setInt(2,intrare.getIdCont());
				statement.setString(3,intrare.getNrMatricol());
				statement.setString(4,intrare.getNume());
				statement.setString(5,intrare.getPrenume());
				statement.setInt(6,intrare.getIdSesiune());
				statement.executeUpdate();
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertStudent: "+e.getMessage());
			return -7;
		}		
		
	}
	
	public int insertProfesor( IntrareProfesori intrare){
		
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
				
				Statement  stmt = conexiune.createStatement();
				ResultSet  rs   = stmt.executeQuery("Select PROFESORI_SEQ.CURRVAL from dual");
				rs.next();
				intrare.setId(rs.getInt(1));
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
				return 0;
			}
		}
		catch( Exception e ){
			System.out.println("Exceptie la insertProfesori: "+e.getMessage());
			return -7;
		}		
		
	}
}
