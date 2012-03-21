package com.clouway.jspservlet.registrationform;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class Form {
  
  private List<FieldValidator> validatorList;

  public Form(List<FieldValidator> validatorList) {
    
    this.validatorList = validatorList;
  }
  
  public void validateRequest(HttpServletRequest request, Map<String, String> errors) {

    for (FieldValidator validator : validatorList) {
      validator.validate(request, errors);
    }
  }
}
