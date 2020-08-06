package com.tij.superhero.dao;

import com.tij.superhero.model.Characters;
import com.tij.superhero.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizationDao<T> implements Dao<Organization> {

    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    LocationDao locationDao;

    @Override
    public Organization create(Organization model) {
        final String SQL_CREATE = "INSERT INTO organization (name, description, locationId, phone, email) VALUES (?,?,?,?,?)";
        jdbc.update(SQL_CREATE, model.getName(), model.getDescription(), model.getLocation().getLocationId(), model.getPhone(), model.getEmail());

        int id = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        model.setOrganizationId(id);

        return model;
    }

    @Override
    public List<Organization> readAll() {
        final String SQL_READALL = "SELECT * FROM organization";
        List<Organization> organizations = jdbc.query(SQL_READALL, new OrganizationMapper());
        for (Organization organization : organizations) {
            organization = getLocationForOrganization(organization);
        }
        return organizations;
    }

    @Override
    public Organization readById(int id) {
        final String SQL_READ_BY_ID = "SELECT * FROM organization WHERE organizationId = ?";
        Organization organization =  jdbc.queryForObject(SQL_READ_BY_ID, new OrganizationMapper(), id);
        organization.setCharacters(getCharacterByOrganization(id));
        organization = getLocationForOrganization(organization);
        return organization;
    }

    @Override
    public void update(Organization model) {
        final String SQL_UPDATE = "UPDATE organization SET " +
                "name = ?, " +
                "description = ?, " +
                "locationId = ?, " +
                "email = ?, " +
                "phone = ? " +
                "WHERE organizationId = ?";
        jdbc.update(SQL_UPDATE, model.getName(), model.getDescription(), model.getLocation().getLocationId(), model.getEmail(), model.getPhone(), model.getOrganizationId());
    }

    @Override
    public void delete(int id) {
        final String SQL_DELETE_ORGANIZATION_CHARACTER = "DELETE FROM organization_character WHERE organizationId = ?";
        jdbc.update(SQL_DELETE_ORGANIZATION_CHARACTER, id);
        final String SQL_DELETE_ORGANIZATION = "DELETE FROM organization WHERE organizationId = ?";
        jdbc.update(SQL_DELETE_ORGANIZATION, id);
    }

    public List<Organization> getOrganizationByCharacterId(int id) {
        final String SELECT_ORGANIZATION_FOR_CHARACTER = "SELECT o.* FROM organization o " +
                "JOIN organization_character oc ON o.organizationId = oc.organizationId " +
                "WHERE oc.characterId = ?";

        List<Organization> organizations = jdbc.query(SELECT_ORGANIZATION_FOR_CHARACTER, new OrganizationMapper(), id);
        for (Organization organization : organizations) {
            organization = getLocationForOrganization(organization);
        }

        return organizations;
    }

    private void associateCharacter(List<Organization> organizations) {
        for(Organization organization : organizations) {
            organization.setCharacters(getCharacterByOrganization(organization.getOrganizationId()));
        }

    }

    public List<Characters> getCharacterByOrganization(int id) {
        final String SELECT_CHARACTER_FOR_ORGANIZATION = "SELECT c.* FROM characters c " +
                "JOIN organization_character oc ON c.characterId = oc.characterId " +
                "WHERE oc.organizationId = ?";

        return jdbc.query(SELECT_CHARACTER_FOR_ORGANIZATION, new CharacterMapper(), id);
    }

    public Organization getLocationForOrganization (Organization organization) {
        final String SQL = "SELECT locationId from organization WHERE organizationId = ?";
        int locationId = jdbc.queryForObject(SQL,Integer.class, organization.getOrganizationId());
        organization.setLocation(locationDao.readById(locationId));
        return organization;
    }
}
