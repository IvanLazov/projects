package com.clouway.jspservlet.calculator;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Addition implements Operation {

  public int calculate(int firstNumber, int secondNumber) {
    return firstNumber + secondNumber;
  }
}
