package com.fiiLicence.fiiLicence.models.old;

/**
 * Created by Cristian Cristea on 5/16/2017.
 */
public class Admin extends User {
    // TODO Add any other necessary data members

    public Admin() {
        super();
    }

    // TODO Add any other necessary constructors after the user base type has been modeled
    // TODO add the methods for stuff that should be done by admins only
    // TODO use the AccessRights. In here the methods should look like banUser(String name) { rights.banUser(name); }

    public AccessRights getRights() {
        return rights;
    }
    public void setRights(AccessRights rights) {
        this.rights = rights;
    }

}
