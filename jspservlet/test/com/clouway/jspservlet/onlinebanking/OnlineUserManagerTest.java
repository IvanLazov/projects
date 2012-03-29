package com.clouway.jspservlet.onlinebanking;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class OnlineUserManagerTest {

  private DatabaseHelper databaseHelper;
  private OnlineUserManager onlineUserManager;
  private String sessionId = "123456QWERTY";
  private String userName = "Ivan";
  
  @Before
  public void setUp() {

    databaseHelper = new DatabaseHelper();
    onlineUserManager = new OnlineUserManagerImpl(databaseHelper);
    databaseHelper.executeQuery("DELETE FROM onlineUser");
  }

  @Test
  public void setUserOnline() {
        
    onlineUserManager.setUserOnline(sessionId, userName);
    assertEquals(sessionId, databaseHelper.executeQueryResult("SELECT sessionId FROM onlineUser WHERE userName=?", userName));
  }
  
  @Test
  public void setUserOffline() {
    
    onlineUserManager.setUserOffline(sessionId);
    assertEquals("", databaseHelper.executeQueryResult("SELECT sessionId FROM onlineUser WHERE userName=?", userName));
  }
  
  @Test
  public void twoUsersAreOnline() {
    
    String secondSessionId = "98765AZERTY";
    String secondUserName = "Misho";
        
    onlineUserManager.setUserOnline(sessionId, userName);
    onlineUserManager.setUserOnline(secondSessionId, secondUserName);
    assertEquals(2, onlineUserManager.getNumberOfOnlineUsers());    
  }
}
