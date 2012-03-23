package com.clouway.jspservlet.onlinebanking;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class LoginServlet extends HttpServlet {

  private UserService userService = Injector.injectUserService(Injector.injectDatabaseService(Injector.injectDatabaseHelper()));

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    try {

      userService.login(userName, password);
      request.getSession().setAttribute("userName", userName);
      request.getRequestDispatcher("onlinebanking/index.jsp").forward(request, response);
    } catch (WrongUserNameOrPasswordException exception) {

      request.setAttribute("error", "Wrong username/password");
      request.getRequestDispatcher("onlinebanking/login.jsp").forward(request, response);
    }
  }
}
