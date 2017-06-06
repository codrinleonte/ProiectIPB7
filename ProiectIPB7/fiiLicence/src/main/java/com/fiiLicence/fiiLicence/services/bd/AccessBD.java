package com.fiiLicence.fiiLicence.services.bd;

import com.fiiLicence.fiiLicence.models.response.LicenseDataResponse;

import java.sql.*;

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

    public int setComisieProfesor(int idProfesor, int idComisie) {
        Statement statement = null;
        try {
            statement = conexiune.createStatement();
            statement.executeUpdate("UPDATE profesori set id_comisie=" + idComisie + " where id=" + idProfesor);
            statement.close();

            statement = conexiune.createStatement();
            ResultSet result = statement.executeQuery("Select id,id_student from licente where id_profesor=" + idProfesor);
            while (result.next()) {
                Statement statementLoop = conexiune.createStatement();
                statementLoop.executeUpdate("UPDATE studenti set id_comisie=" + idComisie + " where id=" + result.getInt(2));
                statementLoop.close();

                statementLoop = conexiune.createStatement();
                statementLoop.executeUpdate("UPDATE detalii_licente set id_comisie=" + idComisie + " where id=" + result.getInt(1));
                statementLoop.close();
            }
            return 0;

        } catch (Exception e) {
            System.out.println("Exceptie la setComisieProfesor: " + e.getMessage());

            return -7;
        } finally {
            try {
                if (statement != null)
                    statement.close();

            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
                return -7;
            }

        }
    }

    public int setFisierLucrare(int idStudent, byte[] data) {
        PreparedStatement statement = null;
        try {
            statement = conexiune.prepareStatement("UPDATE LICENTE SET FISIER = ? WHERE id_student = ? ");
            statement.setInt(2, idStudent);
            statement.setBytes(1, data);
            statement.executeUpdate();
            statement.close();
            return 0;
        } catch (Exception e) {
            try {
                statement.close();
            } catch (Exception exceptie) {
            }
            System.out.println("Exceptie scriere fisier lucrare:" + e.getMessage());
            e.printStackTrace();
            return -7;
        } finally {
            try {
                if (statement != null)
                    statement.close();

            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
                return -7;
            }

        }
    }


    public LicenseDataResponse getLicenseData(int idStudent) {
        LicenseDataResponse license = new LicenseDataResponse();
        PreparedStatement statement = null;
        try {
            statement = conexiune.prepareStatement("select l.titlu,l.id_profesor,l.tip,fisier from  licente l where l.id_student= ? ");
            statement.setInt(1, idStudent);


            ResultSet result = statement.executeQuery();

            if (result.next()) {
                license.setNumeLucrare(result.getString(1));
                license.setCoordonator(result.getString(2));
                license.setTip(result.getString(3));
                if (result.getBlob(4) != null)
                    license.setContinut(result.getBlob(4).getBytes(1, (int) result.getBlob(4).length()));
            }

            statement.close();
            return license;
        } catch (Exception e) {
            try {
                statement.close();
            } catch (Exception exceptie) {
            }
            System.out.println("Exceptie scriere fisier lucrare:" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
