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
                    editDVD();
                    break;
                case "4":
                    listDVD();
                    break;
                case "5":
                    searchByTitle();
                    break;
                case "6":
                    searchByDirector();
                    break;
                case "7":
                    keepGoing = false;
                    break;
                default:
                    getValidInputMessage();
                    break;
            }

        }
        view.exitMessage();
    }

    public String getMainMenu() {
        return view.mainMenu();
    }

    public void addDVD() {
        view.displayAddBanner();
        String addMore = "Y";
        while (checkYes(addMore)) {
            DVD dvd = view.getDVD();
            dao.addDVD(dvd);
            view.displayAddSuccess();
            addMore = view.getAddMore();
        }
    }

    public void removeDVD() {
        view.displayRemoveDVDBanner();
        String removeMore = "Y";
        while (checkYes(removeMore)) {
            String title = view.getTitle();
            DVD dvd = dao.findByTitle(title);
            boolean found = view.displayDVDInfo(dvd);
            if (found) {
                if (checkYes(view.getConfirm())) {
                    dao.removeDVD(title);
                    view.displayRemoveSuccess();
                }
            }
            removeMore = view.getMoreRemove();
        }
    }

    public void editDVD() {
        view.displayEditBanner();
        String editMore = "Y";
        while (checkYes(editMore)) {
            String title = view.getTitle();
            DVD dvd = dao.findByTitle(title);
            boolean found = view.displayDVDInfo(dvd);
            if (found) {
                if (checkYes(view.getDVDConfirm())) {
                    DVD newDVD = view.editDVD(title);
                    if (checkYes(view.getEditConfirm())) {
                        dao.editDVD(title, newDVD);
                        view.displayEditSuccessMessage();
                    }
                }
            }
            editMore = view.getEditMore();
        }
    }

    public void searchByTitle() {
        view.displaySearchByTitle();
        String viewMore = "Y";
        while (checkYes(viewMore)) {
            String title = view.getTitle();
            DVD dvd = dao.findByTitle(title);
            view.displayDVDInfo(dvd);
            viewMore = view.getMoreInfo();
        }
    }

    public void searchByDirector() {
        view.displaySearchByDirectorBanner();
        String findMore = "Y";
        while (checkYes(findMore)) {
            String director = view.getDirector();
            ArrayList<DVD> dvdList = dao.findByDirector(director);
            if (dvdList.size() > 0) {
                view.displayListDVD(dvdList);
                viewMoreInfo();
            }
            else {
                view.displayNotFoundMessage();
            }
            findMore = view.getSearchMore();
        }
    }

    public void listDVD() {
        view.displayListDVDBanner();
        //get and view list of dvd
        ArrayList<DVD> dvdList = dao.listDVD();
        view.displayListDVD(dvdList);
        //view more info of dvd
        viewMoreInfo();
    }

    public void viewMoreInfo() {
        String viewMore = view.getMoreInfo();
        while (checkYes(viewMore)) {
            String title = view.getTitle();
            DVD dvd = dao.findByTitle(title);
            view.displayDVDInfo(dvd);
            viewMore = view.getMoreInfo();
        }
    }

    public boolean checkYes(String yesNo) {
        if (yesNo.equalsIgnoreCase("Y")) return true;
        return false;
    }

    public void getValidInputMessage() {
        view.invalidInput();
    }

}
