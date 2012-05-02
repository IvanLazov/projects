package com.clouway.guice.onlinebanking;

/**
 * WithdrawService provides method for withdraw from user's account
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface WithdrawService {

  /**
   * Withdraw amount from user's account
   *
   * @param amount - the amount we will withdraw
   */
  void withdraw(double amount);
}
