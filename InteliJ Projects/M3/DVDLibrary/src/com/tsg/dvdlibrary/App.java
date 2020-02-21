package com.tsg.dvdlibrary;

import com.tsg.dvdlibrary.controller.DVDLibraryController;
import com.tsg.dvdlibrary.dao.DVDLibraryDao;
import com.tsg.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.tsg.dvdlibrary.service.DVDLibraryServiceLayer;
import com.tsg.dvdlibrary.service.DVDLibraryServiceLayerImpl;
import com.tsg.dvdlibrary.ui.DVDLibraryView;
import com.tsg.dvdlibrary.ui.UserIO;
import com.tsg.dvdlibrary.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        DVDLibraryView view = new DVDLibraryView(io);
        DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
        DVDLibraryServiceLayer service = new DVDLibraryServiceLayerImpl(dao);
        DVDLibraryController controller = new DVDLibraryController(view, service);
        controller.run();
    }
}
