package com.clouway.jspservlet.onlinebanking;

import com.google.inject.Inject;
import com.google.inject.Singleton;

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
@Singleton
public class OnlineUsersServlet extends HttpServlet {

  private final OnlineUserManager onlineUserManager;

  @Inject
  public OnlineUsersServlet(OnlineUserManager onlineUserManager) {
    this.onlineUserManager = onlineUserManager;
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    getNumberOfOnlineUsers(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    getNumberOfOnlineUsers(request, response);
  }

  private void getNumberOfOnlineUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("numberOfOnlineUsers", onlineUserManager.getNumberOfOnlineUsers());
    request.getRequestDispatcher("/onlinebanking/login.jsp").forward(request, response);
  }
}
