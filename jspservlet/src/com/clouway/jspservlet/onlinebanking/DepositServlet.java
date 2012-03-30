package com.clouway.jspservlet.onlinebanking;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class DepositServlet extends HttpServlet {

  private DepositService depositService;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    if (request.getParameter("deposit") != null) {
      try {

        double amount = Double.parseDouble(request.getParameter("amount"));
        User user = (User) request.getSession().getAttribute("user");

        depositService = Injector.injectDepositService(Injector.injectBalanceService(Injector.injectDatabaseHelper(), user));
        depositService.deposit(amount);

        response.sendRedirect("onlinebanking/userPage.jsp");

      } catch (NumberFormatException e) {
        request.setAttribute("error", "Cannot deposit! Invalid entered amount");
        request.getRequestDispatcher("/onlinebanking/userPage.jsp").forward(request, response);
      } catch (InvalidDepositAmountException e) {
        request.setAttribute("error", "Cannot deposit! Amount must be between $1 and $10,000");
        request.getRequestDispatcher("/onlinebanking/userPage.jsp").forward(request, response);
      }
    }

    if (request.getParameter("withdraw") != null) {
      request.getRequestDispatcher("/withdraw").forward(request, response);
    }
  }
}
