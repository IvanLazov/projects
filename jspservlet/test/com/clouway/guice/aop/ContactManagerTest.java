package com.clouway.guice.aop;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.*;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class ContactManagerTest {

  private Map<String, Contact> expected;
  private Map<String, Contact> actual;

  private ContactManager contactManager;
  private Contact contact = new Contact("Ivan", 22);
  private String contactName = "Ivan";

  @Before
  public void setUp() {

    expected = new HashMap<String, Contact>();
    expected.put(contactName, contact);

    actual = new HashMap<String, Contact>();
    contactManager = new ContactManagerImpl(actual);
    contactManager.addContact(contactName, contact);
  }

  @Test
  public void addingNewContact() {
    assertEquals(expected, actual);
  }

  @Test(expected = ContactAlreadyExistsException.class)
  public void contactAlreadyExists() {
    contactManager.addContact(contactName, new Contact("Georgi", 22));
    assertEquals(expected, actual);
  }

  @Test
  public void getContact() {
    assertEquals(contact, contactManager.getContact(contact.getName()));
  }

  @Test(expected = ContactNotExistException.class)
  public void contactNotExist() {
    contactManager.getContact("Test");
  }
}
