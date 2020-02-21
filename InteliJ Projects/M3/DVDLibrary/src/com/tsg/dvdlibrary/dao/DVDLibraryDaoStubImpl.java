package com.tsg.dvdlibrary.dao;

import com.tsg.dvdlibrary.dto.DVD;
import com.tsg.dvdlibrary.service.DVDLibraryServiceLayer;

import java.util.ArrayList;
import java.util.List;

public class DVDLibraryDaoStubImpl implements DVDLibraryDao {

    private DVD onlyDVD;
    private ArrayList<DVD> DVDList = new ArrayList<>();

    public DVDLibraryDaoStubImpl() {
        onlyDVD = new DVD();
        onlyDVD.setTitle("Title1");
        onlyDVD.setDirector("Director1");
        onlyDVD.setMpaaRating("Rating1");
        onlyDVD.setReleaseDate("2012-12-12");
        onlyDVD.setStudio("Studio1");
        onlyDVD.setNote("Note1");

        DVDList.add(onlyDVD);
    }

    @Override
    public DVD addDVD(DVD dvd) throws DVDLibraryDaoPersistenceException {
        if (onlyDVD.getTitle().equalsIgnoreCase(onlyDVD.getTitle())) {
            return onlyDVD;
        } else {
            return null;
        }
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoPersistenceException {
        if (title.equalsIgnoreCase(onlyDVD.getTitle())) {
            return onlyDVD;
        } else {
            return null;
        }
    }

    @Override
    public DVD editDVD(String title, DVD dvd) throws DVDLibraryDaoPersistenceException {
        if (title.equalsIgnoreCase(onlyDVD.getTitle())) {
            return onlyDVD;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<DVD> listDVD() throws DVDLibraryDaoPersistenceException {
        return DVDList;
    }

    @Override
    public DVD findByTitle(String title) throws DVDLibraryDaoPersistenceException {
        if (title.equalsIgnoreCase(onlyDVD.getTitle())) {
            return onlyDVD;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<DVD> findByDirector(String director) throws DVDLibraryDaoPersistenceException {
        return DVDList;
    }
}
