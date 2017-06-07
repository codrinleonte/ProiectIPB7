package com.fiiLicence.fiiLicence.services;

import com.fiiLicence.fiiLicence.models.response.*;
import com.fiiLicence.fiiLicence.services.bd.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DatabaseServiceImpl implements DatabaseService {
    private BD bd;

    public DatabaseServiceImpl() {
        this.bd = new BD();
        if (bd.isConnected()) {
            System.out.println("================================");
            System.out.println("  CONNECTED TO ORACLE DATABASE  ");
            System.out.println("================================");
        } else {
            System.out.println("================================");
            System.out.println("  ERROR TO ORACLE DATABASE  ");
            System.out.println("================================");
        }
    }

    public boolean verifyToken(String token) {
        BD database = new BD();
        IntrareConturi cont;
        bd.login("Admin", "Root");
        cont = database.getContByToken(token);
        if (cont != null)
            return true;
        return false;
    }


    public boolean verifyIfCommitteExists(int idCommitte, String token) {
        List<CommitteListResponse> committeeList = getCommitteList(token);
        List<Integer> committeIdList = new ArrayList<Integer>();

        for (CommitteListResponse c : committeeList) {
            committeIdList.add(c.getId());
        }
        if (committeIdList.contains(idCommitte)) {
            return true;
        }

        return false;

    }


    public boolean verifyIfProfesorExists(int idProfesor, String token) {
        List<ProfListResponse> profsList = getProfList(token);
        System.out.println("-------------ceva---------");
        System.out.println(profsList);
        System.out.println("-------------ceva---------");
        List<Integer> profsIdList = new ArrayList<Integer>();

        for (ProfListResponse p : profsList) {
            profsIdList.add(p.getId());
        }

        if (profsIdList.contains(idProfesor)) {
            return true;
        }
        return false;
    }

    private double calculateGrade(List<Integer> gradesOral, List<Integer> gradesProject) {
        double gradeOral = 0.0;
        double gradeProject = 0.0;
        for (Integer index : gradesOral)
            gradeOral += index;
        for (Integer index : gradesProject)
            gradeProject += index;
        return Math.floor((Math.floor(gradeProject / gradesProject.size() * 100) / 100 + Math.floor(gradeOral / gradesOral.size() * 100) / 100) / 2.0 * 100) / 100.0;
    }


    /*1.
    Descriere: Metoda utilizata pentru intregistrare.
    Input:  - adresa_email (String)
            - parola (String)
    Output: - result (Boolean) (true - daca email-ul de inregistare a fost trimis, false - in caz de orice alta eroare)*/
    @Override
    public boolean validateRegistration(String email, String password) {
        int result = bd.inregistrare_stud(email, password);
        if (result != 0)
            return false;
        else
            return true;
    }

    /*2.
    Descriere: Metoda utilizata pentru confirmarea contului
    Input: - confirm_token (String) (un hash primit pe email ce activeaza contul. Ex: Link-ul din mail: http://localhost:4200/activate?=abcde
                                     va avea confirm_token-ul: "abcde")
    Output: - result (Boolean) (true - contul s-a activat cu succes, false - orice alta eroare (ex: cont deja activat))*/
    @Override
    public boolean confirmRegistration(String confirmToken) {
        int result = bd.verificare(confirmToken);
        System.out.println(result);
        if (result != 0)
            return false;
        else
            return true;

    }

    /*3.
    Descriere: Metoda utilizata pentru autentificare.
    Input:  - adresa_email (String)
        - parola (String)
    Output: - auth_token (String) (daca adresa de email si parola se match-uiesc returneaza un hash ce poate
                                    fi utilizat pentru apelarea in mod securizat a celorlalte metode, daca nu un empty string)*/
    @Override
    public String login(String email, String password) {
        String token = "";
        String username = email.substring(0, email.indexOf('@'));
        AccessBD result = bd.login(username, password);
        if (result != null) {
            token = bd.getHas(email, password);
            bd.setTokenByIdCont(email, token);
        }
        return token;
    }

    /*4.
    Descriere: Metoda utilizata pentru obtinerea informatiilor unui cont in functie de auth_token.
    Input:  - None
    Output: - nume (String)
            - prenume (String)
            - email (String)
            - clasa_cont (String) (Valori posibile: Student, Profesor, Secretar, Admin)*/
    @Override
    public UserinfoResponse getUserInfo(String token) {
        UserinfoResponse output = new UserinfoResponse();
        IntrareConturi cont;
        boolean verifyToken = verifyToken(token);
        if (verifyToken == true) {
            cont = bd.getContByToken(token);
            output.setNume(cont.getUsername().substring(0, cont.getUsername().indexOf('.')));
            output.setPrenume(cont.getUsername().substring(cont.getUsername().indexOf('.') + 1, cont.getUsername().length()));
            output.setEmail(cont.getEmail());
            output.setTip(cont.getTipUtilizator());
            output.setIdUser(cont.getId());
            return output;
        } else
            return null;
    }

    /*5.
    Descriere: Metoda utilizata pentru obtinerea unei liste cu toti profesorii.
    Input:  - None
    Output: - O lista de structuri de forma: { int id; String nume_prof; String prenume_prof; String email_prof; int id_comisie; }
                (-1 pe id_comisie daca acesta este neasignat unei comisii)*/
    @Override
    public List<ProfListResponse> getProfList(String token) {
        List<ProfListResponse> profList = new ArrayList<ProfListResponse>();
        List<IntrareProfesori> profesori = new ArrayList<IntrareProfesori>();
        boolean verifyToken = verifyToken(token);

        if (verifyToken == true) {
            AccessBD access = bd.login("Admin", "Root");
            AccessAdminBD accessAdmin = ((AccessAdminBD) access);
            profesori = accessAdmin.selectProfesori();
            for (IntrareProfesori profesor : profesori) {
                ProfListResponse profesorList = new ProfListResponse();
                profesorList.setId(profesor.getId());
                profesorList.setNumeProf(profesor.getNume());
                profesorList.setPrenumeProf(profesor.getPrenume());
                profesorList.setEmailProf(profesor.getNume() + '.' + profesor.getPrenume() + "@info.uaic.ro");
                profesorList.setIdComisie(profesor.getIdComisie());
                profList.add(profesorList);
            }
            return profList;
        } else
            return null;
    }

    /*6.
    Descriere: Metoda utilizata pentru inscrierea unei lucrari de licenta la examen. (NOTA: Pe moment ignoram upload-ul fisierelor pana gasesc
                cea mai optima metoda pentru a face asta)
    Input:  - nume_lucrare_licenta (String)
        - id_profesor_coordonator (String) (se obtine de la metoda nr. 5)
        - descriere_lucrare_licenta (String)

    Output: - result (Boolean) (true - daca totul s-a desfasurat cu succes, false - altfel)*/
    @Override
    public boolean recordLicence(String token, String nameOfLicence, int idProfesor, String descriptionOfLicence) {
        int idCont;
        IntrareConturi cont;
        IntrareStudenti student;
        AccessBD access = bd.login("Admin", "Root");
        AccessAdminBD accessAdmin = ((AccessAdminBD) access);
        IntrareLicente licenta = new IntrareLicente();
        List<IntrareLicente> licente = accessAdmin.selectLicente();
        IntrareDetaliiLicente intrareDetaliiLicente = new IntrareDetaliiLicente();

        cont = bd.getContByToken(token);
        idCont = cont.getId();
        student = bd.selectStudentByIdCont(idCont);

        for (IntrareLicente licence : licente) {
            if (licence.getIdStudent() == student.getId())
                return false;
        }

        licenta.setId(0);
        licenta.setTitlu(nameOfLicence);
        licenta.setIdProfesor(idProfesor);
        licenta.setIdStudent(idCont);
        licenta.setMaterialeLicenta(null);
        licenta.setIdSesiune(0);
        licenta.setTipLucrare(descriptionOfLicence);
        intrareDetaliiLicente.setId(0);

        if (accessAdmin.insertLicenta(licenta) == 0 && accessAdmin.insertDetaliiLicenta(intrareDetaliiLicente) == 0) {
            return true;
        } else {
            return false;
        }

    }

    /*7.
    Descriere: Metoda ce returneaza nota obtinuta a utilizatorului curent la examen (metoda apelata doar de utilizatori cu clasa student).
    Input:  - id_stud (Integer)
    Output: - valoare_nota (Integer) (-1 daca nota nu exista)*/
    @Override
    public GradeResponse getStudentGrade(int idStudent) {
        GradeResponse grade = new GradeResponse();
        StudentGrade studentGrades;
        ProfsFromCommitte profesori;
        List<Integer> gradesOral = new ArrayList<Integer>();
        List<Integer> gradesProject = new ArrayList<Integer>();
        studentGrades = bd.getAllGrade(idStudent);
        profesori = bd.getProfFromCommitte(studentGrades.getIdComisie());

        grade.setGrade(-1);

        gradesOral.add(studentGrades.getNota1Oral());
        gradesOral.add(studentGrades.getNota2Oral());
        gradesOral.add(studentGrades.getNota3Oral());
        gradesProject.add(studentGrades.getNota1Project());
        gradesProject.add(studentGrades.getNota2Project());
        gradesProject.add(studentGrades.getNota3Project());
        if (studentGrades.getTipLicenta() == null)
            return grade;
        if (studentGrades.getTipLicenta().equals("Licenta")) {
            if (!profesori.containsId(studentGrades.getIdProfesor())) {
                gradesOral.add(studentGrades.getNota5Oral());
                gradesProject.add(studentGrades.getNota5Project());
            }
        } else if (studentGrades.getTipLicenta().equals("Dizertatie")) {
            gradesOral.add(studentGrades.getNota4Oral());
            gradesOral.add(studentGrades.getNota4Project());
            if (!profesori.containsId(studentGrades.getIdProfesor())) {
                gradesOral.add(studentGrades.getNota5Project());
                gradesProject.add(studentGrades.getNota5Project());
            }
        }
        grade.setGrade(calculateGrade(gradesOral, gradesProject));
        return grade;
    }

    /*8.
    Descriere: Metoda utilizata pentru obtinerea unei liste de studenti impreuna cu notele obtinute de acestia.
    Input:  - numar_pagina (Integer)
    Output: - O lista cu 10 structuri de forma: { String nume_stud; String prenume_stud; int nota_finala; } (Ex: daca numar_pagina = 1 se returneaza
              structurile 1-10, daca numar_pagina = 2 se returneaza structurile 11-20, etc)*/
    @Override
    public List<StundetListPageResponse> getClientListPage(int pagenumber, int pagesize) {
        List<StundetListPageResponse> list = new ArrayList<StundetListPageResponse>(); // return list
        List<IntrareStudenti> studenti = new ArrayList<IntrareStudenti>(); // select all students list
        GradeResponse grade; // to get grade for each student
        AccessBD access = bd.login("Admin", "Root");
        AccessAdminBD accessAdmin = ((AccessAdminBD) access);
        studenti = accessAdmin.selectStudenti(); // select all student

        //get students from page pagenaumber
        for (int index = (pagenumber - 1) * pagesize, size = studenti.size(); index < pagenumber * pagesize && index < size; index++) {
            IntrareStudenti student = new IntrareStudenti();
            StundetListPageResponse result = new StundetListPageResponse();
            student = studenti.get(index);
            grade = getStudentGrade(student.getId());

            result.setNumeStudent(student.getNume());
            result.setPrenumeStudent(student.getPrenume());
            result.setNotaFinala(grade.getGrade());

            list.add(result);
        }
        return list;
    }

    /*9.
    Descriere: Metoda ce returneaza o lista de comisii.
    Input:  - None
    Output: - O lista de comisii de forma: { int id; String nume_comisie; String data_examinare; }
    (Forma data_examinare: '12-02-2017' adica 'DD-MM-YYYY')*/
    @Override
    public List<CommitteListResponse> getCommitteList(String token) {
        List<CommitteListResponse> committeeList = new ArrayList<CommitteListResponse>();
        AccessBD access = bd.login("Admin", "Root");

        AccessAdminBD accessAdmin = (AccessAdminBD) access;// presupunem ca este
        // admin
        List<IntrareComisii> listaComisii = accessAdmin.selectComisii();

        for (IntrareComisii c : listaComisii) {
            CommitteListResponse comListRes = new CommitteListResponse();
            comListRes.setId(c.getId());
            comListRes.setNumeComisie("Comisie " + comListRes.getId());
            comListRes.setDataExaminare(c.getDataEvaluare());
            committeeList.add(comListRes);
        }

        return committeeList;
    }

    /*10.
    Descriere: Metoda ce returneaza profesorii dintr-o comisie.
    Input:  - id_comisie (Integer)
    Output: - Lista de profesori din acea comisie
    (o lista cu id-urile acestora este destul, se poate folosi metoda nr. 5 pentru alte informatii).*/

    @Override
    public List<IdResponse> getProfsFromCommitte(int idCommitte) {
        AccessBD access = bd.login("Admin", "Root");
        AccessAdminBD accessAdmin = ((AccessAdminBD) access);
        IntrareComisii comisie = accessAdmin.getCommitteeById(idCommitte);
        List<Integer> idProfiComisie = new ArrayList<Integer>();

        idProfiComisie.add(comisie.getIdProfSef()); // la indexul 0 se va afla
        // id-ul Sefului de comisie
        idProfiComisie.add(comisie.getIdProf2());// la indexul 1 se va afla
        // id-ul profului2
        idProfiComisie.add(comisie.getIdProf3());// la indexul 0 se va afla
        // id-ul profului3

        if (comisie.getIdProf4() != 0) // daca exista al 4 lea
            // profesor(dizertatie) => id_ul
            // profului 4 la indexul3
            idProfiComisie.add(comisie.getIdProf4());

        List<IdResponse> result = new ArrayList<IdResponse>();
        for (int index = 0, size = idProfiComisie.size(); index < size; index++) {
            IdResponse idRes = new IdResponse();
            idRes.setId(idProfiComisie.get(index));
            result.add(idRes);
        }
        return result;
    }

    /*
       * 11. Descriere: Metoda ce returneaza profesorii neasignati unei comisii.
       * Input: - None Output: - Lista de profesori neasignati (o lista cu
       * id-urile acestora este destul, se poate folosi metoda nr. 5 pentru alte
       * informatii).
       */
    @Override
    public List<IdResponse> getProfsWithoutCommitte(String token) {
        List<IdResponse> profsWithoutCommitteeIdList = new ArrayList<IdResponse>();
        AccessBD access = bd.login("Admin", "Root");
        AccessAdminBD accessAdmin = ((AccessAdminBD) access);
        List<IntrareProfesori> profsWithoutCommitteeList = accessAdmin.getProfesorsWithoutCommittee();

        for (IntrareProfesori p : profsWithoutCommitteeList) {
            IdResponse idRes = new IdResponse();
            idRes.setId(p.getId());
            profsWithoutCommitteeIdList.add(idRes);
        }
        return profsWithoutCommitteeIdList;
    }

    /*
     * 12. Descriere: Metoda ce va muta un profesor din orice comisie ar fi (sau
     * daca nu este asignat unei comisii) in comisia specificata. Input: -
     * id_prof (Integer) - id_comisie (Integer) Output: - result (true - daca
     * profesorul a fost mutat, false - din orice alt motiv)
     */
    @Override
    public boolean moveProfToCommitte(int idProf, int idCommitte, String token) {

        if (!(verifyIfCommitteExists(idCommitte, token) || verifyIfProfesorExists(idProf, token))) {
            return false;

        }

        AccessBD access = bd.login("Admin", "Root");
        AccessAdminBD accessAdmin = ((AccessAdminBD) access);

        if (accessAdmin.setComisieProfesor(idProf, idCommitte) == 0)
            return true;
        else
            return false;

    }

    /*
     * 13. Descriere: Metoda utilizata pentru obtinerea unei liste cu studentii
     * ce trebuie evaluati de o anumita comisie. Input: - id_comisie (Integer)
     * Output: - Lista de studenti ce trebuie evaluati de forma: { int id_stud;
     * String nume_stud; String prenume_stud; }
     */
    @Override
    public List<StudentResponse> getEvaluateStudentsByCommitte(int idCommitte) {
        AccessBD access = bd.login("Admin", "Root");
        AccessAdminBD accessAdmin = ((AccessAdminBD) access);
        List<IntrareStudenti> listaStudenti = accessAdmin.getStudentsByCommitte(idCommitte);
        List<StudentResponse> listaResposeStudenti = new ArrayList<StudentResponse>();

        for (IntrareStudenti s : listaStudenti) {
            StudentResponse studResp = new StudentResponse();
            studResp.setIdStudent(s.getIdCont());
            studResp.setNumeStudent(s.getNume());
            studResp.setPrenumeStudent(s.getPrenume());
            listaResposeStudenti.add(studResp);
        }

        return listaResposeStudenti;
    }

    /*
     * 14. Descriere: Metoda ce permite trecerea unei note, de catre un
     * profesor, unui student. Input: - id_prof (Integer) - id_stud (Integer) -
     * valoare_nota (Integer) Output: - result (true - daca nota a fost trecuta,
     * false - din orice alt motiv)
     */
    @Override
    public boolean profNote(int idProf, int idStudent, int gradeOral, int gradeProiect) {

        AccessBD access = bd.login("Admin", "Root");
        AccessAdminBD accessAdmin = ((AccessAdminBD) access);
        IntrareComisii comisieProfesor = accessAdmin.getCommitteByProf(idProf);
        IntrareComisii comisieStudent = accessAdmin.getCommitteByStudent(idStudent);

        if (comisieProfesor == null || comisieStudent == null || comisieProfesor.getId() != comisieStudent.getId()) {

            return false;
        }


        int profIndex = accessAdmin.getProfIndex(idProf, comisieProfesor.getId());
        System.out.println(profIndex);
        return (accessAdmin.updateNotaStudent(profIndex, idStudent, 1, gradeOral, gradeProiect));

    }

    /*15.
    Descriere: Metoda utilizata pentru obtinerea unei liste de studenti indrumati de un anumit profesor
    Input:  - id_prof (Integer)
    Output: - Lista de studenti indrumati de profesor de forma: {
    int id_stud; String nume_stud; String prenume_stud; int nota_finala; int nota1, nota2, nota3, nota4; }
                (daca notele nu exista se reurneaza -1 pe fiecare dintre ele)*/
    @Override
    public List<StudentGuidedListResponse> getStudentGuided(int idProf) {
        return bd.getStudentsOfATeacher(idProf);
    }

    /*16.
    Descriere: Metoda ce adauga un student la lista de studenti indrumati de un anumit profesor
    Input:  - id_prof (Integer)
            - nume_stud (String)
            - prenume_stud (String)
    Output: - result (Boolean) (true - daca studentul a fost adauga, false - orice alt motiv)*/
    @Override
    public boolean insertStudentToListProf(int idProf, String email) {
        String prenumeStudent = email.substring(email.indexOf('.') + 1, email.indexOf('@'));
        String numeStudent = email.substring(0, email.indexOf('.'));
        return bd.addStudent(idProf, numeStudent, prenumeStudent);
    }

    /*17.
    Descriere: Metoda ce elimina un student din lista de studenti indrmati de un anumit profesor.
    Input:  - id_prof (Integer)
            - id_stud (Integer)
    Output: - result (Boolean) (true - daca studentul a fost eliminat din lista, false - orice alt motiv)*/
    @Override
    public boolean deleteStudentToListProf(int idProf, int idStudent) {
        return bd.removeStudent(idProf, idStudent);
    }

    /*18.
    Descriere: Metoda ce permite editarea datei de examinare a unei anumite comisii.
    Input:  - id_comisie (Integer)
            - data_examinare (String) (forma data: 'DD-MM-YYYY')
    Output: - result (Boolean) (true - daca data a fost modificata, false - orice alt motiv)*/
    @Override
    public boolean modifyDate(int idCommitte, String beginDate, String endDate) {
        return bd.editExaminationDate(idCommitte, beginDate, endDate);
    }

     /* 19.
    Descriere: Metoda ce returneaza o tabela cu toti studentii si notele obtinute de acestia (metoda utilizata de secretar).
    Input:  - None
    Output: - Ce vreti voi, noi luam datele si le bagam intr-un PDF. Un exemplu ar fi o lista de structuri de forma: {String nume; String prenume; int nota;}
    */

    @Override
    public List<StundetListPageResponse> getFinalMarksOfStudents() {
        return bd.getStudentsMarks();
    }

    /*20.
   Descriere: Metoda ce returneaza o tabela cu repartizarea pe sali a studentilor (metoda utilizata de admin).
   Input:  - None
   Output: - Tot la fel, ce considerati voi a fi relevant, noi preluam si punem in PDF.
   */
    @Override
    public List<DistributionOnHallsResponse> getDistributionOfStudentsOnHalls() {
        return bd.getDistributionOnHalls();
    }

    /*21. [-] O metoda noua, utilizata pentru crearea unei noi sesiuni:
    Input: - Data inceput sesiune (String, format 'MM/DD/YYYY')
	       - Data sfarsit sesiune (String, format 'MM/DD/YYYY')
	       - Numar total de comisii alocate pentru acea sesiune (Integer)
	Output: - true daca s-a creat, false daca nu (de exemplu, false daca exista una deja activa?)
*/
    @Override
    public boolean addSession(String dataInceput, String dataSfarsit, int nrDeComisii) {
        return bd.addSession(dataInceput, dataSfarsit, nrDeComisii);
    }

    /*functia 22 Input - ID student (Integer)
      Output - true daca studentul are licenta uploadata, false daca nu
        */
    @Override
    public boolean hasUploadedLicense(int idStudent) {
        AccessBD access = bd.login("Admin", "Root");
        AccessAdminBD accessAdmin = ((AccessAdminBD) access);
        if (accessAdmin.getFisierLucrare(idStudent) != null)
            return true;
        return false;
    }

    /*functia 23 Input - ID student (Integer)
    Output - true daca s-a uploadat licenta cu succes, false daca nu
    */
    @Override
    public boolean insertUploadedLicense(int idStudent, byte[] data) {
        AccessBD accessBD = bd.login("Admin", "Root");
        if (accessBD.setFisierLucrare(idStudent, data) != 0)
            return false;

        return true;
    }

    /*functia 24 I O metoda ce permite vizualizarea unei licente a unui student:
        Input - ID student (Integer)
        Output - toate datele licentei: Nume licenta, tip, profesor coordonator, BLOB-ul
    */
    @Override
    public LicenseDataResponse getLicenseInformations(int idStudent) {
        AccessBD access = bd.login("Admin", "Root");
        AccessAdminBD accessAdmin = ((AccessAdminBD) access);
        return accessAdmin.getLicenseData(idStudent);
    }
    /* functia 25 : functie ce returneaza true daca exista o sesiune activa
    *                false altfel
    * input - none
    * output - ce se cere :D
    */
    @Override
    public boolean isSesionActive() {
        AccessBD access = bd.login("Admin", "Root");
        AccessAdminBD accessAdmin = ((AccessAdminBD) access);
        List<IntrareSesiuni> sesiunis = accessAdmin.selectSesiuni();
        for (IntrareSesiuni sesiune : sesiunis) {
            if (sesiune.getActive() == 1)
                return true;
        }
        return  false;
    }


    @Override
    public void finalize() {
        try {
            System.out.println("================================");
            System.out.println("  DISCONNECTED FROM ORACLE DB   ");
            System.out.println("================================");
        } catch (Exception e) {
            System.err.println("Error shutting down database!");
        }
    }
}
