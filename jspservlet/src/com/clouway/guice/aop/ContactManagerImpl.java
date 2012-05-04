package com.clouway.guice.aop;

import com.google.inject.Inject;

import java.util.Map;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class ContactManagerImpl implements ContactManager {

  private final Map<String, Contact> contacts;

  @Inject
  public ContactManagerImpl(Map<String, Contact> contacts) {
    this.contacts = contacts;
  }

  @MethodStatus
  public void addContact(String name, Contact contact) {

    if (!contacts.containsKey(name)) {
      contacts.put(name, contact);
    } else {
      throw new ContactAlreadyExistsException();
    }
  }

  @MethodStatus
  public Contact getContact(String name) {

    if (contacts.containsKey(name)) {
      return contacts.get(name);
    } else {
      throw new ContactNotExistException();
    }
  }
}
