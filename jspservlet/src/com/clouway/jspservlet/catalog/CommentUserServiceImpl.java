package com.clouway.jspservlet.catalog;

import java.util.List;

/**
 * CommentUserServiceImpl provides implementation of CommentUserService interface
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CommentUserServiceImpl implements CommentUserService {

  private CommentsDatabaseService commentsDatabaseService;

  public CommentUserServiceImpl(CommentsDatabaseService commentsDatabaseService) {
    this.commentsDatabaseService = commentsDatabaseService;
  }

  /**
   * Save user's comment for specified book by given bookId in the database
   *
   * @param bookId - bookId
   * @param userName  - userName
   * @param comment - entered user's comment
   */
  public void saveUserComment(int bookId, String userName, String comment) {
    commentsDatabaseService.saveComment(bookId, userName, comment);
  }

  /**
   * Returns a List of Comment objects for specified book by given bookId
   *
   * @param bookId - bookId
   * @return - List of Comment objects
   */
  public List getListOfComments(int bookId) {
    return commentsDatabaseService.getComments(bookId);
  }
}
