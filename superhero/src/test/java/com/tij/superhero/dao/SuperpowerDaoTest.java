package com.tij.superhero.dao;

import com.tij.superhero.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SuperpowerDaoTest {

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
        Superpower superpower = new Superpower();
        superpower.setType("Slow");
        superpower = superpowerDao.create(superpower);

        Superpower result = superpowerDao.readById(superpower.getSuperpowerId());

        assertEquals(superpower, result);
    }

    @Test
    void readAll() {
        Superpower superpower = new Superpower();
        superpower.setType("Slow");
        superpower = superpowerDao.create(superpower);

        Superpower superpower1 = new Superpower();
        superpower1.setType("Fast");
        superpower1 = superpowerDao.create(superpower1);

        List<Superpower> result = superpowerDao.readAll();

        assertEquals(2 ,result.size());
    }

    @Test
    void readById() {
        Superpower superpower = new Superpower();
        superpower.setType("Slow");
        superpower = superpowerDao.create(superpower);

        Superpower superpower1 = new Superpower();
        superpower1.setType("Fast");
        superpower1 = superpowerDao.create(superpower1);

        Superpower result = superpowerDao.readById(superpower.getSuperpowerId());

        assertEquals(superpower, result);
    }

    @Test
    void update() {
        Superpower superpower = new Superpower();
        superpower.setType("Slow");
        superpower = superpowerDao.create(superpower);

        Superpower superpower1 = new Superpower();
        superpower1.setType("Fast");
        superpower1 = superpowerDao.create(superpower1);

        superpower.setType("Super Fast");
        superpowerDao.update(superpower);

        Superpower result = superpowerDao.readById(superpower.getSuperpowerId());

        assertEquals(superpower, result);
    }

    @Test
    void delete() {
        Superpower superpower = new Superpower();
        superpower.setType("Slow");
        superpower = superpowerDao.create(superpower);

        Superpower superpower1 = new Superpower();
        superpower1.setType("Fast");
        superpower1 = superpowerDao.create(superpower1);

        superpowerDao.delete(superpower1.getSuperpowerId());

        List<Superpower> result = superpowerDao.readAll();

        assertEquals(1 ,result.size());
    }
}