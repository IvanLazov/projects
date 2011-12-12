package com.clouway.networkandgui.conversation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * This class provides methods for connecting the client
 * to the server, accept message from the server,
 * and then after the message is accepted, automatically
 * close the connection with the server
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ClientConnection {

    private Socket socket; // accept incoming message
    private ObjectInputStream input; // read incoming message
    private MessageListener listener; // update client's display
    private String message = "";

    /**
     * Add message listener to the class
     *
     * @param listener this is the listener which will update the client's display area
     */
    public void addMessageListener(MessageListener listener) {

        this.listener = listener;
    }

    public void start() {

        try {

            connectToServer();
            listener.updateDisplay(new MessageEvent("Connected to server"));

            acceptMessageFromServer();
            listener.updateDisplay(new MessageEvent(message));

            closeConnection();
            listener.updateDisplay(new MessageEvent("Connection closed"));

        } catch (IOException e) {
            listener.updateDisplay(new MessageEvent("The server is temporarily unavailable."));
        }
    }

    /**
     * Connect to server
     *
     * @throws IOException If an error occurs when connecting to the server
     */
    private void connectToServer() throws IOException {

        socket = new Socket(InetAddress.getLocalHost(), 12345);
        input = new ObjectInputStream(socket.getInputStream());
    }

    /**
     * Accept message from server
     *
     * @throws IOException If an error occurs while accepting the message
     */
    private void acceptMessageFromServer() throws IOException {

        try {
            message = (String) input.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Close connection to server
     *
     * @throws IOException If the connection to the server could not be stopped
     */
    private void closeConnection() throws IOException {

        socket.close();
    }
}
