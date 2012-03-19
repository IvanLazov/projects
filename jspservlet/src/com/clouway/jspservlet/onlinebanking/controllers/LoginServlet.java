package com.clouway.jspservlet.onlinebanking.controllers;

import com.clouway.jspservlet.onlinebanking.business.UserService;
import com.clouway.jspservlet.onlinebanking.business.UserServiceImpl;
import com.clouway.jspservlet.onlinebanking.persistance.DatabaseHelper;
import com.clouway.jspservlet.onlinebanking.persistance.DatabaseService;
import com.clouway.jspservlet.onlinebanking.persistance.DatabaseServiceImpl;
import com.clouway.jspservlet.onlinebanking.exceptions.WrongUserNameOrPasswordException;

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

  private DatabaseHelper databaseHelper = new DatabaseHelper();
  private DatabaseService databaseService = new DatabaseServiceImpl(databaseHelper);
  private UserService userService = new UserServiceImpl(databaseService);

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    try {

      userService.login(userName, password);

      HttpSession session = request.getSession();
      session.setAttribute("userName", userName);
      databaseService.setUserOnline(userName, session.getId());

      response.sendRedirect("onlinebanking/index.jsp");

    } catch (WrongUserNameOrPasswordException exception) {
      response.sendRedirect("onlinebanking/login.jsp?error=Wrong username or password.");
    }
  }
}
