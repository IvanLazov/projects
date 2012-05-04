package com.clouway.guice.aop;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface ContactManager {

  void addContact(String name, Contact contact);

  Contact getContact(String name);
}
