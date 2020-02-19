package com.tr.classroster;

import com.tr.classroster.controller.ClassRosterController;
import com.tr.classroster.dao.ClassRosterAuditDao;
import com.tr.classroster.dao.ClassRosterAuditDaoImpl;
import com.tr.classroster.dao.ClassRosterDao;
import com.tr.classroster.dao.ClassRosterDaoFileImpl;
import com.tr.classroster.service.ClassRosterServiceLayer;
import com.tr.classroster.service.ClassRosterServiceLayerImpl;
import com.tr.classroster.ui.ClassRosterView;
import com.tr.classroster.ui.UserIO;
import com.tr.classroster.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl(); //interface using UserIOConsoleImpl
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl(); //interface using ClassRosterDaoFile
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoImpl();
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        ClassRosterController myController = new ClassRosterController(myService, myView);
        myController.run();
    }
}
