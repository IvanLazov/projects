package com.clouway.jspservlet.catalog;

import java.util.List;

/**
 * CommentsDatabaseService provides methods for
 * - saving user comment
 * - returning list of all comments for specified book by given bookId
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface CommentsDatabaseService {

  /**
   * Save user comment for specified book by given bookId
   *
   * @param bookId - bookId
   * @param userName - userName
   * @param comment - entered comment by the user
   */
  void saveComment(int bookId, String userName, String comment);

  /**
   * Returns a List of Comment objects for specified book by given bookId
   *
   * @param bookId - bookId
   * @return - List of Comment objects
   */
  List getComments(int bookId);
}
