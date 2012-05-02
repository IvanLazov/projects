package com.clouway.jspservlet.aop;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class LoginServiceImpl implements LoginService {

  @Login
  public User login(String userName, String password) {
    return null;
  }
}
