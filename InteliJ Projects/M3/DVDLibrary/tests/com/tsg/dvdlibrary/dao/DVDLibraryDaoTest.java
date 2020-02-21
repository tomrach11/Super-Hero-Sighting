package com.tsg.dvdlibrary.dao;

import com.tsg.dvdlibrary.dto.DVD;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DVDLibraryDaoTest {

    DVDLibraryDao dao = new DVDLibraryDaoFileImpl();

    @BeforeEach
    public void setUp() throws DVDLibraryDaoPersistenceException {
        ArrayList<DVD> DVDList = dao.listDVD();
        for (DVD dvd : DVDList) {
            dao.removeDVD(dvd.getTitle());
        }
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetAddDVD() throws DVDLibraryDaoPersistenceException {
        DVD dvd = new DVD();
        dvd.setTitle("Title1");
        dvd.setReleaseDate("01/01/2020");
        dvd.setDirector("Director1");
        dvd.setMpaaRating("PG-13");
        dvd.setStudio("Studio1");
        dvd.setNote("Note1");
        dao.addDVD(dvd);

        assertEquals(dvd, dao.findByTitle(dvd.getTitle()));
        assertEquals(1, dao.listDVD().size());
    }

    @Test
    public void removeDVD() throws DVDLibraryDaoPersistenceException {
        DVD dvd = new DVD();
        dvd.setTitle("Title1");
        dvd.setReleaseDate("01/01/2020");
        dvd.setDirector("Director1");
        dvd.setMpaaRating("PG-13");
        dvd.setStudio("Studio1");
        dvd.setNote("Note1");
        dao.addDVD(dvd);

        DVD dvd2 = new DVD();
        dvd2.setTitle("Title2");
        dvd2.setReleaseDate("01/01/2020");
        dvd2.setDirector("Director2");
        dvd2.setMpaaRating("PG-13");
        dvd2.setStudio("Studio2");
        dvd2.setNote("Note2");
        dao.addDVD(dvd2);

        DVD removedDVD1 = dao.removeDVD(dvd.getTitle());
        assertEquals(dvd, removedDVD1);
        assertEquals(1, dao.listDVD().size());

        DVD removedDVD2 = dao.removeDVD(dvd2.getTitle());
        assertEquals(dvd2, removedDVD2);
        assertEquals(0, dao.listDVD().size());
    }

    @Test
    public void editDVD() throws DVDLibraryDaoPersistenceException {
        DVD dvd = new DVD();
        dvd.setTitle("Title1");
        dvd.setReleaseDate("01/01/2020");
        dvd.setDirector("Director1");
        dvd.setMpaaRating("PG-13");
        dvd.setStudio("Studio1");
        dvd.setNote("Note1");
        dao.addDVD(dvd);

        DVD dvd2 = new DVD();
        dvd2.setTitle("Title1");
        dvd2.setReleaseDate("01/01/2020");
        dvd2.setDirector("Director2");
        dvd2.setMpaaRating("PG-13");
        dvd2.setStudio("Studio2");
        dvd2.setNote("Note2");

        DVD editedDVD = dao.editDVD(dvd2.getTitle(), dvd2);
        //assertEquals(dvd2, editedDVD);
        assertEquals(dvd2, dao.findByTitle(dvd2.getTitle()));

    }

    @Test
    public void listDVD() throws DVDLibraryDaoPersistenceException {
        DVD dvd = new DVD();
        dvd.setTitle("Title1");
        dvd.setReleaseDate("01/01/2020");
        dvd.setDirector("Director1");
        dvd.setMpaaRating("PG-13");
        dvd.setStudio("Studio1");
        dvd.setNote("Note1");
        dao.addDVD(dvd);

        DVD dvd2 = new DVD();
        dvd2.setTitle("Title2");
        dvd2.setReleaseDate("01/01/2020");
        dvd2.setDirector("Director2");
        dvd2.setMpaaRating("PG-13");
        dvd2.setStudio("Studio2");
        dvd2.setNote("Note2");
        dao.addDVD(dvd2);

        assertEquals(2, dao.listDVD().size());
    }

    @Test
    public void findByDirector() throws DVDLibraryDaoPersistenceException {
        DVD dvd = new DVD();
        dvd.setTitle("Title1");
        dvd.setReleaseDate("01/01/2020");
        dvd.setDirector("Director1");
        dvd.setMpaaRating("PG-13");
        dvd.setStudio("Studio1");
        dvd.setNote("Note1");
        dao.addDVD(dvd);

        DVD dvd2 = new DVD();
        dvd2.setTitle("Title2");
        dvd2.setReleaseDate("01/01/2020");
        dvd2.setDirector("Director2");
        dvd2.setMpaaRating("PG-13");
        dvd2.setStudio("Studio2");
        dvd2.setNote("Note2");
        dao.addDVD(dvd2);

        DVD dvd3 = new DVD();
        dvd3.setTitle("Title3");
        dvd3.setReleaseDate("01/01/2020");
        dvd3.setDirector("Director2");
        dvd3.setMpaaRating("PG-13");
        dvd3.setStudio("Studio3");
        dvd3.setNote("Note3");
        dao.addDVD(dvd3);

        ArrayList<DVD> DVDList = dao.findByDirector(dvd2.getDirector());
        assertEquals(2, DVDList.size());
        ArrayList<DVD> DVDList1 = dao.findByDirector(dvd.getDirector());
        assertEquals(dvd, DVDList1.get(0));
    }
}