package com.clouway.jspservlet.catalog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * SaveCommentServlet is used to save user's comment in the database
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class SaveCommentServlet extends HttpServlet {

  private CommentUserService commentUserService;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    commentUserService = Injector.injectCommentsUserService(Injector.injectCommentsDatabaseService(Injector.injectDatabaseHelper("bookCatalogDB")));

    String username = request.getParameter("username");
    String comment = request.getParameter("comment");
    int bookId = Integer.parseInt(request.getParameter("bookId"));

    if (username.matches("[a-zA-Z\\d]{1,20}") && comment.matches("[a-zA-Z\\d !?,.]{1,255}") && !comment.trim().equals("")) {
      commentUserService.saveUserComment(bookId, username, comment);
    }

    response.sendRedirect(request.getContextPath() + "/commentServlet?bookId=" + bookId);
  }
}
