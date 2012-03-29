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

  //private UserService userService = Injector.injectUserService(Injector.injectDatabaseService(Injector.injectDatabaseHelper()));

  private BalanceService balanceService;
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {      

      double sum = Double.parseDouble(request.getParameter("sum"));

      if (sum < 0) {
        request.setAttribute("error", "Cannot withdraw negative sum!");
      } else {
        
        User user = (User) request.getSession().getAttribute("user");
        balanceService = new BalanceServiceImpl(Injector.injectDatabaseHelper(), user);

        double currentBalance = balanceService.getBalance();
        
        if (currentBalance < sum) {
          request.setAttribute("error", "Cannot withdraw! Insufficient balance!");
        } else {
          balanceService.updateBalance(balanceService.getBalance() - sum);
          request.setAttribute("userBalance", balanceService.getBalance());
        }                
      }
    } catch (NumberFormatException e) {
      request.setAttribute("error", "Cannot deposit! Invalid entered sum!");
    } 

    request.getRequestDispatcher("onlinebanking/userPage.jsp").forward(request, response);
  }
}
