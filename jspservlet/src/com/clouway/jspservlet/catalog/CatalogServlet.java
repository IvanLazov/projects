package com.clouway.jspservlet.catalog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CatalogServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    String[] books = {"Book 1", "Book 2", "Book 3", "Book 4", "Book 5", "Book 6", "Book 7", "Book 8", "Book 9", "Book 10"};
    request.setAttribute("books", books);
    
    int currentPage = Integer.parseInt((String) request.getAttribute("currentPage"));
    
    if (currentPage <= 0) {
      request.setAttribute("currentPage", "1");
    }

    request.getRequestDispatcher("/catalog/bookcatalog.jsp").forward(request, response);
  }
}
