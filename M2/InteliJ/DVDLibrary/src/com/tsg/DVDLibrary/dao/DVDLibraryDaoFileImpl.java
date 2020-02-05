package com.tsg.DVDLibrary.dao;

import com.tsg.DVDLibrary.dto.DVD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    Map<String, DVD> dvds = new HashMap<>();

    @Override
    public void addDVD(DVD dvd) {
        dvds.put(dvd.getTitle(), dvd);
    }

    @Override
    public void removeDVD(String title) {

    }

    @Override
    public void editDVD(String title, DVD dvd) {

    }

    @Override
    public ArrayList<DVD> listDVD() {
        return null;
    }

    @Override
    public DVD findDVD(String title) {
        return null;
    }
}
