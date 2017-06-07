package com.fiiLicence.fiiLicence.models.response;


public class GradeResponse {
    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    private double grade;

    @Override
    public String toString() {
        return " "+grade;
    }
}
