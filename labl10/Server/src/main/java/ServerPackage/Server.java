package ServerPackage;

import JGraphT.Graph;
import SocialNetwork.Retea;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    public static Boolean running;
    public Server() throws IOException {
        ServerSocket serverSocket = null ;
        setRunning(true);
        Retea retea=new Retea();
        try {
            serverSocket = new ServerSocket(PORT);
            while (running) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                if(running)
                    new ClientThread(socket,retea).start();
            }
            Graph graph=new Graph(retea);
            graph.GraphGenerator();
        } catch (IOException e) {
            System.err. println ("Ooops... " + e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }

    public static Boolean getRunning() {
        return running;
    }
    public static void setRunning(Boolean running) {
        Server.running = running;
    }

    public static void main (String [] args ) throws IOException {
        Server server = new Server ();
    }
}