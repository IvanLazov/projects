package com.clouway.guice.onlinebanking;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
@Singleton
public class UserBalanceServlet extends HttpServlet {

  private final BalanceService balanceService;

  @Inject
  public UserBalanceServlet(BalanceService balanceService) {
    this.balanceService = balanceService;
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getSession().setAttribute("userBalance", balanceService.getBalance());
    response.sendRedirect(request.getContextPath() + "/onlinebanking/userPage.jsp");
  }
}
