package com.clouway.jspservlet.catalog;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class BookRowMapper implements RowMapper<Book> {

  public Book map(ResultSet resultSet) throws SQLException {
    return new Book(
                    Integer.parseInt(resultSet.getString("bookId")),
                    resultSet.getString("title"),
                    resultSet.getString("author"),
                    Date.valueOf(resultSet.getString("released")),
                    resultSet.getString("description"));
  }
}
