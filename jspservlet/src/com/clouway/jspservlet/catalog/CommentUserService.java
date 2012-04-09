package com.clouway.jspservlet.catalog;

import java.util.List;

/**
 * CommentUserService provides methods for
 * - saving user comment for specified book
 * - returning a List of Comment objects for specified book by given bookId
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface CommentUserService {

  /**
   * Save user's comment for specified book in the database
   *
   * @param bookId - bookId
   * @param userName  - userName
   * @param comment - entered user's comment
   */
  void saveUserComment(int bookId, String userName, String comment);

  /**
   * Returns a List of Comment objects for specified book by given bookId
   *
   * @param bookId - bookId
   * @return - List of Comment objects
   */
  List getListOfComments(int bookId);
}
