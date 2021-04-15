import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DateBaseConnection {

    private static Connection con=null;

    public static Connection getConnection()
    {
            String url = "jdbc:mysql://localhost/mysql" ;
            try {
                con = DriverManager.getConnection(
                        url, "root", "ovidiu");

            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        return con;
    }
}