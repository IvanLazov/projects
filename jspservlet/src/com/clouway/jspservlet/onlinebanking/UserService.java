package com.clouway.jspservlet.onlinebanking;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface UserService {

  void register(String userName, String password) throws InvalidUserNameException, InvalidPasswordException, UserNameAlreadyExistsException;

  void login(String userName, String password) throws WrongUserNameOrPasswordException;

  void deposit(String userName, double sum);
  
  void withdraw(String userName, double sum);
}
