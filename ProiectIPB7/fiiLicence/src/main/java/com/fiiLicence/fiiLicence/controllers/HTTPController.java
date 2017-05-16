package com.fiiLicence.fiiLicence.controllers;

import com.fiiLicence.fiiLicence.models.*;
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

    // ---------------------------------------- /REGISTRATION -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> registration(@RequestBody RegistrationRequest request) {

        boolean result = databaseService.validateRegistration(request.email, request.password);

        RegistrationResponse response = new RegistrationResponse();
        response.response = result;

        System.out.println("------ /registration - " + request.email + " - " + Boolean.toString(result) + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    // ---------------------------------------- /CONFIRM REGISTRATION ---------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/confirmRegistration", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> confirmRegistration(@RequestBody ConfirmRegistrationRequest request) {

        boolean result = databaseService.confirmRegistration(request.confirmToken);

        RegistrationResponse response = new RegistrationResponse();
        response.response = result;

        System.out.println("------ /confirmRegistration - " + request.confirmToken + " - " + Boolean.toString(result) + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }

    // ---------------------------------------- /LOGIN -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) {

        String result = databaseService.login(request.email, request.password);

        TokenResponse response = new TokenResponse();
        response.token = result;

        System.out.println("------ /login - " + request.email + " - " + result + " ------");
        return new ResponseEntity<TokenResponse>(response, HttpStatus.OK);
    }

    // ---------------------------------------- /USERINFO -------------------------------------------------
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

    // ---------------------------------------- /PROFESORLIST -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/profesorlist", method = RequestMethod.POST)
    public ResponseEntity<List<ProfListResponse>> profesorlist(@RequestHeader("Authorization") String token) {

        List<ProfListResponse> response = databaseService.getProfList(token);

        if (response == null) {
            System.out.println("------ /profesorlist - " + token + " - NO MATCH ------");
            return new ResponseEntity<List<ProfListResponse>>(HttpStatus.NO_CONTENT);
        }

        System.out.println("------ /profesorlist - " + token + " ------");
        return new ResponseEntity<List<ProfListResponse>>(databaseService.getProfList(token), HttpStatus.OK);
    }

    // ---------------------------------------- /recordlicence -------------------------------------------------
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/recordlicence", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> recordLicence(@RequestHeader("Authorization") String token, @RequestBody LicenceRequest request) {

        boolean result = databaseService.recordLicence(request.nameOfLicence, request.idProfesor, request.descriptionOfLicence);

        RegistrationResponse response = new RegistrationResponse();
        response.response = result;

        System.out.println("------ /recordlicence - " + request.nameOfLicence + request.idProfesor + request.descriptionOfLicence + " - " + result + " ------");
        return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
    }


}
