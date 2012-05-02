package com.clouway.jspservlet.singleton;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class Singleton {

  private static Singleton singleton = null;

  private Singleton() {

  }

  public synchronized static Singleton getInstance() {

    if (singleton == null) {
      singleton = new Singleton();
    }

    return  singleton;
  }
}
