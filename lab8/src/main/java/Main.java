import HikariCP.Connection.Service;
import JavaFX.Interfata;
import Objects.Genres;
import Objects.Movie;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import pachetDao.GenresDao;
import pachetDao.MovieDao;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main (String[] args) throws SQLException {
        Movie movie = new Movie(3000, "film1", LocalDate.parse("2011-04-10"), 100, 3);
        MovieDao x = new MovieDao();
        x.insert(movie);
        System.out.println(x.getById(124).toString());
        x.delete(2000);
        List listMovies = x.getAll();
        for (int i = 0; i < listMovies.size(); i++)
            System.out.println(listMovies.get(i).toString());

        Genres genres = new Genres(6, "Romance");
        GenresDao y = new GenresDao();
        y.insert(genres);
        System.out.println(y.getById(1));
        List listGenres = y.getAll();
        for (int i = 0; i < listGenres.size(); i++)
            System.out.println(listGenres.get(i).toString());

        try {
            Controller.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FreeMarker.freeMarker();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Movie> movieList=Service.fetchData();
        System.out.println(movieList.get(0).getTitle());
    }
}
