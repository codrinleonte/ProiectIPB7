package controller;

import clojure.core.Vec;

import java.util.HashMap;
import java.util.Vector;

public class Controller {

    private static HashMap<String, String> activeAuthTokens = new HashMap<>();

    // TODO Any members






    // 1.
    public Boolean register(String email, String password) {

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
    public Boolean confirmEmail(String confirmToken) {

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
    public Boolean newProject(String token, String projectName, String idProf, String projectDescription) {

        if (activeAuthTokens.get(token) == null) {
            return false;
        }

        // TODO DB newProject function needed
        // IN:  String studEmail, String projectName, String idProf, String projectDescription
        // OUT: boolean
        // True in case of success
        // False otherwise

        return true; // return dbNewProject(studEmail, projectName, idProf, projectDescription);
    }

    // 7.
    public Double getMarkForStudent(String token, Integer id) {

        if (activeAuthTokens.get(token) == null) {
            return -1.0;
        }

        Double mark, oralMark, projectMark;

        // TODO DB studentMarks function needed
        // IN:  Integer studId
        // OUT: Vector<Vector<Integer>>
        // A vector containing 2 Integer Vectors.
        // The first vector(at position 0) will hold the PROJECT marks
        // The second vector(at position 1) will hold ORAL marks

        Vector<Vector<Integer>> marks = new Vector<>(); // = dbStudentMarks(id);



        projectMark = 0.0;
        oralMark    = 0.0;

        for (Integer i : marks.elementAt(0)) // Project marks
            projectMark += i;

        for (Integer i : marks.elementAt(1)) // Oral marks
            oralMark += i;

        projectMark = (double)((int)(projectMark * 100)) / 100.0; // Truncate to 2 decimal places
        oralMark    = (double)((int)(oralMark    * 100)) / 100.0;

        mark = (double)((int)(((oralMark + projectMark) / 2.0) * 100)) / 100.0; // Truncate the average to 2 decimal places

        return mark;
    }

    // 8.
    public Vector<Vector<String>> getStudentMarksPage(String token, Integer page) {

        Vector<Vector<String>> result = new Vector<>();

        if (activeAuthTokens.get(token) == null) {
            result.addElement(new Vector<>());
            result.elementAt(0).addElement("access denied");
            return result;
        }

        // TODO DB getStudents function needed
        // IN:  None
        // OUT: Vector<Vector<String>>
        // Each of the small String vectors will contain, in this order: numeStudent, prenumeStudent, idStudent

        //result = dbGetStudents();

        Vector<Vector<String>> studentPage = new Vector<>();
        for (int i = 0; i < 10; ++i)
            studentPage.addElement(result.elementAt(page * 10 + i)); // Getting results for the requested page

        for (Vector<String> stud : studentPage) // Calculating the student marks
            stud.setElementAt(getMarkForStudent(token, Integer.parseInt(stud.elementAt(2))).toString(), 2);

        return studentPage;
    }

    // 9.
    public Vector<Integer> getCommittees(String token) {

        if (activeAuthTokens.get(token) == null) {
            Vector<Integer> result = new Vector<>();
            result.addElement(-1);
            return result;
        }

        // TODO DB getCommittees function needed
        // IN:  None
        // OUT: Vector<Integer>
        // Returns a vector of integers with the IDs of all committees

        return new Vector<>(); // return dbGetCommittees();
    }

    // 10.
    public Vector<Integer> getCommitee(String token, Integer id) {

        if (activeAuthTokens.get(token) == null) {
            Vector<Integer> result = new Vector<>();
            result.addElement(-1);
            return result;
        }

        // TODO DB getCommittee function needed
        // IN:  Integer committeeId
        // OUT: Vector<Integer>
        // Returns a Vector with the IDs of the teachers in the specified committee

        return new Vector<>(); // return dbGetCommittee(id);
    }

    // 11.
    public Vector<Integer> getUnassignedTeachers(String token) {

        if (activeAuthTokens.get(token) == null) {
            Vector<Integer> result = new Vector<>();
            result.addElement(-1);
            return result;
        }

        // TODO DB getUnassignedTeachers function needed
        // IN:  None
        // OUT: Vector<Integer>
        // Returns a Vectors with the IDs of the teachers who are not yet assigned to any committee

        return new Vector<>(); // return dbGetUnassignedTeachers();
    }

    // 12.
    public Boolean assignTeacher(String token, Integer profId, Integer committeeId) {

        if (activeAuthTokens.get(token) == null) {
            return false;
        }

        // TODO DB assignTeacher function needed
        // IN:  Integer profId, Integer committeeId
        // OUT: Boolean
        // True if the function was successful, false otherwise

        return true; // return dbAssignTeacher(profId, committeeId);
    }

    // 13.
    public Vector<Vector<String>> getStudentsForCommittee(String token, Integer id) {

        if (activeAuthTokens.get(token) == null) {
            Vector<Vector<String>> result = new Vector<>();
            result.addElement(new Vector<>());
            result.elementAt(0).addElement("access denied");
        }

        // TODO DB getStudentsForCommittee function needed
        // IN:  Integer committeeId
        // OUT: Vector<Vector<String>>
        // Returns a vector of "students",
        // each "student" is a String vector containing, in this order: id_student, nume, prenume

        return new Vector<>(); // return dbGetStudentsForCommittee(id);
    }

    // 14.
    public Boolean markStudentProject(String token, Integer idProf, Integer idStud, Double mark) {

        if (activeAuthTokens.get(token) == null) {
            return false;
        }

        // TODO DB markStudentProject function
        // IN:  Integer idProf, Integer idStud, Double mark
        // OUT: Boolean
        // Updates the project mark given by idProf to idStud.
        // For example: If, in the committee, idProf is the 2nd teacher, the 2nd student mark will be updated,
        // same for the 1st, 3rd etc. teachers
        // Returns true for success
        // False otherwise

        return true; // return dbMarkStudentProject(idProf, idStud, mark);
    }

    public Boolean markStudentOral(String token, Integer idProf, Integer idStud, Double mark) {

        if (activeAuthTokens.get(token) == null) {
            return false;
        }

        // TODO DB markStudentOral function
        // IN:  Integer idProf, Integer idStud, Double mark
        // OUT: Boolean
        // Updates the oral mark given by idProf to idStud.
        // For example: If, in the committee, idProf is the 2nd teacher, the 2nd student mark will be updated,
        // same for the 1st, 3rd etc. teachers
        // Returns true for success
        // False otherwise

        return true; // return dbMarkStudentOral(idProf, idStud, mark);
    }

    // 15.
    public Vector<HashMap<String, String>> getStudentsByCoordinator(String token, Integer id) {

        Vector<HashMap<String, String>> result = new Vector<>();

        if (activeAuthTokens.get(token) == null) {
            result.addElement(new HashMap<>());
            result.elementAt(0).put("result", "access denied");
            return result;
        }

        // TODO DB getStudentsByCoordinator function needed
        // IN:  Integer profId
        // OUT: Vector<HashMap<String, String>>
        // Returns a Vector of "students", HashMaps with the following entries(Key - Value):
        // id_stud  - the id of the student
        // nume     - the last name of the student
        // prenume  - the first name of the student
        // nota1proiect, nota2proiect, etc. - the project marks(as strings)
        // nota1oral, nota2oral, etc.       - the oral marks(as strings)

        //result = dbGetStudentsByCoordinator(id);

        for (HashMap<String, String> stud : result) {
            stud.put("nota_finala", getMarkForStudent(token, Integer.parseInt(stud.get("id_stud"))).toString());
        }

        return result;
    }

    // 16.
    public Boolean addStudentToTeacher(String token, Integer idProf, String lastName, String firstName) {

        if (activeAuthTokens.get(token) == null) {
            return false;
        }

        // TODO DB addStudentToTeacher function needed
        // IN:  Integer profId, String name, String firstName
        // OUT: Boolean
        // Adds the student with the specified name to the list of coordinated students for the specified teacher

        return true; // return dbAddStudentToTeacher(idProf, lastName, firstName);
    }

    // 17.
    public Boolean removeStudentFromTeacher(String token, Integer idProf, Integer idStud) {

        if (activeAuthTokens.get(token) == null) {
            return false;
        }

        // TODO DB removeStudentFromTeacher function needed
        // IN:  Integer profId, Integer studId
        // OUT: Boolean
        // Remove the student from the list of coordinated students for the specified teacher

        return true; // return dbRemoveStudentToTeacher(idProf, idStud);
    }

    // 18.
    //public Boolean

    // 19.
    public Vector<Vector<String>> getStudentData(String token) {

        Vector<Vector<String>> result = new Vector<>();

        if (activeAuthTokens.get(token) == null) {
            result.addElement(new Vector<>());
            result.elementAt(0).addElement("access denied");
            return result;
        }

        //result = dbGetStudents();

        for (Vector<String> stud : result) // Calculating the student marks
            stud.setElementAt(getMarkForStudent(token, Integer.parseInt(stud.elementAt(2))).toString(), 2);

        return result;
    }

    // 20.
    public HashMap<String, Vector<String>> getRoomRepartition(String token) {

        HashMap<String, Vector<String>> result = new HashMap<>();

        if (activeAuthTokens.get(token) == null) {
            result.put("result", new Vector<>());
            result.get("result").addElement("access denied");
            return result;
        }

        // TODO DB getRooms function needed
        // IN:  None
        // OUT: Vector<String>
        // Returns a vector of stings with the room names of all the rooms that will be used
        // Ex: "C201", "C405", etc.

        // TODO DB getStudentsByRoom
        // IN:  String room
        // OUT: Vector<String>
        // Returns a vector of student *full* names
        // Ex: "Rares Dima", "Robert Otrocol", etc.
        // for the students that will be evaluated in the specified room

        Vector<String> rooms    = new Vector<>(); // = dbGetRooms();
        for (String roomName : rooms)
                result.put(roomName, new Vector<>() /*dbGetStudentsByRoom(roomName)*/);

        return result;
    }

}




