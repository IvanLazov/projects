package com.clouway.jspservlet.onlinebanking.controllers;

import com.clouway.jspservlet.onlinebanking.persistance.DatabaseHelper;
import com.clouway.jspservlet.onlinebanking.persistance.DatabaseService;
import com.clouway.jspservlet.onlinebanking.persistance.DatabaseServiceImpl;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class SessionListener implements HttpSessionListener {

  private DatabaseHelper databaseHelper = new DatabaseHelper();
  private DatabaseService databaseService = new DatabaseServiceImpl(databaseHelper);

  public void sessionCreated(HttpSessionEvent sessionEvent) {

  }

  public void sessionDestroyed(HttpSessionEvent sessionEvent) {
    databaseService.setUserOffline(sessionEvent.getSession().getId());
  }
}
