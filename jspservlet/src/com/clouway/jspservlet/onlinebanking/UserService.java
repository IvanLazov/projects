package com.clouway.jspservlet.onlinebanking;

import com.clouway.jspservlet.onlinebanking.exceptions.InvalidFormatException;
import com.clouway.jspservlet.onlinebanking.exceptions.InvalidPasswordException;
import com.clouway.jspservlet.onlinebanking.exceptions.InvalidUserNameException;
import com.clouway.jspservlet.onlinebanking.exceptions.UserNameAlreadyExistsException;
import com.clouway.jspservlet.onlinebanking.exceptions.UserNotRegisteredException;
import com.clouway.jspservlet.onlinebanking.exceptions.WrongUserNameOrPasswordException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface UserService {

  void register(String userName, String password) throws InvalidUserNameException, InvalidPasswordException, UserNameAlreadyExistsException;

  void login(String userName, String password) throws UserNotRegisteredException, WrongUserNameOrPasswordException;

  void deposit(String userName, String sum) throws InvalidFormatException;
  
  void withdraw(String userName, String sum) throws InvalidFormatException;
}
