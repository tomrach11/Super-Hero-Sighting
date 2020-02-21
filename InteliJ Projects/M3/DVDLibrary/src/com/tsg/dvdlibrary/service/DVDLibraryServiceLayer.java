package com.tsg.dvdlibrary.service;

import com.tsg.dvdlibrary.dao.DVDLibraryDaoPersistenceException;
import com.tsg.dvdlibrary.dao.DVDLibraryDataValidationException;
import com.tsg.dvdlibrary.dao.DVDLibraryDuplicateTitleException;
import com.tsg.dvdlibrary.dto.DVD;

import java.util.ArrayList;

public interface DVDLibraryServiceLayer {

    void createDVD(DVD dvd) throws DVDLibraryDataValidationException, DVDLibraryDuplicateTitleException, DVDLibraryDaoPersistenceException;

    DVD removeDVD(String title) throws DVDLibraryDaoPersistenceException;

    ArrayList<DVD> allDVD() throws DVDLibraryDaoPersistenceException;

    DVD getDVD(String title) throws DVDLibraryDaoPersistenceException;

    DVD editDVD(String title, DVD dvd) throws  DVDLibraryDaoPersistenceException, DVDLibraryDataValidationException;

    ArrayList<DVD> getDVDByDirector(String Director) throws DVDLibraryDaoPersistenceException;
}
