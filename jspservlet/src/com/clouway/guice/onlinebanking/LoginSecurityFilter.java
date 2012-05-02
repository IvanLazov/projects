package com.clouway.guice.onlinebanking;

import com.google.inject.Singleton;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * LoginSecurityFilter is used to prevent unauthorized access to userPage.jsp
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
@Singleton
public class LoginSecurityFilter implements Filter {

  public void init(FilterConfig filterConfig) throws ServletException {
  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    if (request.getSession().getAttribute("user") == null) {
      response.sendRedirect("login.jsp");
    } else {
      chain.doFilter(servletRequest, servletResponse);
    }
  }

  public void destroy() {
  }
}
