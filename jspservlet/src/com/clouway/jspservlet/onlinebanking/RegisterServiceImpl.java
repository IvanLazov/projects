package com.clouway.jspservlet.onlinebanking;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class RegisterServiceImpl implements RegisterService {

  private DatabaseHelper databaseHelper;

  public RegisterServiceImpl(DatabaseHelper databaseHelper) {
    this.databaseHelper = databaseHelper;
  }

  public void register(String userName, String password) {

    try {

      databaseHelper.executeQuery("INSERT INTO user (userName, password) VALUES(?,?)", userName, password);
      String userId = databaseHelper.executeQueryResult("SELECT userId FROM user WHERE userName=?", userName);
      databaseHelper.executeQuery("INSERT INTO account (userId, balance) VALUES(?,?)", userId, 0.0);
    } catch (DuplicateEntryException e) {
      throw new UserNameAlreadyExistsException();
    }
  }
}
