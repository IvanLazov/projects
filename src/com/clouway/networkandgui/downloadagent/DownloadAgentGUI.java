package com.clouway.networkandgui.downloadagent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class creates the GUI part for the URLDownloader.
 * Contains a text field for entering a URL address, progress bar that shows
 * what part of the file is downloaded and a button to start the downloading process
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class DownloadAgentGUI {

    private JFrame frame; // contains all graphic components
    private JButton downloadButton; // starts download process
    private JTextField addressField; // set URL address
    private JProgressBar progressBar; // shows download progress
    private JFileChooser fileChooser; // states the location where to save the file
    private URLDownloader URLDownloader;

    public DownloadAgentGUI(URLDownloader urlDownloader) {

        URLDownloader = urlDownloader;

        // Create addressField
        addressField = new JTextField();
        addressField.setBounds(10, 10, 360, 30);

        // Create progressBar
        progressBar = new JProgressBar();
        progressBar.setBounds(10, 50, 360, 30);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        // Create fileChooser
        fileChooser = new JFileChooser();

        ActionListener downloadListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                int value = fileChooser.showSaveDialog(frame);

                if (value == JFileChooser.APPROVE_OPTION) {
                    try {
                        URLDownloader.download(new FileOutputStream(fileChooser.getSelectedFile()),addressField.getText());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        URLDownloader.addProgressListener(new DownloadProgressListener() {
            public void onProgress(DownloadProgressEvent event) {
                progressBar.setMaximum(event.getMaxProgress());
                progressBar.setValue(event.getCurrentProgress());
            }
        });

        downloadButton = new JButton("Download");
        downloadButton.setBounds(138, 90, 100, 30);
        downloadButton.addActionListener(downloadListener);

        // Create frame and add all graphic components
        frame = new JFrame("Download Agent");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(400, 170);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(addressField);
        frame.add(progressBar);
        frame.add(downloadButton);
    }
}
