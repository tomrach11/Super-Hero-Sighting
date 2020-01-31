package com.tr.classroster.controller;

import com.tr.classroster.dao.ClassRosterDao;
import com.tr.classroster.dao.ClassRosterDaoFileImpl;
import com.tr.classroster.dto.Student;
import com.tr.classroster.ui.ClassRosterView;


public class ClassRosterController {

    ClassRosterView view;
    ClassRosterDao dao;

    public ClassRosterController (ClassRosterDao dao, ClassRosterView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            menuSelection = getMenuSelection();
            switch (menuSelection) {
                case 1:
                    allStudent();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createStudent () {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentID(), newStudent);
        view.displayCreateSuccessBanner();
    }

    private void allStudent() {
        view.displayAllBanner();
        view.displayStudentList(dao.getAllStudents());
    }

    private void viewStudent() {
        view.displayGetStudentBanner();
        String studentId = view.getStudent();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }

    private void removeStudent() {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudent();
        Student student = dao.removeStudent(studentId);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommand();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
