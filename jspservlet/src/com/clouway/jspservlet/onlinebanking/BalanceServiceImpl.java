package com.clouway.jspservlet.onlinebanking;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class BalanceServiceImpl implements BalanceService {

  private final DatabaseHelper databaseHelper;
  private User user;  

  public BalanceServiceImpl(DatabaseHelper databaseHelper, User user) {
    this.databaseHelper = databaseHelper;
    this.user = user;
  }

  public void updateBalance(double sum) {
    databaseHelper.executeQuery("UPDATE account SET balance=? WHERE userId=?", sum, user.getUserId());
  }

  public double getBalance() {
    return Double.parseDouble(databaseHelper.executeQueryResult("SELECT balance FROM account WHERE userId=?", user.getUserId()));
  }
}
