package com.clouway.jspservlet.catalog;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * CatalogFilter is used to set the currentPage, range and lastPage,
 * when user sends request for url - /catalog/bookcatalog.jsp
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CatalogFilter implements Filter {

  public void init(FilterConfig filterConfig) throws ServletException {
  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    servletRequest.getRequestDispatcher("/catalogServlet").forward(servletRequest, servletResponse);
  }

  public void destroy() {
  }
}
