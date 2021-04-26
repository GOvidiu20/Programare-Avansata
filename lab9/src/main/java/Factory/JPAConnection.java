package Factory;

import com.JDBC.JDBCSingleton;
import com.jpa.Singleton;

import javax.persistence.EntityManager;

public class JPAConnection implements Connection{

    public String name;
    JPAConnection(){
        this.name="JPA";
    }
    @Override
    public String getName() {
        return name;
    }
    public EntityManager getConnect(){
        return Singleton.getEntityManager();
    }
}
