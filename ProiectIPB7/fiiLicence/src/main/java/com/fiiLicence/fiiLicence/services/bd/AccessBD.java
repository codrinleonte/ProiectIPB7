package com.fiiLicence.fiiLicence.services.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccessBD {

    protected int idCont;
    protected String tip;
    protected UserBD user;
    protected Connection conexiune;

    public AccessBD() {

    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getTip() {
        return tip;
    }

    public void setIdCont(int idCont) {
        this.idCont = idCont;
    }

    public int getIdCont() {
        return idCont;
    }

    public UserBD getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "AccessBD [idCont=" + idCont + ", tip=" + tip + ", user=" + user + ", conexiune=" + conexiune + "]";
    }

    /*
      * functie care returneaza o istanta
      * IntrareComisii cu atributele corespunzatoare
      * id-ului dat ca parametru
     */
    public IntrareComisii getCommitteeById(int idCommitttee) {
        IntrareComisii rezultat = new IntrareComisii();
        try {

            PreparedStatement statement = conexiune.prepareStatement("Select * from comisii where id = ?");
            statement.setInt(1, idCommitttee);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                rezultat.setId(result.getInt(1));
                rezultat.setIdProfSef(result.getInt(2));
                rezultat.setIdProf2(result.getInt(3));
                rezultat.setIdProf3(result.getInt(4));
                rezultat.setIdProf4(result.getInt(5));
                rezultat.setIdSecretar(result.getInt(6));
                rezultat.setTipComisie(result.getString(7));
                rezultat.setIdEvaluare(result.getInt(8));
            }
            return rezultat;
        } catch (SQLException e) {
            System.out.println("Exceptie la selectComisii: " + e.getMessage());
            return null;
        }

    }

    public IntrareComisii getCommitteByProf(int idProf) {
        IntrareComisii intrare = new IntrareComisii();
        try {
            PreparedStatement pStatement = conexiune.prepareStatement("select * from comisii c join profesori p on c.id = p.id_comisie where p.id = ?");
            pStatement.setInt(1, idProf);
            ResultSet result = pStatement.executeQuery();
            if (result.next() && result != null) {

                intrare.setId(result.getInt(1));
                intrare.setIdProfSef(result.getInt(2));
                intrare.setIdProf2(result.getInt(3));
                intrare.setIdProf3(result.getInt(4));
                intrare.setIdProf4(result.getInt(5));
                intrare.setIdSecretar(result.getInt(6));
                intrare.setTipComisie(result.getString(7));
                intrare.setIdEvaluare(result.getInt(8));

            }
            return intrare;

        } catch (Exception e) {
            System.out.println("Exceptie la selectComisii: " + e.getMessage());
            return null;
        }

    }
    public int updateComisie( IntrareComisii intrare ){
        if(intrare.getId()==0) return -1;
        String apel=" Update comisii set ID_Prof1 = ? , ID_Prof2 = ? , ID_Prof3 =?, ID_Prof4_Dizertatie = ?, ID_Secretar = ?, Tip_Comisie = ?, ID_Evaluare = ? where id = ? ";
        try{

            Statement  stmt = conexiune.createStatement();
            ResultSet  rs   = stmt.executeQuery("Select Count(*) from comisii where id ="+intrare.getId());
            rs.next();
            if( rs.getInt(1) == 0 ) {
                System.out.println("Intrare Inexistenta");
                return -1;
            }

            PreparedStatement statement = conexiune.prepareStatement(apel);
            statement.setInt(1, intrare.getIdProfSef());
            statement.setInt(2, intrare.getIdProf2());
            statement.setInt(3, intrare.getIdProf3());
            statement.setInt(4, intrare.getIdProf4());
            statement.setInt(5, intrare.getIdSecretar());
            statement.setString(6, intrare.getTipComisie());
            statement.setInt(7, intrare.getIdEvaluare());
            statement.setInt(8, intrare.getId());
            statement.executeUpdate();
            conexiune.commit();
            return 0;
        }
        catch( Exception e ){
            System.out.println("Exceptie la updateComisie" + e.getMessage());
            return -7;
        }

    }


    public IntrareProfesori getProfesorById(int idProf) {
        IntrareProfesori intrare = new IntrareProfesori();
        try {
            Statement statement = conexiune.createStatement();
            ResultSet result = statement.executeQuery("Select * from profesori");
            while (result.next()) {

                intrare.setId(result.getInt(1));
                intrare.setIdCont(result.getInt(2));
                intrare.setNume(result.getString(3));
                intrare.setPrenume(result.getString(4));
                intrare.setGradDidactic(result.getString(5));
                intrare.setFunctieComisie(result.getString(6));

            }
            return intrare;
        } catch (Exception e) {
            System.out.println("Exceptie la selectProfesori :" + e.getMessage());
            return null;
        }

    }


    public List<IntrareStudenti> getStudentsByCommitte(int idCommitte) {
        List<IntrareStudenti> listaStudenti = new ArrayList<IntrareStudenti>();
        try {
            PreparedStatement statement = conexiune.prepareStatement("Select * from studenti where id_comisie = ?");
            statement.setInt(1, idCommitte);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                IntrareStudenti intrare = new IntrareStudenti();
                intrare.setId(result.getInt(1));
                intrare.setIdCont(result.getInt(2));
                intrare.setNrMatricol(result.getString(3));
                intrare.setNume(result.getString(4));
                intrare.setPrenume(result.getString(5));
                intrare.setId_comisie(result.getInt(6));
                intrare.setIdSesiune(result.getInt(7));
                listaStudenti.add(intrare);
            }
            return listaStudenti;
        } catch (Exception e) {
            System.out.println("Exceptie la selectStudenti:" + e.getMessage());
            return null;
        }
    }

    public List<IntrareProfesori> getProfesorsWithoutCommittee() {
        List<IntrareProfesori> rezultat = new ArrayList<IntrareProfesori>();
        try {
            Statement statement = conexiune.createStatement();
            ResultSet result = statement.executeQuery("Select * from profesori where id_comisie is null");
            while (result.next()) {
                IntrareProfesori intrare = new IntrareProfesori();
                intrare.setId(result.getInt(1));
                intrare.setIdCont(result.getInt(2));
                intrare.setNume(result.getString(3));
                intrare.setPrenume(result.getString(4));
                intrare.setGradDidactic(result.getString(5));
                intrare.setFunctieComisie(result.getString(6));
                rezultat.add(intrare);
            }
            return rezultat;
        } catch (Exception e) {
            System.out.println("Exceptie la getProfesorsWithoutCommittee :" + e.getMessage());
            return null;
        }
    }

    public List<IntrareProfesori> selectProfesori() {
        List<IntrareProfesori> rezultat = new ArrayList<IntrareProfesori>();
        try {
            Statement statement = conexiune.createStatement();
            ResultSet result = statement.executeQuery("Select * from profesori");
            while (result.next()) {
                IntrareProfesori intrare = new IntrareProfesori();
                intrare.setId(result.getInt(1));
                intrare.setIdCont(result.getInt(2));
                intrare.setNume(result.getString(3));
                intrare.setPrenume(result.getString(4));
                intrare.setGradDidactic(result.getString(5));
                intrare.setFunctieComisie(result.getString(6));
                rezultat.add(intrare);
            }
            return rezultat;
        } catch (Exception e) {
            System.out.println("Exceptie la selectProfesori :" + e.getMessage());
            return null;
        }
    }


}
