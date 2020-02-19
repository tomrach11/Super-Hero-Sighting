package com.tr.classroster.dto;

public class Student {
    private String firstName;
    private String lastName;
    private String studentID;
    private String cohort;

    //constructor
    public Student(String studentID) {
        this.studentID = studentID;
    }

    //getter + setter
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }
}
