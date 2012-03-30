package com.clouway.jspservlet.onlinebanking;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public final class Injector {

  private static DatabaseHelper databaseHelper;
  private static OnlineUserManager onlineUserManager;
  private static RegisterService registerService;
  private static BalanceService balanceService;
  private static DepositService depositService;
  private static WithdrawService withdrawService;

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
    if (balanceService == null) {
      balanceService = new BalanceServiceImpl(databaseHelper, user);
    }
    return balanceService;
  }

  public static DepositService injectDepositService(BalanceService balanceService) {
    if (depositService == null) {
      depositService = new DepositServiceImpl(balanceService);
    }

    return depositService;
  }

  public static WithdrawService injectWithdrawService(BalanceService balanceService) {
    if (withdrawService == null) {
      withdrawService = new WithdrawServiceImp(balanceService);
    }
    return withdrawService;
  }
}
