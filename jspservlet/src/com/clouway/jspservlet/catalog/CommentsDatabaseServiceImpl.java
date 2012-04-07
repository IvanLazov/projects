package com.clouway.jspservlet.catalog;

import java.util.List;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CommentsDatabaseServiceImpl implements CommentsDatabaseService {

  private final DatabaseHelper databaseHelper;

  public CommentsDatabaseServiceImpl(DatabaseHelper databaseHelper) {
    this.databaseHelper = databaseHelper;
  }

  public void saveComment(int bookId, String userName, String comment) {
    databaseHelper.executeQuery("INSERT INTO comments(bookId,userName,comment) VALUES(?,?,?)", bookId, userName, comment);
  }

  public List getComments(int bookId) {
    return databaseHelper.executeQuery("SELECT * FROM comments WHERE bookId=?", new CommentRowMapper(), bookId);
  }
}
