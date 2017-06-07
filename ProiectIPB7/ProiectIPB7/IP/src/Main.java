import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bd.*;

@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
        BD bd = new BD();

        System.out.println("Conectat: " + bd.isConnected());

        System.out.println("Inregistrare_stud: "+bd.inregistrare_stud("test.test@info.uaic.ro", "test"));
        System.out.println("Verificare: "+bd.verificare("40366426737302178264"));
        System.out.println("Logare: " +bd.login("test.test", "test"));

        //System.out.println(bd.inregistrare_prof("lenuta.alboaie", "parola"));
        //System.out.println(bd.login("lenuta.alboaie","parola"));

		
		
		/*if(bd.isConnected())
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
				System.out.println("Set Comisie prof:"+accessAdmin.setComisieProfesor(1, 5));
				System.out.println("Creare Comisie:"+ accessAdmin.creareComisie(0));
				System.out.println("Set Membru Comisie:"+ accessAdmin.setMembruComisie(1,6,1));
				System.out.println("Set Membru Comisie:"+ accessAdmin.setMembruComisie(2,6,2));
				System.out.println("Set Membru Comisie:"+ accessAdmin.setMembruComisie(3,6,3));
				System.out.println("Set Membru Comisie:"+ accessAdmin.setMembruComisie(4,6,4));
				System.out.println("Set Sala   Comisie:"+ accessAdmin.setSalaComisie(1,"Sala"));
			}
		}*/

    }
}
