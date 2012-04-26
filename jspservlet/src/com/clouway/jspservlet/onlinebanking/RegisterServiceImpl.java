package com.clouway.jspservlet.onlinebanking;

import com.google.inject.Inject;

/**
 * RegisterServiceImpl implements RegisterService methods.
 * Used to register new user with specified username and password
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class RegisterServiceImpl implements RegisterService {

  private final DatabaseHelper databaseHelper;

  @Inject
  public RegisterServiceImpl(DatabaseHelper databaseHelper) {
    this.databaseHelper = databaseHelper;
  }

  /**
   * Register new user with specified userName and password
   *
   * @param userName - username we will use to register
   * @param password - password we will use to register
   */
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
