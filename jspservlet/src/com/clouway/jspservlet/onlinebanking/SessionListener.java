package com.clouway.jspservlet.onlinebanking;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class SessionListener implements HttpSessionListener {

  private final OnlineUserManager onlineUserManager = Injector.injectOnlineUserManager(Injector.injectDatabaseHelper());
  
  public void sessionCreated(HttpSessionEvent sessionEvent) {
  }

  public void sessionDestroyed(HttpSessionEvent sessionEvent) {
    onlineUserManager.setUserOffline(sessionEvent.getSession().getId());
  }
}
