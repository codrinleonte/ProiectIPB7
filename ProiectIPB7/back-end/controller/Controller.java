package controller;

import clojure.core.Vec;
import model.scheduling.Timetable;

import java.util.HashMap;
import java.util.Vector;

public class Controller {

    private static HashMap<String, String> activeAuthTokens = new HashMap<>();

    // TODO Any members






    // 1.
    public boolean register(String email, String password) {

        String firstName = email.split("@")[0].split("\\.")[0];
        String lastName  = email.split("@")[0].split("\\.")[0];


        // TODO DB insert function needed.
        // IN:  String email, String password, String firstName, String lastName
        // OUT: boolean
        // True if validation email has been sent
        // False in any other case
        // All accounts are registered as students

        return true; // return dbRegister(email, password, firstName, lastName);
    }

    // 2.
    public boolean confirmEmail(String confirmToken) {

        // TODO DB confirm function needed
        // IN:  String confirmToken
        // OUT: boolean
        // True if key sent matches an account and the account is NOT already activated
        // (also activate the account in the DB in this case)
        // (the whole database will have to be scanned. For ex. UPDATE USERS VALUES activated = 1 WHERE activated = 0 AND token = confirmToken)
        // False in any other case(including account already activated)

        return true; // return dbConfirmEmail(confirmToken);
    }

    // 3.
    public String login(String email, String password) {

        // TODO DB login function needed
        // IN:  String email, String password
        // OUT: String token
        // String with an authentication token if login successful
        // Empty string("") otherwise

        String token = ""; // = dbLogin(email, password);

        if (token.length() > 1) // If the login was successful and a non-empty token was returned
            activeAuthTokens.put(token, email);

        return token;
    }



    // Authentication token needed from this point on

    // 4.
    public Vector<String> getAccountInfo(String token) {

        if (activeAuthTokens.get(token) == null) { // If the token is not found in the active tokens list
            Vector<String> result = new Vector<>();
            result.addElement("access denied");
            return result;
        }

        // TODO DB getInfo function needed
        // IN:  String email
        // OUT: Vector<String> info
        // Return a Vector<String> with the corresponding user info *in this order*: nume, prenume, email, type(student, teacher, secretary etc.)

        return new Vector<>(); //return dbGetAccountInfo(String email);

    }

    // 5.
    public Vector<Vector<String>> getTeachers(String token) {

        if (activeAuthTokens.get(token) == null) {
            Vector<Vector<String>> result = new Vector<>();
            result.addElement(new Vector<>());
            result.elementAt(0).addElement("access denied");
            return result;
        }

        // TODO DB getTeachers function needed
        // IN:  None
        // OUT: Vector<Vector<String>> teachers
        // Teachers contains vectors of Strings, each of these String Vectors holds the info for a specific teacher
        // The info for each teacher is, in this order: id, nume, prenume, email, id_comisie
        // If the teacher is not assigned to a commission, set that field to "-1"

        return new Vector<>(); // return getTeachers();
    }

    // 6.
    public boolean newProject(String token, String projectName, String idProf, String projectDescription) {

        // TODO DB newProject function needed
        // IN:  String studEmail, String projectName, String idProf, String projectDescription
        // OUT: boolean
        // True in case of success
        // False otherwise

        return true; // return dbNewProject(studEmail, projectName, idProf, projectDescription);
    }

}




