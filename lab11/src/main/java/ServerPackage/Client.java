package ServerPackage;

import Controller.Person;
import Controller.PersonDao;
import SocialNetwork.Retea;

import java.util.List;

class Client {
    private Retea retea;
    public Client(Retea retea){
        this.retea=retea;
    }
    public void PersonCommunication(){
            PersonDao personDao=new PersonDao();
            Boolean ok = true;
            Boolean login = false;
            Person currentUser = new Person();
            while (ok) {

                String raspuns = new String();
                String[] requestInWords =null;
                Person person = new Person();
                switch (requestInWords[0]) {
                    case "stop": {
                        raspuns = "Server stopped!";
                        break;
                    }
                    case "exit": {
                        raspuns = "Connection stopped!";
                        ok = Boolean.FALSE;
                        break;
                    }
                    case "register": {
                        int id=personDao.takeID(requestInWords[1]);
                        if (!retea.verificareUser(id)) {
                            personDao.addPerson(requestInWords[1]);
                            raspuns = "Registered successfully";
                        } else
                            raspuns = "This name is already register";
                        break;
                    }
                    case "login": {
                        int id=personDao.takeID(requestInWords[1]);
                        if (!retea.verificareUser(id)) {
                            currentUser = personDao.takePerson(requestInWords[1]);
                            login = true;
                            raspuns = "Login successfully";
                        } else
                            raspuns = "You are not register";
                        break;
                    }
                    case "friend": {
                        if (login) {
                            for (int i = 1; i < requestInWords.length; i++) {
                                int id=personDao.takeID(requestInWords[1]);
                                if (!retea.verificareUser(id))
                                    currentUser.addFriend(requestInWords[i]);
                            }
                            raspuns = "Friends added";
                        } else
                            raspuns = "You are not login";
                        break;
                    }
                    case "message": {
                        currentUser.giveMessage(retea, requestInWords[1]);
                        raspuns = "Message send";
                        break;
                    }
                    case "read": {
                        List<String> messages = currentUser.getMessages();
                        for (String message : messages)
                            raspuns.concat(message);
                        break;
                    }
                    case "logout": {
                        login = false;
                        raspuns = "logout successfully";
                        break;
                    }
                    default:
                        raspuns = "Unknown command";
                }

            }
    }
}