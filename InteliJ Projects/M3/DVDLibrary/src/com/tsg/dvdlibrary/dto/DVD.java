package com.tsg.dvdlibrary.dto;

import java.time.LocalDate;

public class DVD {
    private String title;
    private LocalDate releaseDate;
    private String mpaaRating;
    private String director;
    private String studio;
    private String note;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        String releaseDateString = releaseDate.toString();
        return releaseDateString;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = LocalDate.parse(releaseDate);
    }

    public LocalDate getReleaseDateAsLocalDate() {
        return releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DVD)) return false;

        DVD dvd = (DVD) o;

        if (!getTitle().equals(dvd.getTitle())) return false;
        if (!getReleaseDate().equals(dvd.getReleaseDate())) return false;
        if (!getMpaaRating().equals(dvd.getMpaaRating())) return false;
        if (!getDirector().equals(dvd.getDirector())) return false;
        if (!getStudio().equals(dvd.getStudio())) return false;
        return getNote().equals(dvd.getNote());
    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getReleaseDate().hashCode();
        result = 31 * result + getMpaaRating().hashCode();
        result = 31 * result + getDirector().hashCode();
        result = 31 * result + getStudio().hashCode();
        result = 31 * result + getNote().hashCode();
        return result;
    }
}
