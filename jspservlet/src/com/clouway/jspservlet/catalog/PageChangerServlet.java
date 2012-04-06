package com.clouway.jspservlet.catalog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class PageChangerServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    request.setAttribute("currentPage", request.getParameter("currentPage"));
    request.setAttribute("range", request.getParameter("range"));
    request.getRequestDispatcher("/catalogServlet").forward(request, response);
  }
}
