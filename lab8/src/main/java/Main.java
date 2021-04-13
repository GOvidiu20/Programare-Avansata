import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main (String[] args) throws SQLException {
        Movie movie = new Movie("126", "film1", LocalDate.parse("2011-04-10"), 100, 3);
        MovieDao x = new MovieDao();
        x.insert(movie);
        System.out.println(x.getById("123").toString());
        x.delete("123");
        List listMovies = x.getAll();
        for (int i = 0; i < listMovies.size(); i++)
            System.out.println(listMovies.get(i).toString());

        Genres genres = new Genres("6", "Romance");
        GenresDao y = new GenresDao();
        y.insert(genres);
        System.out.println(y.getById("1"));
        List listGenres = y.getAll();
        for (int i = 0; i < listGenres.size(); i++)
            System.out.println(listGenres.get(i).toString());
    }
}
