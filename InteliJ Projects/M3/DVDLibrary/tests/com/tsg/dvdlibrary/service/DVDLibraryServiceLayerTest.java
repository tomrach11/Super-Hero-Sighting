package com.tsg.dvdlibrary.service;

import com.tsg.dvdlibrary.dao.*;
import com.tsg.dvdlibrary.dto.DVD;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DVDLibraryServiceLayerTest {

    private DVDLibraryServiceLayer service;

    public DVDLibraryServiceLayerTest() {
        DVDLibraryDao dao = new DVDLibraryDaoStubImpl();
        service = new DVDLibraryServiceLayerImpl(dao);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCreateDVD() throws Exception {
        DVD dvd = new DVD();
        dvd.setTitle("Title2");
        dvd.setDirector("Director2");
        dvd.setStudio("Studio2");
        dvd.setReleaseDate("2011-11-11");
        dvd.setMpaaRating("Rate2");
        dvd.setNote("Note2");
        service.createDVD(dvd);
    }

    @Test
    void testDuplicateDVDTitle() throws Exception {
        DVD dvd = new DVD();
        dvd.setTitle("Title1");
        dvd.setDirector("Director2");
        dvd.setStudio("Studio2");
        dvd.setReleaseDate("2011-11-11");
        dvd.setMpaaRating("Rate2");
        dvd.setNote("Note2");
        try {
            service.createDVD(dvd);
            fail("Expected DVDLibraryDuplicateTitleException was not thrown");
        } catch (DVDLibraryDuplicateTitleException e){
            return;
        }
    }

    @Test
    void testValidateData() throws Exception {
        DVD dvd = new DVD();
        dvd.setTitle("Title2");
        dvd.setDirector("Director2");
        try {
            service.createDVD(dvd);
            fail("Expected DVDLibraryDataValidationException was not thrown");
        } catch (DVDLibraryDataValidationException e) {
            return;
        }
    }

    @Test
    void testRemoveDVD() throws Exception{
        DVD dvd = service.removeDVD("Title1");
        assertNotNull(dvd);
        dvd = service.removeDVD("Title999");
        assertNull(dvd);
    }

    @Test
    void testAllDVD() throws Exception {
        assertEquals(1, service.allDVD().size());
    }

    @Test
    void testGetDVD() throws Exception {
        DVD dvd = service.getDVD("Title1");
        assertNotNull(dvd);
        dvd = service.getDVD("Title999");
        assertNull(dvd);
    }

    @Test
    void testEditDVD() throws Exception{
        DVD dvd = new DVD();
        dvd.setTitle("Title1");
        dvd.setDirector("Director2");
        dvd.setStudio("Studio2");
        dvd.setReleaseDate("2011-11-11");
        dvd.setMpaaRating("Rate2");
        dvd.setNote("Note2");
        service.editDVD("Title1", dvd);
    }

    @Test
    void testEditDVDWithNull() throws  Exception {
        DVD dvd = new DVD();
        dvd.setTitle("Title1");
        dvd.setDirector("Director2");
        dvd.setStudio("Studio2");

        try {
            service.editDVD("Title1", dvd);
            fail("Expected DVDLibraryDataValidationException was not thrown");
        } catch (DVDLibraryDataValidationException e) {
            return;
        }
    }

    @Test
    void testGetDVDByDirector() throws Exception {
        assertEquals(1, service.getDVDByDirector("Director1"));
    }
}