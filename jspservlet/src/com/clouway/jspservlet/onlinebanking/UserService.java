package com.clouway.jspservlet.onlinebanking;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface UserService {

  void register(String userName, String password);
  
  void deposit(String userName, String sum);
  
  void withdraw(String userName, String sum);
  
  void login(String userName, String password);
}
