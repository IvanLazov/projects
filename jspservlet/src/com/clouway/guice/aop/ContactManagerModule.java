package com.clouway.guice.aop;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class ContactManagerModule extends AbstractModule {

  private Map<String, Contact> contactMap = new HashMap<String, Contact>();

  protected void configure() {

    bindInterceptor(Matchers.any(), Matchers.annotatedWith(MethodStatus.class), new ContactManagerInterceptor());
    bind(ContactManager.class).to(ContactManagerImpl.class);
    bind(new TypeLiteral<Map<String, Contact>>(){}).toInstance(contactMap);
  }
}
