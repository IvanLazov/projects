package com.clouway.guice.onlinebanking;

import com.google.inject.Inject;

/**
 * DepositServiceImpl class implements DepositService.
 * Provides implementation of the deposit method, with which
 * we can deposit amount to the user's account balance
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class DepositServiceImpl implements DepositService {

  private final BalanceService balanceService;

  @Inject
  public DepositServiceImpl(BalanceService balanceService) {
    this.balanceService = balanceService;
  }

  /**
   * Deposit amount to the user's account balance.
   * Valid amount must be between 1 and 10,000
   *
   * @param amount - the amount we want to deposit
   */
  public void deposit(double amount) {

    if (amount <= 0 || amount > 10000) {
      throw new InvalidDepositAmountException();
    }

    double currentBalance = balanceService.getBalance();

    balanceService.updateBalance(currentBalance + amount);
  }
}
