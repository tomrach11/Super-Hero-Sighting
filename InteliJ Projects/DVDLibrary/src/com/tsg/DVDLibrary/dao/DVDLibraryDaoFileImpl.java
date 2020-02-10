package com.tsg.DVDLibrary.dao;

import com.tsg.DVDLibrary.dto.DVD;

import java.io.*;
import java.util.*;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    private static final String DVDS_FILE ="dvds.txt";
    private static final String DELIMITER = "::";

    Map<String, DVD> dvds = new HashMap<>();

    @Override
    public void addDVD(DVD dvd) throws DVDLibraryDaoException {
        readFile();
        dvds.put(dvd.getTitle(), dvd);
        writeFile();
    }

    @Override
    public void removeDVD(String title) throws DVDLibraryDaoException {
        readFile();
        dvds.remove(title);
        writeFile();
    }

    @Override
    public void editDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        readFile();
        dvds.put(title, dvd);
        writeFile();
    }

    @Override
    public ArrayList<DVD> listDVD() throws DVDLibraryDaoException {
        readFile();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD findByTitle(String title) throws DVDLibraryDaoException {
        readFile();
        return dvds.get(title);
    }

    @Override
    public ArrayList<DVD> findByDirector(String director) throws DVDLibraryDaoException {
        readFile();
        ArrayList<DVD> dvdList = listDVD();
        ArrayList<DVD> dvdDirectorList = new ArrayList<>();
        for (DVD dvd : dvdList) {
            if (dvd.getDirector().equalsIgnoreCase(director)) {
                dvdDirectorList.add(dvd);
            }
        }
        return dvdDirectorList;
    }

    //read file
    public void readFile() throws DVDLibraryDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVDS_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException("-_ Could not load DVDs data into memory.", e);
        }

        while (scanner.hasNextLine()) {
            String dvdText = scanner.nextLine();
            DVD dvd = unmarshallDVD(dvdText);
            dvds.put(dvd.getTitle(), dvd);
        }

    }

    public DVD unmarshallDVD(String dvdText) {
        String[] dvd = dvdText.split(DELIMITER);
        DVD currentDVD = new DVD();
        currentDVD.setTitle(dvd[0]);
        currentDVD.setReleaseDate(dvd[1]);
        currentDVD.setDirector(dvd[2]);
        currentDVD.setStudio(dvd[3]);
        currentDVD.setMpaaRating(dvd[4]);
        currentDVD.setNote(dvd[5]);
        return currentDVD;
    }

    public void writeFile() throws DVDLibraryDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(DVDS_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException("_- Could not save data to file.");
        }

        List<DVD> dvdList = listDVD();
        for (DVD dvd : dvdList) {
            String dvdText = marshallDVD(dvd);
            out.println(dvdText);
            out.flush();
        }
        out.close();
    }

    public String marshallDVD(DVD dvd) {
        String dvdText = "";
        dvdText += dvd.getTitle() + DELIMITER;
        dvdText += dvd.getReleaseDate() + DELIMITER;
        dvdText += dvd.getDirector() + DELIMITER;
        dvdText += dvd.getStudio() + DELIMITER;
        dvdText += dvd.getMpaaRating() + DELIMITER;
        dvdText += dvd.getNote();
        return dvdText;
    }

}
