package com.tr.addressbook.dao;

import com.tr.addressbook.dto.Address;
import com.tr.addressbook.dto.Profile;

import java.util.ArrayList;

public interface AddressBookDao {

    Profile addAddress(Profile profile, Address address) throws AddressBookDaoException;

    Profile removeAddress(String lastName) throws AddressBookDaoException;

    int countAddress() throws AddressBookDaoException;

    ArrayList<Profile> allAddress() throws AddressBookDaoException;

    Profile findAddress(String lastName) throws AddressBookDaoException;

    void editAddress(String lastName, Address address) throws AddressBookDaoException;
}
