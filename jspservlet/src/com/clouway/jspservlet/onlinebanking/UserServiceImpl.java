package com.clouway.jspservlet.onlinebanking;

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
  
  public void deposit(String userName, Double sum) {

    databaseService.updateBalance(userName, databaseService.getBalance(userName) + sum);
  }

  public void withdraw(String userName, String sum) {

    Double currentBalance = databaseService.getBalance(userName) - Double.parseDouble(sum);
    
    if (currentBalance >= 0) {
      databaseService.updateBalance(userName, currentBalance);
    }
  }

  public void login(String userName, String password) {

    if (databaseService.getUserName(userName).equals("") || !password.equals(databaseService.getPassword(userName))) {
      throw new WrongUserNameOrPasswordException();
    }
  }

  private boolean isPasswordValid(String password) {

    return password.matches("[a-zA-Z0-9]{6,20}");
  }
  
  private boolean isUserNameValid(String userName) {

    return userName.matches("[a-zA-Z]{3,20}");
  }
}
