package com.clouway.jspservlet.registrationform;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class RegistrationServlet extends HttpServlet {

  private Resources resources = new Resources();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Map<String, String> fieldToValues = new HashMap<String, String>();

    for (int i = 0; i < resources.getNumberOfFields(); i++) {
      fieldToValues.put(resources.getFieldName(i), request.getParameter(resources.getFieldName(i)));
    }

    ValidatorService validatorService = new ValidatorService();
    validatorService.checkFieldValues(fieldToValues);

    HttpSession session = request.getSession();

    session.setAttribute("fieldToValues", fieldToValues);
    session.setAttribute("errors", validatorService.getErrors());

    response.sendRedirect("registrationform/index.jsp");
  }
}
