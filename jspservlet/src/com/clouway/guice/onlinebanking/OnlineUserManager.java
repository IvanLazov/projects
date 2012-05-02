package com.clouway.guice.onlinebanking;

/**
 * OnlineUserManager provides methods for setting user online/offline,
 * and get the number of online users
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface OnlineUserManager {

  /**
   * Set user online, after successful login
   * and save user sessionId and userName
   *
   * @param sessionId - user's sessionId
   * @param userName - userName
   */
  void setUserOnline(String sessionId, String userName);

  /**
   * Set user offline, after successful logout
   *
   * @param sessionId - user's sessionId
   */
  void setUserOffline(String sessionId);

  /**
   * Get the number of online users
   *
   * @return - the number of online users
   */
  int getNumberOfOnlineUsers();
}
