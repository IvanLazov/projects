package com.clouway.jspservlet.onlinebanking;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class AccountProviderTest {

  private DatabaseHelper databaseHelper;

  @Before
  public void setUp() {

    databaseHelper = new DatabaseHelper();
    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
  }

  @Test
  public void getAccount() {

    User user = new User(1, "Ivan", "123456");
    Account expected = new Account(10, 1, 150);

    databaseHelper.executeQuery("INSERT INTO user(userId, userName, password) VALUES(?,?,?)", user.getUserId(), user.getUserName(), user.getPassword());
    databaseHelper.executeQuery("INSERT INTO account(accountId, userId, balance) VALUES (?,?,?)", expected.getAccountId(), expected.getUserId(), expected.getBalance());

    Account actual = databaseHelper.executeQuery("SELECT * FROM account WHERE accountId=?", new AccountProvider(), expected.getAccountId());
    assertEquals(expected, actual);
  }
}
