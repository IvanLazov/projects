package com.clouway.jspservlet.onlinebanking;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface Provider<T> {

  T get(ResultSet resultSet) throws SQLException;
}
