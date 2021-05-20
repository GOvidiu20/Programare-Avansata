package Controller;

import SocialNetwork.Retea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@RestController
public class PersonDao {


    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> selectAll(){
        String sql = "SELECT * FROM persons";

        List<Person> listPersons = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Person.class));

        return listPersons;
    }
    public void addPerson(String name){
        String sql = "INSERT INTO persons (name) VALUES (?)";
        jdbcTemplate.update(sql, name);
    }
    public Person updatePerson(int id,String name){
        String sql = "UPDATE persons SET name=? WHERE id=?";
        Object[] params = {id, name};
        jdbcTemplate.update(sql, params);
        return new Person(id,name);
    }
    public Person deletePerson(int id){
        String sql = "Select name persons where id=?";
        String name= jdbcTemplate.queryForObject(
                sql, new Object[]{id}, String.class);

        sql = "DELETE from persons where id=?";
        jdbcTemplate.update(sql, id);

        return new Person(id,name);
    }
    public Boolean verificare(int id){
        String sql = "SELECT count(*) FROM persons where id=?";
        int nr=jdbcTemplate.update(sql, id);
        if(nr>0)
            return TRUE;
        return FALSE;
    }
    public int takeID(String name){
        String sql = "SELECT id FROM persons where name=?";
        int id=jdbcTemplate.update(sql, name);
        return id;
    }
    public Person takePerson(String name){
        Person person=new Person();
        String sql = "SELECT id FROM persons where name=?";
        int id=jdbcTemplate.update(sql, name);
        person.setId(id);
        person.setName(name);
        return person;
    }
}
