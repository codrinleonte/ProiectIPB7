package model.users.types;

import model.users.rights.AccessRights;

public class Secretary extends Teacher {

    private AccessRights rights;

    // TODO Add any other necessary data members





    public Secretary() {
        super();
    }

    // TODO Add any other necessary constructors after the user base type has been modeled





    // TODO add the methods for stuff that should be done by secretaries only
    // TODO use the AccessRights. In here the methods should look like  editMarkOf(String teacher, String student) { rights.editMarkOf(teacher, student); }





    public AccessRights getRights() {
        return rights;
    }
    public void setRights(AccessRights rights) {
        this.rights = rights;
    }

    // TODO Add any other necessary data getters/setters
}
