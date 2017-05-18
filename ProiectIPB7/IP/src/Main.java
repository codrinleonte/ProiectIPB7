import java.util.ArrayList;
import java.util.List;

import bd.*;

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
			
		}
		else System.out.println("Logare | Conectare esuata");
		
	}
}
