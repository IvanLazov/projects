package com.clouway.jspservlet.onlinebanking;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OnlineUsersServlet gets the number of online users.
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class OnlineUsersServlet extends HttpServlet {

  private final OnlineUserManager onlineUserManager = Injector.injectOnlineUserManager(Injector.injectDatabaseHelper());

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    request.setAttribute("numberOfOnlineUsers", onlineUserManager.getNumberOfOnlineUsers());
    request.getRequestDispatcher("onlinebanking/login.jsp").forward(request, response);
  }
}
