package com.clouway.guice.onlinebanking;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * LoginServlet is used to log a user
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
@Singleton
public class LoginServlet extends HttpServlet {

  private final LoginService loginService;
  private final OnlineUserManager onlineUserManager;

  @Inject
  public LoginServlet(LoginService loginService, OnlineUserManager onlineUserManager) {
    this.loginService = loginService;
    this.onlineUserManager = onlineUserManager;
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    try {

      User user = loginService.login(userName, password);
      onlineUserManager.setUserOnline(request.getSession().getId(), user.getUserName());
      request.getSession().setAttribute("user", user);
      request.getRequestDispatcher("/userBalance").forward(request, response);

    } catch (WrongUserNameOrPasswordException exception) {
      request.setAttribute("error", "Wrong username/password");
      request.getRequestDispatcher("/onlineUsers").forward(request, response);
    }
  }
}
