package com.clouway.exceptions.stringsumator;

/**
 * Ivan Lazov
 * darkpain1989@gmail.com
 */
public class StringSumator {

    /**
     * Calculate the sum of two numbers of type String
     * @param a String first number
     * @param b String second number
     * @return the sum of a and b
     */
    public String sumStrings(String a, String b) {
        double sum = Double.parseDouble(a) + Double.parseDouble(b);
        return String.valueOf(sum);
    }
}