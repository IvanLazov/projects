package com.clouway.io.consolereader;

/**
 * Ivan Lazov
 * darkpain1989@gmail.com
 */
public class Main {

    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();

        System.out.println("String: " + reader.readString());
        System.out.println("Int: " + reader.readInt());
        System.out.println("Char: " + reader.readChar());
        System.out.println("Float: " + reader.readFloat());
    }
}