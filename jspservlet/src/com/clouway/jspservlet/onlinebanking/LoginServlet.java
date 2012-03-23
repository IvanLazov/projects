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
  private DatabaseService databaseService = Injector.injectDatabaseService(Injector.injectDatabaseHelper());

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    try {

      userService.login(userName, password);
      databaseService.setUserOnline(request.getSession().getId(), String.valueOf(request.getSession().getAttribute("userName")));
      request.getSession().setAttribute("userName", userName);
      response.sendRedirect("onlinebanking/index.jsp");

    } catch (WrongUserNameOrPasswordException exception) {

      request.setAttribute("error", "Wrong username/password");
      request.getRequestDispatcher("onlinebanking/login.jsp").forward(request, response);
    }
  }
}
