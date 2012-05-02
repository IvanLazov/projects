package com.clouway.guice.onlinebanking;

import com.google.inject.Inject;

/**
 * WithdrawServiceImpl implements WithdrawService.
 * Provides implementation of withdraw method
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class WithdrawServiceImp implements WithdrawService {

  private final BalanceService balanceService;

  @Inject
  public WithdrawServiceImp(BalanceService balanceService) {
    this.balanceService = balanceService;
  }

  /**
   * Withdraw amount from user account
   *
   * @param amount - the amount we will withdraw
   */
  public void withdraw(double amount) {

    if (amount <= 0 || amount > 10000) {
      throw new InvalidWithdrawAmountException();
    }

    double currentBalance = balanceService.getBalance();

    if (currentBalance < amount) {
      throw new InsufficientFundsException();
    }

    balanceService.updateBalance(currentBalance - amount);
  }
}
