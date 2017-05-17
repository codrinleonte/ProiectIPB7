package com.fiiLicence.fiiLicence.services.bd;

import com.fiiLicence.fiiLicence.models.response.CommitteListResponse;
import com.fiiLicence.fiiLicence.models.response.IdResponse;
import com.fiiLicence.fiiLicence.services.DatabaseServiceImpl;

import java.io.PrintStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main( String [] args ){
    	//aici ai exemplu cum functioneaza Bd ... 
        BD bd = new BD();
        System.out.println(bd.isConnected());

        System.out.println(bd.inregistrare_stud("marian.gica@info.uaic.ro","parola"));
        System.out.println(bd.verificare("03624201201451881688"));

        bd.login("Admin","Root");
        System.out.println(bd.isLoged());
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
        
        
 //-------------------------------------verificare getProfsWithoutCommitte ----------------       
        
      
        IntrareComisii rez = bd.getAccess().getCommitteeById(1);
        System.out.println(rez);
        DatabaseServiceImpl dataBaseService = new DatabaseServiceImpl();
        
       
       
        
 //-----------------------------------verificare getCommitteList----------------------------
        
       
        
        List<CommitteListResponse> comRespList = dataBaseService.getCommitteList("1");
        System.out.println(comRespList.size());
        for (CommitteListResponse c : comRespList)
            System.out.println(c.id + " " + c.numeComisie + " "  + c.dataExaminare);
    }
}
