package com.clouway.jspservlet.onlinebanking;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class DepositServlet extends HttpServlet {

  private UserService userService = Injector.injectUserService(Injector.injectDatabaseService(Injector.injectDatabaseHelper()));

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    if (request.getParameter("deposit") != null) {

      try {

        double sum = Double.parseDouble(request.getParameter("sum"));

        if (sum < 0) {
          request.setAttribute("error", "Cannot deposit negative sum!");
        } else {
          userService.deposit(String.valueOf(request.getSession().getAttribute("userName")), sum);
        }
      } catch (NumberFormatException e) {
        request.setAttribute("error", "Cannot deposit! Invalid sum entered!");
      }

      request.getRequestDispatcher("onlinebanking/index.jsp").forward(request, response);
    }

    if (request.getParameter("withdraw") != null) {
      request.getRequestDispatcher("/withdraw").forward(request, response);
    }
  }
}
