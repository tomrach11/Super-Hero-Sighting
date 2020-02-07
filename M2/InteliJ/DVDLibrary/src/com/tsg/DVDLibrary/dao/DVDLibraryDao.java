package com.tsg.DVDLibrary.dao;

import com.tsg.DVDLibrary.dto.DVD;

import java.util.ArrayList;

public interface DVDLibraryDao {

    void addDVD(DVD dvd);

    void removeDVD(String title);

    void editDVD(String title, DVD dvd);

    ArrayList<DVD> listDVD();

    DVD findByTitle(String title);

    ArrayList<DVD> findByDirector(String director);

}
