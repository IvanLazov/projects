package com.clouway.guice.aop;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class Main {

  public static void main(String[] args) {

    Injector injector = Guice.createInjector(new ContactManagerModule());
    ContactManager contactManager = injector.getInstance(ContactManager.class);

    contactManager.addContact("Ivan", new Contact("Ivan", 22));
    contactManager.addContact("Georgi", new Contact("Georgi", 23));
    contactManager.getContact("Ivan");
    contactManager.getContact("Ivan");
  }
}
