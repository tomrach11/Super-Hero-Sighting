package com.tij.superhero.dao;

import com.tij.superhero.model.Characters;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CharacterMapper implements RowMapper<Characters> {
    @Override
    public Characters mapRow(ResultSet resultSet, int i) throws SQLException {
        Characters character = new Characters();

        character.setCharacterId(resultSet.getInt("characterId"));
        character.setName(resultSet.getString("name"));
        character.setDescription(resultSet.getString("description"));
        character.setType(resultSet.getString("type"));
        return character;
    }
}
