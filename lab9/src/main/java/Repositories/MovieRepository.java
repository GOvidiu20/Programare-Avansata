package Repositories;

import EntiyPack.Movie;

import javax.persistence.*;


@NamedQueries({
        @NamedQuery(name = "MovieRepository.findByTitle",
                query = "SELECT m FROM Movie m WHERE m.title=:title")
})
public class MovieRepository implements Repository{

    private EntityManager em;
    public MovieRepository(EntityManager em) {
        this.em = em;
    }
    @Override
    public Movie getById(int id) {
        return em.find(Movie.class, id);
    }
    @Override
    public void create(Object b) {
        em.persist(b);
        System.out.println("Create successfuly");
    }
}
