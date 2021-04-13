import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DateBaseConnection {

    public static Connection getConnection()
    {
            String url = "jdbc:mysql://localhost/mysql" ;
            try {
                Connection con = DriverManager.getConnection(
                        url, "root", "ovidiu");

                return con;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }
}