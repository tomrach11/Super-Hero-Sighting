package com.tij.superhero.model;

import java.time.LocalDate;

public class Sighting {
    private int sightingId;
    private Characters character;
    private Location location;
    private LocalDate date;

    public int getSightingId() {
        return sightingId;
    }

    public void setSightingId(int sightingId) {
        this.sightingId = sightingId;
    }

    public Characters getCharacter() {
        return character;
    }

    public void setCharacter(Characters character) {
        this.character = character;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sighting)) return false;

        Sighting sighting = (Sighting) o;

        if (getSightingId() != sighting.getSightingId()) return false;
        if (getCharacter() != null ? !getCharacter().equals(sighting.getCharacter()) : sighting.getCharacter() != null)
            return false;
        if (getLocation() != null ? !getLocation().equals(sighting.getLocation()) : sighting.getLocation() != null)
            return false;
        return getDate() != null ? getDate().equals(sighting.getDate()) : sighting.getDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getSightingId();
        result = 31 * result + (getCharacter() != null ? getCharacter().hashCode() : 0);
        result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        return result;
    }
}
