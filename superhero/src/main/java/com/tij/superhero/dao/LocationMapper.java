package com.tij.superhero.dao;

import com.tij.superhero.model.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationMapper implements RowMapper<Location> {
    @Override
    public Location mapRow(ResultSet resultSet, int i) throws SQLException {
        Location location = new Location();

        location.setLocationId(resultSet.getInt("locationId"));
        location.setLatitude(resultSet.getDouble("latitude"));
        location.setLongitude(resultSet.getDouble("longitude"));
        location.setStreet(resultSet.getString("street"));
        location.setCity(resultSet.getString("city"));
        location.setState(resultSet.getString("state"));
        location.setZipcode(resultSet.getString("zipcode"));
        return location;
    }
}
