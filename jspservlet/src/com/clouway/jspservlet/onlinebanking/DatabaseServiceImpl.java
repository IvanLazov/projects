package com.clouway.jspservlet.onlinebanking;

import com.clouway.jspservlet.onlinebanking.exceptions.DuplicateEntryException;

import java.sql.SQLException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class DatabaseServiceImpl implements DatabaseService {

  private DatabaseHelper databaseHelper;

  public DatabaseServiceImpl(DatabaseHelper databaseHelper) {
    this.databaseHelper = databaseHelper;
  }

  public void save(String userName, String password) {

    try {
      databaseHelper.executeQuery("INSERT INTO user(userName,password) VALUES (?,?)", userName, password);
      databaseHelper.executeQuery("INSERT INTO account(userId, balance) VALUES ((SELECT userId FROM user WHERE userName=?), 0.00)", userName);
    } catch (SQLException e) {
      if (e.getErrorCode() == 1062) {
        throw new DuplicateEntryException();
      }
    }
  }

  public void updateBalance(String userName, double sum) {

    try {
      databaseHelper.executeQuery("UPDATE account SET balance=? WHERE userId=(SELECT userId FROM user WHERE userName=?)", sum, userName);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public double getBalance(String userName) {
    
    double balance = 0;
    
    try {
      balance = Double.parseDouble(databaseHelper.executeQueryResult("SELECT balance FROM account WHERE userId=(SELECT userId FROM user WHERE userName=?)", userName));
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return balance;
  }

  public String getUserName(String userName) {
    
    String user = "";
    
    try {
      user = databaseHelper.executeQueryResult("SELECT userName FROM user WHERE userName=?", userName);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return user;
  }

  public String getPassword(String userName) {
    
    String password = "";
    
    try {
      password = databaseHelper.executeQueryResult("SELECT password FROM user WHERE userName=?", userName);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return password;
  }

  public void setUserOnline(String userName, String sessionId) {

    try {
      databaseHelper.executeQuery("INSERT INTO onlineUser(sessionId, userName) VALUES(?,?)", sessionId, userName);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void setUserOffline(String sessionId) {

    try {
      databaseHelper.executeQuery("DELETE FROM onlineUser WHERE sessionId=?", sessionId);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public int getNumberOfLoggedUsers() {
    
    int count = 0;

    try {
      count = Integer.parseInt(databaseHelper.executeQueryResult("SELECT COUNT(DISTINCT userName) FROM onlineUser"));
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return count;
  }
}
