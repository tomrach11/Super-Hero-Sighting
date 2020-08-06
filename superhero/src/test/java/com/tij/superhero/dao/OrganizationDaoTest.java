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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author ibby4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrganizationDaoTest {

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
    
    public OrganizationDaoTest() {
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
     * Test of create method, of class OrganizationDao.
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

        Organization organization = new Organization();
        organization.setName("M4");
        organization.setDescription("Hero Org");
        organization.setLocation(location);
        organization.setPhone("7185555555");
        organization.setEmail("M4heros@hero.com");
        organization = organizationDao.create(organization);

        organization = organizationDao.create(organization);

        Organization result = organizationDao.readById(organization.getOrganizationId());

        assertEquals(organization, result);
    }

    /**
     * Test of readAll method, of class OrganizationDao.
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

        Organization organization = new Organization();
        organization.setName("M4");
        organization.setDescription("Hero Org");
        organization.setLocation(location);
        organization.setPhone("7185555555");
        organization.setEmail("M4heros@hero.com");
        organization = organizationDao.create(organization);

        Organization organization2 = new Organization();
        organization2.setName("M422");
        organization2.setDescription("Hero Org22");
        organization2.setLocation(location);
        organization2.setPhone("7185555555");
        organization2.setEmail("M422heros@hero.com");
        organization2 = organizationDao.create(organization2);

        List<Organization> result = organizationDao.readAll();

        assertEquals(2, result.size());
    }

    /**
     * Test of readById method, of class OrganizationDao.
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

        Organization organization = new Organization();
        organization.setName("M4");
        organization.setDescription("Hero Org");
        organization.setLocation(location);
        organization.setPhone("7185555555");
        organization.setEmail("M4heros@hero.com");
        organization = organizationDao.create(organization);

        Organization organization2 = new Organization();
        organization2.setName("M422");
        organization2.setDescription("Hero Org22");
        organization2.setLocation(location);
        organization2.setPhone("7185555555");
        organization2.setEmail("M422heros@hero.com");
        organization2 = organizationDao.create(organization2);

        Organization result = organizationDao.readById(organization.getOrganizationId());
        assertEquals(organization, result);
    }

    /**
     * Test of update method, of class OrganizationDao.
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

        Organization organization = new Organization();
        organization.setName("M4");
        organization.setDescription("Hero Org");
        organization.setLocation(location);
        organization.setPhone("7185555555");
        organization.setEmail("M4heros@hero.com");
        organization = organizationDao.create(organization);

        organization.setName("Change");
        organization.setDescription("change");

        organizationDao.update(organization);

        Organization result = organizationDao.readById(organization.getOrganizationId());

        assertEquals(organization, result);
    }

    /**
     * Test of delete method, of class OrganizationDao.
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

        Organization organization = new Organization();
        organization.setName("M4");
        organization.setDescription("Hero Org");
        organization.setLocation(location);
        organization.setPhone("7185555555");
        organization.setEmail("M4heros@hero.com");
        organization = organizationDao.create(organization);

        Organization organization2 = new Organization();
        organization2.setName("M422");
        organization2.setDescription("Hero Org22");
        organization2.setLocation(location);
        organization2.setPhone("7185555555");
        organization2.setEmail("M422heros@hero.com");
        organization2 = organizationDao.create(organization2);

        organizationDao.delete(organization2.getOrganizationId());
        List<Organization> result = organizationDao.readAll();

        assertEquals(1, result.size());
    }

    /**
     * Test of getOrganizationByCharacterId method, of class OrganizationDao.
     */
    @Test
    public void testGetOrganizationByCharacterId() {
    }

    /**
     * Test of getCharacterByOrganization method, of class OrganizationDao.
     */
    @Test
    public void testGetCharacterByOrganization() {
    }
    
}
