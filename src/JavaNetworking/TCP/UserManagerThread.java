package JavaNetworking.TCP;

import java.io.*;
import java.net.Socket;

public class UserManagerThread extends Thread{
    Socket communicationSocket;
    BufferedReader reader;
    BufferedWriter writer;

    public UserManagerThread(Socket communicationSocket) throws IOException {
        this.communicationSocket = communicationSocket;
        reader = new BufferedReader(new InputStreamReader(communicationSocket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(communicationSocket.getOutputStream()));
    }

    @Override
    public void run() {

    }
}
