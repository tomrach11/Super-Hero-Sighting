package com.tsg.dvdlibrary.dao;

import com.tsg.dvdlibrary.dto.DVD;

import java.util.ArrayList;

public interface DVDLibraryDao {

    DVD addDVD(DVD dvd) throws DVDLibraryDaoPersistenceException;

    DVD removeDVD(String title) throws DVDLibraryDaoPersistenceException;

    DVD editDVD(String title, DVD dvd) throws DVDLibraryDaoPersistenceException;

    ArrayList<DVD> listDVD() throws DVDLibraryDaoPersistenceException;

    DVD findByTitle(String title) throws DVDLibraryDaoPersistenceException;

    ArrayList<DVD> findByDirector(String director) throws DVDLibraryDaoPersistenceException;

}
