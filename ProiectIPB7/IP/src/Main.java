import bd.*;

public class Main {

	public static void main( String[] args )
	{
		BD bd = new BD();
		
		System.out.println("Conectat: "+bd.isConnected());
		
		System.out.println("Inregistrare_stud: "+bd.inregistrare_stud("robert.otrocol@info.uaic.ro", "hashparola"));
		System.out.println("Verificare: "+bd.verificare("83583581482831666356"));
		System.out.println("Logare: " +bd.login("robert.otrocol", "hashparola"));
		
		
		bd.login("Admin", "Root");
		
		if(bd.isLoged() && bd.isConnected())
		{
			AccessBD access = bd.getAccess();
			AccessAdminBD  accessAdmin	= (AccessAdminBD) access;
			System.out.println(accessAdmin.getUser());
		}
		else System.out.println("Logare | Conectare esuata");
		
	}
}
