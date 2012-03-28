package com.clouway.jspservlet.onlinebanking;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface DatabaseService {
  
  //void save(String userName, String password) throws DuplicateEntryException;

  void updateBalance(String userName, double sum);
  
  double getBalance(String userName);

  String getUserName(String userName);

  String getPassword(String userName);

  void setUserOnline(String sessionId, String userName);

  void setUserOffline(String sessionId);
  
  int getNumberOfOnlineUsers();
}
