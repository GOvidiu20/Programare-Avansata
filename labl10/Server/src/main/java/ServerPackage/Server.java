package ServerPackage;

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
        try {
            serverSocket = new ServerSocket(PORT);
            while (running) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();

                if(running)
                    new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err. println ("Ooops... " + e);
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