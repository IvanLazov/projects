package com.clouway.guice.onlinebanking;

/**
 * LoginService interface provide method for login.
 * After successful login, returns a User object
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface LoginService {

  /**
   * Login user with specified userName and password
   *
   * @param userName - the userName we will use to login
   * @param password - the password we will use to login
   * @return - a User object, after successful login
   */
  User login(String userName, String password);
}
