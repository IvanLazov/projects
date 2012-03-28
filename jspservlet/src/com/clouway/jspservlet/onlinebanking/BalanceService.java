package com.clouway.jspservlet.onlinebanking;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface BalanceService {

  void updateBalance(double sum);

  double getBalance();
}
