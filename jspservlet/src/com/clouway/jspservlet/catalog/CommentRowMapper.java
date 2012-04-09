package com.clouway.jspservlet.catalog;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * CommentRowMapper creates a Comment object from given ResultSet
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CommentRowMapper implements RowMapper<Comment> {

  /**
   * Returns Comment object from given ResultSet
   *
   * @param resultSet - the resultSet from which we take the necessary parameters to create the object
   * @return - Comment object
   * @throws SQLException - if an error occurs while getting the parameters from the ResultSet
   */
  public Comment map(ResultSet resultSet) throws SQLException {
    return new Comment(
            Integer.parseInt(resultSet.getString("bookId")),
            resultSet.getString("userName"),
            resultSet.getString("comment"));
  }
}
