package controller;

import model.scheduling.Timetable;

import java.util.Vector;

public class Controller {

    private static Vector<String> activeAuthTokens = new Vector<>();

    // TODO Any members






    // 1.
    public boolean register(String email, String password) {

        String firstName = email.split("@")[0].split("\\.")[0];
        String lastName  = email.split("@")[0].split("\\.")[0];


        // TODO DB insert function needed.
        // True if validation email has been sent
        // False in any other case
        // All accounts are registered as students

        return true; // return dbRegister(email, password, firstName, lastName);
    }

    // 2.
    public boolean confirmEmail(String email, String confirmToken) {

        // TODO DB confirm function needed
        // True if key sent to account matches AND account is NOT already activated(also activate the account in this case)
        // False in any other case(including account already activated

        return true; // return dbConfirmEmail(email, confirmToken);
    }

    // 3.
    public String login(String email, String password) {

        // TODO DB login function needed
        // String with an authentication token if login successful
        // Empty string("") otherwise

        String token = ""; // = dbLogin(email, password);

        if (token.length() > 0)
            activeAuthTokens.addElement(token);

        return token;
    }
}

