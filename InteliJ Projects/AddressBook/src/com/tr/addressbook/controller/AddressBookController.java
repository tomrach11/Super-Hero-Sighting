package com.tr.addressbook.controller;

import com.tr.addressbook.dao.AddressBookDao;
import com.tr.addressbook.dao.AddressBookDaoException;
import com.tr.addressbook.dto.Address;
import com.tr.addressbook.dto.Profile;
import com.tr.addressbook.ui.AddressBookView;

import java.util.ArrayList;

public class AddressBookController {

    private AddressBookView view;
    private AddressBookDao dao;

    public AddressBookController(AddressBookView view, AddressBookDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = true;

        try {
            while (keepGoing == true) {

                int userInput = view.mainMenu();

                switch (userInput) {

                    case 1:
                        addAddress();
                        break;
                    case 2:
                        removeAddress();
                        break;
                    case 3:
                        findAddress();
                        break;
                    case 4:
                        addressCount();
                        break;
                    case 5:
                        addressList();
                        break;
                    case 6:
                        keepGoing = false;
                        exitMessage();
                        break;
                    default:
                        invalidMessage();
                        break;
                }
            }
        } catch (AddressBookDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void addAddress() throws AddressBookDaoException {
        view.displayAddAddressBanner();
        Profile profile = view.getProfile();
        Address address = view.getAddress();
        dao.addAddress(profile, address);
        view.displayAddAddressSuccess();
        pressToContinueLoop();
    }

    private void addressCount() throws AddressBookDaoException {
        view.displayAddressCountBanner();
        int count = dao.countAddress();
        view.displayAddressCount(count);
        pressToContinueLoop();
    }

    private void removeAddress() throws AddressBookDaoException {
        view.displayRemoveBanner();
        String lastName = view.getDeleteLastName();
        Profile profile = dao.findAddress(lastName);
        view.displayAddress(profile);
        if ("Y".equalsIgnoreCase(view.confirmDelete())) {
            dao.removeAddress(lastName);
            view.displayDeleteSuccessBanner();
        }
        pressToContinueLoop();
    }

    private void findAddress() throws AddressBookDaoException {
        view.displayFindAddressBanner();
        String lastName = view.getFindLastName();
        Profile profile = dao.findAddress(lastName);
        view.displayAddress(profile);
        pressToContinueLoop();
    }

    private void addressList() throws AddressBookDaoException {
        view.displayListAddressesBanner();
        ArrayList<Profile> addresses = dao.allAddress();
        view.listAddresses(addresses);
        pressToContinueLoop();
    }

    private void exitMessage() {
        view.displayExitMessage();
    }

    private void pressToContinueLoop() {
        String userInput;
        do {
            userInput = view.pressToContinue();
        } while (!userInput.equalsIgnoreCase("1"));
    }

    private void invalidMessage() {
        view.displayInvalidMessage();
    }

}
