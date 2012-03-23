package com.clouway.jspservlet.onlinebanking;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class DatabaseServiceImpl implements DatabaseService {

  private DatabaseHelper databaseHelper;

  public DatabaseServiceImpl(DatabaseHelper databaseHelper) {
    this.databaseHelper = databaseHelper;
  }

  public void save(String userName, String password) {

    databaseHelper.executeQuery("INSERT INTO user(userName,password) VALUES (?,?)", userName, password);
    databaseHelper.executeQuery("INSERT INTO account(userId, balance) VALUES ((SELECT userId FROM user WHERE userName=?), 0.00)", userName);
  }

  public void updateBalance(String userName, double sum) {

    databaseHelper.executeQuery("UPDATE account SET balance=? WHERE userId=(SELECT userId FROM user WHERE userName=?)", sum, userName);
  }

  public double getBalance(String userName) {
    
    double balance;
    balance = Double.parseDouble(databaseHelper.executeQueryResult("SELECT balance FROM account WHERE userId=(SELECT userId FROM user WHERE userName=?)", userName));
    return balance;
  }

  public String getUserName(String userName) {
    
    String user;
    user = databaseHelper.executeQueryResult("SELECT userName FROM user WHERE userName=?", userName);
    return user;
  }

  public String getPassword(String userName) {
    
    String password;
    password = databaseHelper.executeQueryResult("SELECT password FROM user WHERE userName=?", userName);
    return password;
  }

  public void setUserOnline(String sessionId, String userName) {

    databaseHelper.executeQuery("INSERT INTO onlineUser(sessionId, userName) VALUES(?,?)", sessionId, userName);
  }

  public void setUserOffline(String sessionId) {

    databaseHelper.executeQuery("DELETE FROM onlineUser WHERE sessionId=?", sessionId);
  }

  public int getNumberOfOnlineUsers() {
    
    int numberOfOnlineUsers;
    numberOfOnlineUsers = Integer.parseInt(databaseHelper.executeQueryResult("SELECT COUNT(DISTINCT userName) FROM onlineUser"));
    return numberOfOnlineUsers;
  }
}
