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

  private Calculator calculator = new Calculator();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String expression = request.getParameter("input");
    request.setAttribute("result", calculator.calculate(expression));

    RequestDispatcher dispatcher = request.getRequestDispatcher("/calculator/index.jsp");
    dispatcher.forward(request, response);
  }
}
