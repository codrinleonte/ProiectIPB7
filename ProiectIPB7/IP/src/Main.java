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
		
		
		
		if(bd.isConnected())
		{
			AccessBD access = bd.login("Admin", "Root");
			System.out.println(access.getTip());
			if( access.getTip().equals("Access_Admin") )
			{
				AccessAdminBD accessAdmin = ( (AccessAdminBD) access );
				System.out.println(accessAdmin.selectProfesori());
				String ceva = "A";
				byte[] b = ceva.getBytes();
				System.out.println("Set Fisier:"+accessAdmin.setFisierLucrare(1, b));
				System.out.println("Get Fisier:"+accessAdmin.getFisierLucrare(1)[0]);
				System.out.println("Update Sesiune Active:"+accessAdmin.updateSesiuneActive(99));
				System.out.println("Get Sesiune Active:"+accessAdmin.selectSesiuni().get(0).getActive());
				System.out.println("Coordonatori fara comisie:"+accessAdmin.profesoriCoordonatoriFaraComisie());
			}
		}
		
	}
}
