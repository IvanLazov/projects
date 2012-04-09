package com.clouway.jspservlet.catalog;

import java.util.List;

/**
 * CommentsDatabaseServiceImpl provides implementation of CommentsDatabaseService interface
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CommentsDatabaseServiceImpl implements CommentsDatabaseService {

  private final DatabaseHelper databaseHelper;

  public CommentsDatabaseServiceImpl(DatabaseHelper databaseHelper) {
    this.databaseHelper = databaseHelper;
  }

  /**
   * Save user's comment for specified book by given bookId
   *
   * @param bookId - bookId
   * @param userName - userName
   * @param comment - entered comment by the user
   */
  public void saveComment(int bookId, String userName, String comment) {
    databaseHelper.executeQuery("INSERT INTO comments(bookId,userName,comment) VALUES(?,?,?)", bookId, userName, comment);
  }

  /**
   * Returns a List of Comment objects for specified book by given bookId
   *
   * @param bookId - bookId
   * @return - List of Comment objects
   */
  public List getComments(int bookId) {
    return databaseHelper.executeQuery("SELECT * FROM comments WHERE bookId=?", new CommentRowMapper(), bookId);
  }
}
