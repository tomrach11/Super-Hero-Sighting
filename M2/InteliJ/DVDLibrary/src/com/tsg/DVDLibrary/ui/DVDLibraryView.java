package com.tsg.DVDLibrary.ui;

import com.tsg.DVDLibrary.dto.DVD;

import java.util.ArrayList;

public class DVDLibraryView {

    UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public String mainMenu() {
        io.println("Main Menu");
        io.println("\tPlease select the operation you wish to perform: ");
        io.println("\t\t1. Add DVD");
        io.println("\t\t2. Remove DVD");
        io.println("\t\t3. Edit DVD");
        io.println("\t\t4. View List of DVD");
        io.println("\t\t5. Search a DVD");
        io.println("\t\t6. Exit");
        return io.readString("\tPlease enter [1 - 6]: ");
    }

    public void invalidInput() {
        io.println("\t_-Invalid Input. Please enter proper input.");
    }

    //add DVD
    public void displayAddBanner() {
        io.println("Add DVD Menu: ");
    }

    public DVD getDVD() {
        DVD dvd = new DVD();
        //ask dvd info and set to DVD object
        dvd.setTitle(io.readString("\tPlease enter Title: "));
        dvd.setReleaseDate(io.readString("\tPlease enter Release Date: "));
        dvd.setDirector(io.readString("\tPlease enter Director Name: "));
        dvd.setStudio(io.readString("\tPlease enter Studio: "));
        dvd.setMpaaRating(io.readString("\tPlease enter MPAA Rating: "));
        dvd.setNote(io.readString("\tPlease write what do you think about this DVD: "));
        return dvd;
    }

    public void displayAddSuccess() {
        io.println("\tDVD added.");
    }

    public String getAddMore() {
        return io.readString("\tWould you like to add more DVD? [Y/N]: ");
    }

    //remove dvd
    public void displayRemoveDVDBanner() {
        io.println("Remove DVD Menu: ");
    }

    public String getConfirm() {
        return io.readString("\tConfirm to remove? [Y/N]: ");
    }

    public void displayRemoveSuccess() {
        io.println("\tDVD removed.");
    }

    public String getMoreRemove() {
        return io.readString("\tWould you like to remove more DVD? [Y/N]: ");
    }

    //list dvd
    public void displayListDVDBanner() {
        io.println("\tList of DVDs Menu: ");
    }

    public void displayListDVD(ArrayList<DVD> dvds) {
        for (DVD dvd : dvds) {
            io.println("\t- " + dvd.getTitle() + " by " + dvd.getDirector());
        }
    }

    public String getMoreInfo() {
        return io.readString("\tWould you like to get information for a particular DVD? [Y/N]: ");
    }

    public String getTitle() {
        return io.readString("\tPlease enter DVD Title: ");
    }

    public void displayDVDInfo(DVD dvd) {
        if (dvd != null) {
            io.println("\t\tTitle: " + dvd.getTitle());
            io.println("\t\tDirector: " + dvd.getDirector());
            io.println("\t\tStudio: " + dvd.getStudio());
            io.println("\t\tRelease Date: " + dvd.getReleaseDate());
            io.println("\t\tMPAA Rating: " + dvd.getMpaaRating());
            io.println("\t\tNote: " + dvd.getNote());
        }
        else {
            io.println("\tDVD not found.");
        }
    }

    //find dvd
    public void displayFindDVDBanner() {
        io.println("Search DVD by Director Menu: ");
    }


    public String getDirector() {
        return io.readString("\tPlease enter DVD's Director: ");
    }

    public void displayMultipleDVDInfo(ArrayList<DVD> dvdList) {
        System.out.println("test");
        for (DVD dvd : dvdList) {
                System.out.println("test2");
            if (dvd != null) {
                System.out.println("test3");
                io.println("\t\tTitle: " + dvd.getTitle());
                io.println("\t\tDirector: " + dvd.getDirector());
                io.println("\t\tStudio: " + dvd.getStudio());
                io.println("\t\tRelease Date: " + dvd.getReleaseDate());
                io.println("\t\tMPAA Rating: " + dvd.getMpaaRating());
                io.println("\t\tNote: " + dvd.getNote());
            } else {
                io.println("\tDVD not found.");
            }
        }
    }
}
