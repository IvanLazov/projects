package com.clouway.networkandgui.calculator;

/**
 * Calculates the multiplication of two numbers
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Multiplication implements Operation {

    /**
     * Calculates the multiplication of two numbers
     *
     * @param firstNumber - multiplicand
     * @param secondNumber - multiplier
     * @return the result from multiplication
     */
    public double calculate(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }
}
