package com.clouway.jspservlet.onlinebanking;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * WithdrawServlet is used to withdraw from user's account
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
@Singleton
public class WithdrawServlet extends HttpServlet {

  private final WithdrawService withdrawService;

  @Inject
  public WithdrawServlet(WithdrawService withdrawService) {
    this.withdrawService = withdrawService;
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {
      double amount = Double.parseDouble(request.getParameter("amount"));
      withdrawService.withdraw(amount);
    } catch (NumberFormatException e) {
      request.setAttribute("error", "Cannot withdraw! Invalid entered sum!");
    } catch (InsufficientFundsException e) {
      request.setAttribute("error", "Cannot withdraw! Insufficient Funds!");
    } catch (InvalidWithdrawAmountException e) {
      request.setAttribute("error", "Cannot withdraw! Amount must be between $1 and $10,000");
    }

    request.getRequestDispatcher("/userBalance").forward(request, response);
  }
}
