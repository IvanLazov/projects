package com.clouway.guice.onlinebanking;

import com.google.inject.*;
import com.google.inject.Provider;

/**
 * BalanceServiceImpl class implements BalanceService interface.
 * Provides implementation of the methods for updating and getting user's account balance
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class BalanceServiceImpl implements BalanceService {

  private Provider<User> userProvider;
  private final DatabaseHelper databaseHelper;

  /**
   * Constructor creates BalanceServiceImpl object
   *
   * @param databaseHelper - databaseHelper we use to execute queries against the database
   */
  @Inject
  public BalanceServiceImpl(DatabaseHelper databaseHelper, Provider<User> provider) {
    this.databaseHelper = databaseHelper;
    this.userProvider = provider;
  }

  /**
   * Update user account balance
   *
   * @param amount - the amount we add to the user's account balance
   */
  public void updateBalance(double amount) {
    databaseHelper.executeTransaction("UPDATE account SET balance=? WHERE userId=?", amount, userProvider.get().getUserId());
  }

  /**
   * Return user's account balance
   *
   * @return - user balance
   */
  public double getBalance() {
    return Double.parseDouble(databaseHelper.executeQueryResult("SELECT balance FROM account WHERE userId=?", userProvider.get().getUserId()));
  }
}
