package com.clouway.jspservlet.onlinebanking;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * EndSessionListener is used to set user offline, after the session is destroyed
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class EndSessionListener implements HttpSessionListener {

  private final OnlineUserManager onlineUserManager = Injector.injectOnlineUserManager(Injector.injectDatabaseHelper());
  
  public void sessionCreated(HttpSessionEvent sessionEvent) {
  }

  public void sessionDestroyed(HttpSessionEvent sessionEvent) {
    onlineUserManager.setUserOffline(sessionEvent.getSession().getId());
  }
}
