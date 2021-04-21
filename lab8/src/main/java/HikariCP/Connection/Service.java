package HikariCP.Connection;

import HikariCP.HikariConfig.DataSource;
import Objects.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    public static List<Movie> fetchData() throws SQLException {
        String SQL_QUERY = "select * from movies where id=11";
        List<Movie> movies = null;
        try (Connection con = DataSource.getConnection();
             PreparedStatement pst = con.prepareStatement( SQL_QUERY );
             ResultSet rs = pst.executeQuery();) {
            movies = new ArrayList<>();
            Movie movie;
            while ( rs.next() ) {
                movie = new Movie();
                movie.setId( rs.getInt( "id" ) );
                movie.setTitle( rs.getString( "title" ) );
                movie.setRelease_date( LocalDate.parse( "release_date" ) );
                movie.setDuration( rs.getInt( "duration" ) );
                movie.setScore( rs.getInt( "score" ));
                movies.add( movie );
            }
        }
        return movies;
    }
}
