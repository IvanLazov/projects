package com.clouway.jspservlet.onlinebanking;

/**
 * BalanceServiceImpl class implement BalanceService interface.
 * Provides implementation of the methods for updating and getting user's balance
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class BalanceServiceImpl implements BalanceService {

  private final DatabaseHelper databaseHelper;
  private User user;

  /**
   * Constructor creates BalanceServiceImpl
   *
   * @param databaseHelper - databaseHelper we used to execute queries to the database
   * @param user - User object from which we extract user's data
   */
  public BalanceServiceImpl(DatabaseHelper databaseHelper, User user) {
    this.databaseHelper = databaseHelper;
    this.user = user;
  }

  /**
   * Updates user balance
   *
   * @param amount - the sum we add to the user's balance
   */
  public void updateBalance(double amount) {
    databaseHelper.executeQuery("UPDATE account SET balance=? WHERE userId=?", amount, user.getUserId());
  }

  /**
   * Returns user balance
   *
   * @return - user balance
   */
  public double getBalance() {
    return Double.parseDouble(databaseHelper.executeQueryResult("SELECT balance FROM account WHERE userId=?", user.getUserId()));
  }
}
