package com.clouway.io.consolereader;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ivan Lazov
 * darkpain1989@gmail.com
 */
public class ConsoleReader {

    private Scanner input = new Scanner(System.in);

    /**
     * Read string from the console
     *
     * @return the readed string value
     */
    public String readString() {
        return input.next();
    }

    /**
     * Read int from the console
     *
     * @return the readed int value
     */
    public int readInt() {
        int intValue = input.nextInt();

        try {
            intValue = input.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Wrong type or out of range.");
        }

        return intValue;
    }

    /**
     * Read char from the console
     *
     * @return the readed char value
     */
    public char readChar() {
        return input.next().charAt(0);
    }

    /**
     * Read float from the console
     *
     * @return the readed float value
     */
    public float readFloat() {
        float floatValue = 0.0f;

        try {
            floatValue = input.nextFloat();
        } catch (InputMismatchException e) {
            System.err.println("Wrong type or out of range.");
        }

        return floatValue;
    }
}