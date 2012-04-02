package com.clouway.jspservlet.onlinebanking;

/**
 * Validator class is used to validate entered username and password
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class Validator {

  /**
   * Validate username and password using regex matches
   *
   * @param userName - username to validate
   * @param password - password to validate
   */
  public void validate(String userName, String password) {

    if (!userName.matches("[a-zA-Z]{3,20}")) {
      throw new InvalidUserNameException();
    }

    if (!password.matches("[a-zA-Z0-9]{6,20}")) {
      throw new InvalidPasswordException();
    }
  }
}
