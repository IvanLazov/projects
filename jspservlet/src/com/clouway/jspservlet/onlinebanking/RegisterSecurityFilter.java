package com.clouway.jspservlet.onlinebanking;

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
 * RegisterSecurityFilter is used to preserve the user from accessing the register.jsp
 * if the user is already logged in
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class RegisterSecurityFilter implements Filter {

  public void init(FilterConfig filterConfig) throws ServletException {
  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    if (request.getSession().getAttribute("user") != null) {
      response.sendRedirect("userPage.jsp");
    } else {
      chain.doFilter(servletRequest, servletResponse);
    }
  }

  public void destroy() {
  }
}
