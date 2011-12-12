package com.clouway.networkandgui.downloadagent;

import javax.swing.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Launcher {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception exception) {

        }

        DownloadAgentGUI downloadAgentGUI = new DownloadAgentGUI(new URLDownloader());
    }
}
