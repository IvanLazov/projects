package com.clouway.guice.onlinebanking;

import com.google.inject.Inject;

/**
 * LoginServiceImpl implements LoginService
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class LoginServiceImpl implements LoginService {

  private final DatabaseHelper databaseHelper;

  @Inject
  public LoginServiceImpl(DatabaseHelper databaseHelper) {
    this.databaseHelper = databaseHelper;
  }

  /**
   * Login user and if login is successful, returns a User object
   *
   * @param userName - userName
   * @param password - password
   * @return - a User object
   */
  public User login(String userName, String password) {

    User user = databaseHelper.executeQuery("SELECT * FROM user WHERE userName=? && password=?", new UserProvider(), userName, password);
    
    if (user == null) {
      throw new WrongUserNameOrPasswordException();
    }
    
    return user;
  }
}
