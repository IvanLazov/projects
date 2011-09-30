package com.clouway.introducingjava.gcd;

public class GCD {

    /**
        *  Calculates the greatest common divisor of two numbers
        *
        * @param firstNumber int - first number
        * @param secondNumber int - second number
        * @return  Greatest common divisor
        */
    public int greatestCommonDivisor(int firstNumber, int secondNumber) {
        while (firstNumber != secondNumber) {
            if (firstNumber > secondNumber) {
                firstNumber = firstNumber - secondNumber;
            } else {
                secondNumber = secondNumber - firstNumber;
            }
        }

        return firstNumber;
    }
}
