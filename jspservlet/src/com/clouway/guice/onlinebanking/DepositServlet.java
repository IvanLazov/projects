package com.clouway.guice.onlinebanking;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * DepositServlet is used to deposit amount to user's account balance
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
@Singleton
public class DepositServlet extends HttpServlet {

  private final DepositService depositService;

  @Inject
  public DepositServlet(DepositService depositService) {
    this.depositService = depositService;
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    HttpSession session = request.getSession();

    if (request.getParameter("deposit") != null) {

      try {
        double amount = Double.parseDouble(request.getParameter("amount"));
        depositService.deposit(amount);
        session.setAttribute("error", "");
      } catch (NumberFormatException e) {
        session.setAttribute("error", "Cannot deposit! Invalid entered amount");
      } catch (InvalidDepositAmountException e) {
        session.setAttribute("error", "Cannot deposit! Amount must be between $1 and $10,000");
      }

      request.getRequestDispatcher("/userBalance").forward(request, response);
    }

    if (request.getParameter("withdraw") != null) {
      request.getRequestDispatcher("/withdraw").forward(request, response);
    }
  }
}
