package com.clouway.io.textwriter;

import java.io.InputStream;
import java.util.Scanner;

public class TextReader {
    private final InputStream in;

    public TextReader(InputStream in) {
        this.in = in;
    }

    /**
     * Reads until reach of the specific line terminator
     *
     * @param terminationString String set the desired line terminator
     * @return readed content from the buffer
     */
    public String readUntilReach(String terminationString) {
        Scanner scanner = new Scanner(in);
        StringBuffer buffer = new StringBuffer();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            buffer.append(line + "\n");
            if (line.equals(terminationString)) {
                return buffer.toString();
            }
        }

        return null;
    }
}
