package com.clouway.jspservlet.catalog;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CommentRowMapper implements RowMapper<Comment> {

  public Comment map(ResultSet resultSet) throws SQLException {
    return new Comment(
            Integer.parseInt(resultSet.getString("bookId")),
            resultSet.getString("userName"),
            resultSet.getString("comment"));
  }
}
