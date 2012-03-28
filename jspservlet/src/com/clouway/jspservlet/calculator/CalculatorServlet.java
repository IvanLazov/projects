package com.clouway.jspservlet.calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class CalculatorServlet extends HttpServlet {

  private final Calculator calculator = new Calculator();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String expression = request.getParameter("input");

    try {
      request.setAttribute("result", calculator.calculate(expression));
    } catch (ArithmeticException e) {
      request.setAttribute("result", "Infinity");
    } catch (InvalidExpressionException e) {
      request.setAttribute("result", request.getParameter("input"));
    }

    RequestDispatcher dispatcher = request.getRequestDispatcher("/calculator/userPage.jsp");
    dispatcher.forward(request, response);
  }
}
