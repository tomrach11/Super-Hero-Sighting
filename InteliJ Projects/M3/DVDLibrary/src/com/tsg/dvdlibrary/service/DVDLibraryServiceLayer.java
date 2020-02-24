package com.tsg.dvdlibrary.service;

import com.tsg.dvdlibrary.dao.DVDLibraryDaoPersistenceException;
import com.tsg.dvdlibrary.dao.DVDLibraryDataValidationException;
import com.tsg.dvdlibrary.dao.DVDLibraryDuplicateTitleException;
import com.tsg.dvdlibrary.dto.DVD;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface DVDLibraryServiceLayer {

    void createDVD(DVD dvd) throws DVDLibraryDataValidationException, DVDLibraryDuplicateTitleException, DVDLibraryDaoPersistenceException;

    DVD removeDVD(String title) throws DVDLibraryDaoPersistenceException;

    ArrayList<DVD> allDVD() throws DVDLibraryDaoPersistenceException;

    DVD getDVD(String title) throws DVDLibraryDaoPersistenceException;

    DVD editDVD(String title, DVD dvd) throws  DVDLibraryDaoPersistenceException, DVDLibraryDataValidationException;

    ArrayList<DVD> getDVDByDirector(String Director) throws DVDLibraryDaoPersistenceException;

    List<DVD> findFromYear(String year) throws  DVDLibraryDaoPersistenceException;

    List<DVD> findByRating(String rating) throws DVDLibraryDaoPersistenceException;

    List<DVD> findByStudio(String studio) throws DVDLibraryDaoPersistenceException;

    double findAverageAge() throws DVDLibraryDaoPersistenceException;

    List<DVD> findNewestDVD() throws DVDLibraryDaoPersistenceException;

    List<DVD> findOldestDVD() throws DVDLibraryDaoPersistenceException;

}
