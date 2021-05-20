package Optional;

import Controller.Person;
import Controller.PersonDao;
import SocialNetwork.Retea;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping("/relationships")
public class RelationshipsController {
    Relationships relationships;
    Retea retea;
    public RelationshipsController( Relationships relationships,Retea retea){
        this.relationships=relationships;
        this.retea=retea;
    }
    @PostMapping("/addRelationship/{name1}/{name2}")
    public HttpStatus createPerson(@PathVariable String name1, @PathVariable String name2) {

        Vertex vertex1=new Vertex(retea.getUser(name1));
        Vertex vertex2=new Vertex(retea.getUser(name2));
        relationships.addRelationship(vertex1,vertex2);
        return HttpStatus.OK;
    }
}
