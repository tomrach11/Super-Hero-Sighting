package com.tij.superhero.model;

import java.util.List;

public class Characters {
    private int characterId;
    private String name;
    private String description;
    private Superpower superpower;
    private String type;
    private List<Organization> organizations;

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Superpower getSuperpower() {
        return superpower;
    }

    public void setSuperpower(Superpower superpower) {
        this.superpower = superpower;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Characters)) return false;

        Characters that = (Characters) o;

        if (getCharacterId() != that.getCharacterId()) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        if (getSuperpower() != null ? !getSuperpower().equals(that.getSuperpower()) : that.getSuperpower() != null)
            return false;
        if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) return false;
        return getOrganizations() != null ? getOrganizations().equals(that.getOrganizations()) : that.getOrganizations() == null;
    }

    @Override
    public int hashCode() {
        int result = getCharacterId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getSuperpower() != null ? getSuperpower().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getOrganizations() != null ? getOrganizations().hashCode() : 0);
        return result;
    }
}
