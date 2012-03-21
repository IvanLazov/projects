package com.clouway.jspservlet.registrationform;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface FieldValidator {
  
  void validate(HttpServletRequest request, Map<String, String> errors);
}
