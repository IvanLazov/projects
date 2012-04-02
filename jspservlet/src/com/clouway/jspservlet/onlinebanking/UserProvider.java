package com.clouway.jspservlet.onlinebanking;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserProvider implements Provider to be able to get a User from a ResultSet
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class UserProvider implements Provider<User> {

  /**
   * Get a User from a ResultSet
   *
   * @param resultSet - the resultSet from which we will create the object
   * @return - a User from a ResultSet
   * @throws SQLException
   */
  public User get(ResultSet resultSet) throws SQLException {

    return new User(
            Integer.parseInt(resultSet.getString("userId")),
            resultSet.getString("userName"),
            resultSet.getString("password")
    );
  }
}
