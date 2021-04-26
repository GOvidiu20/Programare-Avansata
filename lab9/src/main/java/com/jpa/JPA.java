package com.jpa;

import AbstractRepository.CrudRepo;
import Charts.Charturi;
import EntiyPack.Movie;
import Repositories.MovieRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.core.ResolvableType;

import javax.persistence.EntityManager;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JPA {

    public static void main(String[] args) {
        EntityManager entityMgr = Singleton.getEntityManager();
        entityMgr.getTransaction().begin();
        Movie movie = new Movie(1,"Harry Potter","2000-11-10",150,5);
        //entityMgr.persist(movie);
        entityMgr.getTransaction().commit();
        List<Movie> movies=new ArrayList<>();
        MovieRepository movieRepository=new MovieRepository(entityMgr);
        movieRepository.create(movie);
        Movie movie1=new Movie();
        movie1=movieRepository.getById(2);

        //creem charturi cu ajutorul Swing
        EventQueue.invokeLater(() -> {

            var ex = new Charturi();
            ex.setVisible(true);
        });
        entityMgr.clear();

        CrudRepo crudRepo = null;
        Movie movie2 = crudRepo.save(movie);

    }
}