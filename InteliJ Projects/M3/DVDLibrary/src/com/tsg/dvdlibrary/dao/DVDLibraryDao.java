package com.tsg.dvdlibrary.dao;

import com.tsg.dvdlibrary.dto.DVD;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface DVDLibraryDao {

    DVD addDVD(DVD dvd) throws DVDLibraryDaoPersistenceException;

    DVD removeDVD(String title) throws DVDLibraryDaoPersistenceException;

    DVD editDVD(String title, DVD dvd) throws DVDLibraryDaoPersistenceException;

    ArrayList<DVD> listDVD() throws DVDLibraryDaoPersistenceException;

    DVD findByTitle(String title) throws DVDLibraryDaoPersistenceException;

    ArrayList<DVD> findByDirector(String director) throws DVDLibraryDaoPersistenceException;

    List<DVD> findFromYear(String year) throws  DVDLibraryDaoPersistenceException;

    List<DVD> findByRating(String rating) throws DVDLibraryDaoPersistenceException;

    List<DVD> findByStudio(String studio) throws DVDLibraryDaoPersistenceException;

    double findAverageAge() throws DVDLibraryDaoPersistenceException;

    List<DVD> findNewestDVD() throws DVDLibraryDaoPersistenceException;

    List<DVD> findOldestDVD() throws DVDLibraryDaoPersistenceException;

}
