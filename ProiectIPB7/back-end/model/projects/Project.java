package model.projects;

import model.users.types.Student;

import java.util.Vector;

public class Project {

    private String title;
    private Student student;
    private Vector<String> documentLinks;

    // TODO Add any other necessary data members


    public Project() {}
    public Project(String title, Student student, Vector<String> documentLinks) {
        this.title = title;
        this.student = student;
        this.documentLinks = documentLinks;
    }
    // TODO Add any other necessary constructors





    // TODO Add any other necessary metods





    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public Vector<String> getDocumentLinks() {
        return documentLinks;
    }
    public void setDocumentLinks(Vector<String> documentLinks) {
        this.documentLinks = documentLinks;
    }
    // TODO Add any other necessary getters/setters

    public void addLink(String link){
        this.documentLinks.add(link);
    }

    public void DeleteLink(String link){
        if(this.documentLinks.indexOf(link) >= 0)
            this.documentLinks.remove(this.documentLinks.indexOf(link));
    }

}
