package com.clouway.io.consolereader;

public class Main {

    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();

        System.out.println("String: " + reader.readString());
        System.out.println("Int: " + reader.readInt());
        System.out.println("Char: " + reader.readChar());
        System.out.println("Float: " + reader.readFloat());
    }
}