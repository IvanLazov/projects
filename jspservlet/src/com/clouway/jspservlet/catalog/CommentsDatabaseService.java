package com.clouway.jspservlet.catalog;

import java.util.List;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface CommentsDatabaseService {
  
  void saveComment(int bookId, String userName, String comment);
  List getComments(int bookId);
}
