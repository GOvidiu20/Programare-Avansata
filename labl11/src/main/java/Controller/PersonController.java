package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/persons")
@RestControllerAdvice
public class PersonController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    PersonController(){
        String sql = "INSERT INTO Persons (id,name) VALUES (?, ?)";
        jdbcTemplate.update(sql, 1,"ovidiu");
    }
    @GetMapping
    public List<Person> getPersons() {
        try {
            PersonDao personDao=new PersonDao();
            return (List<Person>) new ResponseEntity<>(personDao.selectAll(), HttpStatus.OK);
        } catch (Exception e) {
            return (List<Person>) new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/add/{name}")
    public HttpStatus createPerson(@PathVariable String name) {
        PersonDao personDao=new PersonDao();
        personDao.addPerson(name);
        return HttpStatus.OK;
    }
    @PutMapping("/{id}/{name}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @PathVariable String name) {
        PersonDao personDao=new PersonDao();

        if (personDao.verificare(id)) {
            return new ResponseEntity<Person>(personDao.updatePerson(id,name), HttpStatus.OK);
        } else {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable int id){
        PersonDao personDao=new PersonDao();
        personDao.deletePerson(id);
        if (personDao.verificare(id)) {
            return new ResponseEntity<Person>(personDao.deletePerson(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
    }
}
