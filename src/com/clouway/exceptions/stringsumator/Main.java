package com.clouway.exceptions.stringsumator;

/**
 * Ivan Lazov
 * darkpain1989@gmail.com
 */
public class Main {

    public static void main(String[] args) {
        StringSumator sumator = new StringSumator();
        String sum;

        try {
            sum = sumator.sumStrings("5", "10");
            System.out.println("Sum is: " + sum);
        } catch (NumberFormatException e) {
            System.err.println("NumberFormatException: " + e.getMessage());
        }
    }
}