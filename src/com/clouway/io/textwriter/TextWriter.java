package com.clouway.io.textwriter;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Ivan Lazov
 * darkpain1989@gmail.com
 */
public class TextWriter {

    /**
     * Write text to the specific output stream
     *
     * @param outputStream OutputStream location in which we want to save
     * @param content String the text we want to save
     */
    public void writeText(OutputStream outputStream, String content) {
        try {
            outputStream.write(content.getBytes());
        } catch (IOException e) {
            System.err.println("Error creating/writing to file");
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
