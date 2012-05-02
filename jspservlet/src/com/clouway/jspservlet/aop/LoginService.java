package com.clouway.jspservlet.aop;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface LoginService {

  User login(String userName, String password);
}
