package com.tsg.dvdlibrary;

import com.tsg.dvdlibrary.controller.DVDLibraryController;
import com.tsg.dvdlibrary.dao.DVDLibraryDao;
import com.tsg.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.tsg.dvdlibrary.ui.DVDLibraryView;
import com.tsg.dvdlibrary.ui.UserIO;
import com.tsg.dvdlibrary.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        DVDLibraryView view = new DVDLibraryView(io);
        DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(view, dao);
        controller.run();
    }
}
