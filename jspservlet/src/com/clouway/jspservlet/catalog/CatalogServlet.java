package com.clouway.jspservlet.catalog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CatalogServlet extends HttpServlet {

  private CatalogUserService catalogUserService;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int currentPage = Integer.parseInt((String) request.getAttribute("currentPage"));
    int range = Integer.parseInt((String) request.getAttribute("range"));

    if (currentPage <= 0) {
      currentPage = 1;
    }

    catalogUserService = Injector.injectCatalogUserService(Injector.injectCatalogDatabaseService(Injector.injectDatabaseHelper("bookCatalogDB")));
    int lastPage = catalogUserService.getNumberOfPages(range);

    if (currentPage >= lastPage) {
      currentPage = lastPage;
    }

    List books = catalogUserService.getListOfBooks(currentPage, range);

    request.setAttribute("currentPage", currentPage);
    request.setAttribute("lastPage", lastPage);
    request.setAttribute("books", books);

    request.getRequestDispatcher("/catalog/bookcatalog.jsp").forward(request, response);
  }
}
