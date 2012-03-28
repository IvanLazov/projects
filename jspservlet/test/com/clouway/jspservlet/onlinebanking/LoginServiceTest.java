package com.clouway.jspservlet.onlinebanking;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class LoginServiceTest {
  
  private DatabaseHelper databaseHelper;
  private LoginService loginService;
  
  @Before
  public void setUp() {
    
    databaseHelper = new DatabaseHelper();
    loginService = new LoginServiceImpl(databaseHelper);
    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
  }
  
  @Test
  public void loginUser() {

    databaseHelper.executeQuery("INSERT INTO user(userId, userName, password) VALUES(?,?,?)", 1, "Ivan", "159159");
    User user = new User(1, "Ivan", "159159");
    assertEquals(user, loginService.login(user.getUserName(), user.getPassword()));
  }
}
