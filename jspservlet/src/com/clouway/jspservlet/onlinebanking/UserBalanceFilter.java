package com.clouway.jspservlet.onlinebanking;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class UserBalanceFilter implements Filter {
  
  private BalanceService balanceService;
  
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

    HttpSession session = ((HttpServletRequest) req).getSession();

    User user = (User) session.getAttribute("user");
    balanceService = new BalanceServiceImpl(Injector.injectDatabaseHelper(), user);
    req.setAttribute("userBalance", balanceService.getBalance());

    chain.doFilter(req, resp);
  }

  public void destroy() {
  
  }
}
