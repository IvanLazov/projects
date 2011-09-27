package com.clouway.io.reverser;

import java.io.IOException;

/**
 * Ivan Lazov
 * darkpain1989@gmail.com
 */
public class Main {

    public static void main(String[] args) {

        FileReverser reverser = new FileReverser();

        reverser.openFile("quote.txt");
        reverser.readFile();
        reverser.reverseFile();
        reverser.writeFile("quote.txt");
    }
}