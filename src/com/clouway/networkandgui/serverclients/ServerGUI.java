package com.clouway.networkandgui.serverclients;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * This class creates the Server's GUI part
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ServerGUI {
        
    private JFrame frame;
    private JTextArea display;
    private JButton buttonStop; // stop the server
    private Server server;

    public ServerGUI() {

        server = new Server();

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setVisible(true);

        display = new JTextArea();
        display.setEditable(false);
        frame.add(display, BorderLayout.CENTER);

        buttonStop = new JButton("Stop Server");
        frame.add(buttonStop, BorderLayout.SOUTH);

        addListeners();
        startServer();
    }

    /**
     * Start server. Calls server's method startServer()
     */
    public void startServer() {
        try {
            server.startServer();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Server has been stopped", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Add listeners to the class
     */
    private void addListeners() {

        // When the button is clicked, the server will be stopped
        buttonStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                stopServer();
                buttonStop.setEnabled(false);
            }
        });

        // Updates the server's display area
        server.addMessageListener(new MessageListener() {
            public void onDisplayMessage(MessageEvent event) {
                updateDisplay(event.getMessage());
            }
        });
    }

    /**
     * Updates the servers display area
     *
     * @param message the message that will be append to the display area
     */
    private void updateDisplay(final String message) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                display.append(message + "\n");
            }
        });
    }

    /**
     * Stop the server. Calls server's method close();
     */
    private void stopServer() {

        try {
            server.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Server is stopped", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
