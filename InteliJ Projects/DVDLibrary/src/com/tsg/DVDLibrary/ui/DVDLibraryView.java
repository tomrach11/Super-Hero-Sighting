package com.tsg.DVDLibrary.ui;

import com.tsg.DVDLibrary.dao.DVDLibraryDaoException;
import com.tsg.DVDLibrary.dto.DVD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DVDLibraryView {

    UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public String mainMenu() {
        io.println("\nMain Menu:");
        io.println("\tPlease select the operation you wish to perform: ");
        io.println("\t\t1. Add DVD");
        io.println("\t\t2. Remove DVD");
        io.println("\t\t3. Edit DVD");
        io.println("\t\t4. View List of DVD");
        io.println("\t\t5. Search DVD by Title");
        io.println("\t\t6. Search DVD by Director");
        io.println("\t\t7. Exit");
        return io.readString("\tPlease enter [1 - 7]: ");
    }

    public void invalidInput() {
        io.println("\n\t_-Invalid Input. Please enter proper input.");
    }

    public void exitMessage() {
        io.println("\nProgram is shutting down ....");
    }

//add DVD
    public void displayAddBanner() {
        io.println("\nAdd DVD Menu: ");
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
        return io.readString("\n\tWould you like to add more DVD? [Y/N]: ");
    }

//remove dvd
    public void displayRemoveDVDBanner() {
        io.println("\nRemove DVD Menu: ");
    }

    public String getConfirm() {
        return io.readString("\tConfirm to remove? [Y/N]: ");
    }

    public void displayRemoveSuccess() {
        io.println("\tDVD removed.");
    }

    public String getMoreRemove() {
        return io.readString("\n\tWould you like to remove more DVD? [Y/N]: ");
    }

//edit dvd
    public void displayEditBanner() {
        io.println("\nEdit DVD Menu: ");
    }

    public String getEditConfirm() {
        return io.readString("\tConfirm edit? [Y/N]: ");
    }

    public String getDVDConfirm() {
        return io.readString("\tEdit This DVD? [Y/N]: ");
    }

    public DVD editDVD(String title) {
        DVD newDVD = new DVD();
        newDVD.setTitle(title);
        io.println("\t\tEditing DVD Title: " + newDVD.getTitle());
        newDVD.setDirector(io.readString("\t\tPlease enter new Director: "));
        newDVD.setStudio(io.readString("\t\tPlease enter new Studio: "));
        newDVD.setReleaseDate(io.readString("\t\tPlease enter new Release Date: "));
        newDVD.setMpaaRating(io.readString("\t\tPlease enter new MPAA Rating: "));
        newDVD.setNote(io.readString("\t\tPlease enter Note: "));
        return newDVD;
    }

    public String getEditMore() {
        return io.readString("\n\tWould you like to edit more DVD? [Y/N]: ");
    }

    public void displayEditSuccessMessage() {
        io.println("\tDVD edited.");
    }

//list dvd
    public void displayListDVDBanner() {
        io.println("\nList of DVDs Menu: ");
    }

    public void displayListDVD(ArrayList<DVD> dvds) {
        for (DVD dvd : dvds) {
            io.println("\t- " + dvd.getTitle() + " by " + dvd.getDirector());
        }
    }

    public String getMoreInfo() {
        return io.readString("\n\tWould you like to get more information for a particular DVD? [Y/N]: ");
    }

    public String getTitle() {
        return io.readString("\tPlease enter DVD Title: ");
    }

    public boolean displayDVDInfo(DVD dvd) {
        if (dvd != null) {
            io.println("\t\tTitle: " + dvd.getTitle());
            io.println("\t\tDirector: " + dvd.getDirector());
            io.println("\t\tStudio: " + dvd.getStudio());
            io.println("\t\tRelease Date: " + dvd.getReleaseDate());
            io.println("\t\tMPAA Rating: " + dvd.getMpaaRating());
            io.println("\t\tNote: " + dvd.getNote());
            return true;
        }
        else {
            displayNotFoundMessage();
            return false;
        }
    }
//search by title
    public void displaySearchByTitle() {
        io.println("\nSearch DVD by Title Menu: ");
    }

//search by director
    public void displaySearchByDirectorBanner() {
        io.println("\nSearch DVD by Director Menu: ");
    }


    public String getDirector() {
        return io.readString("\tPlease enter DVD's Director: ");
    }


    public String getSearchMore() {
        return io.readString("\n\tWould you like to search for more director? [Y/N]: ");
    }

    public void displayNotFoundMessage() {
        io.println("\tDVD not found.");
    }

}
