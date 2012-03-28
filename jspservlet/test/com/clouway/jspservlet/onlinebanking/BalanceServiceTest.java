package com.clouway.jspservlet.onlinebanking;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class BalanceServiceTest {

  private DatabaseHelper databaseHelper;
  private BalanceService balanceService;
  private User user;
  
  @Before
  public void setUp() {
    
    user = new User(1, "Ivan", "159159");
    databaseHelper = new DatabaseHelper();
    balanceService = new BalanceServiceImpl(databaseHelper, user);
    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
  }
  
  @Test
  public void updateUserBalance() {

    databaseHelper.executeQuery("INSERT INTO user (userId, username, password) VALUES(?,?,?)", user.getUserId(), user.getUserName(), user.getPassword());
    databaseHelper.executeQuery("INSERT INTO account (accountId, userId, balance) VALUES(?,?,?)", 1, 1, 0.0);

    balanceService.updateBalance(150.00);

    assertEquals(150.00, balanceService.getBalance());
  }
}
