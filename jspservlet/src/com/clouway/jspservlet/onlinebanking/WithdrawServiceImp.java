package com.clouway.jspservlet.onlinebanking;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class WithdrawServiceImp implements WithdrawService {

  private final BalanceService balanceService;

  public WithdrawServiceImp(BalanceService balanceService) {

    this.balanceService = balanceService;
  }

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
