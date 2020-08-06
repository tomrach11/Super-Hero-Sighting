package com.tij.superhero.dao;

import com.tij.superhero.model.Superpower;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SuperpowerMapper implements RowMapper<Superpower> {
    @Override
    public Superpower mapRow(ResultSet resultSet, int i) throws SQLException {
        Superpower superpower = new Superpower();

        superpower.setSuperpowerId(resultSet.getInt("superpowerId"));
        superpower.setType(resultSet.getString("type"));

        return superpower;
    }
}
