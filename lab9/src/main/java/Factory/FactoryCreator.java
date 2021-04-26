package Factory;

import Repositories.MovieRepository;
import Repositories.Repository;

import javax.persistence.EntityManager;

public class FactoryCreator {
    Connection connection;
    FactoryCreator(){
        ConnectionFactory connectionFactory=new ConnectionFactory();
        connection = connectionFactory.getConnection("JPA");

    }
    public Repository getRepo(){
            return new MovieRepository((EntityManager) connection.getConnect());
    }
}
