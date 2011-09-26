package com.clouway.exceptions.number;

/**
 * Ivan Lazov
 * darkpain1989@gmail.com
 */
public class Main {

    public static void main(String[] args) {
        Number number = new Number();
        System.out.print("Enter number between 0 and 100: ");
        try {
            number.enterNumber();
        } catch (IntervalRangeException e) {
            System.out.println(e.getMessage());
        }
    }
}
