package com.clouway.guice.onlinebanking;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * RegisterServlet is used to register new user
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
@Singleton
public class RegisterServlet extends HttpServlet {

  private final RegisterService registerService;
  private final Validator validator;

  @Inject
  public RegisterServlet(RegisterService registerService, Validator validator) {
    this.registerService = registerService;
    this.validator = validator;
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    try {

      validator.validate(userName, password);
      registerService.register(userName, password);
      request.setAttribute("login", "You can now log in!");

    } catch (InvalidUserNameException e) {
      request.setAttribute("error", "Username must contain only letters. Length from 3 to 20 characters.");
    } catch (InvalidPasswordException e) {
      request.setAttribute("error", "Password can contain letters and digits. Length from 6 to 20 characters.");
    } catch (UserNameAlreadyExistsException e) {
      request.setAttribute("error", "Username already taken! Try with another one.");
    }

    request.getRequestDispatcher("onlinebanking/register.jsp").forward(request, response);
  }
}
