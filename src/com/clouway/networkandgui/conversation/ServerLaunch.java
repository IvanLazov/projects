package com.clouway.networkandgui.conversation;

import javax.swing.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ServerLaunch {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception unused) {

        }

        ServerGUI serverGUI = new ServerGUI(new Server());
    }
}
