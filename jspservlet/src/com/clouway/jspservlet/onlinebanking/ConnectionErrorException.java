package com.clouway.jspservlet.onlinebanking;

import java.sql.SQLException;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class ConnectionErrorException extends RuntimeException {

  public ConnectionErrorException(SQLException e) {
    super(e);
  }
}
