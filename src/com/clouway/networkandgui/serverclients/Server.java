package com.clouway.networkandgui.serverclients;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Map;

/**
 * This class provides the server's functionality.
 * It has a map in which every accepted client connection
 * is saved, so that when a new client is connected,
 * the server can send to the other clients that a new client
 * is connected
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Server {
    
    private int counter = 0;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectOutputStream output;
    private Map<Socket, ObjectOutputStream> outputStreams = new Hashtable<Socket, ObjectOutputStream>();
    private MessageListener listener; // this object is used to display new messages on the Server's display area
    private ServerThread serverThread; // this object implements Runnable, so that in the background it can send messages to the other connected clients

    public Server() {

         serverThread = new ServerThread(outputStreams);
    }

    /**
     * Start server on specified port
     *
     * @throws IOException If an error occurs while binding the server to the port
     */
    public void startServer() throws IOException {

        setSocket();
        listener.onDisplayMessage(new MessageEvent("Server started on port " + serverSocket.getLocalPort()));

        while (true) {

            acceptClient();
            listener.onDisplayMessage(new MessageEvent("Client " + counter + " connected"));

            sendMessageToClient();
            listener.onDisplayMessage(new MessageEvent("Server sent message"));

            outputStreams.put(clientSocket, output);

            new Thread(serverThread).start();
        }
    }

    /**
     * Binds server to specified port
     *
     * @throws IOException If the server cannot be bound to this port
     */
    public void setSocket() throws IOException {

        serverSocket = new ServerSocket(12345);
    }

    /**
     * Send message to every new connected client
     *
     * @throws IOException If an error occurs while sending the message
     */
    private void sendMessageToClient() throws IOException {

        output.writeObject("SERVER: You are Client: " + counter);
        output.flush();
    }

    /**
     * Accept a new client connection
     *
     * @throws IOException If an error occurs while accepting new client
     */
    private void acceptClient() throws IOException {

        clientSocket = serverSocket.accept();
        output = new ObjectOutputStream(clientSocket.getOutputStream());
        output.flush();
        counter++;
    }

    /**
     * This method close the server's socket
     *
     * @throws IOException
     */
    public void close() throws IOException {

        serverSocket.close();
    }

    /**
     * Add a listener to this class
     *
     * @param listener this is the object that will update the server's display area
     */
    public void addMessageListener(MessageListener listener) {

        this.listener = listener;
    }
}
