package SocialNetwork;

import Users.User;

import java.util.ArrayList;
import java.util.List;

public class Retea {
    private List<User> users=new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        this.users.add(user);
    }
    public Boolean verificareUser(String name){
        for(User user:users)
            if(user.getName().equals(name))
                return true;
        return false;
    }
    public User getUser(String name){
        for(User user:users)
            if(user.getName().equals(name))
                return user;
        return null;
    }
}
