package com.tij.superhero.model;

public class Superpower {
    private int superpowerId;
    private String type;

    public int getSuperpowerId() {
        return superpowerId;
    }

    public void setSuperpowerId(int superpowerId) {
        this.superpowerId = superpowerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Superpower)) return false;

        Superpower that = (Superpower) o;

        if (getSuperpowerId() != that.getSuperpowerId()) return false;
        return getType() != null ? getType().equals(that.getType()) : that.getType() == null;
    }

    @Override
    public int hashCode() {
        int result = getSuperpowerId();
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }
}
