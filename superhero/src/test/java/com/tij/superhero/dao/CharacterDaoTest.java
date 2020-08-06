/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tij.superhero.dao;

import com.tij.superhero.model.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author ibby4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CharacterDaoTest {

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

    public CharacterDaoTest() {
    }

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
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

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of create method, of class CharacterDao.
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

        Superpower superpower = new Superpower();
        superpower.setType("Slow");
        superpower = superpowerDao.create(superpower);

        Characters character = new Characters();
        character.setName("Supa1");
        character.setDescription("Fast");
        character.setSuperpower(superpowerDao.readById(superpower.getSuperpowerId()));
        character.setType("Hero");

        List<Organization> orgList = new ArrayList();
        orgList.add(organization);

        character.setOrganizations(orgList);

        Characters result = characterDao.create(character);

        assertEquals(result, character);
    }

    /**
     * Test of readAll method, of class CharacterDao.
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

        Superpower superpower = new Superpower();
        superpower.setType("Slow");
        superpower = superpowerDao.create(superpower);

        Characters character = new Characters();
        character.setName("Supa1");
        character.setDescription("Fast");
        character.setSuperpower(superpowerDao.readById(superpower.getSuperpowerId()));
        character.setType("Hero");

        Characters character2 = new Characters();
        character2.setName("Supa11");
        character2.setDescription("Fast1");
        character2.setSuperpower(superpowerDao.readById(superpower.getSuperpowerId()));
        character2.setType("Hero1");

        List<Organization> orgList = new ArrayList();
        orgList.add(organization);

        character.setOrganizations(orgList);
        character2.setOrganizations(orgList);

        characterDao.create(character);
        characterDao.create(character2);
        List<Characters> result = characterDao.readAll();

        assertEquals(2, result.size());
    }

    /**
     * Test of readById method, of class CharacterDao.
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

        Superpower superpower = new Superpower();
        superpower.setType("Slow");
        superpower = superpowerDao.create(superpower);

        Characters character = new Characters();
        character.setName("Supa1");
        character.setDescription("Fast");
        character.setSuperpower(superpowerDao.readById(superpower.getSuperpowerId()));
        character.setType("Hero");

        Characters character2 = new Characters();
        character2.setName("Supa11");
        character2.setDescription("Fast1");
        character2.setSuperpower(superpowerDao.readById(superpower.getSuperpowerId()));
        character2.setType("Hero1");

        List<Organization> orgList = new ArrayList();
        orgList.add(organization);

        character.setOrganizations(orgList);
        character2.setOrganizations(orgList);

        character = characterDao.create(character);
        characterDao.create(character2);
        
        Characters result = characterDao.readById(character.getCharacterId());
        
        assertEquals(character, result);
    }

    /**
     * Test of associateOrganization method, of class CharacterDao.
     */
    @Test
    public void testAssociateOrganization() {
    }

    /**
     * Test of update method, of class CharacterDao.
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

        Superpower superpower = new Superpower();
        superpower.setType("Slow");
        superpower = superpowerDao.create(superpower);

        Characters character = new Characters();
        character.setName("Supa1");
        character.setDescription("Fast");
        character.setSuperpower(superpowerDao.readById(superpower.getSuperpowerId()));
        character.setType("Hero");

        List<Organization> orgList = new ArrayList();
        orgList.add(organization);

        character.setOrganizations(orgList);
        

        character = characterDao.create(character);
        
        character.setName("Supa2");
        character.setDescription("Speedy");
        characterDao.update(character);
        
        Characters result = characterDao.readById(character.getCharacterId());
        
        assertEquals(character,result);
    }

    /**
     * Test of delete method, of class CharacterDao.
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

        Superpower superpower = new Superpower();
        superpower.setType("Slow");
        superpower = superpowerDao.create(superpower);

        Characters character = new Characters();
        character.setName("Supa1");
        character.setDescription("Fast");
        character.setSuperpower(superpowerDao.readById(superpower.getSuperpowerId()));
        character.setType("Hero");

        List<Organization> orgList = new ArrayList();
        orgList.add(organization);

        character.setOrganizations(orgList);
        

        character = characterDao.create(character);
        
        characterDao.delete(character.getCharacterId());
        List<Characters> charList = characterDao.readAll();
        
        assertEquals(0,charList.size());
    }

}
