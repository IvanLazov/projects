package com.clouway.jspservlet.onlinebanking;

/**
 * Injector class is used to inject objects when we need them..
 * This way we reduce the dependencies in our code.
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public final class Injector {

  private static DatabaseHelper databaseHelper;
  private static RegisterService registerService;
  private static OnlineUserManager onlineUserManager;
  
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

  public static BalanceService injectBalanceService(DatabaseHelper databaseHelper, User user) {
    return new BalanceServiceImpl(databaseHelper, user);
  }

  public static DepositService injectDepositService(BalanceService balanceService) {
    return new DepositServiceImpl(balanceService);
  }

  public static WithdrawService injectWithdrawService(BalanceService balanceService) {
    return new WithdrawServiceImp(balanceService);
  }
}
