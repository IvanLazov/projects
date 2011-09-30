package com.clouway.io.reverser;

public class Main {

    public static void main(String[] args) {

        FileReverser reverser = new FileReverser();

        reverser.openFile("quote.txt");
        reverser.readFile();
        reverser.reverseFile();
        reverser.writeFile("quote.txt");
    }
}