package com.clouway.jspservlet.registrationform;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface Validator {
  
  boolean firstName(String firstName);
  
  boolean lastName(String lastName);

  boolean egn(String egn);

  boolean age(String age);

  boolean address(String address);
  
  boolean password(String password);

  boolean confirmPassword(String password, String confirmPassword);
}
