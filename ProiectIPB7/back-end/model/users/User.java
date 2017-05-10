package model.users;

import model.users.rights.AccessRights;

public abstract class User {

    protected String username;
    protected String name;
    protected String email;
    protected AccessRights rights;
    // TODO add the rest of the info for a user as data members, find something for permissions

    public User() {}
    
    


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	 public AccessRights getRights() {
	        return rights;
	    }
	    public void setRights(AccessRights rights) {
	        this.rights = rights;
	    }

	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", email=" + email + "," + rights+"]";
	}

    // TODO Add any other necessary constructors after the user base type has been modeled





    // TODO Add any other necessary data getters/setters
}
