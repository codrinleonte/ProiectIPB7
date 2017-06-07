package com.fiiLicence.fiiLicence.services.bd;


import com.fiiLicence.fiiLicence.models.response.*;
import com.fiiLicence.fiiLicence.services.DatabaseServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;


public class BD {

    private boolean connected = false;
    private Connection conexiune;
    @SuppressWarnings("unused")
    private String domeniu = "";
    private AccessBD access;

    private void createAccess(String username) {

        String apel = " { ? = call get_type( ? ) }";
        int rezultat;
        int idCont;
        Statement stmt = null;
        ResultSet rs = null;
        CallableStatement statement = null;
        try {

            stmt = conexiune.createStatement();
            rs = stmt.executeQuery("Select ID from CONTURI where username = '" + username + "'");
            rs.next();
            idCont = rs.getInt(1);

            statement = conexiune.prepareCall(apel);
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setString(2, username);
            statement.execute();
            rezultat = statement.getInt(1);

            if (rezultat == 0) {
                UserBD utilizator = new UserBD();
                utilizator.setId(0);
                utilizator.setTip("Admin");
                utilizator.setUsername("Admin");
                this.access = new AccessAdminBD(conexiune, utilizator);
                this.access.setIdCont(idCont);
            } else if (rezultat == 1) {
                UserBD utilizator = new UserBD();
                PreparedStatement statement2 = conexiune.prepareStatement("Select STUDENTI.ID FROM STUDENTI JOIN CONTURI on STUDENTI.ID_CONT=CONTURI.ID WHERE CONTURI.USERNAME=?");
                statement2.setString(1, username);
                ResultSet result = statement2.executeQuery();
                result.next();
                utilizator.setId(result.getInt(1));
                utilizator.setTip("Student");
                utilizator.setUsername(username);

                this.access = new AccessStudentBD(conexiune, utilizator);
                this.access.setIdCont(idCont);
            } else if (rezultat == 2) {
                UserBD utilizator = new UserBD();
                PreparedStatement statement2 = conexiune.prepareStatement("Select PROFESORI.ID FROM PROFESORI JOIN CONTURI on PROFESORI.ID_CONT=CONTURI.ID WHERE CONTURI.USERNAME=?");
                statement2.setString(1, username);
                ResultSet result = statement2.executeQuery();
                result.next();
                utilizator.setId(result.getInt(1));
                utilizator.setTip("Profesor");
                utilizator.setUsername(username);
                this.access = new AccessProfesorBD(conexiune, utilizator);
                this.access.setIdCont(idCont);
            } else {
                UserBD utilizator = new UserBD();
                PreparedStatement statement2 = conexiune.prepareStatement("Select PROFESORI.ID FROM PROFESORI JOIN CONTURI on PROFESORI.ID_CONT=CONTURI.ID WHERE CONTURI.USERNAME=?");
                statement2.setString(1, username);
                ResultSet result = statement2.executeQuery();
                result.next();
                utilizator.setId(result.getInt(1));
                utilizator.setTip("Secretar");
                utilizator.setUsername(username);
                this.access = new AccessSecretarBD(conexiune, utilizator);
                this.access.setIdCont(idCont);
            }

        } catch (Exception e) {
            System.out.println("Exceptie la createAccess: " + e.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (stmt != null)
                    statement.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }

    }

    @SuppressWarnings("unused")
    private int sendEmail(String adresa, String mesaj) {

        return 0;
    }

    public BD() {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.conexiune = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Licente", "ADMIN");
            this.connected = true;

        } catch (Exception e) {

            System.out.println("Exceptie la conectare: " + e.getMessage());
            this.connected = false;

        }
    }

    public boolean isConnected() {
        return connected;
    }

    public void setDomeniu(String domeniu) {
        this.domeniu = domeniu;
    }

    public IntrareConturi getContByToken(String token) {
        IntrareConturi cont = new IntrareConturi();
        Statement stmt = null;
        ResultSet rs = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            stmt = conexiune.createStatement();
            rs = stmt.executeQuery("Select Count(*) from conturi where token='" + token + "'");
            rs.next();
            if (rs.getInt(1) == 0) {
                System.out.println("Intrare Inexistenta");
                return null;
            }

            statement = conexiune.createStatement();
            result = statement.executeQuery("Select * from conturi where token='" + token + "'");
            result.next();
            cont.setId(result.getInt(1));
            cont.setUsername(result.getString(2));
            cont.setHashparola(result.getString(3));
            cont.setEmail(result.getString(4));
            cont.setTipUtilizator(result.getString(5));
            cont.setStatus(result.getInt(6));
            cont.setCodActivare(result.getString(7));
            cont.setToken(result.getString(8));
            return cont;

        } catch (Exception e) {
            System.out.println("Exceptie la getContByToken: " + e.getMessage());
            return null;
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
                if (result != null)
                    result.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }

    }

    public int setTokenByIdCont(String email, String token) {
        Statement stmt = null;
        ResultSet rs = null;
        Statement statement = null;
        try {
            stmt = conexiune.createStatement();
            rs = stmt.executeQuery("Select Count(*) from conturi where email= '" + email + "'");
            rs.next();
            if (rs.getInt(1) == 0) {
                System.out.println("Intrare Inexistenta");
                return -1;
            }

            statement = conexiune.createStatement();
            statement.executeUpdate("UPDATE CONTURI SET Token = '" + token + "' Where email='" + email + "'");
            return 0;
        } catch (Exception e) {
            System.out.println("Exceptie la setTokenByIdCont: " + e.getMessage());
            return 0;
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }
    }

    public int setTokenByIdCont(int id, String token) {
        try {
            Statement stmt = conexiune.createStatement();
            ResultSet rs = stmt.executeQuery("Select Count(*) from conturi where id=" + id);
            rs.next();
            if (rs.getInt(1) == 0) {
                System.out.println("Intrare Inexistenta");
                return -1;
            }

            Statement statement = conexiune.createStatement();
            statement.executeUpdate("UPDATE CONTURI SET Token = '" + token + "' Where id=" + id);
            return 0;
        } catch (Exception e) {
            System.out.println("Exceptie la setTokenByIdCont: " + e.getMessage());
            return 0;
        }
    }

    public AccessBD login(String username, String hashparola) {
        String apel = "{ ? = call login( ?, ? ) }";
        int rezultat;
        CallableStatement statement = null;
        try {

            statement = conexiune.prepareCall(apel);
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setString(2, username);
            statement.setString(3, hashparola);
            statement.execute();
            rezultat = statement.getInt(1);

            if (rezultat == 0) {
                createAccess(username);
                return this.access;
            } else
                return null;

        } catch (Exception e) {
            System.out.println("Exceptie la login: " + e.getMessage());
            return null;
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }

    }

    public int verificare(String hashcod) {
        String apel = "{ ? = call verificare( ? ) }";
        int rezultat;
        CallableStatement statement = null;
        try {

            statement = conexiune.prepareCall(apel);
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setString(2, hashcod);
            statement.execute();
            rezultat = statement.getInt(1);
            return rezultat;
        } catch (Exception e) {
            System.out.println("Exceptie la login: " + e.getMessage());
            return -7;
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }

    }

    public int inregistrare_stud(String email, String hashparola) {
        Random random;
        String hashcod;
        boolean unic;
        int rezultat = 0;

        try {
            String username = email.split("@")[0];
            if (!email.split("@")[1].equals("info.uaic.ro") || username.split("\\.")[0].equals(username))
                return -1;
        } catch (Exception e) {
            System.out.println("Email invalid inregistrare_stud: " + e.getMessage());
            return -1;
        }

        String apel = "SELECT COUNT(ID) FROM CONTURI WHERE COD_ACTIVARE='";

        do {
            random = new Random();
            unic = true;
            hashcod = "";
            for (int i = 0; i < 20; i++)
                hashcod = hashcod + random.nextInt(9);
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                statement = conexiune.createStatement();
                resultSet = statement.executeQuery(apel + hashcod + "'");

                resultSet.next();
                if (resultSet.getInt(1) != 0)
                    unic = false;
            } catch (Exception e) {
                System.out.println("Exceptie la generare cod random la inregistrare_stud: " + e.getMessage());
                return -7;
            } finally {
                try {
                    if (statement != null)
                        statement.close();
                    if (resultSet != null)
                        resultSet.close();
                } catch (SQLException se) {
                    System.out.println("Oups .. " + se);

                }
            }
        } while (!unic);

        apel = "{ ? = call inregistrare_stud( ?, ?, ? ) }";
        CallableStatement statement = null;
        try {
            statement = conexiune.prepareCall(apel);
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setString(2, email.split("@")[0]);
            statement.setString(3, hashparola);
            statement.setString(4, hashcod);
            statement.execute();
            rezultat = statement.getInt(1);

            // MailSender mailSender = new MailSender(email, hashcod);

            return rezultat;
        } catch (Exception e) {
            System.out.println("Exceptie la inregistrare_stud: " + e.getMessage());
            return -7;
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }
    }

    public int inregistrare_prof(String username, String hashparola) {
        String apel = " { ? = call inregistrare_prof( ? , ? ) }";
        int rezultat;
        try {
            CallableStatement statement = conexiune.prepareCall(apel);
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setString(2, username);
            statement.setString(3, hashparola);
            statement.execute();
            rezultat = statement.getInt(1);
            return rezultat;
        } catch (Exception e) {
            System.out.println("Exceptie inregistrare_prof: " + e.getMessage());
            return -7;
        }
    }

    //
    private String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    public String getHas(String email, String password) {
        email.concat(password);
        return MD5(email);
    }

    public List<StudentGuidedListResponse> getStudentsOfATeacher(int idTeacher) {
        List<StudentGuidedListResponse> studentOfATeacher = new ArrayList<>();
        String apel = "SELECT nota_1_oral, nota_2_oral, nota_3_oral, nota_4_oral_dizertatie,nota_5_oral_coordonator, nota_1_PROIECT, NOTA_2_PROIECT, NOTA_3_PROIECT, NOTA_4_PROIECT_DIZERTATIE, NOTA_5_PROIECT_COORDONATOR, STUDENTI.ID, STUDENTI.NUME, STUDENTI.PRENUME FROM licente JOIN DETALII_LICENTE ON LICENTE.ID = DETALII_LICENTE.ID join STUDENTI on LICENTE.ID_STUDENT = STUDENTI.ID WHERE LICENTE.ID_PROFESOR = ?";
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            statement = conexiune.prepareStatement(apel);
            statement.setInt(1, idTeacher);
            result = statement.executeQuery();
            while (result.next()) {
                StudentGuidedListResponse student = new StudentGuidedListResponse();
                DatabaseServiceImpl databaseService = new DatabaseServiceImpl();
                student.setNota1oral(result.getInt(1));
                student.setNota2oral(result.getInt(2));
                student.setNota3oral(result.getInt(3));
                student.setNota4oral(result.getInt(4));
                student.setNota5oral(result.getInt(5));
                student.setNota1project(result.getInt(6));
                student.setNota2project(result.getInt(7));
                student.setNota3project(result.getInt(8));
                student.setNota4project(result.getInt(9));
                student.setNota5project(result.getInt(10));
                student.setIdStudent(result.getInt(11));
                student.setNumeStudent(result.getString(12));
                student.setPrenumStudent(result.getString(13));
                GradeResponse grade = databaseService.getStudentGrade(student.getIdStudent());
                student.setNotaFinala(grade.getGrade());
                studentOfATeacher.add(student);
            }
            return studentOfATeacher;
        } catch (Exception e) {
            System.out.println("Exceptie la obtinerea studentilor: " + e.getMessage());
            return null;
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (result != null)
                    result.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }

    }


    //16.functie: un profesor poate sa adauge un student

    public int getIdStudentByName(String numeStudent, String prenumeStudent) {
        String apelSelect = "Select id from studenti where nume = ? and prenume = ?";
        int idStudent = 0;
        try {
            PreparedStatement statementSelect = conexiune.prepareStatement(apelSelect);
            statementSelect.setString(1, numeStudent);
            statementSelect.setString(2, prenumeStudent);
            ResultSet result = statementSelect.executeQuery();
            while (result.next()) {
                idStudent = result.getInt(1);
            }
            return idStudent;
        } catch (Exception e) {
            System.out.println("Exceptie la obtinerea studentilor: " + e.getMessage());
            return 0;
        }
    }

    public boolean addStudent(int idTeacher, String numeStudent, String prenumeStudent) {
        String apel = " Update licente set ID_PROFESOR = ? where  ID_STUDENT = ? ";
        int idStudent = getIdStudentByName(numeStudent, prenumeStudent);
        PreparedStatement statement = null;
        try {
            statement = conexiune.prepareStatement(apel);
            statement.setInt(1, idTeacher);
            statement.setInt(2, idStudent);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Exceptie la obtinerea studentilor: " + e.getMessage());
            return false;
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }
    }


    //17.functie:un profesor poate scoate un student din lista sa

    public boolean removeStudent(int idTeacher, int idStudent) {
        String apel = " Update licente set ID_PROFESOR = null where ID_Profesor = ? and id_student = ? ";
        PreparedStatement statement = null;
        try {

            statement = conexiune.prepareStatement(apel);
            statement.setInt(1, idTeacher);
            statement.setInt(2, idStudent);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Exceptie la obtinerea studentilor: " + e.getMessage());
            return false;
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }
    }

    //18. functie: se poate edita data de examinare a unei comisii
    public boolean editExaminationDate(int idComisie, String beginDate, String endDate) {
        String apel = "update  evaluari e set e.INCEPUT_EVALUARE=to_date(?,'dd-mm-yyyy'),e.sfarsit_evaluare=to_date(?,'dd-mm-yyyy')where e.id_comisie=?";
        PreparedStatement statement = null;
        try {
            statement = conexiune.prepareStatement(apel);
            statement.setString(1, beginDate);
            statement.setString(2, endDate);
            statement.setInt(3, idComisie);
            statement.executeQuery();

            return true;
        } catch (Exception e) {
            System.out.println("Exceptie la obtinerea studentilor: " + e.getMessage());
            return false;
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }
    }

    public StudentGrade getAllGrade(int idStudent) {
        StudentGrade student = new StudentGrade();
        String apel = "SELECT id_profesor, id_comisie, nota_1_oral, nota_2_oral, nota_3_oral, nota_4_oral_dizertatie, nota_5_oral_coordonator, nota_1_PROIECT, NOTA_2_PROIECT, NOTA_3_PROIECT, NOTA_4_PROIECT_DIZERTATIE, NOTA_5_PROIECT_COORDONATOR,tip FROM licente JOIN DETALII_LICENTE ON LICENTE.ID = DETALII_LICENTE.ID where LICENTE.ID_STUDENT = ?";
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            statement = conexiune.prepareStatement(apel);
            statement.setInt(1, idStudent);
            result = statement.executeQuery();
            while (result.next()) {
                student.setIdProfesor(result.getInt(1));
                student.setIdComisie(result.getInt(2));
                student.setNota1Oral(result.getInt(3));
                student.setNota2Oral(result.getInt(4));
                student.setNota3Oral(result.getInt(5));
                student.setNota4Oral(result.getInt(6));
                student.setNota5Oral(result.getInt(7));
                student.setNota1Project(result.getInt(8));
                student.setNota2Project(result.getInt(9));
                student.setNota3Project(result.getInt(10));
                student.setNota4Project(result.getInt(11));
                student.setNota5Project(result.getInt(12));
                student.setTipLicenta(result.getString(13));
            }
            return student;
        } catch (Exception e) {
            System.out.println("Exceptie la obtinerea notelor: " + e.getMessage());
            return null;
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (result != null)
                    result.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }
    }

    public ProfsFromCommitte getProfFromCommitte(int idComisie) {
        ProfsFromCommitte profesori = new ProfsFromCommitte();
        String apel = "select ID_PROF1,ID_PROF2,ID_PROF3,ID_PROF4_DIZERTATIE from comisii where id = ?";
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            statement = conexiune.prepareStatement(apel);
            statement.setInt(1, idComisie);
            result = statement.executeQuery();
            while (result.next()) {
                profesori.setProfesor1(result.getInt(1));
                profesori.setProfesor2(result.getInt(2));
                profesori.setProfesor3(result.getInt(3));
                profesori.setProfesor4(result.getInt(4));
            }
            return profesori;
        } catch (Exception e) {
            System.out.println("Exceptie la obtinerea Profesorilor Din Comisie: " + e.getMessage());
            return null;
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (result != null)
                    result.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }
    }

    public IntrareStudenti getStudentByID(int idProf) {
        IntrareStudenti intrare = new IntrareStudenti();
        try {
            Statement statement = conexiune.createStatement();
            ResultSet result = statement.executeQuery("Select * from studenti");
            while (result.next()) {
                intrare.setId(result.getInt(1));
                intrare.setIdCont(result.getInt(2));
                intrare.setNrMatricol(result.getString(3));
                intrare.setNume(result.getString(4));
                intrare.setPrenume(result.getString(5));
                intrare.setId_comisie(result.getInt(6));
                intrare.setIdSesiune(result.getInt(7));
            }
            return intrare;
        } catch (Exception e) {
            System.out.println("Exceptie la selectProfesori :" + e.getMessage());
            return null;
        }

    }

    public IntrareStudenti selectStudentByIdCont(int idCont) {
        String apel = " Select * from studenti where id_cont = ? ";
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            statement = conexiune.prepareStatement(apel);
            statement.setInt(1, idCont);
            result = statement.executeQuery();
            IntrareStudenti intrare = new IntrareStudenti();


            while (result.next()) {
                intrare.setId(result.getInt(1));
                intrare.setIdCont(result.getInt(2));
                intrare.setNrMatricol(result.getString(3));
                intrare.setNume(result.getString(4));
                intrare.setPrenume(result.getString(5));
                intrare.setId_comisie(result.getInt(6));
                intrare.setIdSesiune(result.getInt(7));

            }
            return intrare;
        } catch (Exception e) {
            System.out.println("Exceptie la selectStudenti:" + e.getMessage());
            return null;
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (result != null)
                    result.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);
            }
        }
    }

    // de schimbat in acces
    public List<StundetListPageResponse> getStudentsMarks() {
        List<StundetListPageResponse> studenti = new ArrayList<>();

        String apel = "select s.nume,s.prenume,d.NOTA_1_ORAL,d.NOTA_2_ORAL,d.NOTA_3_ORAL,d.NOTA_4_ORAL_DIZERTATIE,d.NOTA_5_ORAL_COORDONATOR,d.NOTA_1_proiect,d.NOTA_2_proiect,d.NOTA_3_proiect,d.NOTA_4_PROIECT_DIZERTATIE,d.NOTA_5_PROIECT_COORDONATOR from detalii_licente d join licente l on d.id=l.id join studenti s on s.ID=l.ID_STUDENT";
        PreparedStatement statement = null;
        try {


            statement = conexiune.prepareStatement(apel);
            ResultSet result = statement.executeQuery();

            Vector<Integer> notePosibile = new Vector<>();

            notePosibile.add(1);
            notePosibile.add(2);
            notePosibile.add(3);
            notePosibile.add(4);
            notePosibile.add(5);
            notePosibile.add(6);
            notePosibile.add(7);
            notePosibile.add(8);
            notePosibile.add(9);
            notePosibile.add(10);

            while (result.next()) {
                int nrNoteOral = 0;
                int nrNoteProiect = 0;
                Vector<Integer> noteOral = new Vector<>();
                Vector<Integer> noteProiect = new Vector<>();
                StundetListPageResponse student = new StundetListPageResponse();
                student.setNumeStudent(result.getString(1));
                System.out.println(result.getString(1));
                student.setPrenumeStudent(result.getString(2));
                if (notePosibile.contains(result.getInt(3))) {
                    noteOral.add(result.getInt(3));
                    nrNoteOral = nrNoteOral + 1;
                }
                if (notePosibile.contains(result.getInt(4))) {
                    noteOral.add(result.getInt(4));
                    nrNoteOral = nrNoteOral + 1;
                }
                if (notePosibile.contains(result.getInt(5))) {
                    noteOral.add(result.getInt(5));
                    nrNoteOral = nrNoteOral + 1;
                }
                if (notePosibile.contains(result.getInt(6))) {
                    noteOral.add(result.getInt(6));
                    nrNoteOral = nrNoteOral + 1;
                }
                if (notePosibile.contains(result.getInt(7))) {
                    noteOral.add(result.getInt(7));
                    nrNoteOral = nrNoteOral + 1;
                }
                if (notePosibile.contains(result.getInt(8))) {
                    noteProiect.add(result.getInt(8));
                    nrNoteProiect = nrNoteProiect + 1;
                }
                if (notePosibile.contains(result.getInt(9))) {
                    noteProiect.add(result.getInt(9));
                    nrNoteProiect = nrNoteProiect + 1;
                }
                if (notePosibile.contains(result.getInt(10))) {
                    noteProiect.add(result.getInt(10));
                    nrNoteProiect = nrNoteProiect + 1;
                }
                if (notePosibile.contains(result.getInt(11))) {
                    noteProiect.add(result.getInt(11));
                    nrNoteProiect = nrNoteProiect + 1;
                }
                if (notePosibile.contains(result.getInt(12))) {
                    noteProiect.add(result.getInt(12));
                    nrNoteProiect = nrNoteProiect + 1;
                }

                Double project = 0.0;
                Double oral = 0.0;


                for (Integer notaPrj : noteProiect) {
                    project = project + (double) notaPrj;
                }
                for (Integer notaOrl : noteProiect) {
                    project = project + (double) notaOrl;
                }
                student.setNotaFinala(Math.floor((Math.floor(project / nrNoteProiect * 100) / 100 + Math.floor(oral / nrNoteOral * 100) / 100) / 2.0 * 100) / 100.0);
                studenti.add(student);
            }
            return studenti;
        } catch (Exception e) {
            System.out.println("Exceptie la obtinerea notelor studentilor: " + e.getMessage());
            return null;
        } finally {
            try {

                if (statement != null)
                    statement.close();
            } catch (SQLException se) {
                System.out.println("Oups .. " + se);

            }

        }

    }

    //20. functie: obtinem distributia pe sali a studentilor


    public List<DistributionOnHallsResponse> getDistributionOnHalls() {
        List<DistributionOnHallsResponse> distribution = new ArrayList<>();
        String apel = "select distinct s.nume,s.prenume,e.sala,c.id,to_char(d.DATA_ORA_SUSTINERE, 'HH24:MI'),to_char(d.DATA_ORA_SUSTINERE + (.000694 * 21), 'HH24:MI')";
        apel = apel + "from studenti s join comisii c on c.id=s.id_comisie join evaluari e on e.id_comisie=c.id join detalii_licente d on d.ID_COMISIE=c.id";
        PreparedStatement statement = null;
        try {

            statement = conexiune.prepareStatement(apel);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                DistributionOnHallsResponse hall = new DistributionOnHallsResponse();
                hall.setNumeStudent(result.getString(1));
                hall.setPrenumeStudent(result.getString(2));
                hall.setSala(result.getString(3));
                hall.setIdComisie(result.getInt(4));
                hall.setOraDeInceput(result.getString(5));
                hall.setOraDeSfarsit(result.getString(6));
                distribution.add(hall);
            }
            return distribution;
        } catch (Exception e) {
            System.out.println("Exceptie la obtinerea studentilor: " + e.getMessage());
            return null;
        } finally {
            try {

                if (statement != null)
                    statement.close();

            } catch (SQLException se) {
                System.out.println("Oups .. " + se);

            }

        }
    }


	/*21. [-] O metoda noua, utilizata pentru crearea unei noi sesiuni:
        Input: - Data inceput sesiune (String, format 'MM/DD/YYYY')
		       - Data sfarsit sesiune (String, format 'MM/DD/YYYY')
		       - Numar total de comisii alocate pentru acea sesiune (Integer)
		Output: - true daca s-a creat, false daca nu (de exemplu, false daca exista una deja activa?)
	*/

    public boolean addSession(String dataInceput, String dataSfarsit, int nrDeComisii) {
        String apel1 = "select max(id) from comisii";
        String apel2 = "select max(id) from sesiuni";
        int idComisie = 0;
        int idSesiune = 0;
        PreparedStatement statement4 = null;
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement3 = null;
        try {

            statement = conexiune.prepareStatement(apel1);
            ResultSet result = statement.executeQuery();
            if (result.next()) {

                idComisie = result.getInt(1);

            }

            statement1 = conexiune.prepareStatement(apel2);
            ResultSet result1 = statement1.executeQuery();
            if (result1.next()) {

                idSesiune = result1.getInt(1) + 1;

            }

            String apel3 = "insert into sesiuni (id,inceput_sesiune,sfarsit_sesiune) values(?,TO_DATE(?,'dd-mm-yyyy'),TO_DATE( ?,'dd-mm-yyyy'))";

            statement3 = conexiune.prepareStatement(apel3);
            statement3.setInt(1, idSesiune);
            statement3.setString(2, dataInceput);
            statement3.setString(3, dataSfarsit);

            statement3.executeUpdate();


            for (int i = 1; i <= nrDeComisii; i++) {
                String apel4 = "insert into comisii(id,id_sesiune) values(?,?)";

                statement4 = conexiune.prepareStatement(apel4);
                statement4.setInt(1, idComisie + i);
                statement4.setInt(2, idSesiune);
                statement4.executeUpdate();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Exceptie la obtinerea studentilor: " + e.getMessage());
            return false;
        } finally {
            try {

                if (statement != null)
                    statement.close();

                if (statement1 != null)
                    statement1.close();

                if (statement3 != null)
                    statement3.close();

                if (statement4 != null)
                    statement4.close();


            } catch (SQLException se) {
                System.out.println("Oups .. " + se);

            }

        }
    }
}
