package com.clouway.jspservlet.onlinebanking;

import com.clouway.jspservlet.onlinebanking.exceptions.DuplicateEntryException;
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
    databaseService = new DatabaseServiceImpl(databaseHelper);
    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
  }

  @Test
  public void happyPath() throws SQLException {

    databaseService.save("Ivan","123456");
    assertEquals("Ivan", databaseHelper.executeQueryResult("SELECT userName FROM user WHERE userName=?", "Ivan"));
  }
  
  @Test
  public void saveAnotherUser() throws SQLException {
    
    databaseService.save("Misho", "654321");
    assertEquals("Misho", databaseHelper.executeQueryResult("SELECT userName FROM user WHERE userName=?", "Misho"));
  }

  @Test(expected = DuplicateEntryException.class)
  public void cannotSaveTwoUsersWithTheSameName() {

    databaseService.save("Ivan", "123456");
    databaseService.save("Ivan", "888888");
  }

  @Test
  public void newRegisteredUserHaveZeroBalanceInAccount() throws SQLException {

    databaseService.save("Ivan", "123456");
    assertEquals(0.0, Double.parseDouble(databaseHelper.executeQueryResult("SELECT balance FROM account WHERE userId = (SELECT userId FROM user WHERE userName=?)", "Ivan")));
  }

  @Test
  public void increaseUserBalance() throws SQLException {
    
    databaseService.save("Ivan", "123456");
    databaseService.updateBalance("Ivan", 150.00);
    assertEquals(150.00, Double.parseDouble(databaseHelper.executeQueryResult("SELECT balance FROM account WHERE userId = (SELECT userId FROM user WHERE userName=?)","Ivan")));
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
    assertEquals(databaseService.getUserName("Ivan"), databaseHelper.executeQueryResult("SELECT userName FROM user WHERE userName=?", "Ivan"));
  }

  @Test
  public void getEmptyUserName() throws SQLException {

    assertEquals(databaseService.getUserName("Misho"), databaseHelper.executeQueryResult("SELECT userName FROM user WHERE userName=?", "Misho"));
  }

  @Test
  public void getUserPassword() throws SQLException {

    databaseService.save("Ivan", "123456");
    assertEquals(databaseService.getPassword("Ivan"), databaseHelper.executeQueryResult("SELECT password FROM user WHERE userName=?", "Ivan"));
  }
  
  @Test
  public void getEmptyPassword() throws SQLException {
    
    assertEquals(databaseService.getPassword("Misho"), databaseHelper.executeQueryResult("SELECT password FROM user WHERE userName=?", "Misho"));
  }
}
