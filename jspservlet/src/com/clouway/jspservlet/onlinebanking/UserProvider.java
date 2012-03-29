package com.clouway.jspservlet.onlinebanking;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class UserProvider implements Provider<User> {

  public User get(ResultSet resultSet) throws SQLException {
    return new User(Integer.parseInt(resultSet.getString("userId")), resultSet.getString("userName"), resultSet.getString("password"));
  }
}
