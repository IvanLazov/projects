package com.clouway.guice.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class ContactManagerInterceptor implements MethodInterceptor {

  public Object invoke(MethodInvocation invocation) throws Throwable {

    System.out.println("Method " + invocation.getMethod().getName() + " will start execution...");

    long startTime = System.currentTimeMillis();

    try {
      return invocation.proceed();
    } finally {
      System.out.println("Method " + invocation.getMethod().getName() + " finished execution for " + (System.currentTimeMillis() - startTime) + "ms\n");
    }
  }
}
