package Factory;

public class ConnectionFactory extends AbstractFactory{
    @Override
    public Connection getConnection(String connection) {
        if(connection.equals("JDBC"))
            return new JDBCConnection();
        else
            if(connection.equals("JPA"))
                return new JPAConnection();
            else return null;
    }
}
