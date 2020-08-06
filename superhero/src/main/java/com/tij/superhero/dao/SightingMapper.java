package com.tij.superhero.dao;

import com.tij.superhero.model.Characters;
import com.tij.superhero.model.Location;
import com.tij.superhero.model.Sighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SightingMapper implements RowMapper<Sighting> {
    @Autowired
    CharacterDao characterDao;

    @Autowired
    LocationDao locationDao;

    @Override
    public Sighting mapRow(ResultSet resultSet, int i) throws SQLException {
        Sighting sighting = new Sighting();

        sighting.setSightingId(resultSet.getInt("sightingId"));
//        Characters character = characterDao.readById(resultSet.getInt("characterId"));
//        sighting.setCharacter(character);
//        Location location = locationDao.readById(resultSet.getInt("locationId"));
//        sighting.setLocation(location);

        sighting.setDate(resultSet.getDate("sightdate").toLocalDate());

        return sighting;
    }
}
