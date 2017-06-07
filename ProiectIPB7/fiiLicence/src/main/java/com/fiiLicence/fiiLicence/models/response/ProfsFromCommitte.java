package com.fiiLicence.fiiLicence.models.response;

public class ProfsFromCommitte {
    private int profesor1;
    private int profesor2;
    private int profesor3;
    private int profesor4;

    public int getProfesor1() {
        return profesor1;
    }

    public void setProfesor1(int profesor1) {
        this.profesor1 = profesor1;
    }

    public int getProfesor2() {
        return profesor2;
    }

    public void setProfesor2(int profesor2) {
        this.profesor2 = profesor2;
    }

    public int getProfesor3() {
        return profesor3;
    }

    public void setProfesor3(int profesor3) {
        this.profesor3 = profesor3;
    }

    public int getProfesor4() {
        return profesor4;
    }

    public void setProfesor4(int profesor4) {
        this.profesor4 = profesor4;
    }

    public String toString() {
        return profesor1 + " " + profesor2 + " " + profesor3 + " " + profesor4;
    }

    public Boolean containsId(int idProfesor){
        if(idProfesor == profesor1)
            return true;
        if(idProfesor == profesor2)
            return  true;
        if(idProfesor == profesor3)
            return true;
        if(idProfesor == profesor4)
            return true;
        return false;
    }

}

