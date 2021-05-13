package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    PersonController(){
        String sql = "INSERT INTO Persons (id,name) VALUES (?, ?)";
        jdbcTemplate.update(sql, 1,"ovidiu");
    }
    @GetMapping
    public List<Person> getPersons() {
        System.out.println("salut");
        PersonDao personDao=new PersonDao();
        return personDao.selectAll();
    }
    @PostMapping("/add/{name}")
    public int createPerson(@PathVariable String name) {
        PersonDao personDao=new PersonDao();
        personDao.addPerson(name);
        return 200;
    }
    @PutMapping("/{id}/{name}")
    public int updatePerson(@PathVariable int id,@PathVariable String name) {
        PersonDao personDao=new PersonDao();
        personDao.updatePerson(id,name);
        return 200;
    }
    @DeleteMapping(value = "/{id}")
    public int deletePerson(@PathVariable int id){
        PersonDao personDao=new PersonDao();
        personDao.deletePerson(id);
        return 200;
    }
}
