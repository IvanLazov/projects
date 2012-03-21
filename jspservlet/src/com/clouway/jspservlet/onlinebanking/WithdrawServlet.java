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
public class WithdrawServlet extends HttpServlet {

  private UserService userService = Injector.injectUserService(Injector.injectDatabaseService(Injector.injectDatabaseHelper()));

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {
      HttpSession session = request.getSession();
      userService.withdraw(session.getAttribute("userName").toString(), request.getParameter("sum"));
    } catch (InvalidFormatException exception) {
      exception.printStackTrace();
    }

    response.sendRedirect("onlinebanking/index.jsp");
  }
}
