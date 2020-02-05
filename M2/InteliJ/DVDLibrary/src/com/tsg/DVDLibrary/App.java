package com.tsg.DVDLibrary;

import com.tsg.DVDLibrary.controller.DVDLibraryController;
import com.tsg.DVDLibrary.dao.DVDLibraryDao;
import com.tsg.DVDLibrary.dao.DVDLibraryDaoFileImpl;
import com.tsg.DVDLibrary.ui.DVDLibraryView;
import com.tsg.DVDLibrary.ui.UserIO;
import com.tsg.DVDLibrary.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        DVDLibraryView view = new DVDLibraryView(io);
        DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(view, dao);
        controller.run();
    }
}
