package com.tr.classroster.controller;

import com.tr.classroster.dao.ClassRosterDao;
import com.tr.classroster.dao.ClassRosterDataValidationException;
import com.tr.classroster.dao.ClassRosterDuplicateIDException;
import com.tr.classroster.dao.ClassRosterPersistenceException;
import com.tr.classroster.dto.Student;
import com.tr.classroster.service.ClassRosterServiceLayer;
import com.tr.classroster.ui.ClassRosterView;


public class ClassRosterController {

    ClassRosterView view;
    ClassRosterServiceLayer service;

    public ClassRosterController (ClassRosterServiceLayer service, ClassRosterView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
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
        } catch (ClassRosterPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createStudent () throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        boolean hasError = false;
        do {
            Student newStudent = view.getNewStudentInfo();
            try {
                service.createStudent(newStudent);
                view.displayCreateSuccessBanner();
                hasError = false;
            } catch (ClassRosterDuplicateIDException | ClassRosterDataValidationException e) {
                hasError = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasError);
    }

    private void allStudent() throws ClassRosterPersistenceException {
        view.displayAllBanner();
        view.displayStudentList(service.getAllStudent());
    }

    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayGetStudentBanner();
        String studentId = view.getStudent();
        Student student = service.getStudent(studentId);
        view.displayStudent(student);
    }

    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudent();
        Student student = service.removeStudent(studentId);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommand();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
