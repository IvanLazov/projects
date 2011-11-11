package com.clouway.testing.stringsumator;

public class StringSumator {

    /**
     * Calculates the sum of two numbers
     *
     * @param a   first number to sum
     * @param b   second number to sum
     * @return   the sum of the two numbers
     */
    public String sumStrings(String a, String b) {

        if (a == null || b == null) {
            throw new IllegalArgumentException();
        }

        double sum = Double.parseDouble(a) + Double.parseDouble(b);

        return String.valueOf(sum);
    }
}
