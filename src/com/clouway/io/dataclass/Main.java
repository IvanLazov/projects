package com.clouway.io.dataclass;

import java.io.*;

/**
 * Ivan Lazov
 * darkpain1989@gmail.com
 */
public class Main {

    public static void main(String[] args) {
        DataClass serialize = new DataClass();
        Person personOne = new Person("Ivan", "male", 21);
        String pathToFile = "ivan.ser";

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(pathToFile);
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to file.");
        }

        FileInputStream in = null;
        try {
            in = new FileInputStream(pathToFile);
        } catch (FileNotFoundException e) {
            System.err.println("Error reading from file");
        }

        serialize.saveObject(out, personOne);

        Person personTwo = (Person) serialize.getObject(in);
        System.out.println("Name: " + personTwo.getName());
        System.out.println("Sex: " + personTwo.getSex());
        System.out.println("Age: " + personTwo.getAge());
    }
}
