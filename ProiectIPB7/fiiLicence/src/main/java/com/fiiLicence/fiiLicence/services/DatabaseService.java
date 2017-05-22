package com.fiiLicence.fiiLicence.services;


import com.fiiLicence.fiiLicence.models.response.*;

import java.util.List;

public interface DatabaseService {

    //1
    boolean validateRegistration(String email, String password);

    //2
    boolean confirmRegistration(String confirmToken);

    //3
    String login(String email, String password);

    //4
    UserinfoResponse getUserInfo(String token);

    //5
    List<ProfListResponse> getProfList(String token);

    //6
    boolean recordLicence(String token, String nameOfLicence, int idProfesor, String descriptionOfLicence);

    //7
    GradeResponse getStudentGrade(int idStudent);

    //8
    List<StundetListPageResponse> getClientListPage(int pagenumber, int pagesize);

    //9
    List<CommitteListResponse> getCommitteList(String token);

    //10
    List<IdResponse> getProfsFromCommitte(int idCommitte);

    //11
    List<IdResponse> getProfsWithoutCommitte(String token);

    //12
    boolean moveProfToCommitte(String token, int idProf, int idCommitte);

    //13
    List<StudentResponse> getEvaluateStudentsByCommitte(int idCommitte);

    //14
    boolean profNote(int idProf, int idStudent, int gradeOral, int gradeProiect);

    //15
    List<StudentGuidedListResponse> getStudentGuided(int idProf);

    //16
    boolean insertStudentToListProf(int idProf, String numeStudent, String prenumeStudent);

    //17
    boolean deleteStudentToListProf(int idProf, int idStudent);

    //18
<<<<<<< HEAD
    boolean modifyDate(int idCommitte, String beginDate, String endDate);
=======
    boolean modifyDate(int idCommitte, String beginDate,String endDate);
>>>>>>> e3fa2c8d910ad16efb1f802180ab7f245a3ec91a
    //19+20
    //to add


}
