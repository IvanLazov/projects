package com.clouway.jspservlet.onlinebanking;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class SessionListener implements HttpSessionListener {

  public void sessionCreated(HttpSessionEvent sessionEvent) {

  }

  public void sessionDestroyed(HttpSessionEvent sessionEvent) {
  //  databaseService.setUserOffline(sessionEvent.getSession().getId());
  }
}
