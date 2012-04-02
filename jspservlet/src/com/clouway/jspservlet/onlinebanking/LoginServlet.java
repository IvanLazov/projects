package com.clouway.jspservlet.onlinebanking;

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
public class LoginServlet extends HttpServlet {

  private final LoginService loginService = new LoginServiceImpl(Injector.injectDatabaseHelper());
  private final OnlineUserManager onlineUserManager = Injector.injectOnlineUserManager(Injector.injectDatabaseHelper());

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    try {

      User user = loginService.login(userName, password);
      onlineUserManager.setUserOnline(request.getSession().getId(), user.getUserName());
      request.getSession().setAttribute("user", user);
      response.sendRedirect("onlinebanking/userPage.jsp");

    } catch (WrongUserNameOrPasswordException exception) {
      request.setAttribute("error", "Wrong username/password");
      request.getRequestDispatcher("onlinebanking/login.jsp").forward(request, response);
    }
  }
}
