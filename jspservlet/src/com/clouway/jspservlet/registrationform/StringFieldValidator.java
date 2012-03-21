package com.clouway.jspservlet.registrationform;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class StringFieldValidator implements FieldValidator {
  
  private String fieldName;
  private String regex;
  private String errorMessage;

  public StringFieldValidator(String fieldName, String regex, String errorMessage) {

    this.fieldName = fieldName;
    this.regex = regex;
    this.errorMessage = errorMessage;
  }

  public void validate(HttpServletRequest request, Map<String, String> errors) {

    if (!request.getParameter(fieldName).matches(regex)) {
      errors.put(fieldName, errorMessage);
    }
  }
}
