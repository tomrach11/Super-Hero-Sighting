package com.tr.addressbook.dao;

import com.tr.addressbook.dto.Address;
import com.tr.addressbook.dto.Profile;

import java.io.*;
import java.util.*;

public class AddressBookDaoFileImpl implements AddressBookDao {

    private static final String ADDRESS_FILE = "address.txt";
    private static final String DELIMITER = "::";

    Map<String, Profile> addresses = new HashMap();

    @Override
    public void addAddress(Profile profile, Address address) throws AddressBookDaoException {
        readFile();
        Profile newProfile = profile;
        newProfile.setAddress(address);
        addresses.put(newProfile.getLastName(), newProfile);
        writeFile();
    }

    @Override
    public void removeAddress(String lastName) throws AddressBookDaoException {
        readFile();
        addresses.remove(lastName);
        writeFile();
    }

    @Override
    public int countAddress() throws AddressBookDaoException {
        readFile();
        return addresses.size();
    }

    @Override
    public ArrayList<Profile> allAddress() throws AddressBookDaoException {
        readFile();
       return new ArrayList<Profile>(addresses.values());
    }

    @Override
    public Profile findAddress(String lastName) throws AddressBookDaoException {
        readFile();
        return addresses.get(lastName);
    }

    public void readFile() throws AddressBookDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ADDRESS_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressBookDaoException("-_- Could not load address data into memory", e);
        }

        while (scanner.hasNextLine()) {
            String currentAddress = scanner.nextLine();
            Profile profile = unmarshallProfile(currentAddress);
            addresses.put(profile.getLastName(), profile);
        }
    }

    public Profile unmarshallProfile(String studentAsText) {
        String[] list = studentAsText.split(DELIMITER);
        Profile profile = new Profile();
        profile.setFirstName(list[0]);
        profile.setLastName(list[1]);

        Address address = new Address();
        address.setStreet(list[2]);
        address.setCity(list[3]);
        address.setState(list[4]);
        address.setZipCode(list[5]);

        profile.setAddress(address);
        return profile;
    }

    public void writeFile() throws AddressBookDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter((new FileWriter(ADDRESS_FILE)));
        } catch (IOException e) {
            throw new AddressBookDaoException("-_-Could not save address data to file.", e);
        }
        List<Profile> profiles = this.allAddress();
        for (Profile profile : profiles) {
            String currentAddress = marchallAddress(profile);
            out.println(currentAddress);
            out.flush();
        }
        out.close();
    }

    public String marchallAddress(Profile profile) {
        String profileAsText = "";
        profileAsText += profile.getFirstName() + DELIMITER;
        profileAsText += profile.getLastName() + DELIMITER;
        Address address = profile.getAddress();
        profileAsText += address.getStreet() + DELIMITER;
        profileAsText += address.getCity() + DELIMITER;
        profileAsText += address.getState() + DELIMITER;
        profileAsText += address.getZipCode();

        return profileAsText;
    }



}
