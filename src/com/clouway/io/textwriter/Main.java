package com.clouway.io.textwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) {
        TextWriter writer = new TextWriter();
        String content = new TextReader(System.in).readUntilReach("|");
        try {
            writer.writeText(new FileOutputStream(new File("test.txt")), content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}