package Factory;

import com.JDBC.JDBCSingleton;

public class JDBCConnection implements Connection{

        public String name;
        JDBCConnection(){
            this.name="JDBC";
        }
        @Override
        public String getName() {
            return name;
        }
        public java.sql.Connection getConnect(){
            return JDBCSingleton.getConnection();
        }
}
