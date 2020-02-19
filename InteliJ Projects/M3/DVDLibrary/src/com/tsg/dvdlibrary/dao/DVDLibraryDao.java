package com.tsg.dvdlibrary.dao;

import com.tsg.dvdlibrary.dto.DVD;

import java.util.ArrayList;

public interface DVDLibraryDao {

    DVD addDVD(DVD dvd) throws DVDLibraryDaoException;

    DVD removeDVD(String title) throws DVDLibraryDaoException;

    DVD editDVD(String title, DVD dvd) throws DVDLibraryDaoException;

    ArrayList<DVD> listDVD() throws DVDLibraryDaoException;

    DVD findByTitle(String title) throws DVDLibraryDaoException;

    ArrayList<DVD> findByDirector(String director) throws DVDLibraryDaoException;

}
