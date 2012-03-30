package com.clouway.jspservlet.onlinebanking;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class DepositServiceImpl implements DepositService {

  private final BalanceService balanceService;

  public DepositServiceImpl(BalanceService balanceService) {
    this.balanceService = balanceService;
  }

  public void deposit(double amount) {

    if (amount <= 0 || amount > 10000) {
      throw new InvalidDepositAmountException();
    }
    double currentBalance = balanceService.getBalance();
    balanceService.updateBalance(currentBalance + amount);
  }
}
