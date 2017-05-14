import bd.BD;

public class Main {

	public static void main( String[] args )
	{
		BD bd = new BD();
		System.out.println("Conectat: "+bd.isConnected());
		System.out.println("Logare: "  +bd.login("", "hashparola"));
		System.out.println("Verificare: "+bd.verificare("1"));
		System.out.println("Inregistrare_stud: "+bd.inregistrare_stud("robert.otrocol@info.uaic.ro", "hashparola"));
		System.out.println("Inregistrare_prof: "+bd.inregistrare_prof("andreea.arusoaie", "hashparola"));
	}
	
}
