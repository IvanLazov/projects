package com.clouway.jspservlet.onlinebanking;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * LogoutServlet is used to invalidate user's session
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
@Singleton
public class LogoutServlet extends HttpServlet {

  private final OnlineUserManager onlineUserManager;

  @Inject
  public LogoutServlet(OnlineUserManager onlineUserManager) {
    this.onlineUserManager = onlineUserManager;
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    onlineUserManager.setUserOffline(request.getSession().getId());
    request.getSession().invalidate();
    response.sendRedirect("onlinebanking/login.jsp");
  }
}
