package com.clouway.jspservlet.registrationform;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class RegistrationServlet extends HttpServlet {

  private String[] field = new String[]{"firstName", "lastName", "egn", "age", "address", "password", "confirmPassword"};
  private Map<String, String> fieldToValue;
  private RegistrationService registrationService;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    fieldToValue = new HashMap<String, String>();

    for (int i = 0; i < field.length; i++) {
      fieldToValue.put(field[i], request.getParameter(field[i]));
    }
    
    registrationService = new RegistrationService(fieldToValue);
    registrationService.checkFormData();

    request.setAttribute("error", registrationService.getErrors());
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("registrationform/index.jsp");
    requestDispatcher.forward(request, response);
    //response.sendRedirect("registrationform/index.jsp");
  }
}
