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
public class LogoutServlet extends HttpServlet {

  private DatabaseHelper databaseHelper = new DatabaseHelper();
  private DatabaseService databaseService = new DatabaseServiceImpl(databaseHelper);

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    HttpSession session = request.getSession();
    //databaseService.logOut(session.getAttribute("userName").toString());
    //session.removeAttribute("userName");
    session.invalidate();
    response.sendRedirect("onlinebanking/login.jsp");
  }
}
