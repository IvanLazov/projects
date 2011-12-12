package com.clouway.networkandgui.calculator;

/**
 * Calculates the subtraction of two numbers
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Subtraction implements Operation {

    /**
     * Calculates the subtraction of two numbers
     *
     * @param firstNumber - number from which subtract
     * @param secondNumber - number to subtract
     * @return the result of subtraction
     */
    public double calculate(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }
}
