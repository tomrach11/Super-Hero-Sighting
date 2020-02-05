package com.tsg.DVDLibrary.ui;

import com.tsg.DVDLibrary.dto.DVD;

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
        dvd.setDirector(io.readString("\t Please enter Director Name: "));
        dvd.setStudio(io.readString("\tPlease enter Studio: "));
        dvd.setMpaaRating(io.readString("\tPlease enter MPAA Rating: "));
        dvd.setNote(io.readString("\tPlease write what do you think about this DVD: "));
        return dvd;
    }

    public void displayAddSuccess() {
        io.println("\tDVD added.");
    }

}
