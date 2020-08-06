package com.tij.superhero.dao;

import com.tij.superhero.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SightingDaoTest {
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

    @BeforeEach
    void setUp() {
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
    void tearDown() {

    }

    @Test
    void create() {
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
        character = characterDao.create(character);

        Sighting sighting = new Sighting();
        sighting.setCharacter(character);
        sighting.setLocation(location);
        sighting.setDate(LocalDate.now());

        sighting = sightingDao.create(sighting);

        Sighting result = sightingDao.readById(sighting.getSightingId());

        assertEquals(sighting, result);
    }

    @Test
    void readAll() {
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
        character = characterDao.create(character);

        Sighting sighting = new Sighting();
        sighting.setCharacter(character);
        sighting.setLocation(location);
        sighting.setDate(LocalDate.now());

        sighting = sightingDao.create(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setCharacter(character2);
        sighting2.setLocation(location);
        sighting2.setDate(LocalDate.now());

        sighting2 = sightingDao.create(sighting);

        List<Sighting> result = sightingDao.readAll();

        assertEquals(2, result.size());
    }

    @Test
    void readById() {
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
        character = characterDao.create(character);

        Sighting sighting = new Sighting();
        sighting.setCharacter(character);
        sighting.setLocation(location);
        sighting.setDate(LocalDate.now());

        sighting = sightingDao.create(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setCharacter(character2);
        sighting2.setLocation(location);
        sighting2.setDate(LocalDate.now());

        sighting2 = sightingDao.create(sighting);

        Sighting result = sightingDao.readById(sighting.getSightingId());

        assertEquals(sighting, result);
    }

    @Test
    void update() {
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
        character2 = characterDao.create(character2);

        Sighting sighting = new Sighting();
        sighting.setCharacter(character);
        sighting.setLocation(location);
        sighting.setDate(LocalDate.now());

        sighting = sightingDao.create(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setCharacter(character2);
        sighting2.setLocation(location);
        sighting2.setDate(LocalDate.now());

        sighting2 = sightingDao.create(sighting2);

        sighting.setCharacter(character2);
        sightingDao.update(sighting);
        Sighting result = sightingDao.readById(sighting.getSightingId());

        assertEquals(sighting, result);
    }

    @Test
    void delete() {
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
        character2 = characterDao.create(character2);

        Sighting sighting = new Sighting();
        sighting.setCharacter(character);
        sighting.setLocation(location);
        sighting.setDate(LocalDate.now());

        sighting = sightingDao.create(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setCharacter(character2);
        sighting2.setLocation(location);
        sighting2.setDate(LocalDate.now());

        sighting2 = sightingDao.create(sighting2);

        sightingDao.delete(sighting2.getSightingId());

        List<Sighting> result = sightingDao.readAll();

        assertEquals(1, result.size());
    }
}