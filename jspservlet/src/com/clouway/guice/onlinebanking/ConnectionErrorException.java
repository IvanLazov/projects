package com.clouway.guice.onlinebanking;

import java.sql.SQLException;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class ConnectionErrorException extends RuntimeException {

  public ConnectionErrorException(SQLException e) {
    super(e);
  }
}
