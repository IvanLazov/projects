package com.clouway.networkandgui.calculator;

/**
 * Calculates the division of two numbers
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Division implements Operation {

    /**
     * Calculates the division of two numbers
     *
     * @param firstNumber - dividend
     * @param secondNumber - divisor
     * @return the result from division
     */
    public double calculate(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }
}
