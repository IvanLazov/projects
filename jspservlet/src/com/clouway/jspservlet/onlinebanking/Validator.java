package com.clouway.jspservlet.onlinebanking;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class Validator {
  
  public void validate(String userName, String password) {

    if (!userName.matches("[a-zA-Z]{3,20}")) {
      throw new InvalidUserNameException();
    }

    if (!password.matches("[a-zA-Z0-9]{6,20}")) {
      throw new InvalidPasswordException();
    }
  }
}
