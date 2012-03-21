package com.clouway.jspservlet.onlinebanking;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

      HttpSession session = request.getSession();
      session.setAttribute("userName", userName);
      //databaseService.setUserOnline(userName, session.getId());

      response.sendRedirect("onlinebanking/index.jsp");

    } catch (WrongUserNameOrPasswordException exception) {
      response.sendRedirect("onlinebanking/login.jsp?error=Wrong username or password.");
    }
  }
}
