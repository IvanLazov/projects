package com.clouway.jspservlet.onlinebanking;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface OnlineUserManager {
  
  void setUserOnline(String sessionId, String userName);
  
  void setUserOffline(String sessionId);
  
  int getNumberOfOnlineUsers();
}
