package com.clouway.jspservlet.onlinebanking;

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
public class DepositServlet extends HttpServlet {

  private DatabaseHelper databaseHelper = new DatabaseHelper();
  private DatabaseService databaseService = new DatabaseServiceImpl(databaseHelper);
  private UserService userService = new UserServiceImpl(databaseService);

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    if (request.getParameter("deposit") != null) {

      try {
        HttpSession session = request.getSession();
        userService.deposit((String) session.getAttribute("userName"), request.getParameter("sum"));
      } catch (InvalidFormatException exception) {
      }

      response.sendRedirect("onlinebanking/index.jsp");
    }

    if (request.getParameter("withdraw") != null) {
      getServletContext().getRequestDispatcher("/withdraw").forward(request, response);
    }
  }
}
