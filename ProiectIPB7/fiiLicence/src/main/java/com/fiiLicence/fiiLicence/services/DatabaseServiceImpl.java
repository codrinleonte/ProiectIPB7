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
        IntrareConturi cont = new IntrareConturi();
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
        IntrareConturi idCont = new IntrareConturi();
        int result = bd.login(username, password);
        if (result == 0) {
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
        IntrareConturi cont = new IntrareConturi();
        boolean verifyToken = verifyToken(token);
        if (verifyToken == true) {
            cont = bd.getContByToken(token);
            output.setNume(cont.getUsername().substring(0, cont.getUsername().indexOf('.')));
            output.setPrenume(cont.getUsername().substring(cont.getUsername().indexOf('.') + 1, cont.getUsername().length()));
            output.setEmail(cont.getEmail());
            output.setTip(cont.getTipUtilizator());
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
        IntrareConturi cont = new IntrareConturi();
        IntrareStudenti student = new IntrareStudenti();
        AccessAdminBD accessAdminBD = (AccessAdminBD) bd.getAccess();
        IntrareLicente licenta = new IntrareLicente();
        List<IntrareLicente> licente = accessAdminBD.selectLicente();

        cont = bd.getContByToken(token);
        idCont = cont.getId();
        student = bd.selectStudentByIdCont(idCont);

        if (!cont.getTipUtilizator().equals("Student"))
            return false;

        for (IntrareLicente licence : licente) {
            if (licence.getIdStudent() == student.getId())
                return false;
        }

        licenta.setId(0);
        licenta.setTitlu(nameOfLicence);
        licenta.setIdProfesor(idProfesor);
        licenta.setTipLucrare(descriptionOfLicence);
        licenta.setIdStudent(student.getId());

        if (accessAdminBD.insertLicenta(licenta) == 0)
            return true;
        else
            return false;
    }

    /*7.
    Descriere: Metoda ce returneaza nota obtinuta a utilizatorului curent la examen (metoda apelata doar de utilizatori cu clasa student).
    Input:  - id_stud (Integer)
    Output: - valoare_nota (Integer) (-1 daca nota nu exista)*/
    @Override
    public GradeResponse getStudentGrade(int idStudent) {
        GradeResponse grade = new GradeResponse();
        grade.setGrade(10);
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
        AccessAdminBD accessAdminBD = (AccessAdminBD) bd.getAccess();

        studenti = accessAdminBD.selectStudenti(); // select all student

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
    Output: - O lista de co	misii de forma: { int id; String nume_comisie; String data_examinare; }
    (Forma data_examinare: '12-02-2017' adica 'DD-MM-YYYY')*/
    @Override
    public List<CommitteListResponse> getCommitteList(String token) {
        List<CommitteListResponse> committeeList = new ArrayList<CommitteListResponse>();

        // aici trebuie verificat ce fel de utilizator este cu ajutorul
        // token-ului ..

        // daca utilizator are drept de acces la o astfel de actiune ( Secretar
        // sau Admin)

        bd.login("Admin", "Root");
        AccessBD access = bd.getAccess();
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
        IntrareComisii comisie = bd.getAccess().getCommitteeById(idCommitte);
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
        for (Integer i : idProfiComisie) {
            IdResponse idRes = new IdResponse();
            idRes.setId(idProfiComisie.get(i - 1));
            result.add(idRes);
        }
        return result;
    }

    /*11.
    Descriere: Metoda ce returneaza profesorii neasignati unei comisii.
    Input:  - None
    Output: - Lista de profesori neasignati
    (o lista cu id-urile acestora este destul, se poate folosi metoda nr. 5 pentru alte informatii).*/
    @Override
    public List<IdResponse> getProfsWithoutCommitte(String token) {
        List<IdResponse> profsWithoutCommitteeIdList = new ArrayList<IdResponse>();
        List<IntrareProfesori> profsWithoutCommitteeList = bd.getAccess().getProfesorsWithoutCommittee();

        for (IntrareProfesori p : profsWithoutCommitteeList) {
            IdResponse idRes = new IdResponse();
            idRes.setId(p.getId());
            profsWithoutCommitteeIdList.add(idRes);
        }
        return profsWithoutCommitteeIdList;
    }

    /*12.
    Descriere: Metoda ce va muta un profesor din orice comisie ar fi
    (sau daca nu este asignat unei comisii) in comisia specificata.
    Input:  - id_prof (Integer)
            - id_comisie (Integer)
    Output: - result (true - daca profesorul a fost mutat, false - din orice alt motiv)*/
    @Override
    public boolean moveProfToCommitte(String token, int idProf, int idCommitte) {

        if (!(verifyIfCommitteExists(idCommitte, token) || verifyIfProfesorExists(idProf, token))) {
            return false;
        }
        BD test = new BD();
        test.login("lacra.lacra", "lacra");
        AccessBD accessSecretar = test.getAccess();

        IntrareComisii comisieNoua = accessSecretar.getCommitteeById(idCommitte);
        IntrareComisii comisieActuala = accessSecretar.getCommitteByProf(idProf);
        if (comisieNoua.getIdProfSef() != 0 && comisieNoua.getIdProf2() != 0 && comisieNoua.getIdProf3() != 0) {  // pt dizertatie +comisie.getIdProf4()!=0
            return false;
        } else {

            if (comisieNoua.getIdProfSef() == 0) {
                comisieNoua.setIdProfSef(idProf);
                accessSecretar.updateComisie(comisieNoua);

                if (comisieActuala != null) {
                    if (comisieActuala.getIdProf2() == idProf) {
                        comisieActuala.setIdProf2(0);
                        accessSecretar.updateComisie(comisieActuala);
                    } else if (comisieActuala.getIdProf3() == idProf) {
                        comisieActuala.setIdProf3(0);
                        accessSecretar.updateComisie(comisieActuala);
                    } else if (comisieActuala.getIdProfSef() == idProf) {
                        comisieActuala.setIdProfSef(0);
                        accessSecretar.updateComisie(comisieActuala);
                    }

                }

                return true;

            } else if (comisieNoua.getIdProfSef() == 0) {
                comisieNoua.setIdProfSef(idProf);
                accessSecretar.updateComisie(comisieNoua);


                if (comisieActuala != null) {
                    if (comisieActuala.getIdProf2() == idProf) {
                        comisieActuala.setIdProf2(0);
                        accessSecretar.updateComisie(comisieActuala);
                    } else if (comisieActuala.getIdProf3() == idProf) {
                        comisieActuala.setIdProf3(0);
                        accessSecretar.updateComisie(comisieActuala);
                    } else if (comisieActuala.getIdProfSef() == idProf) {
                        comisieActuala.setIdProfSef(0);
                        accessSecretar.updateComisie(comisieActuala);
                    }

                }


                return true;
            } else if (comisieNoua.getIdProf2() == 0) {
                comisieNoua.setIdProf2(idProf);
                accessSecretar.updateComisie(comisieNoua);


                if (comisieActuala != null) {
                    if (comisieActuala.getIdProf2() == idProf) {
                        comisieActuala.setIdProf2(0);
                        accessSecretar.updateComisie(comisieActuala);
                    } else if (comisieActuala.getIdProf3() == idProf) {
                        comisieActuala.setIdProf3(0);
                        accessSecretar.updateComisie(comisieActuala);
                    } else if (comisieActuala.getIdProfSef() == idProf) {
                        comisieActuala.setIdProfSef(0);
                        accessSecretar.updateComisie(comisieActuala);
                    }

                }


                return true;
            } else if (comisieNoua.getIdProf3() == 0) {
                comisieNoua.setIdProf3(idProf);
                accessSecretar.updateComisie(comisieNoua);


                if (comisieActuala != null) {
                    if (comisieActuala.getIdProf2() == idProf) {
                        comisieActuala.setIdProf2(0);
                        accessSecretar.updateComisie(comisieActuala);
                    } else if (comisieActuala.getIdProf3() == idProf) {
                        comisieActuala.setIdProf3(0);
                        accessSecretar.updateComisie(comisieActuala);
                    } else if (comisieActuala.getIdProfSef() == idProf) {
                        comisieActuala.setIdProfSef(0);
                        accessSecretar.updateComisie(comisieActuala);
                    }

                }

                return true;
            }
            // pentru dizertatie verificare pt prof4
            return false;
        }
    }

    /*13.
    Descriere: Metoda utilizata pentru obtinerea unei liste cu studentii ce trebuie evaluati de o anumita comisie.
    Input:  - id_comisie (Integer)
    Output: - Lista de studenti ce trebuie evaluati de forma: { int id_stud; String nume_stud; String prenume_stud; }   */
    @Override
    public List<StudentResponse> getEvaluateStudentsByCommitte(int idCommitte) {
        List<IntrareStudenti> listaStudenti = bd.getAccess().getStudentsByCommitte(idCommitte);
        List<StudentResponse> listaResposeStudenti = new ArrayList<StudentResponse>();

        for (IntrareStudenti s : listaStudenti) {
            StudentResponse studResp = new StudentResponse();
            studResp.setIdStudent(s.getId());
            studResp.setNumeStudent(s.getNume());
            studResp.setPrenumeStudent(s.getPrenume());
            listaResposeStudenti.add(studResp);
        }

        return listaResposeStudenti;
    }

    /*14.
    Descriere: Metoda ce permite trecerea unei note, de catre un profesor, unui student.
    Input:  - id_prof (Integer)
            - id_stud (Integer)
            - valoare_nota (Integer)
    Output: - result (true - daca nota a fost trecuta, false - din orice alt motiv)*/
    @Override
    public boolean profNote(int idProf, int idStudent, int gradeOral, int gradeProiect) {
        return false;
    }

    /*15.
    Descriere: Metoda utilizata pentru obtinerea unei liste de studenti indrumati de un anumit profesor
    Input:  - id_prof (Integer)
    Output: - Lista de studenti indrumati de profesor de forma: {
    int id_stud; String nume_stud; String prenume_stud; int nota_finala; int nota1, nota2, nota3, nota4; }
                (daca notele nu exista se reurneaza -1 pe fiecare dintre ele)*/
    @Override
    public List<StudentGuidedListResponse> getStudentGuided(int idProf) {
        return null;
    }

    /*16.
    Descriere: Metoda ce adauga un student la lista de studenti indrumati de un anumit profesor
    Input:  - id_prof (Integer)
            - nume_stud (String)
            - prenume_stud (String)
    Output: - result (Boolean) (true - daca studentul a fost adauga, false - orice alt motiv)*/
    @Override
    public boolean insertStudentToListProf(int idProf, String numeStudent, String prenumeStudent) {
        BD b = new BD();
        return b.addStudent(idProf, numeStudent, prenumeStudent);
    }

    /*17.
    Descriere: Metoda ce elimina un student din lista de studenti indrmati de un anumit profesor.
    Input:  - id_prof (Integer)
            - id_stud (Integer)
    Output: - result (Boolean) (true - daca studentul a fost eliminat din lista, false - orice alt motiv)*/
    @Override
    public boolean deleteStudentToListProf(int idProf, int idStudent) {

        BD b = new BD();
        return b.removeStudent(idProf, idStudent);

       BD b = new BD();
       return b.removeStudent(idProf, idStudent);
    }

    /*18.
    Descriere: Metoda ce permite editarea datei de examinare a unei anumite comisii.
    Input:  - id_comisie (Integer)
            - data_examinare (String) (forma data: 'DD-MM-YYYY')
    Output: - result (Boolean) (true - daca data a fost modificata, false - orice alt motiv)*/
    @Override

 

    public boolean modifyDate(int idCommitte, String beginDate,String endDate) {
    	BD b = new BD();
        return b.editExaminationDate(idCommitte, beginDate, endDate);
    }
    
       /* 19.
    Descriere: Metoda ce returneaza o tabela cu toti studentii si notele obtinute de acestia (metoda utilizata de secretar).
    Input:  - None
    Output: - Ce vreti voi, noi luam datele si le bagam intr-un PDF. Un exemplu ar fi o lista de structuri de forma: {String nume; String prenume; int nota;}
    */
    
    public  List<StundetListPageResponse> getFinalMarksOfStudents(){
    	BD b= new BD();
    	return b.getStudentsMarks(); 
    }
   
     /*20.
    Descriere: Metoda ce returneaza o tabela cu repartizarea pe sali a studentilor (metoda utilizata de admin).
    Input:  - None
    Output: - Tot la fel, ce considerati voi a fi relevant, noi preluam si punem in PDF.
    */
    public List<DistributionOnHallsResponse> getDistributionOfStudentsOnHalls(){
    	BD b =new BD();
    	return b.getDistributionOnHalls();
    }
    
    
      /*21. [-] O metoda noua, utilizata pentru crearea unei noi sesiuni:
	Input: - Data inceput sesiune (String, format 'MM/DD/YYYY')
	       - Data sfarsit sesiune (String, format 'MM/DD/YYYY')
	       - Numar total de comisii alocate pentru acea sesiune (Integer)
	Output: - true daca s-a creat, false daca nu (de exemplu, false daca exista una deja activa?)
*/

  public boolean addSession(String dataInceput,String dataSfarsit,int nrDeComisii){
	  BD b =new BD();
	  return b.addSession(dataInceput, dataSfarsit, nrDeComisii);
  }
    
    


	/*functia 22 Input - ID student (Integer)
	Output - true daca studentul are licenta uploadata, false daca nu
	*/
	@Override
	public boolean hasUploadedLicense(int idStudent) {
		AccessBD access = bd.login("andrei.arusoaie", "parola");
		AccessSecretarBD accessSecretar = (AccessSecretarBD) access;
		if(accessSecretar.getFisierLucrare(idStudent)!= null)
				return true;
		return false;
	}

	/*functia 23 Input - ID student (Integer)
	Output - true daca s-a uploadat licenta cu succes, false daca nu
	*/
	@Override
	public boolean insertUploadedLicense(int idStudent, byte[] data) {
		AccessBD accessBD = new AccessBD();
		if(accessBD.setFisierLucrare(idStudent, data)!=0)
			return false;
		
		return true;
	}

	/*functia 24 I O metoda ce permite vizualizarea unei licente a unui student:
		Input - ID student (Integer)
		Output - toate datele licentei: Nume licenta, tip, profesor coordonator, BLOB-ul
	*/
	@Override
	public LicenseDataResponse getLicenseInformations(int idStudent) {	
		return bd.getAccess().getLicenseData(idStudent);
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
