package com.tij.superhero.dao;

import com.tij.superhero.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationDao<T> implements Dao<Location> {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Location create(Location model) {
        final String SQL_CREATE = "INSERT INTO location (latitude, longitude, street, city, state, zipcode) VALUES (?,?,?,?,?,?)";
        jdbc.update(SQL_CREATE, model.getLatitude(), model.getLongitude(), model.getStreet(), model.getCity(),model.getState(),model.getZipcode());

        int id = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        model.setLocationId(id);

        return model;
    }

    @Override
    public List<Location> readAll() {
        final String SQL_READALL = "SELECT * FROM location";
        return jdbc.query(SQL_READALL, new LocationMapper());
    }

    @Override
    public Location readById(int id) {
        final String SQL_READ_BY_ID = "SELECT * FROM location WHERE locationId = ?";
        return jdbc.queryForObject(SQL_READ_BY_ID, new LocationMapper(), id);
    }

    @Override
    public void update(Location model) {
        final String SQL_UPDATE = "UPDATE location SET " +
                "latitude = ?, " +
                "longitude = ?, " +
                "street = ?, " +
                "city = ?, " +
                "state = ?, " +
                "zipcode = ? " +
                "WHERE locationID = ?";
        jdbc.update(SQL_UPDATE, model.getLatitude(), model.getLongitude(), model.getStreet(), model.getCity(),model.getState(),model.getZipcode(), model.getLocationId());
    }

    @Override
    public void delete(int id) {
        final String SQL_DELETE_ORGANIZATION = "DELETE FROM organization WHERE locationId = ?";
        jdbc.update(SQL_DELETE_ORGANIZATION, id);
        final String SQL_DELETE_SIGHTING = "DELETE FROM sighting WHERE locationId = ?";
        jdbc.update(SQL_DELETE_SIGHTING, id);
        final String SQL_DELETE_LOCATION = "DELETE FROM location WHERE locationId = ?";
        jdbc.update(SQL_DELETE_LOCATION, id);
    }
}
