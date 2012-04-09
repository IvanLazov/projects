package com.clouway.jspservlet.catalog;

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
 * RedirectFilter is used to redirect to /catalog/bookcatalog.jsp
 * when trying to access /catalog/bookcomments.jsp
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class RedirectFilter implements Filter {

  public void init(FilterConfig filterConfig) throws ServletException {
  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    HttpServletResponse response = (HttpServletResponse) servletResponse;
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    response.sendRedirect(request.getContextPath() + "/catalog/bookcatalog.jsp");
  }

  public void destroy() {
  }
}
