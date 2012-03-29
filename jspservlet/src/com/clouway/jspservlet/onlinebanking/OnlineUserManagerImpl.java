package com.clouway.jspservlet.onlinebanking;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class OnlineUserManagerImpl implements OnlineUserManager {

  private final DatabaseHelper databaseHelper;

  public OnlineUserManagerImpl(DatabaseHelper databaseHelper) {
    this.databaseHelper = databaseHelper;
  }

  public void setUserOnline(String sessionId, String userName) {
    databaseHelper.executeQuery("INSERT INTO onlineUser(sessionId,userName) VALUES(?,?)", sessionId, userName);
  }

  public void setUserOffline(String sessionId) {
    databaseHelper.executeQuery("DELETE FROM onlineUser WHERE sessionId=?", sessionId);
  }

  public int getNumberOfOnlineUsers() {
    return Integer.parseInt(databaseHelper.executeQueryResult("SELECT COUNT(DISTINCT userName) FROM onlineUser"));
  }
}
