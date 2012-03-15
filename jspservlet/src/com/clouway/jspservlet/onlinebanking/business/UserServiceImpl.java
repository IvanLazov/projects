package com.clouway.jspservlet.onlinebanking.business;

import com.clouway.jspservlet.onlinebanking.exceptions.*;
import com.clouway.jspservlet.onlinebanking.persistance.DatabaseService;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class UserServiceImpl implements UserService {

  private DatabaseService databaseService;

  public UserServiceImpl(DatabaseService databaseService) {
    this.databaseService = databaseService;
  }

  public void register(String userName, String password) {

    if (!isUserNameValid(userName)) {
      throw new InvalidUserNameException();
    }

    if (!isPasswordValid(password)) {
      throw new InvalidPasswordException();
    }

    try {
      databaseService.save(userName, password);
    } catch (DuplicateEntryException exception) {
      throw new UserNameAlreadyExistsException();
    }
  }
  
  public void deposit(String userName, String sum) {
    
    if (!isSumValid(sum)) {
      throw new InvalidFormatException();
    }

    databaseService.updateBalance(userName, databaseService.getBalance(userName) + Double.parseDouble(sum));
  }

  public void withdraw(String userName, String sum) {

    if (!isSumValid(sum)) {
      throw new InvalidFormatException();
    }

    Double currentBalance = databaseService.getBalance(userName) - Double.parseDouble(sum);
    
    if (currentBalance  >= 0) {
      databaseService.updateBalance(userName, currentBalance);
    }
  }

  public void login(String userName, String password) {

    if (databaseService.getUserName(userName).equals("")) {
      throw new UserNotRegisteredException();
    }
    
    if (!password.equals(databaseService.getPassword(userName))) {
      throw new WrongUserNameOrPasswordException();
    }
  }

  private boolean isPasswordValid(String password) {

    return password.matches("[a-zA-z0-9]{6,20}");
  }
  
  private boolean isUserNameValid(String userName) {

    return userName.matches("[a-zA-z]{3,20}");
  }
  
  private boolean isSumValid(String sum) {

    return sum.matches("[0-9]{1,5}[.][0-9]{2}") || sum.matches("[0-9]{1,5}");
  }
}
