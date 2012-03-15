package com.clouway.jspservlet.onlinebanking;

import com.clouway.jspservlet.onlinebanking.business.UserService;
import com.clouway.jspservlet.onlinebanking.business.UserServiceImpl;
import com.clouway.jspservlet.onlinebanking.exceptions.*;
import com.clouway.jspservlet.onlinebanking.persistance.DatabaseService;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.SQLException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
@RunWith(JMock.class)
public class UserServiceTest {

  Mockery context = new JUnit4Mockery();
  private UserService userService;
  private DatabaseService databaseService = context.mock(DatabaseService.class);
  
  @Before
  public void setUp() {
    userService = new UserServiceImpl(databaseService);
  }

  @Test
  public void happyPath() throws SQLException {

    context.checking(new Expectations(){{
      oneOf(databaseService).save("Ivan", "123456");
    }});

    userService.register("Ivan", "123456");
  }

  @Test(expected = InvalidUserNameException.class)
  public void shouldNotRegisterUserIfUserNameContainsDigits() {
    
    userService.register("Ivan123", "123456");
  }

  @Test(expected = InvalidUserNameException.class)
  public void shouldNotRegisterUserIfUserNameLengthIsLessThanThreeCharacters() {

    userService.register("Iv", "123456");
  }

  @Test(expected = InvalidUserNameException.class)
  public void shouldNotRegisterUserIfUserNameLengthIsMoreThanTwentyCharacters() {

    userService.register("IvanIvanIvanIvanIvanIvan", "123456");
  }
  
  @Test(expected = InvalidUserNameException.class)
  public void shouldNotRegisterUserIfUserNameIsEmpty() {

    userService.register("", "123456");
  }

  @Test(expected = InvalidPasswordException.class)
  public void shouldNotRegisterUserIfPasswordContainsNonWordCharacters() {

    userService.register("Ivan", "123@#$^&");
  }

  @Test(expected = InvalidPasswordException.class)
  public void shouldNotRegisterUserIfPasswordLengthIsLessThanSixCharacters() {

    userService.register("Ivan", "123");
  }

  @Test(expected = InvalidPasswordException.class)
  public void shouldNotRegisterUserIfPasswordLengthIsMoreThanTwentyCharacters() {

    userService.register("Ivan", "1234567890123456789012345");
  }

  @Test(expected = InvalidPasswordException.class)
  public void shouldNotRegisterUserIfPasswordIsEmpty() {

    userService.register("Ivan", "");
  }

  @Test(expected = UserNameAlreadyExistsException.class)
  public void shouldNotRegisterUserIfUserNameIsTaken() {

    context.checking(new Expectations(){{
      allowing(databaseService).save("Ivan", "123456");
      will(throwException(new DuplicateEntryException()));
    }});

    userService.register("Ivan", "123456");
  }

  @Test
  public void depositMoney() {

    context.checking(new Expectations(){{
      oneOf(databaseService).updateBalance("Ivan", 100);
      oneOf(databaseService).getBalance("Ivan");
    }});

    userService.deposit("Ivan", "100");
  }
  
  @Test
  public void shouldDepositMoneyIfEnteredSumHasDecimalPoint() {

    context.checking(new Expectations(){{
      oneOf(databaseService).updateBalance("Ivan", 150.22);
      oneOf(databaseService).getBalance("Ivan");
    }});

    userService.deposit("Ivan", "150.22");
  }

  @Test(expected = InvalidFormatException.class)
  public void shouldNotDepositMoneyIfEnteredSumHasCommaInsteadOfDecimalPoint() {

    userService.deposit("Ivan", "540,30");
  }

  @Test(expected = InvalidFormatException.class)
  public void shouldNotDepositMoneyIfEnteredSumLengthIsMoreThanFiveCharacters() {

    userService.deposit("Ivan", "850666.00");
  }
  
  @Test(expected = InvalidFormatException.class)
  public void shouldNotDepositMoneyIfEnteredSumDoesNotContainsNumbers() {

    userService.deposit("Ivan", "abc");
  }

  @Test(expected = InvalidFormatException.class)
  public void shouldNotDepositMoneyIfSumIsNegative() {

    userService.deposit("Ivan", "-10");
  }
  
  @Test
  public void withdrawMoney() {

    context.checking(new Expectations(){{
      oneOf(databaseService).getBalance("Ivan");
      will(returnValue(100.00));
      oneOf(databaseService).updateBalance("Ivan", 50.00);
    }});

    userService.withdraw("Ivan", "50.00");
  }

  @Test(expected = InvalidFormatException.class)
  public void shouldNotWithdrawMoneyIfEnteredSumDoesNotContainsNumbers() {

    userService.withdraw("Ivan", "abc");
  }

  @Test(expected = InvalidFormatException.class)
  public void shouldNotWithdrawMoneyIfEnteredSumIsNegative() {

    userService.withdraw("Ivan", "-10");
  }

  @Test
  public void shouldNotWithdrawMoneyIfCurrentUserBalanceIsNotEnough() {

    context.checking(new Expectations(){{
      oneOf(databaseService).getBalance("Ivan");
      will(returnValue(100.00));
    }});

    userService.withdraw("Ivan", "200");
  }
  
  @Test
  public void loginUser() {
    
    context.checking(new Expectations(){{
      oneOf(databaseService).getUserName("Ivan");
      will(returnValue("Ivan"));
      oneOf(databaseService).getPassword("Ivan");
      will(returnValue("123456"));
    }});

    userService.login("Ivan", "123456");
  }
  
  @Test(expected = UserNotRegisteredException.class)
  public void cannotLoginUserIfUserIsNotRegistered() {
    
    context.checking(new Expectations(){{
      oneOf(databaseService).getUserName("Ivan");
      will(returnValue(""));
    }});

    userService.login("Ivan", "123456");
  }

  @Test(expected = WrongUserNameOrPasswordException.class)
  public void cannotLoginUserIfPasswordIsWrong() {
    
    context.checking(new Expectations(){{
      oneOf(databaseService).getUserName("Ivan");
      will(returnValue("Ivan"));
      oneOf(databaseService).getPassword("Ivan");
      will(returnValue("123456"));
    }});

    userService.login("Ivan", "112233");
  }
}
