package com.clouway.jspservlet.onlinebanking;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * UserBalanceFilter is used to get the current balance of the user
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class UserBalanceFilter implements Filter {
  
  private BalanceService balanceService;
  
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) servletRequest;
    User user = (User) request.getSession().getAttribute("user");

    balanceService = Injector.injectBalanceService(Injector.injectDatabaseHelper(), user);
    servletRequest.setAttribute("userBalance", balanceService.getBalance());

    chain.doFilter(servletRequest, servletResponse);
  }

  public void destroy() {
  
  }
}
