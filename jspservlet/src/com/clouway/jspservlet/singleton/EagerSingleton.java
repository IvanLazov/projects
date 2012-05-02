package com.clouway.jspservlet.singleton;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class EagerSingleton {

  public static EagerSingleton eagerSingleton = new EagerSingleton();

  private EagerSingleton() {

  }

  public static EagerSingleton getInstance() {
    return eagerSingleton;
  }
}
