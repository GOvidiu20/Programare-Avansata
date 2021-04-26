package Repositories;

import EntiyPack.Movie;

import java.sql.SQLException;

public interface Repository<T> {
    T getById(int id) throws SQLException;
    void create(T b) throws SQLException;
}

