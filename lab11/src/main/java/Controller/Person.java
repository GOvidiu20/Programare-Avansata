package Controller;

import SocialNetwork.Retea;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private int id;
    private String name;

    private List<String> friends=new ArrayList<>();
    private List <String> messages=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Person(){}
    public List<String> getMessages() {
        return messages;
    }
    public void addMessge(String message){
        messages.add(message);
    }
    public void addFriend(String name){
        friends.add(name);
    }
    public void giveMessage(Retea retea, String message){
        Person user=new Person();
        for(String friend:friends){
            user=retea.getUser(friend);
            user.addMessge(message);
        }
    }
}
