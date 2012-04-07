package com.clouway.jspservlet.catalog;

import java.util.List;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CommentsUserServiceImpl implements CommentsUserService {

  private CommentsDatabaseService commentsDatabaseService;

  public CommentsUserServiceImpl(CommentsDatabaseService commentsDatabaseService) {
    this.commentsDatabaseService = commentsDatabaseService;
  }

  public void saveUserComment(int bookId, String userName, String comment) {

    if (!userName.matches("[a-zA-Z]{1,20}")) {
      throw new InvalidUserNameException();
    }

    if (!comment.matches("[a-zA-Z ]{1,20}") || comment.trim().equals("")) {
      throw new InvalidCommentException();
    }

    commentsDatabaseService.saveComment(bookId, userName, comment);
  }

  public List getListOfComments(int bookId) {
    return commentsDatabaseService.getComments(bookId);
  }
}
