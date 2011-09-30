package com.clouway.introducingjava.gcd;

public class LCM {

    /**
        * Calculates the least common multiple of two numbers
        *
        * @param firstNumber int - first number
        * @param secondNumber - second number
        * @param gcd int - greatest common divisor of the two numbers
        * @return Least common multiple
        */
    public int leastCommonMultiple(int firstNumber, int secondNumber, int gcd) {
        firstNumber = (firstNumber * secondNumber) / gcd;
        return firstNumber;
    }
}
