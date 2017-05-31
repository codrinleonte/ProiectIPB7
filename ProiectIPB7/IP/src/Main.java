import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bd.*;

@SuppressWarnings("unused")
public class Main {

	public static void main( String[] args )
	{
		BD bd = new BD();
		
		System.out.println("Conectat: "+bd.isConnected());
		
		//System.out.println("Inregistrare_stud: "+bd.inregistrare_stud("robert.otrocol@info.uaic.ro", "hashparola"));
		//System.out.println("Verificare: "+bd.verificare("80667163180736378150"));
		//System.out.println("Logare: " +bd.login("robert.otrocol", "hashparola"));
		
		//System.out.println(bd.inregistrare_prof("lenuta.alboaie", "parola"));
		//System.out.println(bd.login("lenuta.alboaie","parola"));
		
		System.out.println("Logare: "+bd.login("Admin", "Root"));
		
		
		if(bd.isLoged() && bd.isConnected())
		{
			AccessBD access = bd.getAccess();
			System.out.println("Username: "+access.getUser().getUsername());
			System.out.println("IdCont: "+ access.getIdCont());
			
			AccessAdminBD  accessAdmin = ((AccessAdminBD) access);
			System.out.println("Setare token: "+bd.setTokenByIdCont(accessAdmin.getIdCont(), "Token Ciudat"));
			System.out.println("getContByToken: "+bd.getContByToken("Token Ciudat"));
			
			System.out.println("setDataSustinere:" + accessAdmin.setDataSustinere(1, new Timestamp(System.currentTimeMillis()) ));
			System.out.println("getDataSustinere:" + accessAdmin.getDataSustinere(1));
			System.out.println("setComisieProfesor:" + accessAdmin.setComisieProfesor(1,1));
			System.out.println("getSala:"+ accessAdmin.getSala(1));
			System.out.println("setComisieProfesori:"+ accessAdmin.setComisieProfesor(1, 2));
		}
		else System.out.println("Logare | Conectare esuata");
		
	}
}
