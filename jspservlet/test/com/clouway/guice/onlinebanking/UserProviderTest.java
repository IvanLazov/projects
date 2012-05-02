package com.clouway.guice.onlinebanking;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class UserProviderTest {

  private DatabaseHelper databaseHelper;
  private final User expectedUser = new User(1, "Ivan", "123456");
  
  @Before
  public void setUp() {

    databaseHelper = new DatabaseHelper();
    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
  }

  @Test
  public void getUser() {
    
    databaseHelper.executeQuery("INSERT INTO user(userId,userName,password) VALUES(?,?,?)", expectedUser.getUserId(), expectedUser.getUserName(), expectedUser.getPassword());
    User actualUser = databaseHelper.executeQuery("SELECT * FROM user WHERE userName=?", new UserProvider(), expectedUser.getUserName());

    assertEquals(expectedUser, actualUser);
  }

  @After
  public void tearDown() {

    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
  }
}
