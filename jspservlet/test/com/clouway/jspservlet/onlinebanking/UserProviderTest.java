package com.clouway.jspservlet.onlinebanking;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class UserProviderTest {

  private DatabaseHelper databaseHelper;

  @Before
  public void setUp() {

    databaseHelper = new DatabaseHelper();
    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
  }

  @Test
  public void getUser() {
    
    databaseHelper.executeQuery("INSERT INTO user(userId,userName,password) VALUES(?,?,?)", 1, "Ivan", "159159");

    User expected = new User(1, "Ivan", "159159");
    User actual = databaseHelper.executeQuery("SELECT * FROM user WHERE userName=?", new UserProvider(), "Ivan");

    assertEquals(expected, actual);
  }
}
