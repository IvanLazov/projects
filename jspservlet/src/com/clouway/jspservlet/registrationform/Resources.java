package com.clouway.jspservlet.registrationform;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Resources {

  private String[] fieldNames = new String[]{"firstName", "lastName", "egn", "age", "address", "password", "confirmPassword"};
     
  public Map<String, String> populateValues(HttpServletRequest request) {

    Map<String, String> fieldToValueMap = new HashMap<String, String>();

    for (String field : fieldNames) {
      String fieldValue = request.getParameter(field);
      fieldToValueMap.put(field, fieldValue);
    }

    return fieldToValueMap;
  }
}
