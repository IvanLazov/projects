package com.clouway.networkandgui.serverclients;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Client implements Runnable {

    private boolean connected = false;
    private Socket socket;
    private ObjectInputStream input;
    private MessageListener listener;

    public void addMessageListener(MessageListener listener) {

        this.listener = listener;
    }

    public void run() {

        connectToServer();
        getMessageFromServer();
    }

    /**
     * Connect to server
     */
    private void connectToServer() {

        try {
            socket = new Socket("localhost", 12345);
            input = new ObjectInputStream(socket.getInputStream());
            connected = true;
            listener.onDisplayMessage(new MessageEvent("Connected to server"));

        } catch (IOException e) {

            listener.onDisplayMessage(new MessageEvent("Error connecting to server..."));
        }
    }

    /**
     * Get new messages from server until the client is connected
     */
    public void getMessageFromServer() {

        while (connected) {
            try {

                String message = (String) input.readObject();
                listener.onDisplayMessage(new MessageEvent(message));
            } catch (EOFException e) {
                listener.onDisplayMessage(new MessageEvent("Server has been stopped"));
                connected = false;
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }    
    }
}
