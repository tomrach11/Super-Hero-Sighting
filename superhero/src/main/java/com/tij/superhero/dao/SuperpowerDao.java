package com.tij.superhero.dao;

import com.tij.superhero.model.Characters;
import com.tij.superhero.model.Superpower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SuperpowerDao<T> implements Dao<Superpower> {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Superpower create(Superpower model) {
        final String SQL_CREATE = "INSERT INTO superpower (type) VALUES (?)";
        jdbc.update(SQL_CREATE, model.getType());

        int id = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        model.setSuperpowerId(id);
        return model;
    }

    @Override
    public List<Superpower> readAll() {
        final String SQL_READALL = "SELECT * FROM superpower";
        return jdbc.query(SQL_READALL, new SuperpowerMapper());
    }

    @Override
    public Superpower readById(int id) {
        final String SQL_READ_BY_ID = "SELECT * FROM superpower WHERE superpowerId = ?";
        return jdbc.queryForObject(SQL_READ_BY_ID, new SuperpowerMapper(), id);
    }

    @Override
    public void update(Superpower model) {
        final String SQL_UPDATE = "UPDATE superpower SET " +
                "type = ? " +
                "WHERE superpowerId = ?";
        jdbc.update(SQL_UPDATE, model.getType(), model.getSuperpowerId());
    }

    @Override
    public void delete(int id) {
        final String SQL_SELECT_CHARACTER_BY_SUPERPOWERID = "SELECT * FROM characters WHERE superpowerId = ?";
        List<Characters> characters = jdbc.query(SQL_SELECT_CHARACTER_BY_SUPERPOWERID, new CharacterMapper(), id);
        for (Characters character : characters) {
            int characterId = character.getCharacterId();
            final String SQL_DELETE_ORGANIZATION_CHARACTER = "DELETE FROM organization_character WHERE characterId = ?";
            jdbc.update(SQL_DELETE_ORGANIZATION_CHARACTER, characterId);
            final String SQL_DELETE_SIGHTING = "DELETE FROM sighting WHERE characterId = ?";
            jdbc.update(SQL_DELETE_SIGHTING, characterId);
            final String SQL_DELETE_CHARACTER = "DELETE FROM characters WHERE characterId = ?";
            jdbc.update(SQL_DELETE_CHARACTER, characterId);
        }
        final String DELETE_SUPERPOWER = "DELETE FROM superpower WHERE superpowerId = ?";
        jdbc.update(DELETE_SUPERPOWER, id);
    }
}
