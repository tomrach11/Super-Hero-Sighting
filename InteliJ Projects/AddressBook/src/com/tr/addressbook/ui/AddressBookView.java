package com.tr.addressbook.ui;

import com.tr.addressbook.dao.AddressBookDaoException;
import com.tr.addressbook.dto.Address;
import com.tr.addressbook.dto.Profile;

import java.util.ArrayList;

public class AddressBookView {

    private UserIO io;

    public AddressBookView(UserIO userIo) {
        this.io = userIo;
    }

    public int mainMenu () throws AddressBookDaoException {

        io.println("Initial Menu:");
        io.println("\tPlease select the operation you wish to perform:");
        io.println("\t\t1. Add Address");
        io.println("\t\t2. Delete Address");
        io.println("\t\t3. Find Address");
        io.println("\t\t4. List Address Count");
        io.println("\t\t5. List All Address");
        io.println("\t\t6. Edit Address");
        io.println("\t\t7. Exit");
        return io.readInt("\tEnter operation [1-7]: ",1 , 7);

    }

    //add address
    public Profile getProfile() {
        Profile profile = new Profile();
        profile.setFirstName(io.readString("\tPlease Enter First Name: "));
        profile.setLastName(io.readString("\tPlease Enter Last Name: "));
        return profile;
    }

    public Address getAddress() {
        io.println("\tPlease Enter Address: ");
        Address address = new Address();
        address.setStreet(io.readString("\tStreet: "));
        address.setCity(io.readString("\tCity: "));
        address.setState(io.readString("\tState: "));
        address.setZipCode(io.readString("\tZip Code: "));
        return address;
    }

    public void displayAddAddressBanner() {
        io.println("Add Address Menu:");
    }

    public void displayAddAddressSuccess() {
        io.println("\tAddress added.");
    }

    //remove address
    public void displayRemoveBanner() {
        io.println("Delete Address Menu");
    }

    public String getDeleteLastName() {
        return io.readString("\tPlease enter last name of address to delete: ");
    }

    public String confirmDelete() {
        return io.readString("\tReally Delete? [Y/N]: ");
    }

    public void displayDeleteSuccessBanner() {
        io.println("\tAddress Deleted.");
    }

    //find address
    public void displayFindAddressBanner() {
        io.println("Find Address Menu:");
    }

    public String getFindLastName() {
        return io.readString("\tPlease enter last name of address to find: ");
    }

    public void displayAddress(Profile profile) {
        io.println("\t" + profile.getFirstName() + " " + profile.getLastName());
        Address address = profile.getAddress();
        io.println("\t" + address.getStreet());
        io.print("\t" + address.getCity() + ", ");
        io.print(address.getState() + ", ");
        io.println(address.getZipCode());
        io.println("");
    }

    public void displayNotFoundMessage() {
        io.println("\n\tThis last name is not found.\n");
    }

    //count addresses
    public void displayAddressCount(int count) {
        io.println("There are " + count + " addresses in the book.\n");
    }

    public void displayAddressCountBanner() {
        io.println("List Address Count Menu: ");
    }

    //list addresses
    public void listAddresses(ArrayList<Profile> profiles) {
        for (Profile profile : profiles) {
            io.println("\t" + profile.getFirstName() + " " + profile.getLastName());
            Address address = profile.getAddress();
            io.println("\t" + address.getStreet());
            io.print("\t" + address.getCity() + ", ");
                io.print(address.getState() + ", ");
                io.println(address.getZipCode());
            io.println("");
        }
    }

    public void displayListAddressesBanner() {
        io.println("List Addresses Menu:");
    }

    //edit address
    public void displayEditAddressBanner() {
        io.println("Edit Address Menu: ");
    }

    public String getEditLastName() {
        return io.readString("\tPlease enter last name of address to edit: ");
    }

    public void displayEditSuccessMessage() {
        io.println("\tAddress Edited.");
    }

    //exit
    public void displayExitMessage() {
        io.println("Program is closing...");
    }

    //error
    public void displayErrorMessage(String errorMsg) {
        io.println("--- Error ---");
        io.println(errorMsg);
    }

    //invalid input
    public void displayInvalidMessage() {
        io.println("\n\t-_-Invalid input. Please enter proper input.\n");
    }

    public String pressToContinue() {
        return io.readString("Press 1 to go to Main Menu: ");
    }

}
