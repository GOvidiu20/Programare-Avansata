package Users;

import SocialNetwork.Retea;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String pass;
    private List<String> friends=new ArrayList<>();
    private List <String> messages=new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public void addMessge(String message){
        messages.add(message);
    }
    public void addFriend(String name){
        friends.add(name);
    }
    public void giveMessage(Retea retea,String message){
        User user=new User();
        for(String friend:friends){
            user=retea.getUser(friend);
            user.addMessge(message);
        }
    }
}
