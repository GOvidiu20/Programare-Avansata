package com.jpa;

import EntiyPack.Movie;
import Repositories.MovieRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class JPA {

    public static void main(String[] args) {
        EntityManager entityMgr = Singleton.getEntityManager();
        entityMgr.getTransaction().begin();
        Movie movie = new Movie(1,"Harry Potter","2000-11-10",150,5);
        entityMgr.persist(movie);
        entityMgr.getTransaction().commit();
        List<Movie> movies=new ArrayList<>();
        MovieRepository movieRepository=new MovieRepository(entityMgr);
        movieRepository.create(movie);
        Movie movie1=new Movie();
        movie1=movieRepository.getMovieById(2);
        System.out.println(movie1.getTitle());
        entityMgr.clear();
    }
}