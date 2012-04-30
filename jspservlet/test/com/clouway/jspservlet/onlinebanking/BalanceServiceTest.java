package com.clouway.jspservlet.onlinebanking;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class BalanceServiceTest {

  private DatabaseHelper databaseHelper;
  private BalanceService balanceService;
  private final User user = new User(1, "Ivan", "159159");
  private final Account account = new Account(1, 1, 0.0);

  @Before
  public void setUp() {

    databaseHelper = new DatabaseHelper();
    balanceService = new BalanceServiceImpl(databaseHelper, new com.google.inject.Provider<com.clouway.jspservlet.onlinebanking.User>() {
      public User get() {
        return new User(1, "Ivan", "159159");
      }
    });
    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
  }

  @Test
  public void updateUserBalance() {

    databaseHelper.executeQuery("INSERT INTO user (userId, username, password) VALUES(?,?,?)", user.getUserId(), user.getUserName(), user.getPassword());
    databaseHelper.executeQuery("INSERT INTO account (accountId, userId, balance) VALUES(?,?,?)", account.getAccountId(), account.getUserId(), account.getBalance());

    balanceService.updateBalance(350.00);

    assertEquals(350.00, balanceService.getBalance());
  }

  @After
  public void tearDown() {

    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
  }
}
