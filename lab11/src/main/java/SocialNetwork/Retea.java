package SocialNetwork;

import Controller.Person;
import Controller.PersonDao;


public class Retea {
    PersonDao personDao=new PersonDao();

    public void addUser(Person person){
        personDao.addPerson(person.getName());
    }
    public Boolean verificareUser(int id){
        if(personDao.verificare(id)==0)
            return false;
        return true;
    }
    public Person getUser(String name){
        return personDao.takePerson(name);
    }
}
