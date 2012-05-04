package com.clouway.guice.onlinebanking;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ResultSetBuilder interface is used to get an object of type T
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface ResultSetBuilder<T> {

  /**
   * Get an object of type T from a resultSet
   *
   * @param resultSet - the resultSet from which we will create the object
   * @return - an object of type T
   * @throws SQLException - if an error occurs
   */
  T get(ResultSet resultSet) throws SQLException;
}
