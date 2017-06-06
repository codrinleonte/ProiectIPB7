package com.fiiLicence.fiiLicence.services.bd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccessProfesorBD extends AccessBD {

    AccessProfesorBD(Connection conexiune, UserBD user) {
        this.conexiune = conexiune;
        this.tip = "Access_Teacher";
        this.user = user;
    }

    public List<IntrareMesaje> selectMesaje() {
        List<IntrareMesaje> rezultat = new ArrayList<IntrareMesaje>();
        try {
            Statement statement = conexiune.createStatement();
            ResultSet result = statement.executeQuery("Select * from mesaje");
            while (result.next()) {
                IntrareMesaje intrare = new IntrareMesaje();
                intrare.setId(result.getInt(1));
                intrare.setIdEmitator(result.getInt(2));
                intrare.setIdDestinatar(result.getInt(3));
                intrare.setMesaj(result.getString(4));
                rezultat.add(intrare);
            }
            return rezultat;
        } catch (Exception e) {
            System.out.println("Exceptie la selectMesaje: " + e.getMessage());
            return null;
        }

    }

    public List<IntrareDetaliiLicente> selectDetaliiLicente() {
        List<IntrareDetaliiLicente> rezultat = new ArrayList<IntrareDetaliiLicente>();
        try {

            Statement statement = conexiune.createStatement();
            ResultSet result = statement.executeQuery("Select * from detalii_licente");
            while (result.next()) {
                IntrareDetaliiLicente intrare = new IntrareDetaliiLicente();
                intrare.setId(result.getInt(1));
                intrare.setIdComisie(result.getInt(2));
                intrare.setNota1Oral(result.getInt(3));
                intrare.setNota1Proiect(result.getInt(4));
                intrare.setNota2Oral(result.getInt(5));
                intrare.setNota2Proiect(result.getInt(6));
                intrare.setNota3Oral(result.getInt(7));
                intrare.setNota3Proiect(result.getInt(8));
                intrare.setNota4Oral(result.getInt(9));
                intrare.setNota4Proiect(result.getInt(10));
                intrare.setNota5Oral(result.getInt(11));
                intrare.setNota5Proiect(result.getInt(12));
                intrare.setDataOraSustinerii(result.getTimestamp(13));

                rezultat.add(intrare);
            }

            return rezultat;
        } catch (Exception e) {
            System.out.println("Exceptie la selectDetaliiLicente: " + e.getMessage());
            return null;
        }
    }


    public List<IntrareLicente> selectLicente() {
        List<IntrareLicente> rezultat = new ArrayList<IntrareLicente>();
        try {

            Statement statement = conexiune.createStatement();
            ResultSet result = statement.executeQuery("Select * from licente");
            while (result.next()) {
                IntrareLicente intrare = new IntrareLicente();
                intrare.setId(result.getInt(1));
                intrare.setTitlu(result.getString(2));
                intrare.setIdProfesor(result.getInt(3));
                intrare.setIdStudent(result.getInt(4));
                intrare.setMaterialeLicenta(result.getString(5));
                intrare.setIdSesiune(result.getInt(6));
                intrare.setTipLucrare(result.getString(7));

                rezultat.add(intrare);
            }

            return rezultat;
        } catch (Exception e) {
            System.out.println("Exceptie la selectLicente: " + e.getMessage());
            return null;
        }
    }

    public List<IntrareSesiuni> selectSesiuni() {
        List<IntrareSesiuni> rezultat = new ArrayList<IntrareSesiuni>();
        try {

            Statement statement = conexiune.createStatement();
            ResultSet result = statement.executeQuery("Select * from sesiuni");
            while (result.next()) {
                IntrareSesiuni intrare = new IntrareSesiuni();
                intrare.setId(result.getInt(1));
                intrare.setInceputSesiune(result.getTimestamp(2));
                intrare.setSfarsitSesiune(result.getTimestamp(3));
                intrare.setActive(result.getInt(4));
                rezultat.add(intrare);
            }
            return rezultat;
        } catch (Exception e) {
            System.out.println("Exceptie la selectSesiuni: " + e.getMessage());
            return null;
        }
    }

    public int updateStudent(IntrareStudenti intrare) {
        if (intrare.getId() == 0) return -1;
        String apel = " Update studenti set ID_CONT = ? , NR_MATRICOL = ? , NUME = ? ,  PRENUME=? , ID_COMISIE = ? , ID_SESIUNE=? where id = ? ";
        try {

            Statement stmt = conexiune.createStatement();
            ResultSet rs = stmt.executeQuery("Select Count(*) from studenti where id =" + intrare.getId());
            rs.next();
            if (rs.getInt(1) == 0) {
                System.out.println("Intrare Inexistenta");
                return -1;
            }

            PreparedStatement statement = conexiune.prepareStatement(apel);
            statement.setInt(1, intrare.getIdCont());
            statement.setString(2, intrare.getNrMatricol());
            statement.setString(3, intrare.getNume());
            statement.setString(4, intrare.getPrenume());
            statement.setInt(5, intrare.getIdSesiune());
            statement.setInt(6, intrare.getId_comisie());
            statement.setInt(7, intrare.getId());
            statement.executeUpdate();
            return 0;
        } catch (Exception e) {
            System.out.println("Exceptie la updateStudent" + e.getMessage());
            return -7;
        }
    }

    public List<IntrareStudenti> selectStudenti() {
        List<IntrareStudenti> rezultat = new ArrayList<IntrareStudenti>();
        try {
            Statement statement = conexiune.createStatement();
            ResultSet result = statement.executeQuery("Select * from studenti");
            while (result.next()) {
                IntrareStudenti intrare = new IntrareStudenti();
                intrare.setId(result.getInt(1));
                intrare.setIdCont(result.getInt(2));
                intrare.setNrMatricol(result.getString(3));
                intrare.setNume(result.getString(4));
                intrare.setPrenume(result.getString(5));
                intrare.setId_comisie(result.getInt(6));
                intrare.setIdSesiune(result.getInt(7));
                rezultat.add(intrare);
            }
            return rezultat;
        } catch (Exception e) {
            System.out.println("Exceptie la selectStudenti:" + e.getMessage());
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
                intrare.setIdComisie(result.getInt(6));
                intrare.setFunctieComisie(result.getString(7));
                rezultat.add(intrare);
            }
            return rezultat;
        } catch (Exception e) {
            System.out.println("Exceptie la selectProfesori :" + e.getMessage());
            return null;
        }
    }


    public int updateLicenta(IntrareLicente intrare) {
        if (intrare.getId() == 0) return -1;
        String apel = " Update licente set titlu = ?, id_profesor = ?, id_student = ?, materiale_licenta = ?, id_sesiune = ?, tip = ? where id = ? ";
        try {
            Statement stmt = conexiune.createStatement();
            ResultSet rs = stmt.executeQuery("Select Count(*) from licente where id =" + intrare.getId());
            rs.next();
            if (rs.getInt(1) == 0) {
                System.out.println("Intrare Inexistenta");
                return -1;
            }

            PreparedStatement statement = conexiune.prepareStatement(apel);
            statement.setString(1, intrare.getTitlu());
            statement.setInt(2, intrare.getIdProfesor());
            statement.setInt(3, intrare.getIdStudent());
            statement.setString(4, intrare.getMaterialeLicenta());
            statement.setInt(5, intrare.getIdSesiune());
            statement.setString(6, intrare.getTipLucrare());
            statement.setInt(7, intrare.getId());
            statement.executeUpdate();
            conexiune.commit();

            return 0;
        } catch (Exception e) {
            System.out.println("Exceptie la updateLicenta" + e.getMessage());
            return -7;
        }

    }

    public int updateDetaliiLicenta(IntrareDetaliiLicente intrare) {
        if (intrare.getId() == 0) return -1;
        String apel = " Update detalii_licente set id_comisie = ?, nota_1_oral = ?, nota_1_proiect = ?, nota_2_oral = ?, nota_2_proiect = ?, nota_3_oral = ?, nota_3_proiect = ?, nota_4_oral_dizertatie = ?, nota_4_proiect_dizertatie = ?, nota_5_oral_coordonator=?, nota_5_proiect_coordonator=?, data_ora_sustinere = ? where id = ? ";
        try {

            Statement stmt = conexiune.createStatement();
            ResultSet rs = stmt.executeQuery("Select Count(*) from detalii_licente where id =" + intrare.getId());
            rs.next();
            if (rs.getInt(1) == 0) {
                System.out.println("Intrare Inexistenta");
                return -1;
            }

            PreparedStatement statement = conexiune.prepareStatement(apel);
            statement.setInt(1, intrare.getIdComisie());
            statement.setInt(2, intrare.getNota1Oral());
            statement.setInt(3, intrare.getNota1Proiect());
            statement.setInt(4, intrare.getNota2Oral());
            statement.setInt(5, intrare.getNota2Proiect());
            statement.setInt(6, intrare.getNota3Oral());
            statement.setInt(7, intrare.getNota3Proiect());
            statement.setInt(8, intrare.getNota4Oral());
            statement.setInt(9, intrare.getNota4Proiect());
            statement.setInt(10, intrare.getNota5Oral());
            statement.setInt(11, intrare.getNota5Proiect());
            statement.setTimestamp(12, intrare.getDataOraSustinerii());
            statement.setInt(13, intrare.getId());
            statement.executeUpdate();
            conexiune.commit();

            return 0;
        } catch (Exception e) {
            System.out.println("Exceptie la updateDetaliiLicenta" + e.getMessage());
            return -7;
        }

    }

    public int insertMesaj(IntrareMesaje intrare) {
        String apel;
        try {

            if (intrare.getId() == 0) {
                apel = " Insert into Mesaje Values(Mesaje_SEQ.NEXTVAL, ?, ? ,?)";
                PreparedStatement statement = conexiune.prepareStatement(apel);
                statement.setInt(1, intrare.getIdEmitator());
                statement.setInt(2, intrare.getIdDestinatar());
                statement.setString(3, intrare.getMesaj());
                statement.executeUpdate();

                Statement stmt = conexiune.createStatement();
                ResultSet rs = stmt.executeQuery("Select MESAJE_SEQ.CURRVAL from dual");
                rs.next();
                intrare.setId(rs.getInt(1));

                return 0;
            } else {

                Statement stmt = conexiune.createStatement();
                ResultSet rs = stmt.executeQuery("Select Count(*) from MESAJE where id =" + intrare.getId());
                rs.next();
                if (rs.getInt(1) > 0) {
                    System.out.println("Intrare Existenta. Update?");
                    return -1;
                }

                apel = " Insert into Mesaje Values(?, ?, ? ,?)";
                PreparedStatement statement = conexiune.prepareStatement(apel);
                statement.setInt(1, intrare.getId());
                statement.setInt(2, intrare.getIdEmitator());
                statement.setInt(3, intrare.getIdDestinatar());
                statement.setString(4, intrare.getMesaj());
                statement.executeUpdate();

                return 0;
            }
        } catch (Exception e) {
            System.out.println("Exceptie la insertMesaj: " + e.getMessage());
            return -7;
        }
    }

    public IntrareComisii getCommitteByProf(int idProf) {
        IntrareComisii intrare = new IntrareComisii();
        PreparedStatement pStatement = null;
        ResultSet result = null;
        try {

            pStatement = conexiune.prepareStatement("select * from comisii c join profesori p on c.id = p.id_comisie where p.id = ?");
            pStatement.setInt(1, idProf);
            result = pStatement.executeQuery();
            if (result.next()) {

                intrare.setId(result.getInt(1));
                intrare.setIdProfSef(result.getInt(2));
                intrare.setIdProf2(result.getInt(3));
                intrare.setIdProf3(result.getInt(4));
                intrare.setIdProf4(result.getInt(5));
                intrare.setIdSecretar(result.getInt(6));
                intrare.setTipComisie(result.getString(7));
                //intrare.setIdEvaluare(result.getInt(8));

            }
            return intrare;

        } catch (SQLException e) {
            System.out.println("Exceptie la selectComisii: " + e.getMessage());
            return null;
        } finally {
            try {
                if (pStatement != null)
                    pStatement.close();
                if (result != null)
                    result.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }
    }

    public IntrareComisii getCommitteByStudent(int idStudent) {
        IntrareComisii intrare = new IntrareComisii();
        PreparedStatement pStatement = null;
        ResultSet result = null;
        try {
             pStatement = conexiune.prepareStatement("select * from comisii c join studenti s on c.id = s.id_comisie where s.id = ?");
            pStatement.setInt(1, idStudent);
             result = pStatement.executeQuery();
            if (result.next() && result != null) {

                intrare.setId(result.getInt(1));
                intrare.setIdProfSef(result.getInt(2));
                intrare.setIdProf2(result.getInt(3));
                intrare.setIdProf3(result.getInt(4));
                intrare.setIdProf4(result.getInt(5));
                intrare.setIdSecretar(result.getInt(6));
                intrare.setTipComisie(result.getString(7));
                //intrare.setIdEvaluare(result.getInt(8));

            }
            return intrare;

        } catch (Exception e) {
            System.out.println("Exceptie la selectComisii: " + e.getMessage());
            return null;
        }finally {
            try {
                if (pStatement != null)
                    pStatement.close();
                if( result != null)
                    result.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }

    }

    public int getProfIndex(int idProf, int idCommitte) {

        IntrareComisii rezultat = new IntrareComisii();
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
           statement = conexiune.prepareStatement("Select * from comisii where id = ?");
            statement.setInt(1, idCommitte);
             result = statement.executeQuery();

            while (result.next()) {

                rezultat.setId(result.getInt(1));
                rezultat.setIdProfSef(result.getInt(2));
                rezultat.setIdProf2(result.getInt(3));
                rezultat.setIdProf3(result.getInt(4));
                rezultat.setIdProf4(result.getInt(5));
                rezultat.setIdSecretar(result.getInt(6));
                rezultat.setTipComisie(result.getString(7));
                //rezultat.setIdEvaluare(result.getInt(8));

            }

        } catch (Exception e) {
            System.out.println("Exceptie la selectStudenti:" + e.getMessage());
            return 0;
        }finally {
            try {
                if (statement != null)
                    statement.close();
                if( result != null)
                    result.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }

        if (rezultat.getIdProfSef() == idProf) {
            return 1;
        } else if (rezultat.getIdProf2() == idProf) {
            return 2;
        } else if (rezultat.getIdProf3() == idProf) {
            return 3;
        } else if (rezultat.getIdProf4() == idProf) {
            return 4;
        } else
            return 0;

    }

    public boolean updateNotaStudent(int indexProf, int idStudent, int tipExamen, int notaOral, int notaProiect) {
        if (tipExamen == 1 && (indexProf != 1 && indexProf != 2 && indexProf != 3 && indexProf != 5)) {

            return false;

        } else if (tipExamen == 2 && (indexProf != 1 && indexProf != 2 && indexProf != 3 && indexProf != 4 && indexProf != 5)) {

            return false;
        }

        PreparedStatement statement = null;
        ResultSet result = null;
        PreparedStatement statement2 = null;
        try {
             statement = conexiune.prepareStatement("Select id from licente where id_student = ?");
            statement.setInt(1, idStudent);
            result = statement.executeQuery();
            result.next();


            int idLicenta = result.getInt(1);


            if (indexProf != 5) {
                 statement2 = conexiune.prepareStatement(" update DETALII_LICENTE  set nota_" + indexProf + "_oral = ?,nota_" + indexProf + "_proiect = ? where id = ? ");
                statement2.setInt(1, notaOral);
                statement2.setInt(2, notaProiect);
                statement2.setInt(3, idLicenta);
                statement2.executeUpdate();
                return true;
            } else {
                 statement2 = conexiune.prepareStatement(" update DETALII_LICENTE  set nota_" + indexProf + "_oral_coordonator = ?,nota_" + indexProf + "_proiect_coordonator = ? where id = ? ");
                statement2.setInt(1, notaOral);
                statement2.setInt(2, notaProiect);
                statement2.setInt(3, idLicenta);
                statement2.executeUpdate();
                return true;
            }

        } catch (Exception e) {
            System.out.println("Exceptie la update nota:" + e.getMessage());
            return false;
        }finally {
            try {
                if (statement != null)
                    statement.close();
                if (statement2 != null)
                    statement2.close();
                if( result != null)
                    result.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }
    }


}