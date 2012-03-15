package com.clouway.jspservlet.onlinebanking.controllers;

import com.clouway.jspservlet.onlinebanking.business.UserService;
import com.clouway.jspservlet.onlinebanking.business.UserServiceImpl;
import com.clouway.jspservlet.onlinebanking.persistance.DatabaseHelper;
import com.clouway.jspservlet.onlinebanking.persistance.DatabaseService;
import com.clouway.jspservlet.onlinebanking.persistance.DatabaseServiceImpl;
import com.clouway.jspservlet.onlinebanking.exceptions.InvalidFormatException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class WithdrawServlet extends HttpServlet {

  private DatabaseHelper databaseHelper = new DatabaseHelper();
  private DatabaseService databaseService = new DatabaseServiceImpl(databaseHelper);
  private UserService userService = new UserServiceImpl(databaseService);

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {
      HttpSession session = request.getSession();
      userService.withdraw(session.getAttribute("userName").toString(), request.getParameter("sum").toString());
    } catch (InvalidFormatException exception) {
    }

    response.sendRedirect("onlinebanking/index.jsp");
  }
}
