package com.clouway.jspservlet.onlinebanking;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class LoginServiceImpl implements LoginService {

  private final DatabaseHelper databaseHelper;

  public LoginServiceImpl(DatabaseHelper databaseHelper) {
    this.databaseHelper = databaseHelper;
  }

  public User login(String userName, String password) {

    User user = databaseHelper.executeQuery("SELECT * FROM user WHERE userName=? && password=?", new UserProvider(), userName, password);
    
    if (user == null) {
      throw new WrongUserNameOrPasswordException();
    }
    
    return user;
  }
}
