package com.clouway.exceptions.number;

import java.util.Scanner;

/**
 * Ivan Lazov
 * darkpain1989@gmail.com
 */
public class Number {

    private Scanner scan = new Scanner(System.in);

    /**
     * Checks if the number is entered is between 0 and 100
     * If the number is less or greater, the method throw IntervalRangeException()
     * which handles the exception.
     *
     * @throws IntervalRangeException if the number is out of range
     */
    public void enterNumber() throws IntervalRangeException {
        int number = scan.nextInt();
            if (number < 0 || number > 100) {
                throw new IntervalRangeException();
            }
        }
}
