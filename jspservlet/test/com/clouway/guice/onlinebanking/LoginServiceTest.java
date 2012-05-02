package com.clouway.guice.onlinebanking;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class LoginServiceTest {
  
  private DatabaseHelper databaseHelper;
  private LoginService loginService;
  private final User user = new User(123, "Ivan", "123456");
  
  @Before
  public void setUp() {
    
    databaseHelper = new DatabaseHelper();
    loginService = new LoginServiceImpl(databaseHelper);

    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
  }
  
  @Test
  public void loginRegisteredUser() {

    databaseHelper.executeQuery("INSERT INTO user(userId, userName, password) VALUES(?,?,?)", user.getUserId(), user.getUserName(), user.getPassword());
    assertEquals(user, loginService.login(user.getUserName(), user.getPassword()));
  }
  
  @Test(expected = WrongUserNameOrPasswordException.class)
  public void cannotLoginUnregisteredUser() {
        
    databaseHelper.executeQuery("INSERT INTO user(userId, userName, password) VALUES(?,?,?)", user.getUserId(), user.getUserName(), user.getPassword());
    loginService.login("Misho", "151515");
  }

  @After
  public void tearDown() {

    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
  }
}
