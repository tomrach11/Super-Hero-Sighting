/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tij.superhero.dao;

import com.tij.superhero.model.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author ibby4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationDaoTest {

    @Autowired
    OrganizationDao organizationDao;

    @Autowired
    CharacterDao characterDao;

    @Autowired
    LocationDao locationDao;

    @Autowired
    SightingDao sightingDao;

    @Autowired
    SuperpowerDao superpowerDao;

    public LocationDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        List<Organization> organizations = organizationDao.readAll();
        for (Organization organization : organizations) {
            organizationDao.delete(organization.getOrganizationId());
        }
        List<Location> locations = locationDao.readAll();
        for (Location location : locations) {
            locationDao.delete(location.getLocationId());
        }
        List<Sighting> sightings = sightingDao.readAll();
        for (Sighting sighting : sightings) {
            sightingDao.delete(sighting.getSightingId());
        }
        List<Characters> characters = characterDao.readAll();
        for (Characters character : characters) {
            characterDao.delete(character.getCharacterId());
        }
        List<Superpower> superpowers = superpowerDao.readAll();
        for (Superpower superpower : superpowers) {
            superpowerDao.delete(superpower.getSuperpowerId());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class LocationDao.
     */
    @Test
    public void testCreate() {
        Location location = new Location();
        location.setCity("city");
        location.setLatitude(4.44);
        location.setLongitude(2.12);
        location.setState("NY");
        location.setZipcode("11111");
        location.setStreet("1232123123");

        location = locationDao.create(location);

        Location result = locationDao.readById(location.getLocationId());

        assertEquals(location, result);
    }

    /**
     * Test of readAll method, of class LocationDao.
     */
    @Test
    public void testReadAll() {
        Location location = new Location();
        location.setCity("city");
        location.setLatitude(4.44);
        location.setLongitude(2.12);
        location.setState("NY");
        location.setZipcode("11111");
        location.setStreet("1232123123");

        location = locationDao.create(location);

        Location location2 = new Location();
        location2.setCity("city2");
        location2.setLatitude(4.44);
        location2.setLongitude(2.12);
        location2.setState("NY");
        location2.setZipcode("11111");
        location2.setStreet("1232123123");

        location2 = locationDao.create(location);

        List<Location> result = locationDao.readAll();

        assertEquals(2, result.size());
    }

    /**
     * Test of readById method, of class LocationDao.
     */
    @Test
    public void testReadById() {
        Location location = new Location();
        location.setCity("city");
        location.setLatitude(4.44);
        location.setLongitude(2.12);
        location.setState("NY");
        location.setZipcode("11111");
        location.setStreet("1232123123");

        location = locationDao.create(location);

        Location location2 = new Location();
        location2.setCity("city2");
        location2.setLatitude(4.44);
        location2.setLongitude(2.12);
        location2.setState("NY");
        location2.setZipcode("11111");
        location2.setStreet("1232123123");

        location2 = locationDao.create(location);

        Location result = locationDao.readById(location.getLocationId());

        assertEquals(location, result);
    }

    /**
     * Test of update method, of class LocationDao.
     */
    @Test
    public void testUpdate() {
        Location location = new Location();
        location.setCity("city");
        location.setLatitude(4.44);
        location.setLongitude(2.12);
        location.setState("NY");
        location.setZipcode("11111");
        location.setStreet("1232123123");

        location = locationDao.create(location);

        Location location2 = new Location();
        location2.setCity("city2");
        location2.setLatitude(4.44);
        location2.setLongitude(2.12);
        location2.setState("NY");
        location2.setZipcode("11111");
        location2.setStreet("1232123123");

        location2 = locationDao.create(location);

        location.setCity("city3");
        location.setState("CA");

        locationDao.update(location);

        Location result = locationDao.readById(location.getLocationId());

        assertEquals(location, result);
    }

    /**
     * Test of delete method, of class LocationDao.
     */
    @Test
    public void testDelete() {
        Location location = new Location();
        location.setCity("city");
        location.setLatitude(4.44);
        location.setLongitude(2.12);
        location.setState("NY");
        location.setZipcode("11111");
        location.setStreet("1232123123");

        location = locationDao.create(location);

        Location location2 = new Location();
        location2.setCity("city2");
        location2.setLatitude(4.44);
        location2.setLongitude(2.12);
        location2.setState("NY");
        location2.setZipcode("11111");
        location2.setStreet("1232123123");

        location2 = locationDao.create(location);

        locationDao.delete(location2.getLocationId());

        List<Location> result = locationDao.readAll();

        assertEquals(1, result.size());
    }
    
}
