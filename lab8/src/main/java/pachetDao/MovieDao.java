package pachetDao;

import Objects.Movie;
import dataBase.DateBaseConnection;
import pachetDao.Dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieDao implements Dao<Movie> {
    @Override
    public Movie getById(int id) throws SQLException {
        Movie movie=new Movie();
        Connection con= DateBaseConnection.getConnection();
        Statement stmt = con.createStatement();
        String sql="Select * from movies where id="+id;
        ResultSet rs=stmt.executeQuery(sql);
        rs.next();
        movie.setId(Integer.parseInt(rs.getString(1)));
        movie.setTitle(rs.getString(2));
        movie.setRelease_date(LocalDate.parse(rs.getString(3)));
        movie.setDuration(Integer.parseInt(rs.getString(4)));
        movie.setScore(Integer.parseInt(rs.getString(5)));
        return movie;
    }

    @Override
    public Movie getByName(String name) throws SQLException {
        Movie movie=new Movie();
        Connection con= DateBaseConnection.getConnection();
        Statement stmt = con.createStatement();
        String sql="Select * from movies where id="+name;
        ResultSet rs=stmt.executeQuery(sql);
        rs.next();
        movie.setId(Integer.parseInt(rs.getString(1)));
        movie.setTitle(rs.getString(2));
        movie.setRelease_date(LocalDate.parse(rs.getString(3)));
        movie.setDuration(Integer.parseInt(rs.getString(4)));
        movie.setScore(Integer.parseInt(rs.getString(5)));
        return movie;
    }

    @Override
    public List getAll() throws SQLException {
        List<Movie> movies=new ArrayList<>();
        Connection con= DateBaseConnection.getConnection();
        Statement stmt = con.createStatement();
        String sql="Select * from movies";
        ResultSet rs=stmt.executeQuery(sql);
        while (rs.next()) {
            Movie movie=new Movie();
            movie.setId(Integer.parseInt(rs.getString(1)));
            movie.setTitle(rs.getString(2));
            movie.setRelease_date(LocalDate.parse(rs.getString(3)));
            movie.setDuration(Integer.parseInt(rs.getString(4)));
            movie.setScore(Integer.parseInt(rs.getString(5)));
            movies.add(movie);
        }
        return movies;
    }

    @Override
    public void insert(Movie movie) throws SQLException {
        Connection con= DateBaseConnection.getConnection();
        String sql="Insert into movies (title,release_date,duration,score) values(?,?,?,?)";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setString(1,movie.getTitle());
        stmt.setDate(2, java.sql.Date.valueOf(movie.getRelease_date()));
        stmt.setInt(3,movie.getDuration());
        stmt.setInt(4,movie.getScore());
        stmt.executeUpdate();
        con.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection con= DateBaseConnection.getConnection();
        Statement stmt = con.createStatement();
        String sql="Delete from movies where id="+id;
        stmt.executeUpdate(sql);
    }
}
