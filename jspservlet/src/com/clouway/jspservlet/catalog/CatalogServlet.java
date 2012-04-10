package com.clouway.jspservlet.catalog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * CatalogServlet is used to process user's request.
 * It gets as an attribute the page which the user wants to open and range (interval),
 * then a request is send to the database to take the list of books in this range.
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CatalogServlet extends HttpServlet {

  private CatalogUserService catalogUserService;
  private int currentPage;
  private int range;
  private int lastPage;

  public void init() throws ServletException {
    currentPage = 1;
    range = 3;
    lastPage = 0;
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    if (request.getParameter("currentPage") != null && request.getParameter("range") != null && request.getParameter("lastPage") != null) {
      currentPage = Integer.parseInt(request.getParameter("currentPage"));
      range = Integer.parseInt(request.getParameter("range"));
      lastPage = Integer.parseInt(request.getParameter("lastPage"));
    }

    catalogUserService = Injector.injectCatalogUserService(Injector.injectCatalogDatabaseService(Injector.injectDatabaseHelper("bookCatalogDB")));
    lastPage = catalogUserService.getNumberOfPages(range);

    if (currentPage <= 0) {
      currentPage = 1;
    } else if (currentPage >= lastPage) {
      currentPage = lastPage;
    }

    List books = catalogUserService.getListOfBooks(currentPage, range);

    request.setAttribute("currentPage", currentPage);
    request.setAttribute("range", range);
    request.setAttribute("lastPage", lastPage);
    request.setAttribute("books", books);

    request.getRequestDispatcher("/catalog/bookcatalog.jsp").forward(request, response);
  }
}
