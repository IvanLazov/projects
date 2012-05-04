package com.clouway.guice.aop;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class Contact {

  private final String name;
  private final int age;

  public Contact(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Contact contact = (Contact) o;

    if (age != contact.age) return false;
    if (name != null ? !name.equals(contact.name) : contact.name != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + age;
    return result;
  }
}
