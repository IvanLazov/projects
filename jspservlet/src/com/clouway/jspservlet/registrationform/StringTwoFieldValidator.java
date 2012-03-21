package com.clouway.jspservlet.registrationform;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class StringTwoFieldValidator implements FieldValidator {

  private String password;
  private String confirmPassword;
  private String errorMessage;

  public StringTwoFieldValidator(String password, String confirmPassword, String errorMessage) {

    this.password = password;
    this.confirmPassword = confirmPassword;
    this.errorMessage = errorMessage;
  }

  public void validate(HttpServletRequest request, Map<String, String> errors) {

    if (!request.getParameter(confirmPassword).equals(request.getParameter(password))) {
      errors.put(confirmPassword, errorMessage);
    }
  }
}
