package com.tsg.dvdlibrary.controller;

import com.tsg.dvdlibrary.dao.DVDLibraryDao;
import com.tsg.dvdlibrary.dao.DVDLibraryDaoPersistenceException;
import com.tsg.dvdlibrary.dao.DVDLibraryDataValidationException;
import com.tsg.dvdlibrary.dao.DVDLibraryDuplicateTitleException;
import com.tsg.dvdlibrary.dto.DVD;
import com.tsg.dvdlibrary.service.DVDLibraryServiceLayer;
import com.tsg.dvdlibrary.ui.DVDLibraryView;

import java.util.ArrayList;

public class DVDLibraryController {

    DVDLibraryView view;
    DVDLibraryServiceLayer service;

    public DVDLibraryController(DVDLibraryView view, DVDLibraryServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    public void run() {

        boolean keepGoing = true;
        while (keepGoing == true) {
            try {
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
            } catch (DVDLibraryDaoPersistenceException e){
                view.errorMessage(e.getMessage());
            }
        }
        view.exitMessage();
    }

    public String getMainMenu() {
        return view.mainMenu();
    }

    public void addDVD() throws DVDLibraryDaoPersistenceException {
        view.displayAddBanner();
        String addMore = "Y";
        while (checkYes(addMore)) {
            DVD dvd = view.getDVD();
            boolean hasError = false;
            do {
                try {
                    service.createDVD(dvd);
                    view.displayAddSuccess();
                } catch (DVDLibraryDuplicateTitleException | DVDLibraryDataValidationException e) {
                    view.errorMessage(e.getMessage());
                }
            } while (hasError);
            addMore = view.getAddMore();
        }
    }

    public void removeDVD() throws DVDLibraryDaoPersistenceException {
        view.displayRemoveDVDBanner();
        String removeMore = "Y";
        while (checkYes(removeMore)) {
            String title = view.getTitle();
            DVD dvd = service.getDVD(title);
            boolean found = view.displayDVDInfo(dvd);
            if (found) {
                if (checkYes(view.getConfirm())) {
                    service.removeDVD(title);
                    view.displayRemoveSuccess();
                }
            }
            removeMore = view.getMoreRemove();
        }
    }

    public void editDVD() throws DVDLibraryDaoPersistenceException {
        view.displayEditBanner();
        String editMore = "Y";
        while (checkYes(editMore)) {
            String title = view.getTitle();
            DVD dvd = service.getDVD(title);
            boolean found = view.displayDVDInfo(dvd);
            if (found) {
                if (checkYes(view.getDVDConfirm())) {
                    boolean hasError = false;
                    do {
                        try {
                            DVD newDVD = view.editDVD(title);
                            if (checkYes(view.getEditConfirm())) {
                                service.editDVD(title, newDVD);
                                view.displayEditSuccessMessage();
                            }
                        } catch (DVDLibraryDataValidationException e) {
                            view.errorMessage(e.getMessage());
                        }
                    } while (hasError);
                }
            }
            editMore = view.getEditMore();
        }
    }

    public void searchByTitle() throws DVDLibraryDaoPersistenceException {
        view.displaySearchByTitle();
        String viewMore = "Y";
        while (checkYes(viewMore)) {
            String title = view.getTitle();
            DVD dvd = service.getDVD(title);
            view.displayDVDInfo(dvd);
            viewMore = view.getMoreInfo();
        }
    }

    public void searchByDirector() throws DVDLibraryDaoPersistenceException {
        view.displaySearchByDirectorBanner();
        String findMore = "Y";
        while (checkYes(findMore)) {
            String director = view.getDirector();
            ArrayList<DVD> dvdList = service.getDVDByDirector(director);
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

    public void listDVD() throws DVDLibraryDaoPersistenceException {
        view.displayListDVDBanner();
        //get and view list of dvd
        ArrayList<DVD> dvdList = service.allDVD();
        if (dvdList.size() > 0) {
            view.displayListDVD(dvdList);
            //view more info of dvd
            viewMoreInfo();
        }
        else {
            view.displayNotFoundMessage();
        }
    }

    public void viewMoreInfo() throws DVDLibraryDaoPersistenceException {
        String viewMore = view.getMoreInfo();
        while (checkYes(viewMore)) {
            String title = view.getTitle();
            DVD dvd = service.getDVD(title);
            view.displayDVDInfo(dvd);
            viewMore = view.getMoreInfo();
        }
    }

    public boolean checkYes(String yesNo) {
        while (!yesNo.equalsIgnoreCase("Y") && !yesNo.equalsIgnoreCase("N")) {
            yesNo = view.yesNo();
        }
        if (yesNo.equalsIgnoreCase("Y")) return true;
        return false;
    }

    public void getValidInputMessage() {
        view.invalidInput();
    }

}
