package com.fiiLicence.fiiLicence.services.bd;

import com.fiiLicence.fiiLicence.models.response.CommitteListResponse;
import com.fiiLicence.fiiLicence.models.response.IdResponse;
import com.fiiLicence.fiiLicence.models.response.ProfListResponse;
import com.fiiLicence.fiiLicence.services.DatabaseServiceImpl;

import java.io.PrintStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //aici ai exemplu cum functioneaza Bd ...
        BD bd = new BD();
        System.out.println(bd.isConnected());

        System.out.println(bd.inregistrare_stud("marian.gica@info.uaic.ro", "parola"));
        System.out.println(bd.verificare("26310775315331372186"));

   /*     bd.login("Admin","Root");
        System.out.println(bd.isLoged());
        AccessBD access = bd.getAccess();
        System.out.println(access.getTip());

        AccessAdminBD accessStudent = ((AccessAdminBD) access );

        List<IntrareProfesori> profesori = new ArrayList<IntrareProfesori>();
        profesori = accessStudent.selectProfesori();
        System.out.println(profesori);

        IntrareProfesori profesor = new IntrareProfesori();
        profesor.setId(100);
        profesor.setNume("Cevaa ciudaaat");

        accessStudent.insertProfesor(profesor);

        int result = bd.verificare("28768364612062147362");
        System.out.println(result);*/


        //-------------------------------------verificare getProfsWithoutCommitte ----------------


        // IntrareComisii rez = bd.getAccess().getCommitteeById(1);
        // System.out.println(rez);
     /*   DatabaseServiceImpl dataBaseService = new DatabaseServiceImpl();




        //-----------------------------------verificare getCommitteList----------------------------



        List<CommitteListResponse> comRespList = dataBaseService.getCommitteList("1");
        System.out.println(comRespList.size());
        for (CommitteListResponse c : comRespList)
            System.out.println(c.getId() + " " + c.getNumeComisie() + " "  + c.getDataExaminare());

        //date
        System.out.println("Logare: "+bd.login("Admin", "Root"));

       bd.setTokenByIdCont("marian.gica@info.uaic.ro","test");*/
        // bd.setTokenByIdCont(4,"30ed807e4c78b937222ca5938ec65278");


       /* List<ProfListResponse> profList = new ArrayList<ProfListResponse>();
        List<IntrareProfesori> profesori = new ArrayList<IntrareProfesori>();
        boolean verifyToken = true;
        if (verifyToken == true) {
            bd.login("Admin", "Root");
            AccessBD access = bd.getAccess();
            profesori = access.selectProfesori();
            for (IntrareProfesori profesor : profesori) {
                ProfListResponse profesorList = new ProfListResponse();
                profesorList.setId(profesor.getId());
                profesorList.setNumeProf(profesor.getNume());
                profesorList.setPrenumeProf(profesor.getPrenume());
                profesorList.setEmailProf(profesor.getNume() + '.' + profesor.getPrenume() + "@info.uaic.ro");
                profesorList.setIdComisie(profesor.getIdComisie());
                profList.add(profesorList);
            }
        }
        System.out.println(profList);*/
      /* AccessBD accessBD = bd.getAccess();
       accessBD = (AccessAdminBD) accessBD;
       IntrareProfesori profesor = new IntrareProfesori();
       profesor.setId(41);
       profesor.setIdComisie(1);
       ((AccessAdminBD) accessBD).updateProfesor(profesor);*/
       /* AccessAdminBD accessAdminBD = (AccessAdminBD) bd.getAccess();
        IntrareLicente licenta = new IntrareLicente();
        licenta.setId(3);
        licenta.setTitlu("Licenta test");
        licenta.setTipLucrare("Licenta");
        System.out.println(accessAdminBD.insertLicenta(licenta));*/
        DatabaseServiceImpl se = new DatabaseServiceImpl();
        boolean result = se.insertStudentToListProf(2, "jimmy","jimmy");
        System.out.println("ceva");
    }



}