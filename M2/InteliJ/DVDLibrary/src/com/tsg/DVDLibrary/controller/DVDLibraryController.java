package com.tsg.DVDLibrary.controller;

import com.tsg.DVDLibrary.dao.DVDLibraryDao;
import com.tsg.DVDLibrary.dto.DVD;
import com.tsg.DVDLibrary.ui.DVDLibraryView;

public class DVDLibraryController {

    DVDLibraryView view;
    DVDLibraryDao dao;

    public DVDLibraryController(DVDLibraryView view, DVDLibraryDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {

        boolean keepGoing = true;
        while (keepGoing == true) {

            switch (view.mainMenu()) {
                case "1":
                    System.out.println("add DVD");
                    break;
                case "2":
                    System.out.println("remove DVD");
                    break;
                case "3":
                    System.out.println("Edit DVD");
                    break;
                case "4":
                    System.out.println("view List of DVD");
                    break;
                case "5":
                    System.out.println("search DVD");
                    break;
                case "6":
                    keepGoing = false;
                    break;
                default:
                    view.invalidInput();
                    break;
            }

        }
    }

    public void addDVD() {
        view.displayAddBanner();
        DVD dvd = view.getDVD();
        dao.addDVD(dvd);
    }

}
