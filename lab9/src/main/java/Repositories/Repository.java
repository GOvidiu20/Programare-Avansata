package Repositories;

import EntiyPack.Movie;

public interface Repository {
    Movie getMovieById(int id);
    void create(Movie b);
}

