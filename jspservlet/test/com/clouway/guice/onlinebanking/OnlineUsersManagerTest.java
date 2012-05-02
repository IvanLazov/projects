package com.clouway.guice.onlinebanking;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class OnlineUsersManagerTest {

  private DatabaseHelper databaseHelper;
  private OnlineUserManager onlineUsersManager;
  private final String sessionId = "123456QWERTY";
  private final String userName = "Ivan";
  
  @Before
  public void setUp() {

    databaseHelper = new DatabaseHelper();
    onlineUsersManager = new OnlineUserManagerImpl(databaseHelper);
    databaseHelper.executeQuery("DELETE FROM onlineUser");
  }

  @Test
  public void setUserOnline() {
        
    onlineUsersManager.setUserOnline(sessionId, userName);
    assertEquals(sessionId, databaseHelper.executeQueryResult("SELECT sessionId FROM onlineUser WHERE userName=?", userName));
  }
  
  @Test
  public void setUserOffline() {
    
    onlineUsersManager.setUserOffline(sessionId);
    assertEquals("", databaseHelper.executeQueryResult("SELECT sessionId FROM onlineUser WHERE userName=?", userName));
  }
  
  @Test
  public void twoUsersAreOnline() {
    
    String secondSessionId = "98765AZERTY";
    String secondUserName = "Misho";
        
    onlineUsersManager.setUserOnline(sessionId, userName);
    onlineUsersManager.setUserOnline(secondSessionId, secondUserName);
    assertEquals(2, onlineUsersManager.getNumberOfOnlineUsers());
  }

  @After
  public void tearDown() {
    databaseHelper.executeQuery("DELETE FROM onlineUser");
  }
}
