package com.clouway.jspservlet.onlinebanking;

/**
 * DepositService interface provide method for depositing
 * an amount to the user's account balance
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface DepositService {

  /**
   * Deposit amount to the user's account balance
   *
   * @param amount - the amount we want to deposit
   */
  void deposit(double amount);
}
