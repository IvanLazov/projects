package com.clouway.jspservlet.onlinebanking;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public final class Injector {

  private static DatabaseHelper databaseHelper;
  private static OnlineUserManager onlineUserManager;
  private static RegisterService registerService;

  public static DatabaseHelper injectDatabaseHelper() {
    if (databaseHelper == null) {
      databaseHelper = new DatabaseHelper();
    }
    return databaseHelper;
  }

  public static RegisterService injectRegisterService(DatabaseHelper databaseHelper) {
    if (registerService == null) {
      registerService = new RegisterServiceImpl(databaseHelper);
    }
    return registerService;
  }
  
  public static OnlineUserManager injectOnlineUserManager(DatabaseHelper databaseHelper) {
    if (onlineUserManager == null) {
      onlineUserManager = new OnlineUserManagerImpl(databaseHelper);
    }
    return onlineUserManager;
  }
}
