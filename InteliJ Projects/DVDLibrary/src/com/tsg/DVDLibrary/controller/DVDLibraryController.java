package com.tsg.DVDLibrary.controller;

import com.tsg.DVDLibrary.dao.DVDLibraryDao;
import com.tsg.DVDLibrary.dto.DVD;
import com.tsg.DVDLibrary.ui.DVDLibraryView;

import java.util.ArrayList;

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

            switch (getMainMenu()) {
                case "1":
                    addDVD();
                    break;
                case "2":
                    removeDVD();
                    break;
                case "3":
                    System.out.println("Edit DVD");
                    break;
                case "4":
                    listDVD();
                    break;
                case "5":
                    findByDirector();
                    break;
                case "6":
                    keepGoing = false;
                    break;
                default:
                    getValidInputMessage();
                    break;
            }

        }
    }
    public String getMainMenu() {
        return view.mainMenu();
    }

    public void addDVD() {
        view.displayAddBanner();
        String addMore = "Y";
        while (checkYesNo(addMore)) {
            DVD dvd = view.getDVD();
            dao.addDVD(dvd);
            view.displayAddSuccess();
            addMore = view.getAddMore();
        }
    }

    public void removeDVD() {
        view.displayRemoveDVDBanner();
        String removeMore = "Y";
        while (checkYesNo(removeMore)) {
            String title = view.getTitle();
            DVD dvd = dao.findByTitle(title);
            view.displayDVDInfo(dvd);
            if (checkYesNo(view.getConfirm())) {
                dao.removeDVD(title);
                view.displayRemoveSuccess();
            }
            removeMore = view.getMoreRemove();
        }
    }

    public void findByDirector() {
        view.displayFindDVDBanner();
        String findMore = "Y";
        while (checkYesNo(findMore)) {
            String director = view.getDirector();
            ArrayList<DVD> dvdList = dao.findByDirector(director);
            view.displayMultipleDVDInfo(dvdList);
            findMore = view.getMoreInfo();
        }
    }

    public void listDVD() {
        view.displayListDVDBanner();
        //get and view list of dvd
        ArrayList<DVD> dvdList = dao.listDVD();
        view.displayListDVD(dvdList);
        //view more info of dvd
        String viewMore = view.getMoreInfo();
        while (checkYesNo(viewMore)) {
            String title = view.getTitle();
            DVD dvd = dao.findByTitle(title);
            view.displayDVDInfo(dvd);
            viewMore = view.getMoreInfo();
        }
    }

    public boolean checkYesNo(String yesNo) {
        if (yesNo.equalsIgnoreCase("Y")) return true;
        return false;
    }

    public void getValidInputMessage() {
        view.invalidInput();
    }

}
