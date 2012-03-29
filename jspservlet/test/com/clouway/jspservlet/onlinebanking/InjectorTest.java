package com.clouway.jspservlet.onlinebanking;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class InjectorTest {

  @Test
  public void getDatabaseHelperInstance() {

    assertNotNull(Injector.injectDatabaseHelper());
  }
  
  @Test
  public void shouldGetTheSameInstanceOfDatabaseHelper() {

    assertEquals(Injector.injectDatabaseHelper(), Injector.injectDatabaseHelper());
  }

  @Test
  public void getRegisterServiceInstance() {

    assertNotNull(Injector.injectRegisterService(Injector.injectDatabaseHelper()));
  }
  
  @Test
  public void shouldGetTheSameInstanceOfRegisterService() {

    assertEquals(Injector.injectRegisterService(Injector.injectDatabaseHelper()), Injector.injectRegisterService(Injector.injectDatabaseHelper()));
  }
  
  @Test
  public void getOnlineUserManagerInstance() {

    assertNotNull(Injector.injectOnlineUserManager(Injector.injectDatabaseHelper()));
  }

  @Test
  public void shouldGetTheSameInstanceOfOnlineUserManager() {

    assertEquals(Injector.injectOnlineUserManager(Injector.injectDatabaseHelper()), Injector.injectOnlineUserManager(Injector.injectDatabaseHelper()));
  }
}
