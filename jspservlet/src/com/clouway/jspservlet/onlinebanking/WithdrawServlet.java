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

  private WithdrawService withdrawService;
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {      

      double amount = Double.parseDouble(request.getParameter("amount"));
      User user = (User) request.getAttribute("user");
      
      withdrawService = Injector.injectWithdrawService(Injector.injectBalanceService(Injector.injectDatabaseHelper(), user));
      withdrawService.withdraw(amount);

      response.sendRedirect("onlinebanking/userPage.jsp");

    } catch (NumberFormatException e) {
      request.setAttribute("error", "Cannot withdraw! Invalid entered sum!");
      request.getRequestDispatcher("/onlinebanking/userPage.jsp").forward(request, response);
    } catch (InsufficientFundsException e) {
      request.setAttribute("error", "Cannot withdraw! Insufficient Funds!");
      request.getRequestDispatcher("/onlinebanking/userPage.jsp").forward(request, response);
    } catch (InvalidWithdrawAmountException e) {
      request.setAttribute("error", "Cannot withdraw! Amount must be between $1 and $10,000");
      request.getRequestDispatcher("/onlinebanking/userPage.jsp").forward(request, response);
    }
  }
}
