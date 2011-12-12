package com.clouway.networkandgui.serverclients;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates the GUI
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ClientGUI {

    private JFrame frame;
    private JTextArea display;
    private JButton buttonConnect;
    private Client client;

    public ClientGUI() {

        client = new Client();

        frame = new JFrame("Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setVisible(true);

        display = new JTextArea();
        display.setEditable(false);
        frame.add(display, BorderLayout.CENTER);

        buttonConnect = new JButton("Connect to Server");
        frame.add(buttonConnect, BorderLayout.SOUTH);

        addListeners();
    }

    /**
     * Add a listener for the buttonConnect and for the display area
     */
    private void addListeners() {

        // When the button is clicked, a new Thread is created
        // which starts the Client
        buttonConnect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                new Thread(client).start();
                buttonConnect.setEnabled(false);
            }
        });

        // Display new message on the display area
        client.addMessageListener(new MessageListener() {
            public void onDisplayMessage(MessageEvent event) {
                updateDisplay(event.getMessage());
            }
        });
    }

    /**
     * Display new messages to the client display
     *
     * @param message the message which will be displayed
     */
    private void updateDisplay(final String message) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                display.append(message + "\n");
            }
        });
    }
}
