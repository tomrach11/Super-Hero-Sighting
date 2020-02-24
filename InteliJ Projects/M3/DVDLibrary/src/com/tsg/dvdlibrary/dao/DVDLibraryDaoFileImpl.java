package com.tsg.dvdlibrary.dao;

import com.tsg.dvdlibrary.dto.DVD;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    private static final String DVDS_FILE ="dvds.txt";
    private static final String DELIMITER = "::";

    Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD addDVD(DVD dvd) throws DVDLibraryDaoPersistenceException {
        readFile();
        DVD addedDVD = dvds.put(dvd.getTitle(), dvd);
        writeFile();
        return addedDVD;
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoPersistenceException {
        readFile();
        DVD removedDVD = dvds.remove(title);
        writeFile();
        return removedDVD;
    }

    @Override
    public DVD editDVD(String title, DVD dvd) throws DVDLibraryDaoPersistenceException {
        readFile();
        DVD editedDVD = dvds.put(title, dvd);
        writeFile();
        return editedDVD;
    }

    @Override
    public ArrayList<DVD> listDVD() throws DVDLibraryDaoPersistenceException {
        readFile();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD findByTitle(String title) throws DVDLibraryDaoPersistenceException {
        readFile();
        return dvds.get(title);
    }

    @Override
    public ArrayList<DVD> findByDirector(String director) throws DVDLibraryDaoPersistenceException {
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

    @Override
    public List<DVD> findFromYear(String year) throws DVDLibraryDaoPersistenceException {
        readFile();
        LocalDate yearDate = LocalDate.parse(year + "-01-01");
        Predicate<DVD> fromYear = (DVD dvd) -> {
            return (dvd.getReleaseDateAsLocalDate().getYear() == yearDate.getYear());
        };
        return listDVD().stream().filter(fromYear).collect(Collectors.toList());
    }

    @Override
    public List<DVD> findByRating(String rating) throws DVDLibraryDaoPersistenceException {
        readFile();
        Predicate<DVD> matchRating = (DVD dvd) -> {
            return (dvd.getMpaaRating().equalsIgnoreCase(rating));
        };
        return listDVD().stream().filter(matchRating).collect(Collectors.toList());
    }

    @Override
    public List<DVD> findByStudio(String studio) throws DVDLibraryDaoPersistenceException {
        readFile();
        Predicate<DVD> matchStudio = (DVD dvd) -> {
            return (dvd.getStudio().equalsIgnoreCase(studio));
        };
        return listDVD().stream().filter(matchStudio).collect(Collectors.toList());
    }

    @Override
    public double findAverageAge() throws DVDLibraryDaoPersistenceException {
        readFile();
        int totalYear = 0;
        ToIntFunction<DVD> getYear = (DVD dvd) -> {
            Period p = dvd.getReleaseDateAsLocalDate().until(LocalDate.now());
            return p.getYears();
        };
        return (listDVD().stream().mapToInt(getYear).average().getAsDouble());
    }

    @Override
    public List<DVD> findNewestDVD() throws DVDLibraryDaoPersistenceException {
        readFile();
        LocalDate newestDate = LocalDate.parse("1111-11-11");
        //List<DVD> newestDVDList = new ArrayList<>();
        //use for loop to find newest date
        for(DVD dvd : listDVD()) {
            if (dvd.getReleaseDateAsLocalDate().compareTo(newestDate) > 0 || dvd.getReleaseDateAsLocalDate().compareTo(newestDate) == 0) {
                newestDate = dvd.getReleaseDateAsLocalDate();
                //newestDVDList.add(dvd);
            }
        }

        //use lamda and steam to create list of dvd that match with newestDate
        LocalDate NEWEST = newestDate;
        Predicate<DVD> newestDVD = (DVD dvd) -> dvd.getReleaseDateAsLocalDate().compareTo(NEWEST) == 0;
        return listDVD().stream().filter(newestDVD).collect(Collectors.toList());
    }

    @Override
    public List<DVD> findOldestDVD() throws DVDLibraryDaoPersistenceException {
        readFile();
        LocalDate oldestDate = LocalDate.now();
        for(DVD dvd : listDVD()) {
            if(dvd.getReleaseDateAsLocalDate().compareTo(oldestDate) <= 0) {
                oldestDate = dvd.getReleaseDateAsLocalDate();
            }
        }
        LocalDate OLDEST = oldestDate;
        Predicate<DVD> oldestDVD = (DVD dvd) -> dvd.getReleaseDateAsLocalDate().compareTo(OLDEST) == 0;
        return listDVD().stream().filter(oldestDVD).collect(Collectors.toList());
    }

    //read file
    public void readFile() throws DVDLibraryDaoPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVDS_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoPersistenceException("-_ Could not load DVDs data into memory.", e);
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

    public void writeFile() throws DVDLibraryDaoPersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(DVDS_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoPersistenceException("_- Could not save data to file.");
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
