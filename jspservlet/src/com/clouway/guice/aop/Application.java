package com.clouway.guice.aop;

import com.clouway.guice.onlinebanking.WrongUserNameOrPasswordException;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class Application {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new LoginModule());
    LoginService loginService = injector.getInstance(LoginService.class);

    try {
      User user = loginService.login("Ivan", "");
      System.out.println("Username: " + user.getUserName() + "\nPassword: " + user.getPassword());
    } catch (WrongUserNameOrPasswordException e) {
      System.out.println("You have entered wrong username/password!");
    }
  }
}
