package com.tij.superhero.dao;

import com.tij.superhero.model.Characters;
import com.tij.superhero.model.Location;
import com.tij.superhero.model.Sighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SightingDao<T> implements Dao<Sighting> {

    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    CharacterDao characterDao;

    @Autowired
    LocationDao locationDao;

    @Override
    public Sighting create(Sighting model) {
        final String SQL_CREATE = "INSERT INTO sighting (characterId, locationId, sightdate) VALUES (?,?,?)";
        jdbc.update(SQL_CREATE, model.getCharacter().getCharacterId(), model.getLocation().getLocationId(), model.getDate());

        int id = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        model.setSightingId(id);

        return model;
    }

    @Override
    public List<Sighting> readAll() {
        final String SQL_READALL = "SELECT * FROM sighting";
        List<Sighting> sightings = jdbc.query(SQL_READALL, new SightingMapper());
        for (Sighting sighting : sightings) {
            sighting = getCharacterForSighting(sighting);
            sighting = getLocationForSighting(sighting);
        }
        return sightings;
    }

    @Override
    public Sighting readById(int id) {
        final String SQL_READ_BY_ID = "SELECT * FROM sighting WHERE sightingId = ?";
        Sighting sighting = jdbc.queryForObject(SQL_READ_BY_ID, new SightingMapper(), id);
        sighting = getCharacterForSighting(sighting);
        sighting = getLocationForSighting(sighting);
        return sighting;
    }

    @Override
    public void update(Sighting model) {
        final String SQL_UPDATE = "UPDATE sighting SET " +
                "characterId = ?, " +
                "locationId = ?, " +
                "sightdate = ? " +
                "WHERE sightingId = ?";
        jdbc.update(SQL_UPDATE, model.getCharacter().getCharacterId(), model.getLocation().getLocationId(), model.getDate(), model.getSightingId());
    }

    @Override
    public void delete(int id) {
        final String SQL_DELETE_SIGHTING = "DELETE FROM sighting WHERE sightingId = ?";
        jdbc.update(SQL_DELETE_SIGHTING, id);
    }

    private List<Characters> getCharacterByLocationId(int locationId) {
        final String SELECT_CHARACTER_FOR_LOCATION = "SELECT c.* FROM character c " +
                "WHERE oc.characterId";

        return jdbc.query(SELECT_CHARACTER_FOR_LOCATION, new CharacterMapper(), locationId);

    }

    private List<Location> getLocationByCharacterId(int characterId) {
        final String SELECT_LOCATION_FOR_CHARACTER = "SELECT c.* FROM character c " +
                "WHERE oc.characterId";

        return jdbc.query(SELECT_LOCATION_FOR_CHARACTER, new LocationMapper(), characterId);

    }

    public Sighting getCharacterForSighting (Sighting sighting) {
        final String SQL = "SELECT characterId from sighting WHERE sightingId = ?";
        int characterId = jdbc.queryForObject(SQL,Integer.class, sighting.getSightingId());
        sighting.setCharacter(characterDao.readById(characterId));
        return sighting;
    }

    public Sighting getLocationForSighting (Sighting sighting) {
        final String SQL = "SELECT locationId from sighting WHERE sightingId = ?";
        int locationId = jdbc.queryForObject(SQL,Integer.class, sighting.getSightingId());
        sighting.setLocation(locationDao.readById(locationId));
        return sighting;
    }

//    public List<String> getCharacterNameBySighting (List<Sighting> sightings) {
//        List<String> characterNames = new ArrayList<>();
//        for (Sighting sighting : sightings) {
//            Characters character = characterDao.readById(sighting.getCharacter().getCharacterId());
//            characterNames.add(character.getName());
//        }
//        return characterNames;
//    }
//
//    public List<Location> getLocationBySighting (List<Sighting> sightings) {
//        List<Location> locations = new ArrayList<>();
//        for (Sighting sighting : sightings) {
//            Location location = locationDao.readById(sighting.getLocation().getLocationId());
//            locations.add(location);
//        }
//        return locations;

//    }

}
