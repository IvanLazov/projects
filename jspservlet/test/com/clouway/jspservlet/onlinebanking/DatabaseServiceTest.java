package com.clouway.jspservlet.onlinebanking;

import com.clouway.jspservlet.onlinebanking.exceptions.DuplicateEntryException;
import com.clouway.jspservlet.onlinebanking.persistance.DatabaseHelper;
import com.clouway.jspservlet.onlinebanking.persistance.DatabaseService;
import com.clouway.jspservlet.onlinebanking.persistance.DatabaseServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static junit.framework.Assert.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class DatabaseServiceTest {

  private DatabaseHelper databaseHelper = new DatabaseHelper();
  private DatabaseService databaseService;

  @Before
  public void setUp() throws SQLException {

    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
    databaseHelper.executeQuery("DELETE FROM onlineUser");
    databaseService = new DatabaseServiceImpl(databaseHelper);
  }

  @Test
  public void happyPath() throws SQLException {

    databaseService.save("Ivan","123456");
    assertEquals("Ivan", databaseHelper.executeQueryResult("SELECT userName FROM user WHERE userName=?", "Ivan"));
  }
  
  @Test
  public void saveTwoUsers() throws SQLException {

    databaseService.save("Ivan", "123456");
    databaseService.save("Misho", "654321");
    assertEquals("Misho", databaseHelper.executeQueryResult("SELECT userName FROM user WHERE userName=?", "Misho"));
    assertEquals("Misho", databaseHelper.executeQueryResult("SELECT userName FROM user WHERE userName=?", "Misho"));
    assertEquals("2", databaseHelper.executeQueryResult("SELECT COUNT(*) FROM user"));
  }

  @Test(expected = DuplicateEntryException.class)
  public void cannotSaveTwoUsersWithTheSameName() {

    databaseService.save("Ivan", "123456");
    databaseService.save("Ivan", "888888");
  }
  
  @Test
  public void newRegisteredUserHaveZeroBalanceInAccount() throws SQLException {

    databaseService.save("Ivan", "123456");
    assertEquals("0", databaseHelper.executeQueryResult("SELECT balance FROM account WHERE userId = (SELECT userId FROM user WHERE userName=?)", "Ivan"));
  }

  @Test
  public void increaseUserBalance() throws SQLException {
    
    databaseService.save("Ivan", "123456");
    databaseService.updateBalance("Ivan", 150.00);
    assertEquals("150", databaseHelper.executeQueryResult("SELECT balance FROM account WHERE userId = (SELECT userId FROM user WHERE userName=?)", "Ivan"));
  }
  
  @Test
  public void getUserBalance() throws SQLException {
    
    databaseService.save("Ivan", "123456");
    databaseService.updateBalance("Ivan", 260.00);
    assertEquals(260.00, databaseService.getBalance("Ivan"));
  }
  
  @Test
  public void getUserName() throws SQLException {
    
    databaseService.save("Ivan", "123456");
    assertEquals("Ivan", databaseService.getUserName("Ivan"));
  }

  @Test
  public void getEmptyUserName() throws SQLException {

    assertEquals("", databaseService.getUserName("Misho"));
  }

  @Test
  public void getUserPassword() throws SQLException {

    databaseService.save("Ivan", "123456");
    assertEquals("123456", databaseService.getPassword("Ivan"));
  }
  
  @Test
  public void getEmptyPassword() throws SQLException {
    
    assertEquals("", databaseService.getPassword("Misho"));
  }
  
  @Test
  public void setUserOnline() throws SQLException {
    
    databaseService.setUserOnline("Ivan", "QWERTY");
    assertEquals("Ivan", databaseHelper.executeQueryResult("SELECT userName FROM onlineUser WHERE sessionId=?", "QWERTY"));
  }
  
  @Test
  public void setUserOffline() throws SQLException {

    databaseService.setUserOnline("Ivan", "QWERTY");
    databaseService.setUserOffline("QWERTY");
    assertEquals("", databaseHelper.executeQueryResult("SELECT userName FROM onlineUser WHERE sessionId=?", "QWERTY"));
  }
  
  @Test
  public void getNumberOfLoggedUsers() throws SQLException {
    
    databaseService.setUserOnline("Ivan", "QWERTY");
    databaseService.setUserOnline("Ivan", "QWERTY2");
    databaseService.setUserOnline("Misho", "QWERTY3");
    assertEquals(2, databaseService.getNumberOfLoggedUsers());
  }

  @After
  public void tearDown() throws SQLException {

    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
    databaseHelper.executeQuery("DELETE FROM onlineUser");
  }
}
