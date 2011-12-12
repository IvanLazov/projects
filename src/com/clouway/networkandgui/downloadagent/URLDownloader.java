package com.clouway.networkandgui.downloadagent;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * This class is used to download a file from a URL,
 * and writes it to a specified file output stream
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class URLDownloader implements Runnable {

    private InputStream inputStream;
    private OutputStream outputStream;
    private URLConnection urlConnection;
    private DownloadProgressListener listener;

    public void addProgressListener(DownloadProgressListener listener) {

        this.listener = listener;
    }

    /**
     * Download the file from the URL address and saves it in the specified output
     *
     * @param fileOutputStream the file stream in which the url will be saved
     * @param url the url to be downloaded
     */
    public void download(FileOutputStream fileOutputStream, String url) {

        outputStream = fileOutputStream;

        try {
            urlConnection = new URL(url).openConnection();
            inputStream = new BufferedInputStream(urlConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        new Thread(this).start();
    }

    /**
     * Close input and output streams
     *
     * @throws IOException If the streams cannot be closed
     */
    private void closeConnection() throws IOException {

        inputStream.close();
        outputStream.close();
    }

    /**
     * Run the download progress in the background.
     * This prevents the GUI from freezing
     */
    public void run() {

        try {

            int numberRead;
            int counter = 0;
            int available = urlConnection.getContentLength();

            while ((numberRead = inputStream.read()) != -1) {
                outputStream.write(numberRead);
                counter++;
                listener.onProgress(new DownloadProgressEvent(counter, available));
            }

            closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}