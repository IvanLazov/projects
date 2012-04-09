package com.clouway.jspservlet.catalog;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * BookRowMapper creates a Book object from given ResultSet
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class BookRowMapper implements RowMapper<Book> {

  /**
   * Return Book object from given ResultSet
   *
   * @param resultSet - the resultSet from which we take the necessary parameters to create the object
   * @return - Book object
   * @throws SQLException - if an error occurs while getting the parameters from the ResultSet
   */
  public Book map(ResultSet resultSet) throws SQLException {
    return new Book(
                    Integer.parseInt(resultSet.getString("bookId")),
                    resultSet.getString("title"),
                    resultSet.getString("author"),
                    Date.valueOf(resultSet.getString("released")),
                    resultSet.getString("description"));
  }
}
