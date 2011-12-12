package com.clouway.networkandgui.conversation;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

/**
 * This class provides methods for starting the server,
 * accept connection from client and then send him a message
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Server {

    private Socket connection;
    private ServerSocket socket;
    private ObjectOutputStream output;
    private MessageListener displayListener;

    /**
     * Add a message listener to the class
     *
     * @param listener this is the listener which will update the server's display area
     */
    public void addDisplayListener(MessageListener listener) {

        this.displayListener = listener;
    }

    public void start() {

        try {

            setServerPort();
            displayListener.updateDisplay(new MessageEvent("Server started on port: " + socket.getLocalPort()));

            displayListener.updateDisplay(new MessageEvent("Waiting for client to connect..."));
            acceptClientConnection();
            displayListener.updateDisplay(new MessageEvent("Client connected!"));

            sendMessageToClient();
            displayListener.updateDisplay(new MessageEvent("Server sent message to client"));

        } catch (IOException e) {

        }
    }

    /**
     * Set the port on which the server will accept new clients
     *
     * @throws IOException If the server cannot be bound to this port
     */
    private void setServerPort() throws IOException {

        socket = new ServerSocket(12345);
    }

    /**
     * Accept client connections
     *
     * @throws IOException If an error occurs while accepting new clients
     */
    private void acceptClientConnection() throws IOException {

        connection = socket.accept();
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
    }

    /**
     * Send a message to the connected client
     *
     * @throws IOException If an error occurs while sending the message
     */
    private void sendMessageToClient() throws IOException {

        output.writeObject("SERVER: Hello! " + Calendar.getInstance().getTime());
        output.flush();
    }

    /**
     * Close server's socket
     */
    private void closeSockets() {

        try {
            if (connection != null) {
                connection.close();
            }

            socket.close();
        } catch (IOException e) {

        }
    }

    /**
     * This method is public, so that we can stop the server's socket
     * from the GUI
     */
    public void stopServer() {

        closeSockets();
        displayListener.updateDisplay(new MessageEvent("Connection closed"));
    }
}
