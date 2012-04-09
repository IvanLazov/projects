package com.clouway.jspservlet.catalog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * CommentServlet is used to process user's request,
 * when the user wants to post comment or view all comments for specified book
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CommentServlet extends HttpServlet {

  private CatalogUserService catalogUserService;
  private CommentUserService commentUserService;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    catalogUserService = Injector.injectCatalogUserService(Injector.injectCatalogDatabaseService(Injector.injectDatabaseHelper("bookCatalogDB")));
    commentUserService = Injector.injectCommentsUserService(Injector.injectCommentsDatabaseService(Injector.injectDatabaseHelper("bookCatalogDB")));
    
    Book book = catalogUserService.getRequestBook(Integer.parseInt(request.getParameter("bookId")));
    List comments = commentUserService.getListOfComments(book.getBookId());

    request.setAttribute("book", book);
    request.setAttribute("comments", comments);

    request.getRequestDispatcher("/catalog/bookcomments.jsp").forward(request, response);
  }
}
