package it.academy.homework2.dao;

import java.util.List;

public interface Dao<T> {
    void create(T record);
    List<T> readAll();
}
