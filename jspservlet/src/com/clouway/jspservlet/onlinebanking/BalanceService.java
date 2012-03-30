package com.clouway.jspservlet.onlinebanking;

/**
 * BalanceService interface have methods which we use
 * to update and get user's account balance
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface BalanceService {

  /**
   * Update the user account balance
   *
   * @param amount - the sum we add to the user's balance
   */
  void updateBalance(double amount);

  /**
   * Returns the user account balance
   *
   * @return - user balance
   */
  double getBalance();
}
