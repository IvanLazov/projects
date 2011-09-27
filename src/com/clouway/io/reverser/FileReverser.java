package com.clouway.io.reverser;

import java.io.*;

/**
 * Ivan Lazov
 * darkpain1989@gmail.com
 */
public class FileReverser {

    private BufferedReader reader;
    private BufferedWriter writer;
    private StringBuffer stringBuffer = new StringBuffer();
    private String content;

    /**
     * Open file for reading
     *
     * @param pathToFile String file to open
     */
    public void openFile(String pathToFile) {
        try {
            reader = new BufferedReader(new FileReader(pathToFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads file content line by line
     */
    public void readFile() {
        try {
            String line = reader.readLine();

            while (line != null) {
                stringBuffer.append(line).append("\n");
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reverse readed file content
     */
    public void reverseFile() {
        content = stringBuffer.reverse().toString();
    }

    /**
     * Write the reverse content of the file to the same file
     *
     * @param pathToFile String file to write
     */
    public void writeFile(String pathToFile) {
        try {
            writer = new BufferedWriter(new FileWriter(pathToFile));
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
