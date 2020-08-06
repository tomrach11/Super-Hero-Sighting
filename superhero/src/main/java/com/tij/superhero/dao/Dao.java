package com.tij.superhero.dao;

import java.util.List;

public interface Dao<T> {
    public T create(T model);
    public List<T> readAll();
    public T readById(int id);
    public void update(T model);
    public void delete(int id);
}
