package com.clouway.guice.onlinebanking;

/**
 * BalanceService interface provides methods to update and get user's account balance
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface BalanceService {

  /**
   * Update user account balance
   *
   * @param amount - the amount we want to add
   */
  void updateBalance(double amount);

  /**
   * Returns the user account balance
   *
   * @return - user account balance
   */
  double getBalance();
}
