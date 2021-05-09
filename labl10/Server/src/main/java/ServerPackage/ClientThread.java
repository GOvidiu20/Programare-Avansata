package ServerPackage;

import SocialNetwork.Retea;
import Users.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

class ClientThread extends Thread {
    private Socket socket;
    private Retea retea;

    public ClientThread(Socket socket, Retea retea) {
        this.socket = socket;
        this.retea = retea;
    }

    public void run() {
        try {
            Boolean ok = true;
            Boolean login = false;
            User currentUser = new User();
            while (ok) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();

                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String raspuns = new String();
                String[] requestInWords = getInput(request);
                User user = new User();
                switch (requestInWords[0]) {
                    case "stop": {
                        raspuns = "Server stopped!";
                        Server.setRunning(false);
                        break;
                    }
                    case "exit": {
                        raspuns = "Connection stopped!";
                        ok = Boolean.FALSE;
                        break;
                    }
                    case "register": {
                        if (!retea.verificareUser(requestInWords[1])) {
                            user.setName(requestInWords[1]);
                            retea.addUser(user);
                            raspuns = "Registered successfully";
                        } else
                            raspuns = "This name is already register";
                        break;
                    }
                    case "login": {
                        if (retea.verificareUser(requestInWords[1])) {
                            currentUser = retea.getUser(requestInWords[1]);
                            login = true;
                            raspuns = "Login successfully";
                        } else
                            raspuns = "You are not register";
                        break;
                    }
                    case "friend": {
                        if (login) {
                            for (int i = 1; i < requestInWords.length; i++)
                                if (retea.verificareUser(requestInWords[i]))
                                    currentUser.addFriend(requestInWords[i]);
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

                out.println(raspuns);
                out.flush();
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    public static String[] getInput(String request) {
        String []s=null;
        try {
            s= request.split("\\s+");
        }catch (NullPointerException e){
            System.err.println(e);
        }
        return s;
    }
}