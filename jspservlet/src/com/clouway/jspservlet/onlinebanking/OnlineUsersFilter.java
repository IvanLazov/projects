package com.clouway.jspservlet.onlinebanking;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class OnlineUsersFilter implements Filter {

  private DatabaseService databaseService = Injector.injectDatabaseService(Injector.injectDatabaseHelper());
  
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

    req.setAttribute("numberOfOnlineUsers", databaseService.getNumberOfOnlineUsers());
    chain.doFilter(req, resp);
  }

  public void destroy() {

  }
}
