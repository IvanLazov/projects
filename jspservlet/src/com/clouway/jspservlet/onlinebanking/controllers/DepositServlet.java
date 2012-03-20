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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class DepositServlet extends HttpServlet {

  interface FieldValidator {
    void validate(HttpServletRequest request, Map<String, String> errors);
  }

  class StringFieldValidator implements FieldValidator{
    private String fieldName;
    private String regex;
    private String errorMessage;

    StringFieldValidator(String fieldName, String regex, String errorMessage) {
      this.fieldName = fieldName;
      this.regex = regex;
      this.errorMessage = errorMessage;
    }

    public void validate(HttpServletRequest request, Map<String, String> errors) {
      if (!regex.matches(request.getParameter(fieldName))) {
        errors.put(fieldName, errorMessage);
      }
    }
  }
  
  class SameFieldValidator implements FieldValidator {

    private final String firstField;
    private final String secondField;
    private final String errorMessage;

    public SameFieldValidator(String firstField, String secondField, String errorMessage) {

      this.firstField = firstField;
      this.secondField = secondField;
      this.errorMessage = errorMessage;
    }
    

    public void validate(HttpServletRequest request, Map<String, String> errors) {
      String firstValue = request.getParameter(firstField); //password
      String secondValue = request.getParameter(secondField); // confirmationPassword
      
      if (!firstValue.equals(secondValue)) {
        errors.put(secondField, errorMessage);
      }
    }
  }

  class Form {
    private final List<FieldValidator> validatorList;

    public Form(List<FieldValidator> validatorList) {
      this.validatorList = validatorList;
    }

    public void validateRequest(HttpServletRequest request, Map<String, String> errors) {
      for (FieldValidator field : validatorList) {
        field.validate(request, errors);
      }
    }
  }


  private DatabaseHelper databaseHelper = new DatabaseHelper();
  private DatabaseService databaseService = new DatabaseServiceImpl(databaseHelper);
  private UserService userService = new UserServiceImpl(databaseService);

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    List<FieldValidator> registrationValidatorList = new ArrayList<FieldValidator>();
    registrationValidatorList.add(new StringFieldValidator("username","[a-zA-Z]{3,18}", "Username was not valid."));
    registrationValidatorList.add(new StringFieldValidator("password","[a-z\\.\\|\\:\\@A-Z]{5,20}", "Password was not valid."));
    registrationValidatorList.add(new SameFieldValidator("password","confirmPassword", "Password and confirmation passwords are different."));

    Form registrationForm = new Form(registrationValidatorList);

    Map<String, String> errors = new HashMap<String, String>();
    registrationForm.validateRequest(request, errors);

    if (errors.size() > 0) {

      request.setAttribute("errors", errors);



      // dispatch to the same page
      request.getRequestDispatcher("..").forward(request, response);

    } else {

      // dispatch to another page or servlet
    }






















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
