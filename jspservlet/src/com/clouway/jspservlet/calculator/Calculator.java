package com.clouway.jspservlet.calculator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Calculator {
  
  private Map<String, Operation> operationMap = new HashMap<String, Operation>();
  private String[] operationSign = new String[]{"+", "-", "*", "/"};
    
  public Calculator() {

    operationMap.put("+", new Addition());
    operationMap.put("-", new Subtraction());
    operationMap.put("*", new Multiplication());
    operationMap.put("/", new Division());
  }

  public int calculate(String expression) {

    int result = 0;

    for (String sign : operationSign) {

      if (expression.contains(sign)) {

        int firstNumber = Integer.parseInt(expression.substring(0, expression.indexOf(sign)));
        int secondNumber = Integer.parseInt(expression.substring(expression.indexOf(sign) + 1, expression.length()));
        result = operationMap.get(sign).calculate(firstNumber, secondNumber);
      }
    }

    return result;
  }
}
