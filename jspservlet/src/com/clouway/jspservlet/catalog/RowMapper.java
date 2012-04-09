package com.clouway.jspservlet.catalog;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper interface is used to create object of type T from given ResultSet
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface RowMapper<T> {

  /**
   * Returns an object of type T from given ResultSet
   *
   * @param resultSet - the resultSet from which we get the parameters we need to create the object
   * @return  - object of type T
   * @throws SQLException - if an error occurs during getting parameters from the ResultSet
   */
  T map(ResultSet resultSet) throws SQLException;
}
