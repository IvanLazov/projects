package com.clouway.jspservlet.onlinebanking;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class DatabaseServiceTest {

  private DatabaseHelper databaseHelper = new DatabaseHelper();
  private DatabaseService databaseService;

  @Before
  public void setUp() {

    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
    databaseHelper.executeQuery("DELETE FROM onlineUser");
    databaseService = new DatabaseServiceImpl(databaseHelper);
  }

//  @Test
//  public void happyPath() {
//
//    databaseService.save("Ivan","123456");
//    assertEquals("Ivan", databaseHelper.executeQueryResult("SELECT userName FROM user WHERE userName=?", "Ivan"));
//  }
  
//  @Test
//  public void saveTwoUsers() {
//
//    databaseService.save("Ivan", "123456");
//    databaseService.save("Misho", "654321");
//    assertEquals("Misho", databaseHelper.executeQueryResult("SELECT userName FROM user WHERE userName=?", "Misho"));
//    assertEquals("Misho", databaseHelper.executeQueryResult("SELECT userName FROM user WHERE userName=?", "Misho"));
//    assertEquals("2", databaseHelper.executeQueryResult("SELECT COUNT(*) FROM user"));
//  }

//  @Test(expected = DuplicateEntryException.class)
//  public void cannotSaveTwoUsersWithTheSameName() {
//
//    databaseService.save("Ivan", "123456");
//    databaseService.save("Ivan", "888888");
//  }
  
//  @Test
//  public void newRegisteredUserHaveZeroBalanceInAccount() {
//
//    databaseService.save("Ivan", "123456");
//    assertEquals("0", databaseHelper.executeQueryResult("SELECT balance FROM account WHERE userId = (SELECT userId FROM user WHERE userName=?)", "Ivan"));
//  }

//  @Test
//  public void increaseUserBalance() {
//
//    databaseService.save("Ivan", "123456");
//
//    databaseService.updateBalance("Ivan", 150.00);
//
//    Double balance = databaseService.getBalance("Ivan");
//    assertThat(balance, is(equalTo(150.00)));
//  }
  
//  @Test
//  public void getUserBalance() {
//
//    databaseService.save("Ivan", "123456");
//    databaseService.updateBalance("Ivan", 260.00);
//    assertThat(260.00, is(equalTo(databaseService.getBalance("Ivan"))));
//  }
  
//  @Test
//  public void getUserName() {
//
//    databaseService.save("Ivan", "123456");
//    assertEquals("Ivan", databaseService.getUserName("Ivan"));
//  }

//  @Test
//  public void getEmptyUserName() {
//
//    assertEquals("", databaseService.getUserName("Misho"));
//  }

//  @Test
//  public void getUserPassword() {
//
//    databaseService.save("Ivan", "123456");
//    assertEquals("123456", databaseService.getPassword("Ivan"));
//  }

  @Test
  public void setUserIsOnline() {
    
    databaseService.setUserOnline("123456QWERTY", "Ivan");
    assertEquals("Ivan", databaseHelper.executeQueryResult("SELECT userName FROM onlineUser WHERE userName=?", "Ivan"));
    assertEquals("123456QWERTY", databaseHelper.executeQueryResult("SELECT sessionId FROM onlineUser WHERE userName=?", "Ivan"));
  }

  @Test
  public void setUserOffline() {

    databaseService.setUserOnline("123456QWERTY", "Ivan");
    databaseService.setUserOnline("987654AZERTY", "Misho");
    databaseService.setUserOffline("123456QWERTY");
    assertEquals("987654AZERTY", databaseHelper.executeQueryResult("SELECT sessionId FROM onlineUser WHERE userName=?", "Misho"));
  }

  @Test
  public void getNumberOfOnlineUsers() {

    databaseService.setUserOnline("123456QWERTY", "Ivan");
    databaseService.setUserOnline("987654AZERTY", "Misho");
    assertEquals(2, databaseService.getNumberOfOnlineUsers());
  }
}
