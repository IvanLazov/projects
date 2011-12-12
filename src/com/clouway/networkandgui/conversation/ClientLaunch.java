package com.clouway.networkandgui.conversation;

import javax.swing.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ClientLaunch {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception unused) {

        }

        ClientGUI clientGUI = new ClientGUI(new ClientConnection());
    }
}
