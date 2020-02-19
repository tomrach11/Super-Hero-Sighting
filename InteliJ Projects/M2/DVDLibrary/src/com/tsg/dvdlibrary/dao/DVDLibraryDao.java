package com.tsg.dvdlibrary.dao;

import com.tsg.dvdlibrary.dto.DVD;

import java.util.ArrayList;

public interface DVDLibraryDao {

    void addDVD(DVD dvd) throws DVDLibraryDaoException;

    void removeDVD(String title) throws DVDLibraryDaoException;

    void editDVD(String title, DVD dvd) throws DVDLibraryDaoException;

    ArrayList<DVD> listDVD() throws DVDLibraryDaoException;

    DVD findByTitle(String title) throws DVDLibraryDaoException;

    ArrayList<DVD> findByDirector(String director) throws DVDLibraryDaoException;

}
