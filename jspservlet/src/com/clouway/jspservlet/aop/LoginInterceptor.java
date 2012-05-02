package com.clouway.jspservlet.aop;

import com.clouway.jspservlet.onlinebanking.WrongUserNameOrPasswordException;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class LoginInterceptor implements MethodInterceptor {

  private static final Map<String, User> users = new HashMap<String, User>();

  static {
    users.put("Ivan", new User("Ivan", "159159"));
  }

  public Object invoke(MethodInvocation methodInvocation) throws Throwable {

    String userName = (String) methodInvocation.getArguments()[0];
    String password = (String) methodInvocation.getArguments()[1];

    if (users.get(userName) != null && users.get(userName).getPassword().equals(password)) {
      return users.get(userName);
    } else {
      throw new WrongUserNameOrPasswordException();
    }
  }
}
