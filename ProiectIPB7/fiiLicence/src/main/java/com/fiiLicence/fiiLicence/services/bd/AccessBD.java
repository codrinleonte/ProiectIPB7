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

    public int getIdCont(int idCont) {
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

}
