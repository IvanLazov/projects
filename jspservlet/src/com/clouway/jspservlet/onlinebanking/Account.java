package com.clouway.jspservlet.onlinebanking;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class Account {
  
  private int accountId;
  private int userId;
  private double balance;

  public Account(int accountId, int userId, double balance) {
    this.accountId = accountId;
    this.userId = userId;
    this.balance = balance;
  }

  public int getAccountId() {
    return accountId;
  }

  public int getUserId() {
    return userId;
  }

  public double getBalance() {
    return balance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Account account = (Account) o;

    if (accountId != account.accountId) return false;
    if (Double.compare(account.balance, balance) != 0) return false;
    if (userId != account.userId) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = accountId;
    result = 31 * result + userId;
    temp = balance != +0.0d ? Double.doubleToLongBits(balance) : 0L;
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }
}
