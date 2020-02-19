package com.tr.addressbook.dao;

import com.tr.addressbook.dto.Address;
import com.tr.addressbook.dto.Profile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookDaoTest {

    private AddressBookDao dao = new AddressBookDaoFileImpl();

    @BeforeEach
    public void setUp() throws AddressBookDaoException {
        List<Profile> addressList = dao.allAddress();
        for (Profile profile : addressList) {
            dao.removeAddress(profile.getLastName());
        }
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetAddress() throws AddressBookDaoException {
        Profile profile = new Profile();
        Address address = new Address();

        profile.setFirstName("Jon");
        profile.setLastName("Doe");

        address.setStreet("1234");
        address.setCity("NYC");
        address.setState("NY");
        address.setZipCode("10106");

        dao.addAddress(profile, address);

        Profile fromDao = dao.findAddress(profile.getLastName());

        assertEquals(profile, fromDao);
    }

    @Test
    public void testRemoveAddress() throws AddressBookDaoException {
        Profile profile = new Profile();
        Address address = new Address();

        profile.setFirstName("Jon");
        profile.setLastName("Doe");

        address.setStreet("1234");
        address.setCity("NYC");
        address.setState("NY");
        address.setZipCode("10106");
        dao.addAddress(profile, address);

        Profile removedProfile = dao.removeAddress(profile.getLastName());

        assertEquals(profile, removedProfile);
        assertEquals(0, dao.allAddress().size());
    }

    @Test
    public void testCountAllAddress() throws AddressBookDaoException {
        Profile profile = new Profile();
        Address address = new Address();
        profile.setFirstName("Jon");
        profile.setLastName("Doe");
        address.setStreet("1234");
        address.setCity("NYC");
        address.setState("NY");
        address.setZipCode("10106");
        dao.addAddress(profile, address);

        Profile profile2 = new Profile();
        Address address2 = new Address();
        profile2.setFirstName("Jon2");
        profile2.setLastName("Doe2");
        address2.setStreet("12342");
        address2.setCity("NYC2");
        address2.setState("NY2");
        address2.setZipCode("101062");
        dao.addAddress(profile2, address2);

        assertEquals(2, dao.allAddress().size());
    }

    @Test
    public void editAddress() throws AddressBookDaoException {
        Profile profile = new Profile();
        Address address = new Address();
        profile.setFirstName("Jon");
        profile.setLastName("Doe");
        address.setStreet("1234");
        address.setCity("NYC");
        address.setState("NY");
        address.setZipCode("10106");
        dao.addAddress(profile, address);

        Address address2 = new Address();
        address2.setStreet("12342");
        address2.setCity("NYC2");
        address2.setState("NY2");
        address2.setZipCode("101062");

        profile.setAddress(address2);
        dao.editAddress(profile.getLastName(), address2);

        assertEquals(profile, dao.findAddress(profile.getLastName()));
    }
}