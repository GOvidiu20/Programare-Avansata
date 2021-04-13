import java.sql.SQLException;
import java.util.List;


public interface Dao <T>{
    T getById(String id) throws SQLException;
    T getByName(String name) throws SQLException;
    List<T> getAll() throws SQLException;
    void insert(T t) throws SQLException;
    void delete(String id) throws SQLException;
}
