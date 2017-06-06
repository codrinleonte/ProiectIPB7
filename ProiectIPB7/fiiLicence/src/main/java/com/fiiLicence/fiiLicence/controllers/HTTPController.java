package com.fiiLicence.fiiLicence.controllers;

import com.fiiLicence.fiiLicence.models.requests.*;
import com.fiiLicence.fiiLicence.models.response.*;

import com.fiiLicence.fiiLicence.services.DatabaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HTTPController {
    @Autowired
    private DatabaseServiceImpl databaseService;

    //1 ---------------------------------------- /REGISTRATION -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> registration(@RequestBody RegistrationRequest request) {

        boolean result = databaseService.validateRegistration(request.getEmail(), request.getPassword());

        RegistrationResponse response = new RegistrationResponse();
        response.setResponse(result);

        System.out.println("------ /registration - " + request.getEmail() + " - " + Boolean.toString(result) + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //2 ---------------------------------------- /CONFIRM REGISTRATION ---------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/confirmregistration", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> confirmRegistration(@RequestBody ConfirmRegistrationRequest request) {

        boolean result = databaseService.confirmRegistration(request.getConfirmToken());

        RegistrationResponse response = new RegistrationResponse();
        response.setResponse(result);

        System.out.println("------ /confirmRegistration - " + request.getConfirmToken() + " - " + Boolean.toString(result) + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //3 ---------------------------------------- /LOGIN -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) {

        String result = databaseService.login(request.getEmail(), request.getPassword());

        TokenResponse response = new TokenResponse();
        response.setToken(result);

        System.out.println("------ /login - " + request.getEmail() + " - " + result + " ------");
        return new ResponseEntity<TokenResponse>(response, HttpStatus.OK);
    }

    //4 ---------------------------------------- /USERINFO -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
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
    @CrossOrigin
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
    @CrossOrigin
    @RequestMapping(value = "/recordlicence", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> recordLicence(@RequestHeader("Authorization") String token, @RequestBody LicenceRequest request) {
        if (!databaseService.verifyToken(token))
            return null;
        boolean result = databaseService.recordLicence(token, request.getNameOfLicence(), request.getIdProfesor(), request.getDescriptionOfLicence());

        RegistrationResponse response = new RegistrationResponse();
        response.setResponse(result);

        System.out.println("------ /recordlicence - " + request.getNameOfLicence() + request.getIdProfesor() + request.getDescriptionOfLicence() + " - " + result + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //7 ---------------------------------------- /GETSTUDENTGRADE -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/getStudentGrade", method = RequestMethod.POST)
    public ResponseEntity<GradeResponse> getStudentGrade(@RequestHeader("Authorization") String token, @RequestBody IdResponse request) {
        if (!databaseService.verifyToken(token))
            return null;
        GradeResponse result = databaseService.getStudentGrade(request.getId());

        System.out.println("------ /getStudentGrade - " + request.getId() + " - " + result + " ------");
        return new ResponseEntity<GradeResponse>(result, HttpStatus.OK);
    }

    //8 ---------------------------------------- /ClientListPage -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/clientListPage", method = RequestMethod.POST)
    public ResponseEntity<List<StundetListPageResponse>> clientListPage(@RequestHeader("Authorization") String token, @RequestBody ClientListPageRequest request) {
        if (!databaseService.verifyToken(token))
            return null;
        List<StundetListPageResponse> response = databaseService.getClientListPage(request.getPagenumber(), request.getPagesize());

        if (response == null) {
            System.out.println("------ /clientListPage - " + token + " - NO MATCH ------");
            return new ResponseEntity<List<StundetListPageResponse>>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /clientListPage - " + token + " ------");
        return new ResponseEntity<List<StundetListPageResponse>>(databaseService.getClientListPage(request.getPagenumber(), request.getPagesize()), HttpStatus.OK);
    }

    //9 ---------------------------------------- /GETCOMMITTELIST -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/getCommitteList", method = RequestMethod.GET)
    public ResponseEntity<List<CommitteListResponse>> getCommitteList(@RequestHeader("Authorization") String token) {
        if (!databaseService.verifyToken(token))
            return null;
        List<CommitteListResponse> response = databaseService.getCommitteList(token);

        if (response == null) {
            System.out.println("------ /getCommitteList - " + token + " - NO MATCH ------");
            return new ResponseEntity<List<CommitteListResponse>>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /getCommitteList - " + token + " ------");
        return new ResponseEntity<List<CommitteListResponse>>(databaseService.getCommitteList(token), HttpStatus.OK);
    }

    //10 ---------------------------------------- /GETPROFSFROMCOMMITTE -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/getProfsFromCommitte", method = RequestMethod.POST)
    public ResponseEntity<List<IdResponse>> getProfsFromCommitte(@RequestHeader("Authorization") String token, @RequestBody IdResponse request) {
        if (!databaseService.verifyToken(token))
            return null;
        List<IdResponse> response = databaseService.getProfsFromCommitte(request.getId());

        if (response == null) {
            System.out.println("------ /getProfsFromCommitte - " + token + " - NO MATCH ------");
            return new ResponseEntity<List<IdResponse>>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /getProfsFromCommitte - " + token + " ------");
        return new ResponseEntity<List<IdResponse>>(databaseService.getProfsFromCommitte(request.getId()), HttpStatus.OK);
    }


    //11 ---------------------------------------- /GETPROFSWITHOUTCOMMITTE -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/getProfsWithoutCommitte", method = RequestMethod.GET)
    public ResponseEntity<List<IdResponse>> getProfsWithoutCommitte(@RequestHeader("Authorization") String token) {
        if (!databaseService.verifyToken(token))
            return null;
        List<IdResponse> response = databaseService.getProfsWithoutCommitte(token);

        if (response == null) {
            System.out.println("------ /getProfsWithoutCommitte - " + token + " - NO MATCH ------");
            return new ResponseEntity<List<IdResponse>>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /getProfsWithoutCommitte - " + token + " ------");
        return new ResponseEntity<List<IdResponse>>(databaseService.getProfsWithoutCommitte(token), HttpStatus.OK);
    }

    //12 ---------------------------------------- /MOVEPROFTOCOMMITTE -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/moveProfToCommitte", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> moveProfToCommitte(@RequestHeader("Authorization") String token, @RequestBody MoveProfRequest request) {
        if (!databaseService.verifyToken(token))
            return null;
        boolean result = databaseService.moveProfToCommitte(request.getIdProf(), request.getIdCommitte(), token);

        RegistrationResponse response = new RegistrationResponse();
        response.setResponse(result);

        System.out.println("------ /moveProfToCommitte - " + request.getIdProf() + " " + request.getIdCommitte() + " - " + result + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //13 ---------------------------------------- /GETEVALUATESTUDENTBYCOMMITE -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/getEvaluateStudentsByCommitte", method = RequestMethod.POST)
    public ResponseEntity<List<StudentResponse>> getEvaluateStudentsByCommitte(@RequestHeader("Authorization") String token, @RequestBody IdResponse request) {
        if (!databaseService.verifyToken(token))
            return null;
        List<StudentResponse> response = databaseService.getEvaluateStudentsByCommitte(request.getId());

        if (response == null) {
            System.out.println("------ /getEvaluateStudentsByCommitte - " + token + " - NO MATCH ------");
            return new ResponseEntity<List<StudentResponse>>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /getEvaluateStudentsByCommitte - " + token + " ------");
        return new ResponseEntity<List<StudentResponse>>(databaseService.getEvaluateStudentsByCommitte(request.getId()), HttpStatus.OK);
    }

    //14 ---------------------------------------- /PROFNOTE -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/profNote", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> profNote(@RequestHeader("Authorization") String token, @RequestBody ProfNoteRequest request) {
        if (!databaseService.verifyToken(token))
            return null;
        boolean result = databaseService.profNote(request.getIdProf(), request.getIdStudent(), request.getGradeOral(), request.getGradeProiect());

        RegistrationResponse response = new RegistrationResponse();
        response.setResponse(result);

        System.out.println("------ /profNote - " + request.getIdProf() + " " + request.getIdStudent() + " " + request.getGradeOral() + " " + request.getGradeProiect() + " - " + result + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //15 ---------------------------------------- /GETSTUDENTGUIDEDBYPROF -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/getStudentGuided", method = RequestMethod.POST)
    public ResponseEntity<List<StudentGuidedListResponse>> getStudentGuided(@RequestHeader("Authorization") String token, @RequestBody IdResponse request) {
        if (!databaseService.verifyToken(token))
            return null;
        List<StudentGuidedListResponse> response = databaseService.getStudentGuided(request.getId());

        if (response == null) {
            System.out.println("------ /getStudentGuided - " + token + " - NO MATCH ------");
            return new ResponseEntity<List<StudentGuidedListResponse>>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /getStudentGuided - " + token + " ------");
        return new ResponseEntity<List<StudentGuidedListResponse>>(databaseService.getStudentGuided(request.getId()), HttpStatus.OK);
    }

    //16 ---------------------------------------- /INSERTSTUDENTTOLISTPROF -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/insertStudentToListProf", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> insertStudentToListProf(@RequestHeader("Authorization") String token, @RequestBody InsertStudentRequest request) {
        if (!databaseService.verifyToken(token))
            return null;
        boolean result = databaseService.insertStudentToListProf(request.getIdProf(), request.getEmail());

        RegistrationResponse response = new RegistrationResponse();
        response.setResponse(result);

        System.out.println("------ /insertStudentToListProf - " + request.getIdProf() + " " + request.getEmail() + " - " + result + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //17 ---------------------------------------- /DELETESTUDENTTOLISTPROF -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/deleteStudentToListProf", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> deleteStudentToListProf(@RequestHeader("Authorization") String token, @RequestBody DeleteStudentRequest request) {
        if (!databaseService.verifyToken(token))
            return null;
        boolean result = databaseService.deleteStudentToListProf(request.getIdProf(), request.getIdStudent());

        RegistrationResponse response = new RegistrationResponse();
        response.setResponse(result);

        System.out.println("------ /deleteStudentToListProf - " + request.getIdProf() + " " + request.getIdStudent() + " - " + result + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //18 ---------------------------------------- /MODIFYDATE -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/modifyDate", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> modifyDate(@RequestHeader("Authorization") String token, @RequestBody ModifyDateRequest request) {
        if (!databaseService.verifyToken(token))
            return null;
        boolean result = databaseService.modifyDate(request.getIdCommitte(), request.getBeginDate(), request.getEndDate());

        RegistrationResponse response = new RegistrationResponse();
        response.setResponse(result);

        System.out.println("------ /modifyDate - " + request.getIdCommitte() + " " + request.getBeginDate() + " " + request.getEndDate() + " - " + result + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //19 ---------------------------------------- /GETALLSTUDENTS -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    public ResponseEntity<List<StundetListPageResponse>> getAllStudents(@RequestHeader("Authorization") String token) {
        if (!databaseService.verifyToken(token))
            return null;
        List<StundetListPageResponse> response = databaseService.getFinalMarksOfStudents();

        if (response == null) {
            System.out.println("------ /getAllStudents - " + token + " - NO MATCH ------");
            return new ResponseEntity<List<StundetListPageResponse>>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /getAllStudents - " + token + " ------");
        return new ResponseEntity<List<StundetListPageResponse>>(databaseService.getFinalMarksOfStudents(), HttpStatus.OK);
    }

    //20 ---------------------------------------- /GETALLHALLS -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/getALLHalls", method = RequestMethod.GET)
    public ResponseEntity<List<DistributionOnHallsResponse>> getAllHalls(@RequestHeader("Authorization") String token) {
        if (!databaseService.verifyToken(token))
            return null;
        List<DistributionOnHallsResponse> response = databaseService.getDistributionOfStudentsOnHalls();

        if (response == null) {
            System.out.println("------ /getAllStudents - " + token + " - NO MATCH ------");
            return new ResponseEntity<List<DistributionOnHallsResponse>>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /getAllStudents - " + token + " ------");
        return new ResponseEntity<List<DistributionOnHallsResponse>>(databaseService.getDistributionOfStudentsOnHalls(), HttpStatus.OK);
    }

    //21 ---------------------------------------- /CREATESESION -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/createSesion", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> createSesion(@RequestHeader("Authorization") String token, @RequestBody SesionRequest request) {
        if (!databaseService.verifyToken(token))
            return null;
        boolean result = databaseService.addSession(request.getBeginDate(), request.getEndDate(), request.getNumberOfCommitte());

        RegistrationResponse response = new RegistrationResponse();
        response.setResponse(result);

        System.out.println("------ /createSesion - " + request.getBeginDate() + " - " + Boolean.toString(result) + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //22 ---------------------------------------- /HASLICENSE -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/hasLicense", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> hasLicense(@RequestHeader("Authorization") String token, @RequestBody IdRequest request) {
        if (!databaseService.verifyToken(token))
            return null;
        boolean result = databaseService.hasUploadedLicense(request.getID());

        RegistrationResponse response = new RegistrationResponse();
        response.setResponse(result);

        System.out.println("------ /hasLicense - " + request.getID() + " - " + Boolean.toString(result) + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //23 ---------------------------------------- /UPDATELICENSE-------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/updateLicense", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> updateLicense(@RequestHeader("Authorization") String token, @RequestBody UpdateLicenceRequest request) {
        if (!databaseService.verifyToken(token))
            return null;
        boolean result = databaseService.insertUploadedLicense(request.getIdStudent(), request.getData());

        RegistrationResponse response = new RegistrationResponse();
        response.setResponse(result);

        System.out.println("------ /updateLicense - " + request.getIdStudent() + " - " + Boolean.toString(result) + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    //24 ---------------------------------------- /GETLICENSE -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/getLicense", method = RequestMethod.POST)
    public ResponseEntity<LicenseDataResponse> getLicense(@RequestHeader("Authorization") String token, @RequestBody IdRequest request) {
        if (!databaseService.verifyToken(token))
            return null;
        LicenseDataResponse result = databaseService.getLicenseInformations(request.getID());

        System.out.println("------ /getLicense - " + request.getID() + " ------");
        return new ResponseEntity<LicenseDataResponse>(result, HttpStatus.OK);
    }

    //25 ---------------------------------------- /ISSESIONACTIVE -------------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/activeSesion", method = RequestMethod.GET)
    public ResponseEntity<RegistrationResponse> activeSesion(@RequestHeader("Authorization") String token) {
        if (!databaseService.verifyToken(token))
            return null;
        boolean result = databaseService.isSesionActive();

        RegistrationResponse response = new RegistrationResponse();
        response.setResponse(result);

        System.out.println("------ /activeSesion - " + " - " + Boolean.toString(result) + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }
}
