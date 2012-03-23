package com.clouway.jspservlet.onlinebanking;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class RegisterServlet extends HttpServlet {

  private UserService userService = Injector.injectUserService(Injector.injectDatabaseService(Injector.injectDatabaseHelper()));

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    
    try {

      userService.register(userName, password);
      request.setAttribute("success", "You can now log in!");

    } catch (InvalidUserNameException exception) {
      request.setAttribute("error", "Invalid username! Username must contain only letters. Length from 3 to 20 characters.");
    } catch (InvalidPasswordException exception) {
      request.setAttribute("error", "Invalid password! Password can contain letters and digits. Length from 6 to 20 characters.");
    } catch (UserNameAlreadyExistsException exception) {
      request.setAttribute("error", "Username already taken! Try with another one.");
    }

    request.getRequestDispatcher("onlinebanking/register.jsp").forward(request, response);
  }
}
