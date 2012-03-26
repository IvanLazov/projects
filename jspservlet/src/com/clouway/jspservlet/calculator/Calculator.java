package com.clouway.jspservlet.calculator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Calculator {
  
  private final Map<String, Operation> operationMap = new HashMap<String, Operation>();
  private final String[] operationSign = new String[]{"+","-", "*", "/"};
    
  public Calculator() {

    operationMap.put("+", new Addition());
    operationMap.put("-", new Subtraction());
    operationMap.put("*", new Multiplication());
    operationMap.put("/", new Division());
  }

  public int calculate(String expression) {

    int result = 0;

    for (String sign : operationSign) {

      if (expression.lastIndexOf(sign) > 0) {

        try {
          int firstNumber = Integer.parseInt(expression.substring(0, expression.lastIndexOf(sign)));
          int secondNumber = Integer.parseInt(expression.substring(expression.lastIndexOf(sign) + 1, expression.length()));
          result = operationMap.get(sign).calculate(firstNumber, secondNumber);
        } catch (NumberFormatException e) {
          throw new InvalidExpressionException();
        }
      }
    }

    return result;
  }
}
