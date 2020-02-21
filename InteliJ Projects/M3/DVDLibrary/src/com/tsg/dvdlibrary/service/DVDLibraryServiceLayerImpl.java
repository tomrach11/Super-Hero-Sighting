package com.tsg.dvdlibrary.service;

import com.tsg.dvdlibrary.dao.DVDLibraryDao;
import com.tsg.dvdlibrary.dao.DVDLibraryDaoPersistenceException;
import com.tsg.dvdlibrary.dao.DVDLibraryDataValidationException;
import com.tsg.dvdlibrary.dao.DVDLibraryDuplicateTitleException;
import com.tsg.dvdlibrary.dto.DVD;

import java.util.ArrayList;

public class DVDLibraryServiceLayerImpl implements DVDLibraryServiceLayer {

    DVDLibraryDao dao;

    public DVDLibraryServiceLayerImpl(DVDLibraryDao dao) {
        this.dao = dao;
    }

    @Override
    public void createDVD(DVD dvd) throws DVDLibraryDataValidationException, DVDLibraryDuplicateTitleException, DVDLibraryDaoPersistenceException {
        DVD fromDao = dao.findByTitle(dvd.getTitle());
        if (fromDao != null) {
            throw new DVDLibraryDuplicateTitleException("ERROR: Title " + dvd.getTitle() + " already exist.");
        }

        validateData(dvd);

        dao.addDVD(dvd);
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoPersistenceException {
        return dao.removeDVD(title);
    }

    @Override
    public ArrayList<DVD> allDVD() throws DVDLibraryDaoPersistenceException {
        return dao.listDVD();
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoPersistenceException {
        return dao.findByTitle(title);
    }

    @Override
    public DVD editDVD(String title, DVD dvd) throws DVDLibraryDaoPersistenceException, DVDLibraryDataValidationException {
        validateData(dvd);
        return dao.editDVD(title, dvd);
    }

    @Override
    public ArrayList<DVD> getDVDByDirector(String Director) throws DVDLibraryDaoPersistenceException {
        return dao.findByDirector(Director);
    }

    private void validateData(DVD dvd) throws DVDLibraryDataValidationException {
        if ( dvd.getTitle() == null
                || dvd.getTitle().trim().length() == 0
                || dvd.getDirector() == null
                || dvd.getDirector().trim().length() == 0
                || dvd.getMpaaRating() == null
                || dvd.getMpaaRating().trim().length() == 0
                || dvd.getReleaseDate() == null
                || dvd.getReleaseDate().trim().length() == 0
                || dvd.getStudio() == null
                || dvd.getStudio().trim().length() == 0)   {

            throw new DVDLibraryDataValidationException("ERROR: All field are required.");
        }
    }
}
