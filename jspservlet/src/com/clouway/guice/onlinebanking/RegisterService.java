package com.clouway.guice.onlinebanking;

/**
 * RegisterService provides a method for registering new user
 * with specified username and password
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface RegisterService {

  /**
   * Register new user with specified username and password
   *
   * @param userName - username we will use to register
   * @param password - password we will use to register
   */
  void register(String userName, String password);
}
