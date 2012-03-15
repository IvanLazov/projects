package com.clouway.jspservlet.onlinebanking;

import com.clouway.jspservlet.onlinebanking.exceptions.InvalidPasswordException;
import com.clouway.jspservlet.onlinebanking.exceptions.InvalidUserNameException;
import com.clouway.jspservlet.onlinebanking.exceptions.UserNameAlreadyExistsException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class RegisterServlet extends HttpServlet {

  private DatabaseHelper databaseHelper = new DatabaseHelper();
  private DatabaseService databaseService = new DatabaseServiceImpl(databaseHelper);
  private UserService userService = new UserServiceImpl(databaseService);

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    
    try {

      userService.register(userName, password);

      HttpSession session = request.getSession();
      session.setAttribute("userName", userName);
      databaseService.setUserOnline(userName, session.getId());

      response.sendRedirect("onlinebanking/index.jsp");

    } catch (InvalidUserNameException exception) {
      response.sendRedirect("onlinebanking/register.jsp?error=Invalid username! Username must contain only letters. Length from 3 to 20 characters.");
    } catch (InvalidPasswordException exception) {
      response.sendRedirect("onlinebanking/register.jsp?error=Invalid password! Password can contain letters and digits. Length from 6 to 20 characters");
    } catch (UserNameAlreadyExistsException exception) {
      response.sendRedirect("onlinebanking/register.jsp?error=Username already exists! Try with another username.");
    }
  }
}
