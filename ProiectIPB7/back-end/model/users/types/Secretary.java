package model.users.types;

import java.util.Vector;

import model.committee.Committee;
import model.marks.StudentMark;
import model.users.User;
import model.users.rights.AccessRights;


public class Secretary extends User {

	
	
    // TODO Add any other necessary data members
    
    
    

	

    public Secretary() {
        super();
    }

   
    public Secretary(String username, String firstName, String lastName, String email,  AccessRights secretaryRights) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.rights=secretaryRights;
		
	}

    
    
    
    // TODO add the methods for stuff that should be done by secretaries only
    // TODO use the AccessRights. In here the methods should look like  editMarkOf(String teacher, String student) { rights.editMarkOf(teacher, student); }



    // TODO Add any other necessary data getters/setters
}
