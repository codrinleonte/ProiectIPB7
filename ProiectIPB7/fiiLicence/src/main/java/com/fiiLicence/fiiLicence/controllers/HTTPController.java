package com.fiiLicence.fiiLicence.controllers;

import com.fiiLicence.fiiLicence.models.requests.*;
import com.fiiLicence.fiiLicence.models.response.*;
import com.fiiLicence.fiiLicence.services.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HTTPController {
    @Autowired
    private DatabaseService databaseService;

    //1 ---------------------------------------- /REGISTRATION -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> registration(@RequestBody RegistrationRequest request) {

        boolean result = databaseService.validateRegistration(request.email, request.password);

        RegistrationResponse response = new RegistrationResponse();
        response.response = result;

        System.out.println("------ /registration - " + request.email + " - " + Boolean.toString(result) + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //2 ---------------------------------------- /CONFIRM REGISTRATION ---------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/confirmregistration", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> confirmRegistration(@RequestBody ConfirmRegistrationRequest request) {

        boolean result = databaseService.confirmRegistration(request.confirmToken);

        RegistrationResponse response = new RegistrationResponse();
        response.response = result;

        System.out.println("------ /confirmRegistration - " + request.confirmToken + " - " + Boolean.toString(result) + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //3 ---------------------------------------- /LOGIN -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) {

        String result = databaseService.login(request.email, request.password);

        TokenResponse response = new TokenResponse();
        response.token = result;

        System.out.println("------ /login - " + request.email + " - " + result + " ------");
        return new ResponseEntity<TokenResponse>(response, HttpStatus.OK);
    }

    //4 ---------------------------------------- /USERINFO -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/userinfo", method = RequestMethod.POST)
    public ResponseEntity<UserinfoResponse> getUserInfo(@RequestHeader("Authorization") String token) {

        UserinfoResponse response = databaseService.getUserInfo(token);

        if (response == null) {
            System.out.println("------ /userinfo - " + token + " - NO MATCH ------");
            return new ResponseEntity<UserinfoResponse>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /userinfo - " + token + " ------");
        return new ResponseEntity<UserinfoResponse>(databaseService.getUserInfo(token), HttpStatus.OK);
    }

    //5 ---------------------------------------- /PROFESORLIST -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/profesorlist", method = RequestMethod.GET)
    public ResponseEntity<List<ProfListResponse>> profesorlist(@RequestHeader("Authorization") String token) {

        List<ProfListResponse> response = databaseService.getProfList(token);

        if (response == null) {
            System.out.println("------ /profesorlist - " + token + " - NO MATCH ------");
            return new ResponseEntity<List<ProfListResponse>>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /profesorlist - " + token + " ------");
        return new ResponseEntity<List<ProfListResponse>>(databaseService.getProfList(token), HttpStatus.OK);
    }

    //6 ---------------------------------------- /RECORDLICENCE -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/recordlicence", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> recordLicence(@RequestHeader("Authorization") String token, @RequestBody LicenceRequest request) {

        boolean result = databaseService.recordLicence(request.nameOfLicence, request.idProfesor, request.descriptionOfLicence);

        RegistrationResponse response = new RegistrationResponse();
        response.response = result;

        System.out.println("------ /recordlicence - " + request.nameOfLicence + request.idProfesor + request.descriptionOfLicence + " - " + result + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //7 ---------------------------------------- /GETSTUDENTGRADE -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getStudentGrade", method = RequestMethod.POST)
    public ResponseEntity<GradeResponse> getStudentGrade(@RequestHeader("Authorization") String token, @RequestBody IdResponse request) {

        GradeResponse result = databaseService.getStudentGrade(request.id);

        System.out.println("------ /getStudentGrade - " + request.id + " - " + result + " ------");
        return new ResponseEntity<GradeResponse>(result, HttpStatus.OK);
    }

    //8 ---------------------------------------- /ClientListPageRequest -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/profesorlist", method = RequestMethod.POST)
    public ResponseEntity<List<StundetListPageResponse>> profesorlist(@RequestHeader("Authorization") String token,@RequestBody ClientListPageRequest request) {

        List<StundetListPageResponse> response = databaseService.getClientListPage(request.pagenumber,request.pagesize);

        if (response == null) {
            System.out.println("------ /profesorlist - " + token + " - NO MATCH ------");
            return new ResponseEntity<List<StundetListPageResponse>>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /profesorlist - " + token + " ------");
        return new ResponseEntity<List<StundetListPageResponse>>(databaseService.getClientListPage(request.pagenumber,request.pagesize), HttpStatus.OK);
    }

    //9 ---------------------------------------- /GETCOMMITTELIST -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getCommitteList", method = RequestMethod.POST)
    public ResponseEntity<List<CommitteListResponse>> getCommitteList(@RequestHeader("Authorization") String token) {

        List<CommitteListResponse> response = databaseService.getCommitteList(token);

        if (response == null) {
            System.out.println("------ /getCommitteList - " + token + " - NO MATCH ------");
            return new ResponseEntity<List<CommitteListResponse>>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /getCommitteList - " + token + " ------");
        return new ResponseEntity<List<CommitteListResponse>>(databaseService.getCommitteList(token), HttpStatus.OK);
    }

    //10 ---------------------------------------- /GETPROFSFROMCOMMITTE -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getProfsFromCommitte", method = RequestMethod.POST)
    public ResponseEntity<List<IdResponse>> getProfsFromCommitte(@RequestHeader("Authorization") String token,@RequestBody IdResponse request) {

        List<IdResponse> response = databaseService.getProfsFromCommitte(request.id);

        if (response == null) {
            System.out.println("------ /getProfsFromCommitte - " + token + " - NO MATCH ------");
            return new ResponseEntity<List<IdResponse>>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /getProfsFromCommitte - " + token + " ------");
        return new ResponseEntity<List<IdResponse>>(databaseService.getProfsFromCommitte(request.id), HttpStatus.OK);
    }


    //11 ---------------------------------------- /GETPROFSWITHOUTCOMMITTE -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getProfsWithoutCommitte", method = RequestMethod.POST)
    public ResponseEntity<List<IdResponse>> getProfsWithoutCommitte(@RequestHeader("Authorization") String token) {

        List<IdResponse> response = databaseService.getProfsWithoutCommitte(token);

        if (response == null) {
            System.out.println("------ /getProfsWithoutCommitte - " + token + " - NO MATCH ------");
            return new ResponseEntity<List<IdResponse>>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /getProfsWithoutCommitte - " + token + " ------");
        return new ResponseEntity<List<IdResponse>>(databaseService.getProfsWithoutCommitte(token), HttpStatus.OK);
    }

    //12 ---------------------------------------- /MOVEPROFTOCOMMITTE -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/moveProfToCommitte", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> moveProfToCommitte(@RequestHeader("Authorization") String token, @RequestBody MoveProfRequest request) {

        boolean result = databaseService.moveProfToCommitte(request.idProf,request.idCommitte);

        RegistrationResponse response = new RegistrationResponse();
        response.response = result;

        System.out.println("------ /moveProfToCommitte - " + request.idProf +" " + request.idCommitte + " - " + result + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //13 ---------------------------------------- /GETPROFSWITHOUTCOMMITTE -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getEvaluateStudentsByCommitte", method = RequestMethod.POST)
    public ResponseEntity<List<StudentResponse>> getEvaluateStudentsByCommitte(@RequestHeader("Authorization") String token,@RequestBody IdResponse request) {

        List<StudentResponse> response = databaseService.getEvaluateStudentsByCommitte(request.id);

        if (response == null) {
            System.out.println("------ /getEvaluateStudentsByCommitte - " + token + " - NO MATCH ------");
            return new ResponseEntity<List<StudentResponse>>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /getEvaluateStudentsByCommitte - " + token + " ------");
        return new ResponseEntity<List<StudentResponse>>(databaseService.getEvaluateStudentsByCommitte(request.id), HttpStatus.OK);
    }

    //14 ---------------------------------------- /PROFNOTE -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/profNote", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> profNote(@RequestHeader("Authorization") String token, @RequestBody ProfNoteRequest request) {

        boolean result = databaseService.profNote(request.idProf,request.idStudent,request.grade);

        RegistrationResponse response = new RegistrationResponse();
        response.response = result;

        System.out.println("------ /profNote - " + request.idProf +" " + request.idStudent+" "+request.grade + " - " + result + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //15 ---------------------------------------- /GETPROFSWITHOUTCOMMITTE -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getStudentGuided", method = RequestMethod.POST)
    public ResponseEntity<List<StudentGuidedListResponse>> getStudentGuided(@RequestHeader("Authorization") String token,@RequestBody IdResponse request) {

        List<StudentGuidedListResponse> response = databaseService.getStudentGuided(request.id);

        if (response == null) {
            System.out.println("------ /getStudentGuided - " + token + " - NO MATCH ------");
            return new ResponseEntity<List<StudentGuidedListResponse>>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /getStudentGuided - " + token + " ------");
        return new ResponseEntity<List<StudentGuidedListResponse>>(databaseService.getStudentGuided(request.id), HttpStatus.OK);
    }

    //16 ---------------------------------------- /INSERTSTUDENTTOLISTPROF -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/insertStudentToListProf", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> insertStudentToListProf(@RequestHeader("Authorization") String token, @RequestBody InsertStudentRequest request) {

        boolean result = databaseService.insertStudentToListProf(request.idProf,request.numeStudent,request.prenumeStudent);

        RegistrationResponse response = new RegistrationResponse();
        response.response = result;

        System.out.println("------ /insertStudentToListProf - " + request.idProf +" " + request.numeStudent+" "+request.prenumeStudent + " - " + result + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //17 ---------------------------------------- /DELETESTUDENTTOLISTPROF -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/deleteStudentToListProf", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> deleteStudentToListProf(@RequestHeader("Authorization") String token, @RequestBody DeleteStudentRequest request) {

        boolean result = databaseService.deleteStudentToListProf(request.idProf,request.idStudent);

        RegistrationResponse response = new RegistrationResponse();
        response.response = result;

        System.out.println("------ /deleteStudentToListProf - " + request.idProf +" " + request.idStudent + " - " + result + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //18 ---------------------------------------- /MODIFYDATE -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/modifyDate", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> modifyDate(@RequestHeader("Authorization") String token, @RequestBody ModifyDateRequest request) {

        boolean result = databaseService.modifyDate(request.idCommitte,request.beginDate,request.endDate);

        RegistrationResponse response = new RegistrationResponse();
        response.response = result;

        System.out.println("------ /modifyDate - " + request.idCommitte +" " + request.beginDate +" "+request.endDate+ " - " + result + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }


}
