package com.clouway.networkandgui.serverclients;

import javax.swing.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ClientLaunch {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception exception) {

        }

        ClientGUI clientGUI = new ClientGUI();
    }
}
