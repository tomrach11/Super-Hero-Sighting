package com.tr.addressbook;

import com.tr.addressbook.controller.AddressBookController;
import com.tr.addressbook.dao.AddressBookDao;
import com.tr.addressbook.dao.AddressBookDaoFileImpl;
import com.tr.addressbook.ui.AddressBookView;
import com.tr.addressbook.ui.UserIO;
import com.tr.addressbook.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        AddressBookView view = new AddressBookView(io);
        AddressBookDao dao = new AddressBookDaoFileImpl();
        AddressBookController controller = new AddressBookController(view, dao);
        controller.run();
    }
}
