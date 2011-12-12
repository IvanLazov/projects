package com.clouway.networkandgui.conversation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ServerGUI {

    private JFrame frame;
    private JTextArea display;
    private JButton buttonStopServer;
    private Server server; // this is the object which provide the Server functionality

    public ServerGUI(Server connection) {

        server = connection;

        display = new JTextArea();
        display.setEditable(false);

        buttonStopServer = new JButton("Stop Server");

        frame = new JFrame("Server");
        frame.setSize(500, 350);
        frame.setVisible(true);
        frame.add(new JScrollPane(display), BorderLayout.CENTER);
        frame.add(buttonStopServer, BorderLayout.SOUTH);

        // Stop the server when the button is clicked
        buttonStopServer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                server.stopServer();
            }

        });

        // Stop the server and close the window when the "close" button
        // of the frame is clicked
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                server.stopServer();
                System.exit(0);
            }
        });

        // Updates server's display
        server.addDisplayListener(new MessageListener() {

            public void updateDisplay(MessageEvent event) {
                displayStatus(event.getMessage());
            }
        });

        server.start();
    }

    // Update Servers display area
    private void displayStatus(final String message) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                display.append(message + "\n");
            }
        });
    }
}
