package com.tij.superhero.dao;

import com.tij.superhero.model.Organization;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizationMapper implements RowMapper<Organization> {
    @Override
    public Organization mapRow(ResultSet resultSet, int i) throws SQLException {
        Organization org = new Organization();

        org.setOrganizationId(resultSet.getInt("organizationId"));
        org.setName(resultSet.getString("name"));
        org.setDescription(resultSet.getString("description"));
        org.setPhone(resultSet.getString("phone"));
        org.setEmail(resultSet.getString("email"));

        return org;
    }
}
