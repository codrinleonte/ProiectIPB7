import bd.*;
import model.users.User;

public class Main {

	public static void main( String[] args )
	{
		BD bd = new BD();
		System.out.println("Conectat: "+bd.isConnected());
		System.out.println("Inregistrare_stud: "+bd.inregistrare_stud("robert.otrocol@info.uaic.ro", "hashparola"));
		
		System.out.println("Inregistrare_prof: "+bd.inregistrare_prof("andreea.arusoaie", "hashparola"));
		//System.out.println("Logare: "  +bd.login("andreea.arusoaie","hashparola"));
		
		System.out.println("Verificare: "+bd.verificare("52048607175574743650"));
		System.out.println("Locare: " +bd.login("robert.otrocol", "hashparola"));
		
		
		AccessBD access=bd.getAccess();
		User user = access.getUser();
		System.out.println(user);
		
		
	}
}
