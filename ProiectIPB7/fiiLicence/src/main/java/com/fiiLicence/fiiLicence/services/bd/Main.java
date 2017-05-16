package com.fiiLicence.fiiLicence.services.bd;
import com.fiiLicence.fiiLicence.services.DatabaseServiceImpl;
import sun.security.provider.MD5;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main( String [] args ){

        BD bd = new BD();
        System.out.println(bd.isConnected());

        System.out.println(bd.inregistrare_stud("marian.gica@info.uaic.ro","parola"));
        System.out.println(bd.verificare("03624201201451881688"));

        System.out.println(bd.login("marian.gica","parola"));
        System.out.println(bd.isLoged());

        bd.login("Admin","Root");

        AccessBD access = bd.getAccess();
        System.out.println(access.getTip());

        AccessAdminBD accessStudent = ((AccessAdminBD) access );

        List<IntrareProfesori> profesori = new ArrayList<IntrareProfesori>();
        profesori = accessStudent.selectProfesori();

        IntrareProfesori profesor = new IntrareProfesori();
        profesor.setId(100);
        profesor.setNume("Cevaa ciudaaat");

        accessStudent.insertProfesor(profesor);

        int result = bd.verificare("28768364612062147362");
        System.out.println(result);


        System.out.println(profesori);
    }
}
