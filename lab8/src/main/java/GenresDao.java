import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenresDao implements Dao<Genres>{
    @Override
    public Genres getById(int id) throws SQLException {
        Genres genres=new Genres();
        Connection con=DateBaseConnection.getConnection();
        Statement stmt = con.createStatement();
        String sql="Select * from genres where id="+id;
        ResultSet rs=stmt.executeQuery(sql);
        rs.next();
        genres.setId(Integer.parseInt(rs.getString(1)));
        genres.setName(rs.getString(2));
        return genres;
    }

    @Override
    public Genres getByName(String name) throws SQLException {
        Genres genres=new Genres();
        Connection con=DateBaseConnection.getConnection();
        Statement stmt = con.createStatement();
        String sql="Select * from genres where name="+name;
        ResultSet rs=stmt.executeQuery(sql);
        rs.next();
        genres.setId(Integer.parseInt(rs.getString(1)));
        genres.setName(rs.getString(2));
        return genres;
    }

    @Override
    public List<Genres> getAll() throws SQLException {
        Genres genres=new Genres();
        List<Genres> genresx=new ArrayList<>();
        Connection con=DateBaseConnection.getConnection();
        Statement stmt = con.createStatement();
        String sql="Select * from genres";
        ResultSet rs=stmt.executeQuery(sql);
        while (rs.next()) {
            genres.setId(Integer.parseInt(rs.getString(1)));
            genres.setName(rs.getString(2));
            genresx.add(genres);
        }
        return genresx;
    }

    @Override
    public void insert(Genres genres) throws SQLException {
        Connection con=DateBaseConnection.getConnection();
        String sql="Insert into genres (name) values (?)";
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setString(1,genres.getName());
        stmt.executeUpdate();
        con.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection con=DateBaseConnection.getConnection();
        Statement stmt = con.createStatement();
        String sql="Delete from genres where id="+id;
        stmt.executeUpdate(sql);
    }
}
