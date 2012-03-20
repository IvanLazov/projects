package com.clouway.jspservlet.registrationform;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Resources {
  
  private Map<String, String> messageMap;
  private String[] fieldNames = new String[]{"firstName", "lastName", "egn", "age", "address", "password", "confirmPassword"};
  
  public Resources() {

    messageMap = new HashMap<String, String>();
    messageMap.put("firstName", "First name must contain only letters. Length 3-15 characters.");
    messageMap.put("lastName", "Last name must contain only letters. Length 3-15 characters.");
    messageMap.put("egn", "EGN must contain exactly 10 digits.");
    messageMap.put("age", "Valid age between 18-118 years.");
    messageMap.put("address", "Address can contain only letters and digits.");
    messageMap.put("password", "Password can contain only letters and digits.");
    messageMap.put("confirmPassword", "Password don't match");
  }
  
     
  public Map<String, String> populateValues(HttpServletRequest request) {
    Map<String, String> fieldToValueMap = new HashMap<String, String>();
    for (String field : fieldNames) {
      String fieldValue = request.getParameter(field);

      fieldToValueMap.put(field, fieldValue);
    }
    return fieldToValueMap;
  }
}
