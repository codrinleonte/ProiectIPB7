import java.util.Vector;
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
		
			/*
			//Teste Mesaje  
			Vector<IntrareMesaje> mesaje = accessAdmin.selectMesaje();
			System.out.println("Mesaje:"+mesaje);	
			IntrareMesaje mesaj = new IntrareMesaje();
			mesaj.setIdDestinatar(1);
			mesaj.setIdEmitator(2);
			mesaj.setMesaj("ceva ciuuudat");
			accessAdmin.insertMesaj(mesaj);
			mesaj.setMesaj("Modificat");
			accessAdmin.updateMesaj(mesaj);
			mesaj.setId(40);
			accessAdmin.dropMesaj(mesaj);
			*/
			
			
			/*
			//TesteConturi
			Vector<IntrareConturi> conturi = accessAdmin.selectConturi();
			System.out.println("Conturi:"+conturi);
			IntrareConturi cont = new IntrareConturi();
			cont.setTipUtilizator("ceva ciuuuudat");
			accessAdmin.insertCont(cont);
			accessAdmin.dropCont(cont);
			*/
			
			
			/*
			//Teste Studenti
			Vector<IntrareStudenti> studenti = accessAdmin.selectStudenti();
			System.out.println("Studenti:"+studenti);
			IntrareStudenti student = new IntrareStudenti();
			student.setNume("Ceva Ciuuudat");
			accessAdmin.insertStudent(student);
			student.setNume("Modificat");
			accessAdmin.updateStudent(student);
			accessAdmin.dropStudent(student);
			*/
			
			
			/*
			//Teste Profesori
			Vector<IntrareProfesori> profesori = accessAdmin.selectProfesori();
			System.out.println("Profesori:"+profesori);
			IntrareProfesori profesor = new IntrareProfesori();
			profesor.setId(133);
			profesor.setNume("Cevaaa ciudat");
			accessAdmin.insertProfesor( profesor );
			accessAdmin.dropProfesor(profesor);
			*/
			

		}
		else System.out.println("Logare | Conectare esuata");
		
	}
}
