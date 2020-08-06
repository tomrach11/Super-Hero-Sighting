package com.tij.superhero.dao;

import com.tij.superhero.model.Characters;
import com.tij.superhero.model.Organization;
import com.tij.superhero.model.Sighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CharacterDao implements Dao<Characters> {

    @Autowired
    private JdbcTemplate jdbc;

//    @Autowired
//    public CharacterDao(JdbcTemplate jdbc) {
//        this.jdbc = jdbc;
//    }

    @Autowired
    OrganizationDao organizationDao;

    @Autowired
    SuperpowerDao superpowerDao;


    @Override
    public Characters create(Characters model) {
        final String SQL_CREATE = "INSERT INTO characters (name, description, superpowerId, type) VALUES (?,?,?,?)";
        jdbc.update(SQL_CREATE, model.getName(), model.getDescription(), model.getSuperpower().getSuperpowerId(), model.getType());

        int id = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        model.setCharacterId(id);
        insertIntoOrganization(model);
        return model;
    }

    @Override
    public List<Characters> readAll() {
        final String SQL_READALL = "SELECT * FROM characters";
        List<Characters> charList = jdbc.query(SQL_READALL, new CharacterMapper());
        associateOrganization(charList);
        for (Characters character : charList) {
            character = getSuperpowerForCharacter(character);
        }
        return charList;
    }

    @Override
    public Characters readById(int id) {
        final String SQL_READ_BY_ID = "SELECT * FROM characters WHERE characterId = ?";
        Characters character = jdbc.queryForObject(SQL_READ_BY_ID, new CharacterMapper(), id);
        character.setOrganizations(organizationDao.getOrganizationByCharacterId(id));
        character = getSuperpowerForCharacter(character);
        return character;
    }

    public void associateOrganization(List<Characters> characters) {
        for(Characters character : characters) {
            character.setOrganizations(organizationDao.getOrganizationByCharacterId(character.getCharacterId()));
        }
    }
    
    public void insertIntoOrganization(Characters character){
        final String SQL_INSERT_ORGANIZATION_CHARACTERS = "INSERT INTO organization_character (characterId, organizationId) VALUES (?,?)";
        for(Organization organization : character.getOrganizations()){
            jdbc.update(SQL_INSERT_ORGANIZATION_CHARACTERS, character.getCharacterId(),organization.getOrganizationId());
        }
    }

    @Override
    public void update(Characters model) {
        final String SQL_UPDATE = "UPDATE characters SET " +
                "name = ?, " +
                "description = ?, " +
                "superpowerId = ?, " +
                "type = ?" +
                "WHERE characterID = ?";
        jdbc.update(SQL_UPDATE, model.getName(), model.getDescription(), model.getSuperpower().getSuperpowerId(), model.getType(), model.getCharacterId());
        insertIntoOrganization(model);

    }

    @Override
    public void delete(int id) {
        final String SQL_DELETE_ORGANIZATION_CHARACTER = "DELETE FROM organization_character WHERE characterId = ?";
        jdbc.update(SQL_DELETE_ORGANIZATION_CHARACTER, id);
        final String SQL_DELETE_SIGHTING = "DELETE FROM sighting WHERE characterId = ?";
        jdbc.update(SQL_DELETE_SIGHTING, id);
        final String SQL_DELETE_CHARACTER = "DELETE FROM characters WHERE characterId = ?";
        jdbc.update(SQL_DELETE_CHARACTER, id);
    }

    public Characters getSuperpowerForCharacter (Characters character) {
        final String SQL = "SELECT superpowerId from characters WHERE characterId = ?";
        int superpowerId = jdbc.queryForObject(SQL,Integer.class, character.getCharacterId());
        character.setSuperpower(superpowerDao.readById(superpowerId));
        return character;
    }

}
