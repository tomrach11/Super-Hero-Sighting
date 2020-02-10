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
        dvds.remove(title);
    }

    @Override
    public void editDVD(String title, DVD dvd) {
        dvds.put(title, dvd);
    }

    @Override
    public ArrayList<DVD> listDVD() {
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD findByTitle(String title) {
        return dvds.get(title);
    }

    @Override
    public ArrayList<DVD> findByDirector(String director) {
        ArrayList<DVD> dvdList = listDVD();
        ArrayList<DVD> dvdDirectorList = new ArrayList<>();
        for (DVD dvd : dvdList) {
            if (dvd.getDirector().equalsIgnoreCase(director)) {
                dvdDirectorList.add(dvd);
            }
        }
        return dvdDirectorList;
    }
}
