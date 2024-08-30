package JavaNetworking.TCP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TCPServer {
    public static Set<UserManagerThread> loggedInUsers = new HashSet<>();
    private final int openPort;
    private final ServerSocket serverSocket;

    public TCPServer(int openPort) throws IOException {
        System.out.println("Server is starting...");
        this.openPort = openPort;
        serverSocket = new ServerSocket(this.openPort);
        System.out.println("Server has started successfully!");
    }

    public void waitForConnections() throws IOException {
        System.out.println("Waiting for connections on: " + openPort);
        while (!serverSocket.isClosed()) {
            Socket newSocket = serverSocket.accept();
            System.out.printf("New connection with: %s:%d\n", newSocket.getInetAddress(), newSocket.getLocalPort());
            UserManagerThread userManager = new UserManagerThread(newSocket);
            userManager.start();
            loggedInUsers.add(userManager);
        }
    }

    private void announceNewConnection(BufferedWriter writer){

    }
}


