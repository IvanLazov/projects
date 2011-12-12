package com.clouway.networkandgui.conversation;

import javax.swing.*;
import java.awt.*;

/**
 * This class creates the client graphic interface
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ClientGUI {

    private JFrame frame;
    private JTextArea display;
    private ClientConnection clientConnection;

    public ClientGUI(ClientConnection connection) {

        display = new JTextArea();
        display.setEditable(false);

        frame = new JFrame("Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setVisible(true);
        frame.add(display, BorderLayout.CENTER);

        clientConnection = connection;
        clientConnection.addMessageListener(new MessageListener() {
            public void updateDisplay(MessageEvent event) {
                displayMessage(event.getMessage());
            }
        });

        clientConnection.start();
    }

    /**
     *  Display received messages from server
     *
     * @param message to be displayed in the display area
     */
    private void displayMessage(final String message) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                display.append(message + "\n");
            }
        });
    }
}
