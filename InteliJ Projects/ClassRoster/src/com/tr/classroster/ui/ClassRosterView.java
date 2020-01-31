package com.tr.classroster.ui;

import com.tr.classroster.dto.Student;

import java.util.List;

public class ClassRosterView {

    private UserIO io;

    public ClassRosterView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Student IDs");
        io.print("2. Create New Student");
        io.print("3. View a Student List");
        io.print("4. Remove a Student");
        io.print("5. Exit");
        return io.readInt("Please select from the above choice.", 1, 5);
    }

    //Add new students
    public Student getNewStudentInfo() {
        String studentId = io.readString("Please Enter Student ID: ");
        String firstName = io.readString("Please Enter Student First Name: ");
        String lastName = io.readString("Please Enter Student Last Name: ");
        String cohort = io.readString("Please Enter Cohort: ");
        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        return currentStudent;
    }
    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }
    public void displayCreateSuccessBanner() {
        io.readString("Student successfully created. Please hit enter to continue: ");
    }

    //View students
    public void displayStudentList(List<Student> studentList) {
        for(Student currentStudent : studentList) {
            io.print(currentStudent.getStudentID() + ": "
                    + currentStudent.getFirstName() + " " + currentStudent.getLastName());
        }
        io.readString("Please hit enter to continue: ");
    }
    public void displayAllBanner() {
        io.print("=== Student List ===");
    }

    //Get student
    public String getStudent() {
        return io.readString("Please enter student ID: ");
    }

    public void displayStudent(Student student) {
        if (student != null) {
            io.print(student.getStudentID());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
        }
        else {
            io.print("Student not found.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayGetStudentBanner() {
        io.print("=== Get Student ===");
    }

    //remove student
    public void displayRemoveStudentBanner() {
        io.print("=== Remove Student ===");
    }

    public void displayRemoveSuccessBanner() {
        io.print("Student successfully removed. Please hit enter to continue.");
    }

    //Exit
    public void displayExitBanner() {
        io.print("Good Bye!!");
    }

    public void displayUnknownCommand() {
        io.print("Unknown Command!!");
    }
}
