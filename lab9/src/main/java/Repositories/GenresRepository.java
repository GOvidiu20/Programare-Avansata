package Repositories;

import EntiyPack.Genres;

import java.sql.*;

public class GenresRepository implements Repository{
    private Connection con;
    public GenresRepository(Connection con) {
        this.con = con;
    }
    @Override
    public Genres getById(int id) throws SQLException {
        Genres genres=new Genres();
        Statement stmt = con.createStatement();
        String sql="Select * from genres where id="+id;
        ResultSet rs=stmt.executeQuery(sql);
        rs.next();
        genres.setId(Integer.parseInt(rs.getString(1)));
        genres.setName(rs.getString(2));
        return genres;
    }
    @Override
    public void create(Object genres) throws SQLException {
        String sql="Insert into genres (name) values (?)";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setString(1,genres.getName());
        stmt.executeUpdate();
        con.close();
        System.out.println("Create successfuly");
    }

}
