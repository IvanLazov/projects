package com.clouway.jspservlet.onlinebanking;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class RegisterServiceTest {

  private DatabaseHelper databaseHelper;
  private RegisterService registerService;
  
  @Before
  public void setUp() {
    
    databaseHelper = Injector.injectDatabaseHelper();
    registerService = Injector.injectRegisterService(databaseHelper);
    databaseHelper.executeQuery("DELETE FROM account");
    databaseHelper.executeQuery("DELETE FROM user");
  }
  
  @Test
  public void registerUserAndSaveDataInUserTable() {

    registerService.register("Ivan", "123456");
    
    String userName = "Ivan";
    String password = "123456";
    
    assertEquals(userName, databaseHelper.executeQueryResult("SELECT userName FROM user WHERE password=?", password));
    assertEquals(password, databaseHelper.executeQueryResult("SELECT password FROM user WHERE userName=?", userName));
  }
  
  @Test
  public void registerUserAndSaveDataInUserTableAndAccountTable() {

    registerService.register("Ivan", "123456");        
    
    User user = databaseHelper.executeQuery("SELECT * FROM user WHERE userName=?", new UserProvider(), "Ivan");
    Account account = databaseHelper.executeQuery("SELECT * FROM account WHERE userId=?", new AccountProvider(), user.getUserId());
    
    assertEquals(user.getUserId(), account.getUserId());
    assertEquals(0.0, account.getBalance());
  }

  @Test(expected = UserNameAlreadyExistsException.class)
  public void cannotSaveTwoUsersWithTheSameName() {

    registerService.register("Ivan", "123456");
    registerService.register("Ivan", "123456");
  }
}
