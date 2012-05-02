package com.clouway.guice.onlinebanking;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class AccountProviderTest {

  private DatabaseHelper databaseHelper;
  private final User user = new User(1, "Ivan", "123456");
  private final Account expectedAccount = new Account(1, 1, 0.0);

  @Before
  public void setUp() {

    databaseHelper = new DatabaseHelper();
    
    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
  }

  @Test
  public void getAccount() {

    databaseHelper.executeQuery("INSERT INTO user(userId, userName, password) VALUES(?,?,?)", user.getUserId(), user.getUserName(), user.getPassword());
    databaseHelper.executeQuery("INSERT INTO account(accountId, userId, balance) VALUES (?,?,?)", expectedAccount.getAccountId(), expectedAccount.getUserId(), expectedAccount.getBalance());

    Account actualAccount = databaseHelper.executeQuery("SELECT * FROM account WHERE accountId=?", new AccountProvider(), expectedAccount.getAccountId());
    assertEquals(expectedAccount, actualAccount);
  }

  @After
  public void tearDown() {

    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
  }
}
