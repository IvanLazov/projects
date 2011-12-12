package com.clouway.networkandgui.serverclients;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

/**
 * This class implements Runnable, so that the server
 * can send in the background to all other connected clients
 * a message which tells them that a new client is connected
 * to the server
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ServerThread implements Runnable {

    private final Map<Socket, ObjectOutputStream> outputStreams; // contains all currently connected clients

    public ServerThread(Map<Socket, ObjectOutputStream> outputStreams) {

        this.outputStreams = outputStreams;
    }


    /**
     * Sends to every client a message that a new client has connected
     */
    public void run() {
        
        try {

            int numberOfConnectedClients = outputStreams.size();

            for (Map.Entry<Socket, ObjectOutputStream> e : outputStreams.entrySet()) {
                e.getValue().writeObject("SERVER: Client " + numberOfConnectedClients + " connected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
