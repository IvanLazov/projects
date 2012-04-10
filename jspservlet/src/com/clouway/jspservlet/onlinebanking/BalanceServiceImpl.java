package com.clouway.jspservlet.onlinebanking;

/**
 * BalanceServiceImpl class implements BalanceService interface.
 * Provides implementation of the methods for updating and getting user's account balance
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class BalanceServiceImpl implements BalanceService {

  private User user;
  private final DatabaseHelper databaseHelper;

  /**
   * Constructor creates BalanceServiceImpl object
   *
   * @param databaseHelper - databaseHelper we use to execute queries against the database
   * @param user - User object from which we extract data
   */
  public BalanceServiceImpl(DatabaseHelper databaseHelper, User user) {
    this.databaseHelper = databaseHelper;
    this.user = user;
  }

  /**
   * Update user account balance
   *
   * @param amount - the amount we add to the user's account balance
   */
  public void updateBalance(double amount) {
    databaseHelper.executeTransaction("UPDATE account SET balance=? WHERE userId=?", amount, user.getUserId());
  }

  /**
   * Return user's account balance
   *
   * @return - user balance
   */
  public double getBalance() {
    return Double.parseDouble(databaseHelper.executeQueryResult("SELECT balance FROM account WHERE userId=?", user.getUserId()));
  }
}
