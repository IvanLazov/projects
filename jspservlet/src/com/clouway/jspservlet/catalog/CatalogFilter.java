package com.clouway.jspservlet.catalog;

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
public class CatalogFilter implements Filter {

  public void init(FilterConfig filterConfig) throws ServletException {
  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    servletRequest.setAttribute("currentPage", "1");
    servletRequest.setAttribute("range", "3");
    servletRequest.setAttribute("lastPage", "0");

    servletRequest.getRequestDispatcher("/catalogServlet").forward(servletRequest, servletResponse);
  }

  public void destroy() {
  }
}
