package com.clouway.jspservlet.registrationform;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ValidatorServlet extends HttpServlet {

  private Resources resources = new Resources();    
  private List<FieldValidator> fieldValidatorList = new ArrayList<FieldValidator>();
  
  public void init() throws ServletException {

    fieldValidatorList.add(new StringFieldValidator("firstName", "[a-zA-Z]{1,15}", "Username must contain only letters. Length from 1 to 18 characters!"));
    fieldValidatorList.add(new StringFieldValidator("lastName", "[a-zA-Z]{1,15}", "Lastname must contain only letters. Length from 1 to 18 characters!"));
    fieldValidatorList.add(new StringFieldValidator("egn", "[0-9]{10}", "EGN must contain exactly 10 digits!"));
    fieldValidatorList.add(new AgeFieldValidator("age", "[0-9]{2,3}", "Valid age is between 18 and 118!"));
    fieldValidatorList.add(new StringFieldValidator("address", "[a-zA-Z0-9 ]{1,100}", "Address can contain letters and digits. Length from 1 to 100 characters!"));
    fieldValidatorList.add(new StringFieldValidator("password", "[a-zA-Z0-9]{6,18}", "Password must contain only letters and digits. Length from 6 to 18 characters"));
    fieldValidatorList.add(new StringTwoFieldValidator("password", "confirmPassword", "Passwords are not equals."));
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    Map<String, String> fieldToValues = resources.populateValues(request);
    Map<String, String> errors = new HashMap<String, String>();

    Form form = new Form(fieldValidatorList);
    form.validateRequest(request, errors);

    request.setAttribute("fieldToValues", fieldToValues);
    request.setAttribute("errors", errors);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/registrationform/userPage.jsp");
    dispatcher.forward(request, response);
  }
}
