import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.CharBuffer;

public class Server {
    static final int port = 1200;

    public static void main(String[] args) throws Exception {
        // Listen to a specific port

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = serverSocket.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out
        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        // create a DataInputStream so we can read data from it.
        // read the message from the socket
        String ch = inServer.readLine();
        //Delete all vowels and send reply to client
        ch = ch.replaceAll("[aeiouyAEIOUY]", "");
        outServer.println(ch);
        System.out.println("Closing sockets.");
        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
        serverSocket.close();
    }
}
