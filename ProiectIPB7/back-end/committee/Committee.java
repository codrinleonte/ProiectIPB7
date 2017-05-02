package committee;

import elements.users.types.Secretary;
import elements.users.types.Teacher;

import java.util.Vector;

public class Committee {

    private Secretary secretary;
    private Vector<Teacher> teachers;

    // TODO Add any other necessary data members(might be complete)



    public Committee() {
        this.secretary = new Secretary();
        this.teachers  = new Vector<>();
    }

    public Committee(Secretary secretary, Vector<Teacher> teachers) {
        this.secretary = secretary;
        this.teachers  = teachers;
    }



    // TODO Add any methods needed






    public Secretary getSecretary() {
        return secretary;
    }

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }

    public Vector<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Vector<Teacher> teachers) {
        this.teachers = teachers;
    }
}
