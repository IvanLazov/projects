package com.clouway.jspservlet.onlinebanking;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class WithdrawServlet extends HttpServlet {

  private UserService userService = Injector.injectUserService(Injector.injectDatabaseService(Injector.injectDatabaseHelper()));

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {
      double sum = Double.parseDouble(request.getParameter("sum"));

      if (sum < 0) {
        request.setAttribute("error", "Cannot withdraw negative sum!");
      } else {
        userService.withdraw(String.valueOf(request.getSession().getAttribute("userName")), sum);
      }

    } catch (NumberFormatException e) {
      request.setAttribute("error", "Cannot deposit! Invalid sum entered!");
    } catch (InsufficientBalanceException e) {
      request.setAttribute("error", "Cannot withdraw! Insufficient balance!");
    }

    request.getRequestDispatcher("onlinebanking/index.jsp").forward(request, response);
  }
}
