package com.clouway.networkandgui.calculator;

/**
 * Calculates the sum of two numbers
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Addition implements Operation {

    /**
     * Calculates the sum of two numbers
     *
     * @param firstNumber - first number to sum
     * @param secondNumber - second number to sum
     * @return the sum of two numbers
     */
    public double calculate(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }
}
