package com.clouway.guice.onlinebanking;

import com.google.inject.Inject;

/**
 * OnlineUserManagerImpl implements OnlineUserManager methods
 * Set user online/offline, and get the number of online users
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class OnlineUserManagerImpl implements OnlineUserManager {

  private final DatabaseHelper databaseHelper;

  @Inject
  public OnlineUserManagerImpl(DatabaseHelper databaseHelper) {
    this.databaseHelper = databaseHelper;
  }

  /**
   * Set user online, after successful login
   *
   * @param sessionId - user's sessionId
   * @param userName - userName
   */
  public void setUserOnline(String sessionId, String userName) {
    databaseHelper.executeQuery("INSERT INTO onlineUser(sessionId,userName) VALUES(?,?)", sessionId, userName);
  }

  /**
   * Set user offline, after successful logout
   *
   * @param sessionId - user's sessionId
   */
  public void setUserOffline(String sessionId) {
    databaseHelper.executeQuery("DELETE FROM onlineUser WHERE sessionId=?", sessionId);
  }

  /**
   * Get the number of online users
   *
   * @return - number of online users
   */
  public int getNumberOfOnlineUsers() {
    return Integer.parseInt(databaseHelper.executeQueryResult("SELECT COUNT(DISTINCT userName) FROM onlineUser"));
  }
}
