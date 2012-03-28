package com.clouway.jspservlet.onlinebanking;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public final class Injector {

  public static DatabaseHelper injectDatabaseHelper() {
    return new DatabaseHelper();
  }

  public static DatabaseService injectDatabaseService(DatabaseHelper databaseHelper) {
    return new DatabaseServiceImpl(databaseHelper);
  }

  public static RegisterService injectRegisterService(DatabaseHelper databaseHelper) {
    return new RegisterServiceImpl(databaseHelper);
  }

  public static UserService injectUserService(DatabaseService databaseService) {
    return new UserServiceImpl(databaseService);
  }
}
