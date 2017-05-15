import java.util.Vector;
import bd.*;
import model.messages.MessageBD;
import model.users.User;
import model.users.types.*;

public class Main {

	public static void main( String[] args )
	{
		BD bd = new BD();
		System.out.println("Conectat: "+bd.isConnected());
		System.out.println("Inregistrare_stud: "+bd.inregistrare_stud("robert.otrocol@info.uaic.ro", "hashparola"));
		
		System.out.println("Inregistrare_prof: "+bd.inregistrare_prof("andreea.arusoaie", "hashparola"));
		System.out.println("Logare: "  +bd.login("Admin","Root"));
		
		System.out.println("Verificare: "+bd.verificare("52048607175574743650"));
		//System.out.println("Locare: " +bd.login("robert.otrocol", "hashparola"));
		
		
		AccessBD access=bd.getAccess();
		User user = access.getUser();
		System.out.println(user);
		
		Vector <Teacher> listaProfi =  access.fetchListaProfesori();
		System.out.println(listaProfi);
		
		Vector <Account> listaConturi   =  ((AccessAdminBD) access).fetchConturi();
		System.out.println(listaConturi);
		
		Vector <MessageBD> listaMesaje  =  ((AccessAdminBD) access).fetchMesaje();
		System.out.println(listaMesaje);
		
		Vector <Student>  listaStudenti = ((AccessAdminBD) access).fetchStudenti();
		System.out.println(listaStudenti);
		
		
	}
}
